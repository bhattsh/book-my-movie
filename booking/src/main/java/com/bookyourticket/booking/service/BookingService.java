package com.bookyourticket.booking.service;

import java.util.List;
import java.util.Optional;

import com.bookyourticket.booking.entity.Booking;

public interface BookingService {
	List<Booking> getAllBookings();

	void createBooking(Booking booking);

	void deleteAccount(int bookingId);

	Optional<Booking> getBookingById(int bookingId); 
//	public Booking getBookingById(int bookingId);
}
