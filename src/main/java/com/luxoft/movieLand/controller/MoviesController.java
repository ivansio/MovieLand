package com.luxoft.movieland.controller;

import com.luxoft.movieland.dao.jdbc.JdbcMovieDao;
import com.luxoft.movieland.entity.Movie;
import com.luxoft.movieland.service.MovieService;
import com.luxoft.movieland.util.JsonJacksonConverter;
import com.luxoft.movieland.util.JsonManualConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1/movies")
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private JsonManualConverter jsonConverter;

    @Autowired
    private JsonJacksonConverter jsonJacksonConverter;

    @RequestMapping(produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String getAllMovie(){
        List<Movie> movies = movieService.getAll();
        //String movieJsonArray = jsonConverter.toJsonArray(movies);
        String moviesJsonArray = jsonJacksonConverter.parseListMovie(movies);
        return moviesJsonArray;
    }
}
