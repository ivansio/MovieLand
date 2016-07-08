package com.luxoft.movieland.controller;

import com.luxoft.movieland.dto.MovieAllDto;
import com.luxoft.movieland.dto.MovieRequest;
import com.luxoft.movieland.dto.MovieRequestTransformer;
import com.luxoft.movieland.entity.Movie;
import com.luxoft.movieland.service.MovieService;
import com.luxoft.movieland.util.JsonJacksonConverter;
import com.luxoft.movieland.util.JsonManualConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/v1/movies")
public class MoviesController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MoviesController.class);

    @Autowired
    private MovieService movieService;

    @Autowired
    private JsonJacksonConverter jsonJacksonConverter;

    @Autowired
    private MovieRequestTransformer movieRequestTransformer;

   /* @RequestMapping(produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String getAllMovie(){
        LOGGER.info("Getting all movies");
        long startTime = System.currentTimeMillis();
        List<MovieAllDto> movies =(List<MovieAllDto>) movieService.getAll();
        LOGGER.info("Movies {} received. {} ms elapsed.", movies, System.currentTimeMillis() - startTime);
        String moviesJsonArray = jsonJacksonConverter.listMovieToJson(movies);
        LOGGER.debug("Response body: {}",moviesJsonArray);
        return moviesJsonArray;
    }*/

    
    @RequestMapping(produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public String getAllMovieSort(@RequestParam(value = "rating", required = false) String ratingSort
            ,@RequestParam(value = "price", required = false) String priceSort){
        LOGGER.info("Getting all movies");
        long startTime = System.currentTimeMillis();
        List<MovieAllDto> movies =(List<MovieAllDto>) movieService.getAllSort(ratingSort,priceSort);
        LOGGER.info("Movies {} received. {} ms elapsed.", movies, System.currentTimeMillis() - startTime);
        String moviesJsonArray = jsonJacksonConverter.listMovieToJson(movies);
        LOGGER.debug("Response body: {}",moviesJsonArray);
        return moviesJsonArray;
    }

}
