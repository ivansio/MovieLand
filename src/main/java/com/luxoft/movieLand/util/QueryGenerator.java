package com.luxoft.movieland.util;

import com.luxoft.movieland.dto.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryGenerator {
    @Autowired
    private String getMoviesByIdSQL;

    public String getGeneratedQueryAllMovies(String ratingSort, String priceSort) {
        return getMoviesByIdSQL + " order by rating " + ratingSort + ", price " + priceSort;
    }
}
