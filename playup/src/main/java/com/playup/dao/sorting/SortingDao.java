package com.playup.dao.sorting;

import com.playup.database.PlayupDBConnection;
import com.playup.model.search.SearchVenue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rajath Bharadwaj
 */

public class SortingDao
{
	private static final String VENUE_ID = "venue_id";
	private static final String NAME = "name";
	private static final String CITY = "city";
	private static final String AVAILABLE_SLOTS = "available_slots";
	private static final String TOTAL_SLOTS = "total_slots";
	private static final String FROM_TIME = "from_time";
	private static final String TO_TIME = "to_time";
	private static final String CONTACT_INFO = "contact_info";
	private static final String LATITUDE = "latitude";
	private static final String LONGITUDE = "longitude";
	private static final String SLOT_PRICES = "slot_price";
	private static final String AVERAGE_RATINGS = "avg_ratings";
	private static final String CATEGORY_ID = "category_id";
	private static final String DEFAULT_QUERY = "Select * from Venues;";
	private static final String ALPHABETICAL_QUERY = "Select * from Venues order by name ASC;";
	private static final String LOWTOHIGH_QUERY = "Select * from Venues order by avg_ratings ASC;";
	private static final String HIGHTOLOW_QUERY = "Select * from Venues order by avg_ratings DESC;";

	private static SortingDao instance = null;
	public static SortingDao getInstance()
	{
		if(instance == null)
		{
			instance = new SortingDao();
		}
		return instance;
	}

	public static List<SearchVenue> getVenuesFromDB() throws SQLException
	{
		List<SearchVenue> venueList = new ArrayList<>();
		ResultSet resultSet = PlayupDBConnection.getInstance().readData(DEFAULT_QUERY);
		while (resultSet != null && resultSet.next())
		{
			venueList.add(new SearchVenue(resultSet.getString(VENUE_ID), resultSet.getString(NAME),
					resultSet.getString(CITY), resultSet.getString(AVAILABLE_SLOTS), resultSet.getString(TOTAL_SLOTS),
					resultSet.getString(FROM_TIME), resultSet.getString(TO_TIME), resultSet.getString(CONTACT_INFO),
					resultSet.getString(LATITUDE), resultSet.getString(LONGITUDE), resultSet.getString(SLOT_PRICES),
					resultSet.getString(AVERAGE_RATINGS), resultSet.getString(CATEGORY_ID)));
		}
		return venueList;
	}

	public static List<SearchVenue> getSortAlphabeticalFromDB() throws SQLException
	{
		List<SearchVenue> venueList = new ArrayList<>();
		ResultSet resultSet = PlayupDBConnection.getInstance().readData(ALPHABETICAL_QUERY);
		while (resultSet != null && resultSet.next())
		{
			venueList.add(new SearchVenue(resultSet.getString(VENUE_ID), resultSet.getString(NAME),
					resultSet.getString(CITY), resultSet.getString(AVAILABLE_SLOTS), resultSet.getString(TOTAL_SLOTS),
					resultSet.getString(FROM_TIME), resultSet.getString(TO_TIME), resultSet.getString(CONTACT_INFO),
					resultSet.getString(LATITUDE), resultSet.getString(LONGITUDE), resultSet.getString(SLOT_PRICES),
					resultSet.getString(AVERAGE_RATINGS), resultSet.getString(CATEGORY_ID)));
		}
		return venueList;
	}

	public static List<SearchVenue> getSortLowToHighRatingsFromDB() throws SQLException
	{
		List<SearchVenue> venueList = new ArrayList<>();
		ResultSet resultSet = PlayupDBConnection.getInstance().readData(LOWTOHIGH_QUERY);
		while (resultSet != null && resultSet.next())
		{
			venueList.add(new SearchVenue(resultSet.getString(VENUE_ID), resultSet.getString(NAME),
					resultSet.getString(CITY), resultSet.getString(AVAILABLE_SLOTS), resultSet.getString(TOTAL_SLOTS),
					resultSet.getString(FROM_TIME), resultSet.getString(TO_TIME), resultSet.getString(CONTACT_INFO),
					resultSet.getString(LATITUDE), resultSet.getString(LONGITUDE), resultSet.getString(SLOT_PRICES),
					resultSet.getString(AVERAGE_RATINGS), resultSet.getString(CATEGORY_ID)));
		}
		return venueList;
	}

	public static List<SearchVenue> getSortHighToLowRatingsFromDB() throws SQLException
	{
		List<SearchVenue> venueList = new ArrayList<>();
		ResultSet resultSet = PlayupDBConnection.getInstance().readData(HIGHTOLOW_QUERY);
		while (resultSet != null && resultSet.next())
		{
			venueList.add(new SearchVenue(resultSet.getString(VENUE_ID), resultSet.getString(NAME),
					resultSet.getString(CITY), resultSet.getString(AVAILABLE_SLOTS), resultSet.getString(TOTAL_SLOTS),
					resultSet.getString(FROM_TIME), resultSet.getString(TO_TIME), resultSet.getString(CONTACT_INFO),
					resultSet.getString(LATITUDE), resultSet.getString(LONGITUDE), resultSet.getString(SLOT_PRICES),
					resultSet.getString(AVERAGE_RATINGS), resultSet.getString(CATEGORY_ID)));
		}
		return venueList;
	}

}
