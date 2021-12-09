package com.playup.service.booking;

public abstract class BookingServiceAbstractFactory {

    public abstract IVenueBookingService venueBookingService();

    public abstract INearestVenueLocatorService nearestVenueLocatorService();
}
