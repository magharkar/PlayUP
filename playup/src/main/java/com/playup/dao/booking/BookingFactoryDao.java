package com.playup.dao.booking;

/**
 * @author Mugdha Anil Agharkar
 */

public class BookingFactoryDao extends BookingAbstractFactoryDao {
    private static BookingFactoryDao instance = null;
    private ISlotBookingDao slotBookingDao;
    private INearestVenueLocationDao nearestLocationDao;

    private BookingFactoryDao() {}

    public static BookingFactoryDao instance() {
        if (null == instance) {
            instance = new BookingFactoryDao();
        }
        return instance;
    }

    @Override
    public ISlotBookingDao slotBookingDao() {
        if(slotBookingDao == null) {
            slotBookingDao = new SlotBookingDaoImpl();
        }
        return slotBookingDao;
    }

    @Override
    public INearestVenueLocationDao nearestLocationDao() {
        if(nearestLocationDao == null) {
            nearestLocationDao = new NearestVenueLocationDaoImpl();
        }
        return nearestLocationDao;
    }
}
