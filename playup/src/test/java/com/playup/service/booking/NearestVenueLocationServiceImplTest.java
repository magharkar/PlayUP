package com.playup.service.booking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class NearestVenueLocationServiceImplTest {

    INearestVenueLocatorService nearestVenueLocatorService = mock(NearestVenueLocatorServiceImpl.class);

    @Test
    void testGetNearestVenue() {

        when(nearestVenueLocatorService.getNearestVenue("2000001")).thenReturn(null);
        assertEquals(nearestVenueLocatorService.getNearestVenue("200001"), null,
                "success");
        verify(nearestVenueLocatorService).getNearestVenue("200001");

    }
}
