package com.bookyourticket.booking.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bookyourticket.booking.entity.Booking;
import com.bookyourticket.booking.resource.BookingResource;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BookingServiceTests {
	
	@Mock
	private BookingService service;
	
	@Mock
	private BookingResource repository;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void getAllBookings() {
		List<Booking> list = new ArrayList<Booking>();
		Booking firstBooking = new Booking(67, 800.67, LocalDateTime.now(), true);
		Booking secondBooking = new Booking(56, 5600.67, LocalDateTime.now(), false);
		
		list.add(firstBooking);
		list.add(secondBooking);
		
		when(service.getAllBookings()).thenReturn(list);
		
		List<Booking> bookingslist = service.getAllBookings();
		assertEquals(2, bookingslist.size());  
	}
	
	@Test
    public void createBookingsTest()
    {
        Booking booking = new Booking(59, 560.67, LocalDateTime.now(), true);
        service.createBooking(booking); 
         
        verify(service, times(1)).createBooking(booking); 
    }
	
	@Test
	public void deleteBookingById() {
		Booking booking = new Booking(59, 560.67, LocalDateTime.now(), true);
        service.deleteAccount(12);  
         
        verify(service, times(0)).createBooking(booking);  
	}
}
