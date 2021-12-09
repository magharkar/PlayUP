package com.playup.model.Review;

public class ViewReviewModel {
    int venueID;
    String venueName;
    String averageRating;
    String reviewTitle;
    String reviewDescription;

    public ViewReviewModel(int venue_id, String venueName, String reviewTitle, String reviewDescription, String averageRating) {
        super();
        this.venueID = venue_id;
        this.venueName = venueName;
        this.reviewTitle = reviewTitle;
        this.reviewDescription = reviewDescription;
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

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }
}
