package com.playup.service.booking;


public class BookingServiceFactory extends BookingServiceAbstractFactory {

    private static BookingServiceFactory instance = null;
    private IVenueBookingService venueBookingService;
    private INearestVenueLocatorService nearestVenueLocatorService;

    private BookingServiceFactory() {

    }

    public static BookingServiceFactory instance() {
        if (instance == null) {
            instance = new BookingServiceFactory();
        }
        return instance;
    }

    @Override
    public IVenueBookingService venueBookingService() {
        if(venueBookingService == null) {
            venueBookingService = new VenueBookingServiceImpl();
        }
        return venueBookingService;
    }

    @Override
    public INearestVenueLocatorService nearestVenueLocatorService() {
        if(nearestVenueLocatorService == null) {
            nearestVenueLocatorService = new NearestVenueLocatorServiceImpl();
        }
        return  nearestVenueLocatorService;
    }
}
