package com.playup.service.Review;

import com.playup.dao.Review.ReviewDao;
import com.playup.model.Review.ReviewModel;
import com.playup.model.Review.ViewReviewModel;

import java.util.ArrayList;
import java.util.List;

public class ReviewImpl {

    private static ReviewImpl instance = null;
    public static ReviewImpl getInstance()
    {
        if(instance == null)
        {
            instance = new ReviewImpl();
        }
        return instance;
    }

    public ArrayList<ReviewModel> fetchVenues()
    {
        List<ReviewModel> venueList = new ArrayList<>();
        try
        {
            venueList = ReviewDao.getInstance().getVenuesFromDB();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return (ArrayList<ReviewModel>) venueList;
    }

    public ArrayList<ViewReviewModel> viewReviews()
    {
        List<ViewReviewModel> viewReviewList = new ArrayList<>();
        try
        {
            viewReviewList = ReviewDao.getInstance().getReviewsFromDB();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return (ArrayList<ViewReviewModel>) viewReviewList;
    }

    public void postReviews(int venueID, String title, String description, int rating)
    {
       ReviewDao.getInstance().postReviewToDB( venueID,title,description,rating);
    }
}
