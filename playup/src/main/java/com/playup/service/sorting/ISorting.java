package com.playup.service.sorting;

import com.playup.model.Venue;

import java.util.ArrayList;

public interface ISorting
{
    ArrayList<Venue> fetchVenues(String sortParam);
}
