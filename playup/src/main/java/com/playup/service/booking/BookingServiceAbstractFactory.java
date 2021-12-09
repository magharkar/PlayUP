package com.playup.service.booking;

/**
 * @author Mugdha Anil Agharkar
 */

public abstract class BookingServiceAbstractFactory {
    public abstract IVenueBookingService venueBookingService();

    public abstract INearestVenueLocatorService nearestVenueLocatorService();
}
