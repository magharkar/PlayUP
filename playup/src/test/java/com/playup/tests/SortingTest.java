package com.playup.tests;

import com.playup.model.Sorting;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertNotNull;

/**
 * Unit test for Sorting class.
 */

public class SortingTest {
    @Mock
    Sorting sorting = new Sorting();

    /**
     * Not Null test to check Calculator class exists.
     */

    @Test
    public void NotNullTest() throws ClassNotFoundException
    {
        Class<?> classFinder = Class.forName("com.playup.model.Sorting", false, getClass().getClassLoader());
        assertNotNull(classFinder);

    }

//    @Test
//    public void fetchVenuesTestDefault() {
//        ArrayList<Venue> venueList = new ArrayList<>();
//        Venue venue1 = new Venue("2000001", "DalPlex", "Halifax", "5", "10", "8:00:00", "20:00", "",
//                "44.6345Ą N", "63.5926Ą W", "$50", "4", "0");
//        Venue venue2 = new Venue("2000002", "Huskies Stadium", "Halifax", "12", "15", "6:00:00", "21:00:00", "",
//                "44.6312Ą N", "63.5795Ą W", "$70", "3", "0");
//        Venue venue3 = new Venue("2000003", "Capital Sports Club", "Halifax", "10", "20", "7:00:00", "22:00:00", "",
//                "44.6597Ą N", "63.6643Ą W", "$40", "4", "0");
//        Venue venue4 = new Venue("2000003", "Husky Stadium", "Halifax", "7", "10", "8:00:00", "20:00", "",
//                "47.6504Ą N", "122.3016Ą W", "$30", "5", "0");
//        venueList.add(venue1);
//        venueList.add(venue2);
//        venueList.add(venue3);
//        venueList.add(venue4);
//        when(Sorting.fetchVenues("default")).thenReturn((venueList));
//        //assertEquals(venueList, Sorting.fetchVenues("default"));
//
//    }
}
