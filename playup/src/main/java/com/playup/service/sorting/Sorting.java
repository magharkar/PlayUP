package com.playup.service;

import com.playup.database.DataBaseUtilities;
import com.playup.model.Venue;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that sorts all venues based on alphabets, low to high ratings and high to low ratings
 * @author Rajath Bharadwaj
 */

@Component
public class Sorting implements ISorting {

    @Override
    public ArrayList<Venue> fetchVenues(String sortParam){
        String sortingParameter = sortParam;
        List<Venue> sortingList = new ArrayList<>();
        try{
            if(sortingParameter.matches("default") ){
                sortingList = DataBaseUtilities.getInstance().getVenuesFromDB();
            }
            else if(sortingParameter.matches("alphabetical") ){
                sortingList = DataBaseUtilities.getInstance().getSortAlphabeticalFromDB();
            }
            else if(sortParam.matches("lowtohigh") ){
                sortingList = DataBaseUtilities.getInstance().getSortLowToHighRatingsFromDB();
            }
            else if(sortParam.matches("hightolow")){
                sortingList = DataBaseUtilities.getInstance().getSortHighToLowRatingsFromDB();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ArrayList<Venue>) sortingList;
    }
}
