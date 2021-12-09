package com.playup.tests.service.sorting;

import com.playup.model.search.SearchVenue;
import com.playup.service.sorting.ISorting;
import com.playup.service.sorting.SortingImpl;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for Sorting class.
 * @author Rajath Bharadwaj
 */

public class SortingImplTest
{
    @Mock
    ISorting sorting = new SortingImpl();

    /**
     * Not Null test to check Calculator class exists.
     */
    @Test
    public void NotNullTest() throws ClassNotFoundException
    {

        Class<?> classFinder = Class.forName("com.playup.service.sorting.SortingImpl", false, getClass().getClassLoader());
        assertNotNull(classFinder);
    }

    /**
     * Test to verify default list of venues.
     */
    @Test
    public void fetchVenuesTestDefault()
    {

        ArrayList<SearchVenue> venueList = new ArrayList<>();
        SearchVenue venue1 = new SearchVenue("2000001", "DalPlex", "Halifax", "5", "10", "8:00:00", "20:00", "",
                "44.6345Ą N", "63.5926Ą W", "$50", "4", "0");
        SearchVenue venue2 = new SearchVenue("2000002", "Huskies Stadium", "Halifax", "12", "15", "6:00:00", "21:00:00", "",
                "44.6312Ą N", "63.5795Ą W", "$70", "3", "0");
        SearchVenue venue3 = new SearchVenue("2000003", "Capital Sports Club", "Halifax", "10", "20", "7:00:00", "22:00:00", "",
                "44.6597Ą N", "63.6643Ą W", "$40", "4", "0");
        SearchVenue venue4 = new SearchVenue("2000003", "Husky Stadium", "Halifax", "7", "10", "8:00:00", "20:00", "",
                "47.6504Ą N", "122.3016Ą W", "$30", "5", "0");
        venueList.add(venue1);
        venueList.add(venue2);
        venueList.add(venue3);
        venueList.add(venue4);
        ArrayList<SearchVenue> expectedList = sorting.fetchVenues("default");
        assertEquals(venueList.size(), expectedList.size());
    }

    /**
     * Test to verify alphabetical list of venues.
     */
    @Test
    public void fetchVenuesTestAlphabetical()
    {

        ArrayList<SearchVenue> venueList = new ArrayList<>();
        SearchVenue venue2 = new SearchVenue("2000001", "DalPlex", "Halifax", "5", "10", "8:00:00", "20:00", "",
                "44.6345Ą N", "63.5926Ą W", "$50", "4", "0");
        SearchVenue venue3 = new SearchVenue("2000002", "Huskies Stadium", "Halifax", "12", "15", "6:00:00", "21:00:00", "",
                "44.6312Ą N", "63.5795Ą W", "$70", "3", "0");
        SearchVenue venue1 = new SearchVenue("2000003", "Capital Sports Club", "Halifax", "10", "20", "7:00:00", "22:00:00", "",
                "44.6597Ą N", "63.6643Ą W", "$40", "4", "0");
        SearchVenue venue4 = new SearchVenue("2000003", "Husky Stadium", "Halifax", "7", "10", "8:00:00", "20:00", "",
                "47.6504Ą N", "122.3016Ą W", "$30", "5", "0");
        venueList.add(venue1);
        venueList.add(venue2);
        venueList.add(venue3);
        venueList.add(venue4);
        ArrayList<SearchVenue> expectedList = sorting.fetchVenues("alphabetical");
        assertEquals(venueList.size(), expectedList.size());

    }

    /**
     * Test to verify low to high rating list of venues.
     */
    @Test
    public void fetchVenuesTestLowToHigh()
    {

        ArrayList<SearchVenue> venueList = new ArrayList<>();
        SearchVenue venue2 = new SearchVenue("2000001", "DalPlex", "Halifax", "5", "10", "8:00:00", "20:00", "",
                "44.6345Ą N", "63.5926Ą W", "$50", "4", "0");
        SearchVenue venue1 = new SearchVenue("2000002", "Huskies Stadium", "Halifax", "12", "15", "6:00:00", "21:00:00", "",
                "44.6312Ą N", "63.5795Ą W", "$70", "3", "0");
        SearchVenue venue3 = new SearchVenue("2000003", "Capital Sports Club", "Halifax", "10", "20", "7:00:00", "22:00:00", "",
                "44.6597Ą N", "63.6643Ą W", "$40", "4", "0");
        SearchVenue venue4 = new SearchVenue("2000003", "Husky Stadium", "Halifax", "7", "10", "8:00:00", "20:00", "",
                "47.6504Ą N", "122.3016Ą W", "$30", "5", "0");
        venueList.add(venue1);
        venueList.add(venue2);
        venueList.add(venue3);
        venueList.add(venue4);
        ArrayList<SearchVenue> expectedList = sorting.fetchVenues("lowtohigh");
        assertEquals(venueList.size(), expectedList.size());

    }

    /**
     * Test to verify high to low rating list of venues.
     */
    @Test
    public void fetchVenuesTestHighToLow()
    {

        ArrayList<SearchVenue> venueList = new ArrayList<>();
        SearchVenue venue2 = new SearchVenue("2000001", "DalPlex", "Halifax", "5", "10", "8:00:00", "20:00", "",
                "44.6345Ą N", "63.5926Ą W", "$50", "4", "0");
        SearchVenue venue4 = new SearchVenue("2000002", "Huskies Stadium", "Halifax", "12", "15", "6:00:00", "21:00:00", "",
                "44.6312Ą N", "63.5795Ą W", "$70", "3", "0");
        SearchVenue venue3 = new SearchVenue("2000003", "Capital Sports Club", "Halifax", "10", "20", "7:00:00", "22:00:00", "",
                "44.6597Ą N", "63.6643Ą W", "$40", "4", "0");
        SearchVenue venue1 = new SearchVenue("2000003", "Husky Stadium", "Halifax", "7", "10", "8:00:00", "20:00", "",
                "47.6504Ą N", "122.3016Ą W", "$30", "5", "0");
        venueList.add(venue1);
        venueList.add(venue2);
        venueList.add(venue3);
        venueList.add(venue4);
        ArrayList<SearchVenue> expectedList = sorting.fetchVenues("hightolow");
        assertEquals(venueList.size(), expectedList.size());

    }
}
