package com.playup.controller;

import com.playup.model.Sorting;
import com.playup.model.Venue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class SortingController {
    @GetMapping("/venues")
    public ModelAndView search() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("venueSorting");
        return mv;
    }

    @RequestMapping(value = "/venues/getVenueResults", method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<Venue> getVenueResults(@RequestBody String sortParam){
        return Sorting.fetchVenues(sortParam);
    }

}
