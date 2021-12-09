package com.playup.service.sorting;

import java.util.ArrayList;

import com.playup.model.search.SearchVenue;

public interface ISorting {
    ArrayList<SearchVenue> fetchVenues(String sortParam);
}
