package com.playup.model;

import com.playup.database.DataBaseUtilities;

import java.util.ArrayList;
import java.util.List;

public class Sorting {
    public static ArrayList<Venue> fetchVenues(String sortParam){
        String sortingParameter = sortParam;
        List<Venue> sortingList = new ArrayList<>();
        try{
            if(sortingParameter.matches("default") ){
                sortingList = DataBaseUtilities.getVenuesFromDB();
            }
            else if(sortingParameter.matches("alphabetical") ){
                sortingList = DataBaseUtilities.getSortAlphabeticalFromDB();
            }
            else if(sortParam.matches("lowtohigh") ){
                sortingList = DataBaseUtilities.getSortLowToHighRatingsFromDB();
            }
            else if(sortParam.matches("hightolow")){
                sortingList = DataBaseUtilities.getSortHighToLowRatingsFromDB();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ArrayList<Venue>) sortingList;
    }
}
