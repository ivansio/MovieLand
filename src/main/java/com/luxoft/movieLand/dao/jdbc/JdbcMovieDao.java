package com.luxoft.movieland.dao.jdbc;

import com.luxoft.movieland.dao.MovieDao;
import com.luxoft.movieland.dao.jdbc.mapper.CountryRowMapper;
import com.luxoft.movieland.dao.jdbc.mapper.GenreRowMapper;
import com.luxoft.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.luxoft.movieland.dao.jdbc.mapper.ReviewRowMapper;
import com.luxoft.movieland.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class JdbcMovieDao implements MovieDao {
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

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Override
    public Movie getById(int id) {
        Movie movie = jdbcTemplate.queryForObject(getMovieByIdSQL, new Object[]{id},new MovieRowMapper());
        movie.setCountryList(jdbcTemplate.query(getRefMovieCountrySQL, new Object[]{id},new CountryRowMapper()));
        movie.setGenreList(jdbcTemplate.query(getRefMovieGenreSQL, new Object[]{id},new GenreRowMapper()));
        movie.setReviewList(jdbcTemplate.query(getReviewByIdSQL, new Object[]{id},new ReviewRowMapper()));
        return movie;
    }

    @Override
    public List<Movie> getAll(){
        List<Movie> movies = jdbcTemplate.query(getMoviesByIdSQL,new MovieRowMapper());

        for(Movie movie : movies){
            movie.setGenreList(jdbcTemplate.query(getRefMovieGenreSQL, new Object[]{movie.getId()},new GenreRowMapper()));
        }
        return movies;
    }
}
