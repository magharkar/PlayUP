package com.playup.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.playup.dao.SearchVenue;

@Controller
public class SearchController {
	
	@GetMapping("/search")
    public ModelAndView search() {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("search");
        return mv;
    }
    
    @RequestMapping(value = "/search/getSearchResults", method = RequestMethod.POST)
    public @ResponseBody ArrayList<Object> getSearchResults(@RequestBody String searchKey){
		return SearchVenue.getInstance().search(searchKey);
    }

}
