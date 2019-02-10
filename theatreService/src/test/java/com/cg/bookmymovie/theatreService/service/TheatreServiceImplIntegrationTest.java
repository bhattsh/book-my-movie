
package com.cg.bookmymovie.theatreService.service;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookmymovie.theatreService.entity.Address;
import com.cg.bookmymovie.theatreService.entity.Auditorium;
import com.cg.bookmymovie.theatreService.entity.Seat;
import com.cg.bookmymovie.theatreService.entity.Theatre;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TheatreServiceImplIntegrationTest {

	@Autowired(required = true)
	private TheatreService theatreService;

	Theatre theatre, theatre2;

	@Before
	public void addTheatreFailedTest() {

		Set<Seat> seatSet = new HashSet<Seat>();
		Set<Auditorium> auditoriumSet = new HashSet<Auditorium>();

		seatSet.add(new Seat("Balcony", "M", 12));
		auditoriumSet.add(new Auditorium("Kibe", seatSet));
		Address address = new Address("Prabhat Road", "Maharashtra", "Pune");
		theatre = new Theatre(1, "E-SQUARE", address, auditoriumSet);
		theatre2 = new Theatre(2, "Wave Mall", address, auditoriumSet);
	}

	@Test
	@Ignore
	public void testGetTheatreByWrongId() {
		assertEquals(null, theatreService.getTheatreById(1));
	}

	@Test
	@Ignore
	public void testGetTheatreByCorrectId() {
		assertEquals(theatre.getTheatreName(), theatreService.getTheatreById(1).get().getTheatreName());
	}

	@Test
	@Ignore
	public void testDeleteTheatre() {
		theatreService.deleteTheatre(theatre);
		assertEquals(null, theatreService.getTheatreById(1));
	}

	@Test
	@Ignore
	public void testgetAllTheatreQuantity() {
		assertEquals(2, theatreService.getAllTheatres().size());
	}
	
	@Test
	@Ignore
	public void addNewTheatres() {
		theatreService.addNewTheatre(theatre2);
		System.out.println("hello");
		System.out.println(theatreService.getTheatreById(2).get().getTheatreName());
		assertEquals("Wave Mall", theatreService.getTheatreById(2).get().getTheatreName());
	}
}
