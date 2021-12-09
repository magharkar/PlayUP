/**
 * @author Mugdha Anil Agharkar
 */
package com.playup.model.booking;

public class VenueSlot {
    private int venueId;
    private int slotId;
    private String slotTiming;
    private String slotType;
    private String bookingStatus;
    private String sport;

    public VenueSlot() {}

    public VenueSlot(int venueId, int slotId, String slotTiming, String slotType, String bookingStatus, String sport) {
        this.venueId = venueId;
        this.slotId = slotId;
        this.slotTiming = slotTiming;
        this.slotType  = slotType;
        this.bookingStatus = bookingStatus;
        this.sport = sport;
    }

    public VenueSlot(int slotId, String slotType, String bookingStatus, String sport) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.bookingStatus = bookingStatus;
        this.sport = sport;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getSlotTiming() {
        return slotTiming;
    }

    public void setSlotTiming(String slotTiming) {
        this.slotTiming = slotTiming;
    }

    public String getSlotType() {
        return slotType;
    }

    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
