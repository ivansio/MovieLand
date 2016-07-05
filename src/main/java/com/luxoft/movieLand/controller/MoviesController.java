package com.luxoft.movieland.controller;

import com.luxoft.movieland.dto.MovieAllDto;
import com.luxoft.movieland.service.MovieService;
import com.luxoft.movieland.util.JsonJacksonConverter;
import com.luxoft.movieland.util.JsonManualConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/v1/movies")
public class MoviesController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MovieService movieService;

    @Autowired
    private JsonJacksonConverter jsonJacksonConverter;

    @RequestMapping(produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String getAllMovie(){
        log.info("Getting all movies");
        long startTime = System.currentTimeMillis();
        List<MovieAllDto> movies =(List<MovieAllDto>) movieService.getAll();
        log.info("Movies {} received. {} ms elapsed.", movies, System.currentTimeMillis() - startTime);
        String moviesJsonArray = jsonJacksonConverter.listMovieToJson(movies);
        return moviesJsonArray;
    }
}
