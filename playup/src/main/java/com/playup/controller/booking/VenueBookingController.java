//@Author: Mugdha Anil Agharkar

package com.playup.controller.booking;

import com.playup.model.search.SearchVenue;
import com.playup.model.booking.VenueSlot;
import com.playup.service.booking.BookingServiceFactory;
import com.playup.service.booking.INearestVenueLocatorService;
import com.playup.service.booking.IVenueBookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@Controller
public class VenueBookingController {

    IVenueBookingService venueBookingService;
    INearestVenueLocatorService nearestVenueLocatorService;

    public VenueBookingController() {
        this.venueBookingService = BookingServiceFactory.instance().venueBookingService();
        this.nearestVenueLocatorService = BookingServiceFactory.instance().nearestVenueLocatorService();
    }

    @RequestMapping(value = "venue/nearest_venue/{id}", method = {RequestMethod.GET})
    public String getNearestVenue(@PathVariable ("id") String ide, Model model) {

        String id = nearestVenueLocatorService.getNearestVenue(ide);
        SearchVenue venue = venueBookingService.getVenueDetails(Integer.parseInt(id));

        ArrayList<VenueSlot> slots = venueBookingService.getAllSlots(Integer.parseInt(id));
        System.out.println(venue.getVenueID());
        System.out.println(venue.getVenueName());
        System.out.println(venue.getVenueCity());

        model.addAttribute("venueName", venue.getVenueName());
        model.addAttribute("venueCity", venue.getVenueCity());
        model.addAttribute("availableSlots", venue.getAvailableSlots());
        model.addAttribute("slots", slots);
        model.addAttribute("id", id);
        return "venue";


    }

    @RequestMapping(value = "/venue/{id}", method = {RequestMethod.GET})
    public String getLogin(@PathVariable("id") String id, Model model) {
        int venueId = Integer.parseInt(id);

        SearchVenue venue = venueBookingService.getVenueDetails(venueId);

        ArrayList<VenueSlot> slots = venueBookingService.getAllSlots(venueId);
        System.out.println(venue.getVenueID());
        System.out.println(venue.getVenueName());
        System.out.println(venue.getVenueCity());

        model.addAttribute("venueName", venue.getVenueName());
        model.addAttribute("venueCity", venue.getVenueCity());
        model.addAttribute("availableSlots", venue.getAvailableSlots());
        model.addAttribute("slots", slots);
        model.addAttribute("id", id);

        return "venue";
    }

    @PostMapping("/venue/{id}")
    public String setslot(@RequestParam (name = "selectedSlot") String selectedSlot,
                          @RequestParam (name = "id") String id, Model model) {
        System.out.println(selectedSlot);
        System.out.println(id);
        boolean success = venueBookingService.bookSlot(Integer.parseInt(id), Integer.parseInt(selectedSlot));
        System.out.println(success);
        String dynamicUrl = id + "/" + selectedSlot;
        model.addAttribute("id", dynamicUrl);
        return "venue";
    }

}
