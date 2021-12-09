/**
 * @author Mugdha Anil Agharkar
 */
package com.playup.dao.booking;

public abstract class BookingAbstractFactoryDao {
    public abstract ISlotBookingDao slotBookingDao();

    public abstract INearestVenueLocationDao nearestLocationDao();

}
