package com.playup.model.Review;

public class ReviewModel {

    int venueID;
    String venueName;
    String venueCity;
    String slotPrice;
    String averageRating;


    public ReviewModel(int venue_id, String venueName, String venueCity, String slotPrice,
                       String averageRating) {
        super();
        this.venueID = venue_id;
        this.venueName = venueName;
        this.venueCity = venueCity;
        this.slotPrice = slotPrice;
        this.averageRating = averageRating;
    }

    public int getVenueID() {
        return venueID;
    }
    public void setVenueID(int venueID) {
        this.venueID = venueID;
    }
    public String getVenueName() {
        return venueName;
    }
    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }
    public String getVenueCity() {
        return venueCity;
    }
    public void setVenueCity(String venueCity) {
        this.venueCity = venueCity;
    }
    public String getSlotPrice() {
        return slotPrice;
    }
    public void setSlotPrice(String slotPrice) {
        this.slotPrice = slotPrice;
    }
    public String getAverageRating() {
        return averageRating;
    }
    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }


}
