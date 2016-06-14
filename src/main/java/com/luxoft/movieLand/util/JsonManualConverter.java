package com.luxoft.movieLand.util;

import com.luxoft.movieLand.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class JsonManualConverter {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final String COMMA_SEPARATOR = ",";
    private static final String COLON_SEPARATOR = ":";

    public String toJson(Movie movie) {
        StringBuilder json = new StringBuilder("{");
        String[] movieFieldNames = {"name", "english_name", "year", "country", "genre", "description", "reviewDescription", "rating"};
        Object[] cityFields = {movie.getName(),movie.getEnglishName(),movie.getYear(),movie.getCounties(),movie.getGenres(),
                movie.getDescription(),movie.getReview(),movie.getRating()};
        for (int i = 0; i < movieFieldNames.length; i++) {
            json.append(surroundByQuotes(movieFieldNames[i]));
            json.append(COLON_SEPARATOR);
            json.append(surroundByQuotes(cityFields[i]));
            if (i != movieFieldNames.length - 1) {
                json.append(COMMA_SEPARATOR);
            }
        }
        json.append("}");
        return json.toString();
    }

    private String surroundByQuotes(Object value) {
        return "\"" + value + "\"";
    }
}
