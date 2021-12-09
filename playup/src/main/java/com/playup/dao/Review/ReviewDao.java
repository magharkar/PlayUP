package com.playup.dao.Review;

import com.playup.database.PlayupDBConnection;
import com.playup.model.Review.ReviewModel;
import com.playup.model.Review.ViewReviewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rajath Bharadwaj
 */
public class ReviewDao
{
    public static final String SELECT_QUERY = "Select * from Venues;";
    public static final String SELECT_QUERY_JOINS = "Select review_ratings.title,review_ratings.description,review_ratings.rating,Venues.venue_id,Venues.name from review_ratings INNER JOIN Venues on review_ratings.venue_id= Venues.venue_id";
    public static final String SELECT_QUERY_POST_REVIEW = "Insert into review_ratings(title,description,venue_id,rating) values(";
    public static final String SINGLE_QUOTE = "'";
    public static final String COMMA = ",";
    public static final String BRACKET = ")";
    public static final String VENUE_ID = "venue_id";
    public static final String NAME = "name";
    public static final String CITY = "city";
    public static final String SLOT_PRICE = "slot_price";
    public static final String AVERAGE_RATING = "avg_ratings";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String RATING = "rating";

    private static ReviewDao instance = null;
    public static ReviewDao getInstance()
    {
        if(instance == null)
        {
            instance = new ReviewDao();
        }
        return instance;
    }

    public static List<ReviewModel> getVenuesFromDB() throws SQLException
    {
        List<ReviewModel> venueList = new ArrayList<>();
        ResultSet resultSet = PlayupDBConnection.getInstance().readData(SELECT_QUERY);
        while (resultSet != null && resultSet.next())
        {
            venueList.add(new ReviewModel(resultSet.getInt(VENUE_ID),resultSet.getString(NAME),
                    resultSet.getString(CITY), resultSet.getString(SLOT_PRICE),
                    resultSet.getString(AVERAGE_RATING)));
        }
        return venueList;
    }

    public static List<ViewReviewModel> getReviewsFromDB() throws SQLException
    {
        List<ViewReviewModel> reviewList = new ArrayList<>();
        ResultSet resultSet = PlayupDBConnection.getInstance().readData(SELECT_QUERY_JOINS);
        while (resultSet != null && resultSet.next())
        {
            reviewList.add(new ViewReviewModel(resultSet.getInt(VENUE_ID),resultSet.getString(NAME), resultSet.getString(TITLE),
                    resultSet.getString(DESCRIPTION), resultSet.getString(RATING)));
        }
        return reviewList;
    }
    
    public static boolean postReviewToDB(int venueID, String title, String description, int rating)
    {
        boolean resultSet = false;
        try
        {
            String query = SELECT_QUERY_POST_REVIEW+SINGLE_QUOTE+title+SINGLE_QUOTE+COMMA+SINGLE_QUOTE+description+SINGLE_QUOTE+COMMA+venueID+COMMA+rating+BRACKET;
            System.out.println(query);
            resultSet = PlayupDBConnection.getInstance().updateData(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
