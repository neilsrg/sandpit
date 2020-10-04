package au.com.prince.bean;

import au.com.prince.model.Movie;
import au.com.prince.model.MovieList;
import au.com.prince.model.MoviePriceCompare;
import au.com.prince.utils.JsonDataFormatUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

/**
 * To call the REST API to get the movies list from a provider
 */
@Component
public class MovieCollector {

	@Value("${provider.context}")
	private String providerBaseContext;

	@Value("${provider.api.key}")
	private String apiKey;

	@Value("#{${provider.name}}")
	private Map<String, String> providerName;

	@Value("#{${provider.prefix}}")
	private Map<String, String> providerPrefix;


	@Autowired
	private MovieCollector classicMovies;

	@Autowired
	private MovieList movieList;

	@Autowired
	private Movie movieDetails;

	@Autowired
	private MoviePriceCompare moviePriceCompare;

	@Autowired
	private Parser parser;

	public HttpResponse<String> getMovies(String provider) throws Exception {
		String uriProvider = providerBaseContext + provider + "/movies";
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(uriProvider))
				.GET()
				.header("x-api-key", apiKey)
				.build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		return response;
	}

	public HttpResponse<String> getMoviesDetails(String provider, String id) throws Exception {
		String uriProvider = providerBaseContext + provider + "/movie/" + id;

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(uriProvider))
				.GET()
				.header("x-api-key", apiKey)
				.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		return response;
	}

	public MoviePriceCompare getMoviePrice(String provider, Movie movie, String baseProvider, String[] providerList, String movieId) throws Exception{

		ObjectMapper mapper = JsonDataFormatUtils.createObjectMapperJodaYYYY_MM_DD();

		// Initial Prices
		String providerLow = provider;
		Double priceLow = movie.getPrice();
		String providerHigh = provider;
		Double priceHigh = movie.getPrice();
		HttpResponse<String> response;

		// Iterate the provider list to get the lowest movie price
		for (int i=0; i < providerList.length; i++) {
			if (providerList[i] != baseProvider) {
				response = classicMovies.getMoviesDetails(providerList[i], providerPrefix.get(providerList[i]) + parser.getIdNumber(movieId));
				movieDetails = mapper.readValue(response.body(), Movie.class);
				if (movieDetails.getPrice() < priceLow) {
					providerLow = providerName.get(providerList[i]);
					priceLow = movieDetails.getPrice();
				} else {
					providerHigh = providerName.get(providerList[i]);
					priceHigh = movieDetails.getPrice();
				}
			}
		}

		// Set the Movie Prices comparison details.
		moviePriceCompare.setPoster(movie.getPoster());
		moviePriceCompare.setTitle(movie.getTitle());
		moviePriceCompare.setProviderLow(providerLow);
		moviePriceCompare.setPriceLow(priceLow);
		moviePriceCompare.setProviderHigh(providerHigh);
		moviePriceCompare.setPriceHigh(priceHigh);

		return moviePriceCompare;
	}
	
}
