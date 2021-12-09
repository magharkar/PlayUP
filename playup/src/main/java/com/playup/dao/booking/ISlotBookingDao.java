package com.playup.dao.booking;

import com.playup.model.Venue;
import com.playup.model.booking.VenueSlot;

import java.util.ArrayList;

public interface ISlotBookingDao {

    Venue getVenueById(int venueId);

    ArrayList<VenueSlot> getSlotsByVenueId(int venueId);

    boolean updateSlot(int venueId, int slotId);

    boolean updateVenueSlot(Venue venue);

}
