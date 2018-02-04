package com.hackton.ulertsregistries.model;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Class representing an Sos : the SMS automatically sent by Mayday containing time of the call to emergency service, number
 * that called it, gps coordinates of the phone at the moment of the call.
 */
public class Sos {
	
	private long id;
	private String phoneNumber;
	private Double longitude;
	private Double latitude;
    private LocalDateTime time;
    private String photos;
    
	public Sos(long id, String phoneNumber, Double latitude, Double longitude, LocalDateTime time, String photos) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.time = time;
		this.photos = photos;
	}
	
	public long getId() {
		return id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public String getPhotos() {
		return photos;
	}

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }
}
