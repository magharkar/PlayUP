package com.playup.dao.search;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import com.playup.database.PlayupDBConnection;
import com.playup.model.search.AbstractSearchFactory;
import com.playup.model.search.SearchVenue;

/**
 * @author vibhorbhatnagar
 */

public class SearchVenueDao extends AbstractSearchFactory {
	@Override
	public ArrayList<Object> search(String searchKey) {
		try {
			List<SearchVenue> venuesList = getVenuesFromDB();
			ArrayList<Object> searchResults = new ArrayList<Object>();
			searchResults.addAll(filterBySearchKey(venuesList, searchKey));
			return searchResults;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Collection<SearchVenue> filterBySearchKey(List<SearchVenue> venuesList, String searchKey) {
		Collection<SearchVenue> venueCollection = new HashSet<>();
		for (SearchVenue venue : venuesList) {
			if (venue.getVenueName().toLowerCase().contains(searchKey.toLowerCase())) {
				venueCollection.add(venue);
				continue;
			} else if (venue.getVenueID().contains(searchKey.toLowerCase())) {
				venueCollection.add(venue);
				continue;
			} else if (venue.getVenueCity().toLowerCase().contains(searchKey.toLowerCase())) {
				venueCollection.add(venue);
				continue;
			}
		}
		return venueCollection;
	}

	public List<SearchVenue> getVenuesFromDB() throws SQLException {
		List<SearchVenue> venueList = new ArrayList<>();
		ResultSet resultSet = PlayupDBConnection.getInstance().readData("Select * from Venues;");
		while (resultSet != null && resultSet.next()) {
			venueList.add(new SearchVenue(resultSet.getString("venue_id"), resultSet.getString("name"),
					resultSet.getString("city"), resultSet.getString("available_slots"),
					resultSet.getString("total_slots"), resultSet.getString("from_time"),
					resultSet.getString("to_time"), resultSet.getString("contact_info"),
					resultSet.getString("latitude"), resultSet.getString("longitude"),
					resultSet.getString("slot_price"), resultSet.getString("avg_ratings"),
					resultSet.getString("category_id")));
		}
		return venueList;
	}

}
