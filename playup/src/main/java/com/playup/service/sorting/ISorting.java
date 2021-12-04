package com.playup.service;

import com.playup.model.Venue;

import java.util.ArrayList;

public interface ISorting {
    public ArrayList<Venue> fetchVenues(String sortParam);
}
