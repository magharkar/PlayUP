package com.playup.service.booking;

import com.playup.dao.booking.BookingDaoImpl;
import com.playup.model.Venue;
import com.playup.model.booking.VenueSlot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VenueBookingServiceImpl implements  IVenueBookingService{


    @Override
    public boolean bookSlot(int venueId, int selectedSlot) {
        boolean success = BookingDaoImpl.getInstance().updateSlot(venueId, selectedSlot);
        if(success) {
            updateVenueAvailability(venueId);
        }
        return success;
    }

    @Override
    public ArrayList<VenueSlot> getAllSlots(int venueId) {
        ArrayList<VenueSlot> venueSlots = BookingDaoImpl.getInstance().getSlotsByVenueId(venueId);
        ArrayList<VenueSlot> venueSlotOptions = new ArrayList<>();
        for(int iterator = 0; iterator < venueSlots.size(); iterator ++) {
            int slotId = venueSlots.get(iterator).getSlotId();
            String slotType = venueSlots.get(iterator).getSlotType();
            String bookingStatus = venueSlots.get(iterator).getBookingStatus();
            VenueSlot venueSlot = new VenueSlot(slotId, slotType, bookingStatus);
            venueSlotOptions.add(venueSlot);
        }
        return venueSlotOptions;
    }

    @Override
    public Venue getVenueDetails(int venueId) {
        Venue venue = BookingDaoImpl.getInstance().getVenueById(venueId);
        return venue;
    }

    @Override
    public boolean updateVenueAvailability(int venueId) {
        Venue venue = BookingDaoImpl.getInstance().getVenueById(venueId);
        String currentAvailableSlot = venue.getAvailableSlots();
        int currentSlotCount = Integer.parseInt(currentAvailableSlot);
        int updatedSlot = currentSlotCount - 1;
        venue.setAvailableSlots(String.valueOf(updatedSlot));
        boolean success = BookingDaoImpl.getInstance().updateVenueSlot(venue);
        return success;

    }
}
