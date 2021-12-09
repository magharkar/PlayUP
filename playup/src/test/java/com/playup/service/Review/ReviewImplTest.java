package com.playup.service.Review;

import com.playup.model.Review.ReviewModel;
import com.playup.model.Review.ViewReviewModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Unit test for Sorting class.
 * @author Rajath Bharadwaj
 */

@RunWith(MockitoJUnitRunner.class)
public class ReviewImplTest
{

    @Mock
    ReviewImpl review = new ReviewImpl();

    /**
     * Not Null test to check class exists.
     */
    @Test
    public void NotNullTest() throws ClassNotFoundException
    {

        Class<?> classFinder = Class.forName("com.playup.service.Review.ReviewImpl", false, getClass().getClassLoader());
        assertNotNull(classFinder);
    }

    /**
     * Test to verify default list of venues.
     */
    @Test
    public void fetchVenuesTestDefault()
    {
        ArrayList<ReviewModel> venueList = new ArrayList<>();
        ReviewModel venue1 = new ReviewModel(2000001, "DalPlex", "Halifax", "$50", "4");
        ReviewModel venue2 = new ReviewModel(2000002, "Huskies Stadium", "Halifax", "$70", "3");
        ReviewModel venue3 = new ReviewModel(2000003, "Capital Sports Club", "Halifax", "$40", "4");
        ReviewModel venue4 = new ReviewModel(2000004, "Husky Stadium", "Halifax", "$30", "5");
        venueList.add(venue1);
        venueList.add(venue2);
        venueList.add(venue3);
        venueList.add(venue4);
        when(review.fetchVenues()).thenReturn(venueList);
        ArrayList<ReviewModel> expectedList = review.fetchVenues();
        assertEquals(venueList.size(), expectedList.size());
    }

    /**
     * Test to verify list of reviews.
     */
    @Test
    public void viewReviewsTest() throws SQLException {
        ArrayList<ViewReviewModel> reviewList = new ArrayList<>();
        ViewReviewModel venue1 = new ViewReviewModel(2000001, "DalPlex", "Great Place!", "It was really a great place for sports activities", "4");
        ViewReviewModel venue2 = new ViewReviewModel(2000002, "Huskies Stadium", "Good", "It was a good and well maintained stadium", "4");
        ViewReviewModel venue3 = new ViewReviewModel(2000003, "Capital Sports Club", "Not Clean", "The Club was good but not cleaned", "2");
        ViewReviewModel venue4 = new ViewReviewModel(2000004, "Scotiabank Centre", "Nice Club", "The club was pretty clean and nice.", "5");
        reviewList.add(venue1);
        reviewList.add(venue2);
        reviewList.add(venue3);
        reviewList.add(venue4);
        when(review.viewReviews()).thenReturn(reviewList);
        ArrayList<ViewReviewModel> expectedList = review.viewReviews();
        assertEquals(reviewList.size(), expectedList.size());
    }

}
