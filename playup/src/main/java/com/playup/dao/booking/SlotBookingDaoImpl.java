package com.playup.dao.booking;

/**
 * @author Mugdha Anil Agharkar
 */

import com.playup.constants.ApplicationConstants;
import com.playup.constants.QueryConstants;
import com.playup.database.PlayupDBConnection;
import com.playup.model.search.SearchVenue;
import com.playup.model.booking.VenueSlot;
import com.playup.model.booking.VenueSlotFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SlotBookingDaoImpl implements ISlotBookingDao {
    private static SlotBookingDaoImpl bookingDaoInstance;

    public SlotBookingDaoImpl(){}

    public static SlotBookingDaoImpl getInstance () {
        if(bookingDaoInstance==null) {
            bookingDaoInstance = new SlotBookingDaoImpl();
            return bookingDaoInstance;
        }
        return bookingDaoInstance;
    }

    @Override
    public SearchVenue getVenueById(int venueId) {
        String query = QueryConstants.GET_VENUE_BY_ID + venueId;
        String sqlQuery = String.format(query);
        ResultSet resultSet = null;
        try {
            resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
            while (resultSet!= null && resultSet.next()) {
                SearchVenue venue = new SearchVenue(resultSet.getString(ApplicationConstants.VENUE_ID), resultSet.getString(ApplicationConstants.NAME),
                        resultSet.getString(ApplicationConstants.CITY), resultSet.getString(ApplicationConstants.AVAILABLE_SLOTS_TABLE), resultSet.getString(ApplicationConstants.TOTAL_SLOTS),
                        resultSet.getString(ApplicationConstants.FROM_TIME), resultSet.getString(ApplicationConstants.TO_TIME), resultSet.getString(ApplicationConstants.CONTACT_INFO),
                        resultSet.getString(ApplicationConstants.LATITUDE), resultSet.getString(ApplicationConstants.LONGITUDE), resultSet.getString(ApplicationConstants.SLOT_PRICE),
                        resultSet.getString(ApplicationConstants.AVG), resultSet.getString(ApplicationConstants.CATEGORY));
                return venue;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<VenueSlot> getSlotsByVenueId(int venueId) {
        String query = QueryConstants.GET_SLOT_BY_VENUE_ID + venueId;
        String sqlQuery = String.format(query);
        ResultSet resultSet = null;
        ArrayList<VenueSlot> venueSlots = new ArrayList<>();
            try {
                resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
                while (resultSet.next()) {
                    VenueSlot venueSlot = VenueSlotFactory.getVenueSlot();
                    venueSlot.setVenueId(resultSet.getInt(ApplicationConstants.VENUE_ID));
                    venueSlot.setSlotId(resultSet.getInt(ApplicationConstants.SLOT_ID));
                    venueSlot.setSlotTiming(resultSet.getString(ApplicationConstants.SLOT_TIMING));
                    venueSlot.setSlotType(resultSet.getString(ApplicationConstants.SLOT_TYPE));
                    venueSlot.setBookingStatus(resultSet.getString(ApplicationConstants.BOOKING_STATUS));
                    venueSlot.setSport(resultSet.getString(ApplicationConstants.SPORT));
                    venueSlots.add(venueSlot);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return venueSlots;
    }

    @Override
    public boolean updateSlot(int venueId, int slotId) {
        String TEXT = "' AND slot_id='";
        String COMMA = "'";
        boolean success = false;
        String query = QueryConstants.UPDATE_SLOT_QUERY +venueId + TEXT + slotId + COMMA;
        String sqlQuery = String.format(query);
        try {
            success = PlayupDBConnection.getInstance().updateData(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean updateVenueSlot(SearchVenue venue) {
        boolean success = false;
        String WHERE = "'WHERE venue_id='";
        String COMMA = "'";
        String updatedSlotCount = venue.getAvailableSlots();
        String venueId = venue.getVenueID();
        String query = QueryConstants.UPDATE_VENUES + updatedSlotCount + WHERE
                + venueId + COMMA;
        String sqlQuery = String.format(query);
        try {
            success = PlayupDBConnection.getInstance().updateData(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
}