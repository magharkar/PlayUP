package com.playup.service.booking;

import com.playup.dao.booking.INearestVenueLocationDao;

public interface INearestVenueLocatorService {

    public String getNearestVenue(String currentVenueId);


}
