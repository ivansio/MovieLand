package com.luxoft.movieLand.util;

import com.luxoft.movieLand.entity.Movie;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by red5 on 10.06.2016.
 */
public class testMovieToJson {
    @Test
        public void testMovieToJson() {
                String expectedJson = "[{\"name\":\"Test movie\",\"year\":\"1955\",\"rating\":\"8.23\",\"genre\":\"test genre\"}]";
                JsonJacksonConverter jsonJacksonConverter = new JsonJacksonConverter();
                Movie movie = new Movie();
               // movie.setMovieTitle("Test movie");
                movie.setYear(1955);
                movie.setRating(8.23);
               // movie.setGenre("test genre");

                ArrayList< Movie > movies = new ArrayList<>();

                movies.add(movie);


        //String actualJson = jsonJacksonConverter.parseMovie(movies);
                //assertEquals(expectedJson, actualJson);
        }
}
