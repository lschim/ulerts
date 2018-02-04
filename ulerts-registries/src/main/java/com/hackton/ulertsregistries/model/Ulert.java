package com.hackton.ulertsregistries.model;

import java.time.LocalDateTime;
import java.util.Map;

public class Ulert {
	
	private long id;
	private Integer phoneNumber;
	private Map<Double,Double> gpsCoordinates;
    private LocalDateTime time;
    private String photos;
    
	public Ulert(long id, Integer phoneNumber, Map<Double, Double> gpsCoordinates, LocalDateTime time, String photos) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.gpsCoordinates = gpsCoordinates;
		this.time = time;
		this.photos = photos;
	}
	
	public long getId() {
		return id;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public Map<Double, Double> getGpsCoordinates() {
		return gpsCoordinates;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public String getPhotos() {
		return photos;
	}
}
