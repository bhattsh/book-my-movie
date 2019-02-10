package com.cg.bookmymovie.ewallet.ewallet.ewalletservicetest;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookmymovie.ewallet.ewallet.ewallet.Ewallet;
import com.cg.bookmymovie.ewallet.ewallet.ewallet.Statement;
import com.cg.bookmymovie.ewallet.ewallet.ewalletservice.EwalletService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EwalletServiceTest {
	
	Ewallet wallet = new Ewallet(1500.0, null);
	
	
	@Autowired
	private EwalletService service;
	
	
	@Test
	public void testForGetWallets() {
		
		List<Ewallet> serviceTest = service.getAllWallets();
		assertEquals(false, serviceTest.isEmpty());
	}
	
	
	@Test
	@Ignore
	public void testForTransactionCount() {
		List<Statement> serviceTest = service.getStatements();
		assertEquals(6, serviceTest.size());
	}
	
	/*
	 * @Test
	 * 
	 * public void testForTransactionCountForSpecificId() { Set<Statement> statement
	 * = service.getStatement(1); }
	 */
	
	
	
	
	@Test
	@Ignore
	public void testForSizeOfWallets() {
		List<Ewallet> wallet = service.getAllWallets();
		assertEquals(1, service.getAllWallets().size());
	}
	
	
	@Test
	@Ignore
	public void testForCheckBalance() {
		Double balance = service.getById(1).get().getCurrentBalance();
		assertEquals(500.0, balance,0.0);
	}
	
	@Test
	@Ignore
	public void testForGetWalletById() {
		int id = service.getById(1).get().getProfileId();
		assertEquals(1, id);
	}
	
	

	
	@Test
	@Ignore
	public void testForAddMoney() {
		double updatedBalance =service.addMoneyToWallet(1, 100.0);
		assertEquals(1300, updatedBalance,0.0);
	}
	
	@Test
	@Ignore
	public void testForBuyTicket() {
		double updatedBalance = service.buyTicket(1, 100.0);
		assertEquals(1100, updatedBalance,0.0);
	}
	
}


