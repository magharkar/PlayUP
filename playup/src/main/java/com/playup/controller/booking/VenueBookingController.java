package com.playup.controller.booking;

import com.playup.constants.ApplicationConstants;
import com.playup.model.search.SearchVenue;
import com.playup.model.booking.VenueSlot;
import com.playup.service.booking.BookingServiceFactory;
import com.playup.service.booking.INearestVenueLocatorService;
import com.playup.service.booking.IVenueBookingService;
import com.playup.service.payment.ICardFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

/**
 * @author Mugdha Anil Agharkar
 */

@Controller
public class VenueBookingController {
    @Autowired
    private ICardFactoryService cardFactoryService;

    IVenueBookingService venueBookingService;

    INearestVenueLocatorService nearestVenueLocatorService;

    public VenueBookingController() {
        this.venueBookingService = BookingServiceFactory.instance().venueBookingService();
        this.nearestVenueLocatorService = BookingServiceFactory.instance().nearestVenueLocatorService();
    }

    @RequestMapping(value = "venue/nearest_venue/{id}", method = {RequestMethod.GET})
    public String getNearestVenue(@PathVariable (ApplicationConstants.ID_OBJECT) String ide, Model model) {
        String id = nearestVenueLocatorService.getNearestVenue(ide);
        SearchVenue venue = venueBookingService.getVenueDetails(Integer.parseInt(id));

        ArrayList<VenueSlot> slots = venueBookingService.getAllSlots(Integer.parseInt(id));

        model.addAttribute(ApplicationConstants.VENUE_NAME, venue.getVenueName());
        model.addAttribute(ApplicationConstants.VENUE_CITY, venue.getVenueCity());
        model.addAttribute(ApplicationConstants.AVAILABLE_SLOTS, venue.getAvailableSlots());
        model.addAttribute(ApplicationConstants.SLOTS, slots);
        model.addAttribute(ApplicationConstants.ID_OBJECT, id);
        model.addAttribute(ApplicationConstants.AMOUNT, venue.getSlotPrice());
        return ApplicationConstants.VENUE_OBJECT;
    }

    @RequestMapping(value = "/venue/{id}", method = {RequestMethod.GET})
    public String getVenue(@PathVariable(ApplicationConstants.ID_OBJECT) String id, Model model) {
        int venueId = Integer.parseInt(id);

        SearchVenue venue = venueBookingService.getVenueDetails(venueId);

        ArrayList<VenueSlot> slots = venueBookingService.getAllSlots(venueId);
        model.addAttribute(ApplicationConstants.VENUE_NAME, venue.getVenueName());
        model.addAttribute(ApplicationConstants.VENUE_CITY, venue.getVenueCity());
        model.addAttribute(ApplicationConstants.AVAILABLE_SLOTS, venue.getAvailableSlots());
        model.addAttribute(ApplicationConstants.SLOTS, slots);
        model.addAttribute(ApplicationConstants.ID_OBJECT, id);
        model.addAttribute(ApplicationConstants.AMOUNT, venue.getSlotPrice());
        return ApplicationConstants.VENUE_OBJECT;
    }

    @PostMapping("/venue/{id}")
    public String setSlot(@RequestParam (name = ApplicationConstants.SELECTED_SLOT) String selectedSlot,
                          @RequestParam (name = ApplicationConstants.ID_OBJECT) String id,
                          @RequestParam (name = ApplicationConstants.AMOUNT) String amount, Model model) {
        model.addAttribute(ApplicationConstants.ID_OBJECT, id);
        model.addAttribute(ApplicationConstants.SELECTED_SLOT, selectedSlot);
        model.addAttribute(ApplicationConstants.AMOUNT,amount);
        model.addAttribute(ApplicationConstants.CREDIT_CARD_TEXT,cardFactoryService.getCreditCard());
        return ApplicationConstants.PAYMENT_TEXT;
    }

    @GetMapping("/payment_confirmation/{id}/{selectedSlot}")
    public String book(@PathVariable(ApplicationConstants.ID_OBJECT) String id,
                       @PathVariable(ApplicationConstants.SELECTED_SLOT) String selectedSlot,
                       Model model) {
        boolean success = venueBookingService.bookSlot(Integer.parseInt(id), Integer.parseInt(selectedSlot));
        return ApplicationConstants.PAYMENT_CONFIRMATION_TEXT;
    }

}
