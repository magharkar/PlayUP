package com.playup.dao.booking;

/**
 * @author Mugdha Anil Agharkar
 */

public abstract class BookingAbstractFactoryDao {
    public abstract ISlotBookingDao slotBookingDao();

    public abstract INearestVenueLocationDao nearestLocationDao();

}
