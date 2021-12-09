package com.playup.dao.Review;


import com.playup.database.PlayupDBConnection;
import com.playup.model.Review.ReviewModel;
import com.playup.model.Review.ViewReviewModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to execute queries and fetch data from the database
 * @author Rajath Bharadwaj
 */
public class ReviewDao {

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
        ResultSet resultSet = PlayupDBConnection.getInstance().readData("Select * from Venues;");
        while (resultSet != null && resultSet.next())
        {
            venueList.add(new ReviewModel(resultSet.getInt("venue_id"),resultSet.getString("name"),
                    resultSet.getString("city"), resultSet.getString("slot_price"),
                    resultSet.getString("avg_ratings")));
        }
        return venueList;
    }

    public static List<ViewReviewModel> getReviewsFromDB() throws SQLException
    {
        List<ViewReviewModel> reviewList = new ArrayList<>();
        ResultSet resultSet = PlayupDBConnection.getInstance().readData("Select review_ratings.title,review_ratings.description,review_ratings.rating,Venues.venue_id,Venues.name from review_ratings INNER JOIN Venues on review_ratings.venue_id= Venues.venue_id");
        while (resultSet != null && resultSet.next())
        {
            reviewList.add(new ViewReviewModel(resultSet.getInt("venue_id"),resultSet.getString("name"), resultSet.getString("title"),
                    resultSet.getString("description"), resultSet.getString("rating")));
        }
        return reviewList;
    }
    
    public static boolean postReviewToDB(int venueID, String title, String description, int rating) {
        boolean resultSet = false;
        try
        {
            String query = "Insert into review_ratings(title,description,venue_id,rating) values("+"'"+title+"'"+","+"'"+description+"'"+","+venueID+","+rating+")";
            System.out.println(query);
            resultSet = PlayupDBConnection.getInstance().updateData(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
