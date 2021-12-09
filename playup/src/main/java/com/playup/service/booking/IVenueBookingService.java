package com.playup.service.booking;

import com.playup.model.Venue;
import com.playup.model.booking.VenueSlot;

import java.util.ArrayList;

public interface IVenueBookingService {

    boolean bookSlot(int venueId, int selectedSlot);

    ArrayList<VenueSlot> getAllSlots(int venueId);

    Venue getVenueDetails(int venueId);

    boolean updateVenueAvailability(int venueId);
}
