package com.playup.dao.booking;

import java.util.HashMap;

/**
 * @author Mugdha Anil Agharkar
 */

public interface INearestVenueLocationDao {
    HashMap<String, String[]> getLocationsOfAllVenues();
    boolean getSportAvailabilityAtNearestVenue(String nearestVenue, String sport);
}
