package com.playup.service.sorting;

import com.playup.dao.sorting.SortingDao;
import com.playup.model.search.SearchVenue;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that sorts all venues based on alphabets, low to high ratings and high to low ratings
 * @author Rajath Bharadwaj
 */

@Component
public class SortingImpl implements ISorting
{
    @Override
    public ArrayList<SearchVenue> fetchVenues(String sortParam)
    {
        String sortingParameter = sortParam;
        List<SearchVenue> sortingList = new ArrayList<>();
        try{
            if(sortingParameter.matches("default"))
            {
                sortingList = SortingDao.getInstance().getVenuesFromDB();
            }
            else if(sortingParameter.matches("alphabetical"))
            {
                sortingList = SortingDao.getInstance().getSortAlphabeticalFromDB();
            }
            else if(sortParam.matches("lowtohigh"))
            {
                sortingList = SortingDao.getInstance().getSortLowToHighRatingsFromDB();
            }
            else if(sortParam.matches("hightolow"))
            {
                sortingList = SortingDao.getInstance().getSortHighToLowRatingsFromDB();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return (ArrayList<SearchVenue>) sortingList;
    }
}
