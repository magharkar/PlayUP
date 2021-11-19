package com.playup.model;

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
