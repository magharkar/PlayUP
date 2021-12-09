package com.playup.dao.booking;

import com.playup.model.search.SearchVenue;
import com.playup.model.booking.VenueSlot;

import java.util.ArrayList;

public interface ISlotBookingDao {

    SearchVenue getVenueById(int venueId);

    ArrayList<VenueSlot> getSlotsByVenueId(int venueId);

    boolean updateSlot(int venueId, int slotId);

    boolean updateVenueSlot(SearchVenue venue);

}
