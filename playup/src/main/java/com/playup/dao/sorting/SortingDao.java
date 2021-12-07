package com.playup.dao.sorting;

import com.playup.database.PlayupDBConnection;
import com.playup.model.Venue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to execute queries and fetch data from the database
 * @author Rajath Bharadwaj
 */

public class SortingDao
{

	private static SortingDao instance = null;
	public static SortingDao getInstance()
	{
		if(instance == null)
		{
			instance = new SortingDao();
		}
		return instance;
	}

	public static List<Venue> getVenuesFromDB() throws SQLException
	{
		List<Venue> venueList = new ArrayList<>();
		ResultSet resultSet = PlayupDBConnection.getInstance().readData("Select * from Venues;");
		while (resultSet != null && resultSet.next())
		{
			venueList.add(new Venue(resultSet.getString("venue_id"), resultSet.getString("name"),
					resultSet.getString("city"), resultSet.getString("available_slots"), resultSet.getString("total_slots"),
					resultSet.getString("from_time"), resultSet.getString("to_time"), resultSet.getString("contact_info"),
					resultSet.getString("latitude"), resultSet.getString("longitude"), resultSet.getString("slot_price"),
					resultSet.getString("avg_ratings"), resultSet.getString("category_id")));
		}
		return venueList;
	}
	public static List<Venue> getSortAlphabeticalFromDB() throws SQLException
	{
		List<Venue> venueList = new ArrayList<>();
		ResultSet resultSet = PlayupDBConnection.getInstance().readData("Select * from Venues order by name ASC;");
		while (resultSet != null && resultSet.next())
		{
			venueList.add(new Venue(resultSet.getString("venue_id"), resultSet.getString("name"),
					resultSet.getString("city"), resultSet.getString("available_slots"), resultSet.getString("total_slots"),
					resultSet.getString("from_time"), resultSet.getString("to_time"), resultSet.getString("contact_info"),
					resultSet.getString("latitude"), resultSet.getString("longitude"), resultSet.getString("slot_price"),
					resultSet.getString("avg_ratings"), resultSet.getString("category_id")));
		}
		return venueList;
	}

	public static List<Venue> getSortLowToHighRatingsFromDB() throws SQLException
	{
		List<Venue> venueList = new ArrayList<>();
		ResultSet resultSet = PlayupDBConnection.getInstance().readData("Select * from Venues order by avg_ratings ASC;");
		while (resultSet != null && resultSet.next())
		{
			venueList.add(new Venue(resultSet.getString("venue_id"), resultSet.getString("name"),
					resultSet.getString("city"), resultSet.getString("available_slots"), resultSet.getString("total_slots"),
					resultSet.getString("from_time"), resultSet.getString("to_time"), resultSet.getString("contact_info"),
					resultSet.getString("latitude"), resultSet.getString("longitude"), resultSet.getString("slot_price"),
					resultSet.getString("avg_ratings"), resultSet.getString("category_id")));
		}
		return venueList;
	}

	public static List<Venue> getSortHighToLowRatingsFromDB() throws SQLException
	{
		List<Venue> venueList = new ArrayList<>();
		ResultSet resultSet = PlayupDBConnection.getInstance().readData("Select * from Venues order by avg_ratings DESC;");
		while (resultSet != null && resultSet.next())
		{
			venueList.add(new Venue(resultSet.getString("venue_id"), resultSet.getString("name"),
					resultSet.getString("city"), resultSet.getString("available_slots"), resultSet.getString("total_slots"),
					resultSet.getString("from_time"), resultSet.getString("to_time"), resultSet.getString("contact_info"),
					resultSet.getString("latitude"), resultSet.getString("longitude"), resultSet.getString("slot_price"),
					resultSet.getString("avg_ratings"), resultSet.getString("category_id")));
		}
		return venueList;
	}

}
