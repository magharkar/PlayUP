package com.playup.dao.booking;

import com.playup.model.search.SearchVenue;

import java.util.ArrayList;
import java.util.HashMap;

public interface INearestVenueLocationDao {

    HashMap<String, String[]> getLocationsOfAllVenues();

    public boolean getSportAvailabilityAtNearestVenue(String nearestVenue, String sport);
}
