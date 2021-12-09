/**
 * @author Mugdha Anil Agharkar
 */
package com.playup.dao.booking;

import java.util.HashMap;

public interface INearestVenueLocationDao {

    HashMap<String, String[]> getLocationsOfAllVenues();
    boolean getSportAvailabilityAtNearestVenue(String nearestVenue, String sport);
}
