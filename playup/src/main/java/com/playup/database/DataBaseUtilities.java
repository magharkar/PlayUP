package com.playup.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.playup.model.Venue;

/**
 * DBUtils can be used by anyone to add methods according to the feature to execute queries in the database
 * @author Vibhor Bhatnagar
 */

public class DataBaseUtilities {
	
	private static DataBaseUtilities instance = null;
	
	public DataBaseUtilities() {

	}
	
	public static DataBaseUtilities getInstance() {
		if(instance == null) {
			instance = new DataBaseUtilities();
		}
		return instance;
	}

	public static List<Venue> getVenuesFromDB() throws SQLException {
		List<Venue> venueList = new ArrayList<>();
		ResultSet resultSet = PlayupDBConnection.getInstance().readData("Select * from Venues;");
		while (resultSet != null && resultSet.next()) {
			venueList.add(new Venue(resultSet.getString("venue_id"), resultSet.getString("name"),
					resultSet.getString("city"), resultSet.getString("available_slots"), resultSet.getString("total_slots"),
					resultSet.getString("from_time"), resultSet.getString("to_time"), resultSet.getString("contact_info"),
					resultSet.getString("latitude"), resultSet.getString("longitude"), resultSet.getString("slot_price"),
					resultSet.getString("avg_ratings"), resultSet.getString("category_id")));
		}
		return venueList;
	}
}
