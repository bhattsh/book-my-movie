package com.cg.bookmymovie.ewallet.ewallet.ewalletservice;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.cg.bookmymovie.ewallet.ewallet.ewallet.Ewallet;
import com.cg.bookmymovie.ewallet.ewallet.ewallet.Statement;

public interface EwalletService {
	
	public void addWallet(Ewallet wallet);

	public List<Ewallet> getAllWallets();

	public double addMoneyToWallet(int profileId, Double amount);

	public double buyTicket(int profileId, Double amount);

	public Optional<Ewallet> getById(int profileId);

	public Set<Statement> getStatement(int profileId);

	public List<Statement> getStatements();
	

}
