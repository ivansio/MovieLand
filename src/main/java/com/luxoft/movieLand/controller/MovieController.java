package com.luxoft.movieland.controller;

import com.luxoft.movieland.entity.Movie;
import com.luxoft.movieland.service.MovieService;
import com.luxoft.movieland.util.JsonManualConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/v1/movie")
public class MovieController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MovieService movieService;

    @Autowired
    private JsonManualConverter jsonConverter;

    @RequestMapping(value = "/{movieId}", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String getMovieById(@PathVariable int movieId) {
        log.info("Getting movie with id = {}", movieId);
        long startTime = System.currentTimeMillis();
        Movie movie = movieService.getById(movieId);
        log.info("Movie {} received. {} ms elapsed.", movie, System.currentTimeMillis() - startTime);
        String movieJson = jsonConverter.toJson(movie);
        return movieJson;
    }
}
