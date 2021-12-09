/**
 * @author Mugdha Anil Agharkar
 */
package com.playup.dao.booking;

import com.playup.database.PlayupDBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class NearestVenueLocationDaoImpl implements INearestVenueLocationDao {
    @Override
    public HashMap<String, String[]> getLocationsOfAllVenues() {
        String query = "Select venue_id, latitude, longitude from Venues";
        String sqlQuery = String.format(query);
        ResultSet resultSet = null;
        HashMap<String, String[]> venueCoordinates = new HashMap<>();
        try {
            resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
            while (resultSet!= null && resultSet.next()) {
                String venueId = resultSet.getString("venue_id");
                String latitude = resultSet.getString("latitude");
                String longitude = resultSet.getString("longitude");
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
        String query = "Select * from venue_slot_mapping where sport=" + "'" + sport + "'" + " AND venue_id = " + "'" + nearestVenue + "'";
        String sqlQuery = String.format(query);
        System.out.println(sqlQuery);
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
