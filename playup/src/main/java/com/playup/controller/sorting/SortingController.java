package com.playup.controller.sorting;

import com.playup.model.search.SearchVenue;
import com.playup.service.sorting.ISorting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class SortingController {
    public static final String VENUE_PATH = "/venues";
    public static final String VENUE_RESULTS_PATH = "/venues/getVenueResults";
    public static final String VIEW_NAME = "venueSorting";

    @Autowired
    ISorting sorting;

    @GetMapping(VENUE_PATH)
    public ModelAndView search() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(VIEW_NAME);
        return mv;
    }

    @RequestMapping(value = VENUE_RESULTS_PATH, method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<SearchVenue> getVenueResults(@RequestBody String sortParam) {
        return sorting.fetchVenues(sortParam);
    }

}
