package com.cg.bookmymovie.screeningservice.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookmymovie.screeningservice.Repository.ScreeningRespository;
import com.cg.bookmymovie.screeningservice.entity.Address;
import com.cg.bookmymovie.screeningservice.entity.Screening;

@Service
public class ScreeningServiceImpl implements ScreeningService{

	@Autowired
	private ScreeningRespository repository;
	
	@Override
	public boolean addScreening(Screening newScreening) {
		
		List<Screening> screeningMovies = repository.findScreeningByTheatreAddressAndTheatreNameAndAuditoriumNameAndDate(newScreening.getTheatreAddress(),
				newScreening.getTheatreName(), newScreening.getAuditoriumName(), newScreening.getDate());
		
		if (screeningMovies == null) {
			System.out.println("no screening to conflict");
			repository.save(newScreening);
			return true;
			
		} else {
			for (Screening screening : screeningMovies)	{			
				/*
				 * System.out.println("possibility of conflict");
				 * System.out.println("screening i'm about to add time :"+
				 * newScreening.getStartTime() +
				 * "Screening in DB time : "+(screening.getStartTime()).plusHours(screening.
				 * getMovieDuration().getHour()).
				 * plusMinutes(screening.getMovieDuration().getMinute()).plus(1,
				 * ChronoUnit.HOURS)); System.out.println(screening.getStartTime() +
				 * " "+screening.getMovieDuration());
				 */				
				if (newScreening.getStartTime().isBefore((screening.getStartTime()).plusHours(screening.getMovieDuration().getHour()).
						plusMinutes(screening.getMovieDuration().getMinute()).plus(1, ChronoUnit.HOURS)))
					return false;
			
			
			}
			repository.save(newScreening);
			return true;
		}
	}
	
	/*
	 * @Override public List<Screening> getScreenings(Address theatreAddress, String
	 * theatreName, String auditoriumName, LocalDate date) { return repository.
	 * findScreeningByTheatreAddressAndTheatreNameAndAuditoriumNameAndDate(
	 * theatreAddress, theatreName, auditoriumName, date); }
	 */

	@Override
	public List<Screening> getAllScreenings() {
		return repository.findAll();
	}

	
	@Override
	public List<Screening> getSpecificScreening(Address address, String theatreName, String auditoriumName, LocalDate date,
			LocalTime time) {
		System.out.println(theatreName + " "+auditoriumName + " "+date + " "+time);
		Screening screening = repository.findScreeningByTheatreNameAndAuditoriumNameAndDateAndStartTime(theatreName, auditoriumName, date, time);
		System.out.println(screening.getAuditoriumName());
		return null;
	}
	
	@Override
	public boolean removeScreeningById(int screeningId) {
		if(repository.existsById(screeningId)) {
			 
			Optional<Screening> screeningToRemove = repository.findById(screeningId);
			if(screeningToRemove.get().isShowing() == true)
				return false;
			
			repository.deleteById(screeningId);		
			return true;
		}
			return false;
	}

//Incomplete 	
	@Override
	public boolean updateScreening() {
		List<Screening> screeningsToUpdate = repository.findScreeningByShowing(true);
		
		/*if(screeningsToUpdate == null)
			return false;
		else {
			for(Screening screening: screeningsToUpdate)
			{
				if(screening.getDate().isBefore(LocalDate.now()) && screening.getStartTime().isBefore(LocalTime.now()) )
				
			}	
			return false;
	}*/
	return false;
}
	
}