package com.luxoft.movieland.dao.jdbc;

import com.luxoft.movieland.dao.MovieDao;
import com.luxoft.movieland.dao.jdbc.mapper.*;
import com.luxoft.movieland.dto.MovieAllDto;
import com.luxoft.movieland.entity.Movie;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JdbcMovieDao implements MovieDao {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(JdbcMovieDao.class);

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
        LOGGER.debug("Start getting movie_id ={}  from DB",id);
        Movie movie = jdbcTemplate.queryForObject(getMovieByIdSQL, new Object[]{id},new MovieRowMapper());
        movie.setCountryList(jdbcTemplate.query(getRefMovieCountrySQL, new Object[]{id},new CountryRowMapper()));
        movie.setGenreList(jdbcTemplate.query(getRefMovieGenreSQL, new Object[]{id},new GenreRowMapper()));
        movie.setReviewList(jdbcTemplate.query(getReviewByIdSQL, new Object[]{id},new ReviewRowMapper()));
        LOGGER.debug("Finish getting movie_id ={} from DB",id);
        LOGGER.debug("Response body: {}", movie);
        return movie;
    }

    @Override
    public List<MovieAllDto> getAll(){
        LOGGER.debug("Start getting all movies from DB");
        long startTime = System.currentTimeMillis();
        List<MovieAllDto> movies = jdbcTemplate.query(getMoviesByIdSQL,new MovieDtoRowMapper());
        LOGGER.info("Finish query getting all movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        for(MovieAllDto movie : movies){
            movie.setGenreList(jdbcTemplate.query(getRefMovieGenreSQL, new Object[]{movie.getId()},new GenreRowMapper()));
        }
        LOGGER.debug("Finish getting all movies from DB");
        return movies;
    }
}
