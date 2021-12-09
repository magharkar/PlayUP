package com.playup.dao.booking;

import com.playup.constants.ApplicationConstants;
import com.playup.constants.QueryConstants;
import com.playup.database.PlayupDBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author Mugdha Anil Agharkar
 */

public class NearestVenueLocationDaoImpl implements INearestVenueLocationDao {
    private final String VENUE = "' AND venue_id = '";
    private final String COMMA = "'";
    @Override
    public HashMap<String, String[]> getLocationsOfAllVenues() {
        String query = QueryConstants.GET_LOCATION_OF_ALL_VENUES;
        String sqlQuery = String.format(query);
        ResultSet resultSet = null;
        HashMap<String, String[]> venueCoordinates = new HashMap<>();
        try {
            resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
            while (resultSet!= null && resultSet.next()) {
                String venueId = resultSet.getString(ApplicationConstants.VENUE_ID);
                String latitude = resultSet.getString(ApplicationConstants.LATITUDE);
                String longitude = resultSet.getString(ApplicationConstants.LONGITUDE);
                String[] latLongArray = {latitude, longitude};
                venueCoordinates.put(venueId,latLongArray);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return venueCoordinates;
    }

    @Override
    public boolean getSportAvailabilityAtNearestVenue(String nearestVenue, String sport) {
        String query = QueryConstants.SELECT_VENUE_SLOT + sport + VENUE +nearestVenue + COMMA;
        String sqlQuery = String.format(query);
        ResultSet resultSet = null;
        resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
        try {
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
