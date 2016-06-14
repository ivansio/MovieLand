package com.luxoft.movieLand.dao.jdbc;

import com.luxoft.movieLand.dao.MovieDao;
import com.luxoft.movieLand.dao.jdbc.mapper.CountryRowMapper;
import com.luxoft.movieLand.dao.jdbc.mapper.GenreRowMapper;
import com.luxoft.movieLand.dao.jdbc.mapper.MovieRowMapper;
import com.luxoft.movieLand.dao.jdbc.mapper.ReviewRowMapper;
import com.luxoft.movieLand.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;

@Service
public class JdbcMovieDao implements MovieDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    private String getMovieByIdSQL;

    @Autowired
    private String getRefMovieCountrySQL;

    @Autowired
    private String getRefMovieGenreSQL;

    @Autowired
    private String getReviewByIdSQL;

    @Override
    public Movie getById(int id) {
        Movie movie = jdbcTemplate.queryForObject(getMovieByIdSQL, new Object[]{id},new MovieRowMapper());
        movie.setCountryList(jdbcTemplate.query(getRefMovieCountrySQL, new Object[]{id},new CountryRowMapper()));
        movie.setGenreList(jdbcTemplate.query(getRefMovieGenreSQL, new Object[]{id},new GenreRowMapper()));
        movie.setReviewList(jdbcTemplate.query(getReviewByIdSQL, new Object[]{id},new ReviewRowMapper()));
        return movie;
    }
}
