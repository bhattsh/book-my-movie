package com.cg.bookmymovie.screeningservice.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookmymovie.screeningservice.entity.Address;
import com.cg.bookmymovie.screeningservice.entity.Screening;

@Repository
public interface ScreeningRespository extends MongoRepository<Screening, Integer>{

//before adding screening, to check	
	List<Screening> findScreeningByTheatreAddressAndTheatreNameAndAuditoriumNameAndDate(Address theatreAddress, String theatreName, String auditoriumName, LocalDate date);

//for getting specific screening
	Screening findScreeningByTheatreNameAndAuditoriumNameAndDateAndStartTime(String theatreName, String auditoriumName, LocalDate date, LocalTime time);

	List<Screening> findScreeningByDateAndStartTime(LocalDate date, LocalTime time);

	List<Screening> findScreeningByShowing(boolean showing);
}
