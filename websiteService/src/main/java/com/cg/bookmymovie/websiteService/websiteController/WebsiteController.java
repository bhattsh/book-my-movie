package com.cg.bookmymovie.websiteService.websiteController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.cg.bookmymovie.ewallet.ewallet.ewallet.Ewallet;
import com.cg.bookmymovie.movie.movie.entity.Movie;
import com.cg.bookmymovie.screeningservice.entity.Address;
import com.cg.bookmymovie.screeningservice.entity.Screening;

@RestController
public class WebsiteController {

	@Autowired
	private RestTemplate template;

	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("hello", "message", "shubham bhatt");
	}

	
	@RequestMapping("/welcome")
	public ModelAndView welcomePage() {
		return new ModelAndView("hello", "message", "shubham bhatt");
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/cityToSearch")
	public ModelAndView searchMovieInACity(@RequestParam String cityToSearch) {

		Set<Screening> allMovieShowingInACity = new HashSet<Screening>();

		ResponseEntity<Screening[]> screening = template.getForEntity("http://localhost:9090/screenings",
				Screening[].class);

		List<Screening> allScreenings = Arrays.asList(screening.getBody());

		for (Screening screeningToValidate : allScreenings) {

			Address address = screeningToValidate.getTheatreAddress();

			if (address.getCity().equalsIgnoreCase(cityToSearch)) {
				allMovieShowingInACity.add(screeningToValidate);
			}
		}

		return new ModelAndView("moviesShowing", "movies", allMovieShowingInACity);
	}

	@RequestMapping("/getMovieDetails")
	public ModelAndView getMovie(@RequestParam String movieName) {
		Movie movie =	template.getForObject("http://localhost:8585/movies/"+movieName, Movie.class);
		return new ModelAndView("movieDetail", "movie", movie);
	}
	
//Wallet related 
	@RequestMapping("/DepositForm")
	public String depositForm() {
		return "DepositForm";
	}

	@RequestMapping("/deposit")
	public String deposit(@ModelAttribute Ewallet wallet, Model model) {
		// restTemplate.postForEntity("http://localhost:1111/ewallets/", wallet, null);
		template.put(
				"http://localhost:1111/ewallets/" + wallet.getProfileId() + "?amount=" + wallet.getCurrentBalance(),
				null);
		model.addAttribute("message", "Successfully added money!");
		return "DepositForm";
	}

	@RequestMapping("/WithdrawForm")
	public String withdrawForm() {
		return "WithdrawForm";
	}

	@RequestMapping("/withdraw")
	public String withdraw(@ModelAttribute Ewallet wallet, Model model) {
		// restTemplate.postForEntity("http://localhost:1111/ewallets/", wallet, null);
		template.put("http://localhost:1111/ewallets/ewallet/" + wallet.getProfileId() + "?amount="
				+ wallet.getCurrentBalance(), null);
		model.addAttribute("message", "ticket booked Successfully...!");
		return "WithdrawForm";
	}

	/*
	 * @RequestMapping("/StatementForm") public String statementForm() { return
	 * "StatementForm"; }
	 * 
	 * @RequestMapping("/statement") public String statement(@ModelAttribute Ewallet
	 * wallet, Model model) {
	 * restTemplate.getForObject("http://localhost:1111/ewallets/ewalletsstatement/"
	 * +wallet.getProfileId() , Statement.class); return "StatementForm"; }
	 */

}
