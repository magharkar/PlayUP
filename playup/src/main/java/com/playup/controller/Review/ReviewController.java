package com.playup.controller.Review;

import com.playup.model.Review.ReviewModel;
import com.playup.model.Review.ViewReviewModel;
import com.playup.service.Review.ReviewImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class ReviewController {

    @GetMapping("/review")
    public ModelAndView search()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("reviewPage");
        return mv;
    }

    @RequestMapping(value = "/review/reviewPage", method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<ReviewModel> getVenueResults()
    {
        return ReviewImpl.getInstance().fetchVenues();
    }

    @RequestMapping(value = "/review/viewReviewPage", method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<ViewReviewModel> getViewReviewResults()
    {
        return ReviewImpl.getInstance().viewReviews();
    }

    @RequestMapping(value = "/review/postReviewPage/{venueID}", method = RequestMethod.GET)
    public
    String getPostReviewResults(@PathVariable("venueID") int venueID, Model model)
    {
        model.addAttribute("venueID",venueID);
        return "postReview";
    }

    @PostMapping("/review/postReviewPage/{venueID}")
    public String postReview(@RequestParam (name = "venueID") int venueID, @RequestParam String title, @RequestParam String description, @RequestParam int rating) throws SQLException
    {
        ReviewImpl.getInstance().postReviews(venueID,title,description,rating);
        return "redirect:/review";
    }
}
