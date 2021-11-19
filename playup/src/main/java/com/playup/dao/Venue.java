package com.playup.dao;

public class Venue {
	String venueID;
	String venueName;
	String venueCity;
	String availableSlots;
	String totalSlots;
	String fromTime;
	String toTime;
	String cotactInfo;
	String lattitude;
	String longitude;
	String slotPrice;
	String averageRating;
	String categoryID;
	
	
	
	public Venue(String venueID, String venueName, String venueCity, String availableSlots, String totalSlots,
			String fromTime, String toTime, String cotactInfo, String lattitude, String longitude, String slotPrice,
			String averageRating, String categoryID) {
		super();
		this.venueID = venueID;
		this.venueName = venueName;
		this.venueCity = venueCity;
		this.availableSlots = availableSlots;
		this.totalSlots = totalSlots;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.cotactInfo = cotactInfo;
		this.lattitude = lattitude;
		this.longitude = longitude;
		this.slotPrice = slotPrice;
		this.averageRating = averageRating;
		this.categoryID = categoryID;
	}
	
	public String getVenueID() {
		return venueID;
	}
	public void setVenueID(String venueID) {
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
	public String getAvailableSlots() {
		return availableSlots;
	}
	public void setAvailableSlots(String availableSlots) {
		this.availableSlots = availableSlots;
	}
	public String getTotalSlots() {
		return totalSlots;
	}
	public void setTotalSlots(String totalSlots) {
		this.totalSlots = totalSlots;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	public String getCotactInfo() {
		return cotactInfo;
	}
	public void setCotactInfo(String cotactInfo) {
		this.cotactInfo = cotactInfo;
	}
	public String getLattitude() {
		return lattitude;
	}
	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
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
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

}
