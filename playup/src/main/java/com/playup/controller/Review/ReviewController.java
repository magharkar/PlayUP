package com.playup.controller.Review;

import com.playup.model.Review.ReviewModel;
import com.playup.model.Review.ViewReviewModel;
import com.playup.service.Review.ReviewImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class ReviewController {
    public static final String VENUE_ID = "venueID";
    public static final String POST_REVIEW = "postReview";
    public static final String REDIRECT = "redirect:/review";
    public static final String REVIEW = "/review";
    public static final String VIEW_NAME = "reviewPage";
    public static final String REVIEW_PAGE = "/review/reviewPage";
    public static final String VIEW_REVIEW_PAGE = "/review/viewReviewPage";
    public static final String POST_REVIEW_PAGE = "/review/postReviewPage/{venueID}";


    @GetMapping(REVIEW)
    public ModelAndView search() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_NAME);
        return mv;
    }

    @RequestMapping(value = REVIEW_PAGE, method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<ReviewModel> getVenueResults() {
        return ReviewImpl.getInstance().fetchVenues();
    }

    @RequestMapping(value = VIEW_REVIEW_PAGE, method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<ViewReviewModel> getViewReviewResults() {
        return ReviewImpl.getInstance().viewReviews();
    }

    @RequestMapping(value = POST_REVIEW_PAGE, method = RequestMethod.GET)
    public
    String getPostReviewResults(@PathVariable(VENUE_ID) int venueID, Model model) {
        model.addAttribute(VENUE_ID,venueID);
        return POST_REVIEW;
    }

    @PostMapping(POST_REVIEW_PAGE)
    public String postReview(@RequestParam (name = VENUE_ID) int venueID, @RequestParam String title, @RequestParam String description, @RequestParam int rating) {
        ReviewImpl.getInstance().postReviews(venueID,title,description,rating);
        return REDIRECT;
    }
}
