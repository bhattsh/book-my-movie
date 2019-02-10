package com.cg.bookmymovie.screeningservice.testService;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookmymovie.screeningservice.entity.Address;
import com.cg.bookmymovie.screeningservice.entity.Screening;
import com.cg.bookmymovie.screeningservice.service.ScreeningService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ServiceTest {

	@Autowired
	private ScreeningService service;

	Screening screening;

	@Test
	@Ignore
	public void addScreeningSuccessfullyTest() {
		Map<String, Double> priceBySeat = new HashMap<String, Double>();
		priceBySeat.put("front", 100.0);
		priceBySeat.put("middle", 150.0);
		priceBySeat.put("back", 200.0);
		LocalTime movieDuration = LocalTime.of(2, 0);
		screening = new Screening(3, "3 idiots", movieDuration, "thriller", "hindi", "abc", "Inox",
				new Address("Rajasthan", "Jaipur", "Pratap Nagar"), "beta", LocalTime.of(9, 0),
				LocalDate.of(2019, 02, 13), priceBySeat, true);

		assertEquals(true, service.addScreening(screening));
	}

	@Test
	public void addScreeningFailedTest() {
		Map<String, Double> priceBySeat = new HashMap<String, Double>();
		priceBySeat.put("front", 100.0);
		priceBySeat.put("middle", 150.0);
		priceBySeat.put("back", 200.0);
		LocalTime movieDuration = LocalTime.of(2, 0);
		Screening screeningOne = new Screening(3, "3 idiots", movieDuration, "thriller", "hindi", "abc", "Inox",
				new Address("Rajasthan", "Jaipur", "Pratap Nagar"), "beta", LocalTime.of(12, 1), LocalDate.of(2019, 02, 13),
				priceBySeat, true);
		assertEquals(false, service.addScreening(screeningOne));
	}

	
	@Test
	@Ignore
	public void getAllScreeningTest() {
		assertEquals(1, service.getAllScreenings().size());
	}

//Get screening by id test	
	/*
	 * @Test public void getScreeningByIdWithValidIdTest() {
	 * assertEquals(1,service.getScreeningById(1).get().getScreeningId()); }
	 * 
	 * @Test public void getScreeningByIdWithInValidIdTest() {
	 * assertEquals(null,service.getScreeningById(10)); }
	 */

	@Test
	@Ignore
	public void deleteSreeningByIdWhenScreeningToRemoveExistTest() {
		assertEquals(true, service.removeScreeningById(1));
	}
	
	@Test
	public void deleteScreeningByIdWhenScreeningToRemoveNotExist() {
		assertEquals(false, service.removeScreeningById(102));
	}
	
}
