package com.cg.bookmymovie.ewallet.ewallet.ewalletcontroller;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookmymovie.ewallet.ewallet.ewallet.Ewallet;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EwalletControllerTest{
	@Autowired
	private TestRestTemplate testRestTemplate;

	Ewallet wallet = new Ewallet(1200.0, null);
	
	
	@Test
	public void testGetAllWallets() {
		
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/ewallets", String.class);
		
		assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
	}
	
	@Test
	@Ignore
	public void testGetAllWalletsWhenThereIsNoControler() {
		
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/ewallets", String.class);
		
		assertEquals(responseEntity.getStatusCode(),HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void testGetAllWalletsWrongUri() {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/ewallet", String.class);
		
		assertEquals(responseEntity.getStatusCode(),HttpStatus.NOT_FOUND);
	}
	
	@Test
	@Ignore
	public void testGetWallet() {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/ewallets/1", String.class);
		assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
	}
	
	@Test
	public void testGetWalletWhichIsNotThere() {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/ewallets/1244", String.class);
		assertEquals(responseEntity.getStatusCode(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	/*
	 * @Test
	 * 
	 * @Ignore public void testForGetWallet() { ResponseEntity<String>
	 * responseEntity = testRestTemplate.getForEntity("/ewallets/1", String.class);
	 * assertEquals(responseEntity.getStatusCode(), HttpStatus.OK); }
	 */
	@Test
	
	public void testForAddWallet() {
		ResponseEntity<String> responseEntity = testRestTemplate.postForEntity("/ewallets", wallet, String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
	}
	
	
	@Test
	@Ignore
	public void testForGetById() {
		ResponseEntity<String> responseEntity= testRestTemplate.getForEntity("/ewallets/1", String.class);
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
		
	}
	

}

