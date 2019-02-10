package com.bookyourticket.booking.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking {
	@Id
	private Integer bookingId;
	private Integer profileId;
	private Double totalcost;
	private LocalDateTime bookingDate;
	private Boolean paid;
	static int bookingCount;
	static {
        bookingCount = 1; 
    }
    {
    	bookingId=bookingCount++;
    }
	
	public Booking() {
	}

	public Booking(Integer profileId, Double totalcost, LocalDateTime bookingDate, Boolean paid) {
		super();
		this.profileId = profileId;
		this.totalcost = totalcost;
		this.bookingDate = bookingDate;
		this.paid = paid;
	}
	
	public Integer getBookingId() {
		return bookingId;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public Double getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(Double totalcost) {
		this.totalcost = totalcost;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	@Override
	public String toString() {
		return "Booking [profileId=" + profileId + ", totalcost=" + totalcost + ", bookingDate=" + bookingDate
				+ ", paid=" + paid + "]";
	}
}
