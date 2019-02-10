package com.bookyourticket.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookyourticket.booking.entity.Booking;
import com.bookyourticket.booking.repository.BookingRepository;

@Service
public class BookingserviceImpl implements BookingService {
	
	@Autowired
	private BookingRepository repository;

	@Override
	public List<Booking> getAllBookings() {
		return repository.findAll();
	}

	@Override
	public void createBooking(Booking booking) {
		repository.insert(booking);
	}

	@Override
	public void deleteAccount(int bookingId) {
		repository.deleteById(bookingId);
	}

	@Override
	public Optional<Booking> getBookingById(int bookingId) {
		return repository.findById(bookingId);
	}
}
