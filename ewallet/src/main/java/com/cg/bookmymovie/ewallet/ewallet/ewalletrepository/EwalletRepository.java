package com.cg.bookmymovie.ewallet.ewallet.ewalletrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookmymovie.ewallet.ewallet.ewallet.Ewallet;


@Repository
public interface EwalletRepository extends JpaRepository<Ewallet, Integer>{
	
}

