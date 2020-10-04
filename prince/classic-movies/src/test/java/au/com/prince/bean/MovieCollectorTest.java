package au.com.prince.bean;

import org.junit.Test;
import org.mockito.Mockito;

import java.net.http.HttpResponse;

import static org.mockito.Mockito.when;

public class MovieCollectorTest {

    @Test
    public void testGetMovies() throws Throwable {
        MovieCollector mockedMovieCollector = Mockito.mock(MovieCollector.class);
        HttpResponse<String> mockedResponse = Mockito.mock(HttpResponse.class);
        Mockito.when(mockedResponse.statusCode()).thenReturn(200);
        Mockito.when(mockedResponse.body()).thenReturn("abc").toString();

        when(mockedMovieCollector.getMovies("cinemaworld")).thenReturn(mockedResponse);
    }
}
