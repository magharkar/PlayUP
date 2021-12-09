package com.playup.service.booking;

import com.playup.dao.booking.SlotBookingDaoImpl;
import com.playup.model.search.SearchVenue;
import com.playup.model.booking.VenueSlot;
import com.playup.model.search.SearchVenue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VenueBookingServiceImpl implements  IVenueBookingService{


    @Override
    public boolean bookSlot(int venueId, int selectedSlot) {
        boolean success = SlotBookingDaoImpl.getInstance().updateSlot(venueId, selectedSlot);
        if(success) {
            updateVenueAvailability(venueId);
        }
        return success;
    }

    @Override
    public ArrayList<VenueSlot> getAllSlots(int venueId) {
        ArrayList<VenueSlot> venueSlots = SlotBookingDaoImpl.getInstance().getSlotsByVenueId(venueId);
        ArrayList<VenueSlot> venueSlotOptions = new ArrayList<>();
        for(int iterator = 0; iterator < venueSlots.size(); iterator ++) {
            int slotId = venueSlots.get(iterator).getSlotId();
            String slotType = venueSlots.get(iterator).getSlotType();
            String bookingStatus = venueSlots.get(iterator).getBookingStatus();
            String sport = venueSlots.get(iterator).getSport();
            VenueSlot venueSlot = new VenueSlot(slotId, slotType, bookingStatus, sport);
            venueSlotOptions.add(venueSlot);
        }
        return venueSlotOptions;
    }

    @Override
    public SearchVenue getVenueDetails(int venueId) {
        SearchVenue venue = SlotBookingDaoImpl.getInstance().getVenueById(venueId);
        return venue;
    }

    @Override
    public boolean updateVenueAvailability(int venueId) {
        SearchVenue venue = SlotBookingDaoImpl.getInstance().getVenueById(venueId);
        String currentAvailableSlot = venue.getAvailableSlots();
        int currentSlotCount = Integer.parseInt(currentAvailableSlot);
        int updatedSlot = currentSlotCount - 1;
        venue.setAvailableSlots(String.valueOf(updatedSlot));
        boolean success = SlotBookingDaoImpl.getInstance().updateVenueSlot(venue);
        return success;

    }
}
