package com.luxoft.movieLand.controller;

import com.luxoft.movieLand.entity.Movie;
import com.luxoft.movieLand.service.MovieService;
import com.luxoft.movieLand.util.JsonManualConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

@Controller
@RequestMapping("/v1/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private JsonManualConverter jsonConverter;

    @RequestMapping(value = "/{movieId}", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String getMovieById(@PathVariable int movieId) {
        Movie movie = movieService.getById(movieId);
        String movieJson = jsonConverter.toJson(movie);
        return movieJson;
    }
}
