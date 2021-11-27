package com.playup.model;

import com.playup.constants.ApplicationConstants;
import com.playup.service.TicketGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class SupportModel {

    private int ticketNumber;
    private String name;
    private String email;
    private String venue;
    private String description;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SupportModel(){}

    public SupportModel(String name, String email, String venue, String description) {
        this.name = name;
        this.email = email;
        this.venue = venue;
        this.description = description;
    }

    public SupportModel(int ticketNumber,String name, String email, String venue, String description) {
        this.ticketNumber = ticketNumber;
        this.name = name;
        this.email = email;
        this.venue = venue;
        this.description = description;
    }

    public SupportModel( Map<String, String> supportData) {
        this.name = supportData.get("name");
        this.email = supportData.get("email");
        this.venue = supportData.get("venue");
        this.description = supportData.get("description");
        this.ticketNumber = TicketGeneratorService.getInstance().generateTicketNumber(ApplicationConstants.minimumSupportTicketNumber,ApplicationConstants.maximumSupportTicketNumber);
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getName() {
        return name;
    }

    public String getVenue() {
        return venue;
    }

    public String getDescription() {
        return description;
    }
}
