package com.bookyourticket.booking.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookyourticket.booking.entity.Booking;
import com.bookyourticket.booking.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingResource {
	
	@Autowired
	private BookingService service;
	
	@GetMapping
	public List<Booking> getAllBookings() {
		return service.getAllBookings();
	}
	
	@PostMapping
	public void createBooking(@RequestBody Booking booking) {
		service.createBooking(booking);
	}
	
	@DeleteMapping("/{bookingId}")
	public void deleteAccount(@PathVariable int bookingId) {
		service.deleteAccount(bookingId);
	}
	
	@GetMapping("/{bookingId}")
    public Optional<Booking> getBookingById(@PathVariable int bookingId) {
        return service.getBookingById(bookingId); 
    }
}
