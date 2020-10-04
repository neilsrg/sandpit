package au.com.prince.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * MovieList Field Definition
 */
@Component
public class MovieList {
    @JsonProperty("Provider")
    private String provider;
    @JsonProperty("Movies")
    private List<Movie> movies;

    public MovieList() { }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "MovieList{" +
                "provider='" + provider + '\'' +
                ", movieList=" + movies +
                '}';
    }
}
