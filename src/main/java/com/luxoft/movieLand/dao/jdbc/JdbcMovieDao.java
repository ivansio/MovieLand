package com.luxoft.movieland.dao.jdbc;

import com.luxoft.movieland.dao.MovieDao;
import com.luxoft.movieland.dao.jdbc.mapper.*;
import com.luxoft.movieland.dto.MovieAllDto;
import com.luxoft.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JdbcMovieDao implements MovieDao {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getMovieByIdSQL;

    @Autowired
    private String getRefMovieCountrySQL;

    @Autowired
    private String getRefMovieGenreSQL;

    @Autowired
    private String getReviewByIdSQL;

    @Autowired
    private String getMoviesByIdSQL;

    @Override
    public Movie getById(int id) {
        Movie movie = jdbcTemplate.queryForObject(getMovieByIdSQL, new Object[]{id},new MovieRowMapper());
        movie.setCountryList(jdbcTemplate.query(getRefMovieCountrySQL, new Object[]{id},new CountryRowMapper()));
        movie.setGenreList(jdbcTemplate.query(getRefMovieGenreSQL, new Object[]{id},new GenreRowMapper()));
        movie.setReviewList(jdbcTemplate.query(getReviewByIdSQL, new Object[]{id},new ReviewRowMapper()));
        return movie;
    }

    @Override
    public List<MovieAllDto> getAll(){
        log.info("Start getting all movies from DB");
        long startTime = System.currentTimeMillis();
        List<MovieAllDto> movies = jdbcTemplate.query(getMoviesByIdSQL,new MovieAllRowMapper());
        log.info("Finish query getting all movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        for(MovieAllDto movie : movies){
            movie.setGenreList(jdbcTemplate.query(getRefMovieGenreSQL, new Object[]{movie.getId()},new GenreRowMapper()));
        }
        return movies;
    }
}
