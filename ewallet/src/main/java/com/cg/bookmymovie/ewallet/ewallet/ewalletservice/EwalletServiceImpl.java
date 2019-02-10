package com.cg.bookmymovie.ewallet.ewallet.ewalletservice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookmymovie.ewallet.ewallet.ewallet.Ewallet;
import com.cg.bookmymovie.ewallet.ewallet.ewallet.Statement;
import com.cg.bookmymovie.ewallet.ewallet.ewalletrepository.EwalletRepository;
import com.cg.bookmymovie.ewallet.ewallet.ewalletrepository.StatementRepository;


@Service
public class EwalletServiceImpl implements EwalletService{
	
	
	@Autowired
	private EwalletRepository repo;
	
	@Autowired
	private StatementRepository repoStatement;

	@Override
	public void addWallet(Ewallet wallet) {
		 repo.save(wallet);
	
	}

	@Override
	public List<Ewallet> getAllWallets() {
		return repo.findAll();
		
	}

	/* (non-Javadoc)
	 * @see com.cg.bookmymovie.ewallet.ewallet.ewalletservice.EwalletService#addMoneyToWallet(int, java.lang.Double)
	 */
	@Override
	public double addMoneyToWallet(int profileId, Double amount) {
		Ewallet wallet = repo.findById(profileId).get();
		wallet.setCurrentBalance(wallet.getCurrentBalance()+amount);
		 repo.save(wallet);
		 wallet.setProfileId(profileId);

		Statement statement = new Statement();
		statement.setTransactionType("credit");
		statement.setDateTime(LocalDateTime.now());
		statement.setRemarks("Money Added Successfully...!");
		statement.setAmount(amount);
		statement.setEwallet(wallet);
		repoStatement.save(statement);
		double finalAmount = wallet.getCurrentBalance();
		return finalAmount;
		
	}

	@Override
	public double buyTicket(int profileId, Double amount) {
		
		Ewallet wallet = repo.findById(profileId).get();	
		wallet.setCurrentBalance(wallet.getCurrentBalance()-amount);
		 repo.save(wallet);
		 wallet.setProfileId(profileId);
		 Statement statement = new Statement();
		 statement.setAmount(amount);
		 statement.setDateTime(LocalDateTime.now());
		 statement.setRemarks("ticket purchase successfully...!");
		 statement.setTransactionType("withdraw");
		 statement.setEwallet(wallet);
		 
		 repoStatement.save(statement);
		 double finalBalance = wallet.getCurrentBalance();
		 return finalBalance;
	}

	@Override
	public Optional<Ewallet> getById(int profileId) {
		return repo.findById(profileId);
		
	}
	@Override
	public Set<Statement> getStatement(int profileId) {
		Ewallet wallet = repo.findById(profileId).get();		
		return wallet.getStatement();
	}

	@Override
	public List<Statement> getStatements() {
		
		return repoStatement.findAll();

}
}




