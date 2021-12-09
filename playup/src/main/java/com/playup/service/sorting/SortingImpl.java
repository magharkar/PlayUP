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
    public static final String DEFAULT = "default";
    public static final String ALPHABETICAL = "alphabetical";
    public static final String LOWTOHIGH = "lowtohigh";
    public static final String HIGHTOLOW = "hightolow";

    @Override
    public ArrayList<SearchVenue> fetchVenues(String sortParam)
    {
        String sortingParameter = sortParam;
        List<SearchVenue> sortingList = new ArrayList<>();
        try{
            if(sortingParameter.matches(DEFAULT))
            {
                sortingList = SortingDao.getInstance().getVenuesFromDB();
            }
            else if(sortingParameter.matches(ALPHABETICAL))
            {
                sortingList = SortingDao.getInstance().getSortAlphabeticalFromDB();
            }
            else if(sortParam.matches(LOWTOHIGH))
            {
                sortingList = SortingDao.getInstance().getSortLowToHighRatingsFromDB();
            }
            else if(sortParam.matches(HIGHTOLOW))
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
