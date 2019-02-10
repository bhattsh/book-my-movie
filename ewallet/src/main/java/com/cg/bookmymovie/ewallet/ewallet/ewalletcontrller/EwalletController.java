package com.cg.bookmymovie.ewallet.ewallet.ewalletcontrller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookmymovie.ewallet.ewallet.ewallet.Ewallet;
import com.cg.bookmymovie.ewallet.ewallet.ewallet.Statement;
import com.cg.bookmymovie.ewallet.ewallet.ewalletservice.EwalletService;

@RestController
@RequestMapping("/ewallets")

public class EwalletController {

	@Autowired
	private EwalletService service;
	

	@PostMapping
	public void addWallet(@RequestBody Ewallet wallet) {
		service.addWallet(wallet);
	}

	@GetMapping
	public List<Ewallet> getAllWallets() {
		return service.getAllWallets();
	}

	@PutMapping("/ewallet/{profileId}")
	public void buyTicket(@PathVariable int profileId, @RequestParam("amount") Double amount) {
		Ewallet wallet = service.getById(profileId).get();
		if(amount>wallet.getCurrentBalance()) {
			double requiredAmount=amount-wallet.getCurrentBalance();
			service.addMoneyToWallet(profileId, requiredAmount);
			service.buyTicket(profileId, amount);
		}
		else 
			service.buyTicket(profileId, amount);
	}

	@GetMapping("/{profileId}")
	public double getById(@PathVariable int profileId) {
		Ewallet wallet = service.getById(profileId).get();
		double currentBalance = wallet.getCurrentBalance();
		return currentBalance;
	}

	@GetMapping("/ewalletsstatement/{profileId}")
	public Set<Statement> getStatement(@PathVariable int profileId){
		return service.getStatement(profileId);
		
	}
	
	@GetMapping("/ewalletsstatements")
	public List<Statement> getStatements(){
		return service.getStatements();
		
	}
	
	@PutMapping("/{profileId}")
	public void addMoneyInToWallet(@PathVariable int profileId , @RequestParam("amount") double amount) {
			service.addMoneyToWallet(profileId, amount);
	}
	
}
