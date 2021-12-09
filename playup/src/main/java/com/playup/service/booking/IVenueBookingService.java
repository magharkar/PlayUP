package com.playup.service.booking;

import com.playup.model.search.SearchVenue;
import com.playup.model.booking.VenueSlot;
import com.playup.model.search.SearchVenue;

import java.util.ArrayList;

public interface IVenueBookingService {

    boolean bookSlot(int venueId, int selectedSlot);

    ArrayList<VenueSlot> getAllSlots(int venueId);

    SearchVenue getVenueDetails(int venueId);

    boolean updateVenueAvailability(int venueId);
}
