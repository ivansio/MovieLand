package com.luxoft.movieland.util;

import com.luxoft.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class JsonManualConverter {
    //private final Logger log = LoggerFactory.getLogger(getClass());
    private static final String COMMA_SEPARATOR = ",";
    private static final String COLON_SEPARATOR = ":";

    public String toJson(Movie movie) {
        StringBuilder json = new StringBuilder("{");
        String[] movieFieldNames = {"title", "year", "country", "genre", "description", "reviewDescription", "rating"};
        Object[] movieFields = {TransformerConverter.getTitle(movie),movie.getYear(),TransformerConverter.getCounties(movie),TransformerConverter.getGenres(movie),
                movie.getDescription(),TransformerConverter.getReview(movie),movie.getRating()};
        for (int i = 0; i < movieFieldNames.length; i++) {
            json.append(surroundByQuotes(movieFieldNames[i]));
            json.append(COLON_SEPARATOR);
            json.append(surroundByQuotes(movieFields[i]));
            if (i != movieFieldNames.length - 1) {
                json.append(COMMA_SEPARATOR);
            }
        }
        json.append("}");
        return json.toString();
    }

    public String toJsonArray(List<Movie> movies) {
        StringBuilder json = new StringBuilder("{");
        String[] movieFieldNames = {"title", "year", "rating", "genre"};
        int j=1;
        for (Movie movie : movies) {
            Object[] movieFields = {movie.getName() + "/" + movie.getEnglishName(), movie.getYear(), movie.getRating(),
                    TransformerConverter.getGenres(movie)
            };
            json.append("{");
            for (int i = 0; i < movieFieldNames.length; i++) {
                json.append(surroundByQuotes(movieFieldNames[i]));
                json.append(COLON_SEPARATOR);
                json.append(surroundByQuotes(movieFields[i]));
                if (i != movieFieldNames.length - 1) {
                    json.append(COMMA_SEPARATOR);
                }
            }
            json.append("}");
            if (j++ != movies.size()) {
                json.append(",");
            }
        }
        json.append("}");
        return json.toString();
    }
    private String surroundByQuotes(Object value) {
        return "\"" + value + "\"";
    }
}
