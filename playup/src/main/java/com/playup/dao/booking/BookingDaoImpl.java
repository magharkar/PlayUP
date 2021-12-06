package com.playup.dao.booking;

import com.playup.database.PlayupDBConnection;
import com.playup.model.Venue;
import com.playup.model.booking.VenueSlot;
import com.playup.model.booking.VenueSlotFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingDaoImpl implements IBookingDao {

    private static BookingDaoImpl bookingDaoInstance;

    private BookingDaoImpl(){}

    public static BookingDaoImpl getInstance () {
        if(bookingDaoInstance==null) {
            bookingDaoInstance = new BookingDaoImpl();
            return bookingDaoInstance;
        }
        return bookingDaoInstance;
    }

    @Override
    public Venue getVenueById(int venueId) {
        String query = "Select * from Venues where venue_id=" + venueId;
        String sqlQuery = String.format(query);
        System.out.println(sqlQuery);
        ResultSet resultSet = null;
        try {
            resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
            while (resultSet!= null && resultSet.next()) {
                Venue venue = new Venue(resultSet.getString("venue_id"), resultSet.getString("name"),
                        resultSet.getString("city"), resultSet.getString("available_slots"), resultSet.getString("total_slots"),
                        resultSet.getString("from_time"), resultSet.getString("to_time"), resultSet.getString("contact_info"),
                        resultSet.getString("latitude"), resultSet.getString("longitude"), resultSet.getString("slot_price"),
                        resultSet.getString("avg_ratings"), resultSet.getString("category_id"));
                return venue;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<VenueSlot> getSlotsByVenueId(int venueId) {

        String query = "Select * from venue_slot_mapping where venue_id=" + venueId;
        String sqlQuery = String.format(query);
        ResultSet resultSet = null;
        ArrayList<VenueSlot> venueSlots = new ArrayList<>();

            try {
                resultSet = PlayupDBConnection.getInstance().readData(sqlQuery);
                while (resultSet.next()) {
                    VenueSlot venueSlot = VenueSlotFactory.getVenueSlot();
                    venueSlot.setVenueId(resultSet.getInt("venue_id"));
                    venueSlot.setSlotId(resultSet.getInt("slot_id"));
                    venueSlot.setSlotTiming(resultSet.getString("slot_timing"));
                    venueSlot.setSlotType(resultSet.getString("slot_type"));
                    venueSlot.setBookingStatus(resultSet.getString("booking_status"));
                    venueSlots.add(venueSlot);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return venueSlots;
    }

    @Override
    public boolean updateSlot(int venueId, int slotId) {
        boolean success = false;
        String query = "Update venue_slot_mapping SET booking_status= 'unavailable' WHERE venue_id="
                + "'" + venueId + "'" + " AND slot_id=" + "'" + slotId + "'";
        String sqlQuery = String.format(query);
        System.out.println(sqlQuery);
        try {
            success = PlayupDBConnection.getInstance().updateData(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean updateVenueSlot(Venue venue) {
        boolean success = false;
        String updatedSlotCount = venue.getAvailableSlots();
        String venueId = venue.getVenueID();
        String query = "Update Venues SET available_slots=" + "'" + updatedSlotCount + "'" + "WHERE venue_id="
                + "'" + venueId + "'";
        String sqlQuery = String.format(query);
        System.out.println(sqlQuery);
        try {
            success = PlayupDBConnection.getInstance().updateData(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

}
