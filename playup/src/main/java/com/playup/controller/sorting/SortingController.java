package com.playup.controller;

import com.playup.service.ISorting;
import com.playup.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class SortingController {

    @Autowired
    ISorting sorting;

    @GetMapping("/venues")
    public ModelAndView search() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("venueSorting");
        return mv;
    }

    @RequestMapping(value = "/venues/getVenueResults", method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<Venue> getVenueResults(@RequestBody String sortParam){
        return sorting.fetchVenues(sortParam);
    }

}
