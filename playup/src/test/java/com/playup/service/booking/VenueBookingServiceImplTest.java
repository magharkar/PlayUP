package com.playup.service.booking;

import com.playup.model.search.SearchVenue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VenueBookingServiceImplTest {
    IVenueBookingService venueBookingService = mock(VenueBookingServiceImpl.class);
    SearchVenue venue = mock(SearchVenue.class);

    @Test
    boolean testBookSlot() {
        when(venueBookingService.bookSlot(2000001, 1)).thenReturn(true);
        assertEquals(venueBookingService.bookSlot(2000001, 1),true, "slot booked");
        verify(venueBookingService).bookSlot(200001, 1);
        return true;
    }

    @Test
    SearchVenue testGetVenueDetails() {
        when(venueBookingService.getVenueDetails(2000001)).thenReturn(venue);
        assertEquals(venueBookingService.getVenueDetails(2000001),venue, "success");
        verify(venueBookingService).getVenueDetails(200001);
        return venue;
    }

    @Test
    boolean testUpdateVenueAvailability() {
        when(venueBookingService.updateVenueAvailability(2000001)).thenReturn(true);
        assertEquals(venueBookingService.updateVenueAvailability(2000001),true, "success");
        verify(venueBookingService).updateVenueAvailability(200001);
        return true;
    }
}
