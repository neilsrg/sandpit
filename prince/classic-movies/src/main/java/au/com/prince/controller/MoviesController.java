package au.com.prince.controller;

import au.com.prince.bean.MovieCollector;
import au.com.prince.model.Movie;
import au.com.prince.model.MovieList;
import au.com.prince.model.MoviePriceCompare;
import au.com.prince.utils.JsonDataFormatUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpResponse;

/**
 * To get the list of movies from the providers
 */
@Controller
public class MoviesController {
	@Value("${provider.list}")
	private String[] providerList;

	@Autowired
	private MovieCollector classicMovies;

	@Autowired
	private MovieList movieList;

	@Autowired
	private Movie movieDetails;

	@Autowired
	private MoviePriceCompare moviePriceCompare;

	private String baseProvider = null;

	@RequestMapping("/ClassicMovies")
	public ModelAndView getClassicMovies() throws Exception {

		ObjectMapper mapper = JsonDataFormatUtils.createObjectMapperJodaYYYY_MM_DD();

		MovieList temp;
		
		ModelAndView modelAndView = new ModelAndView("classicMovies");
		HttpResponse<String> response;

		// Iterate the providerList and get the longest movies list as a main list
		movieList = null;
		for (String provider : providerList) {
			response = classicMovies.getMovies(provider);
			temp = mapper.readValue(response.body(), MovieList.class);
			if (temp.getMovies() != null) {
				if (movieList == null) {
					movieList = temp;
					baseProvider = provider;
				}
				else if (temp.getMovies().size() > movieList.getMovies().size()) {
					movieList = temp;
					baseProvider = provider;
				}
			}
		}

		// Return the movies list to the .JSP file
		if (movieList != null) {
			modelAndView.addObject("moviesList", movieList);
			return modelAndView;
		} else {
			return new ModelAndView("redirect:/error");
		}
	}

	@RequestMapping("/ClassicMovies/{movieId}")
	public ModelAndView getClassicMoviesPrices(@PathVariable String movieId) throws Exception {

		ObjectMapper mapper = JsonDataFormatUtils.createObjectMapperJodaYYYY_MM_DD();
		ModelAndView modelAndView = new ModelAndView("classicMoviesPrices");
		HttpResponse<String> response;

		// Get the movie price details
		response = classicMovies.getMoviesDetails(baseProvider, movieId);
		if (response.statusCode() == 200) {
			movieDetails = mapper.readValue(response.body(), Movie.class);
			moviePriceCompare = classicMovies.getMoviePrice(movieList.getProvider(), movieDetails, baseProvider, providerList, movieId);
			modelAndView.addObject("movieDetails", moviePriceCompare);
			return modelAndView;
		} else {
			return new ModelAndView("redirect:/error");
		}
	}
}
