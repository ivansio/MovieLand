package com.luxoft.movieLand.dao.jdbc;

import com.luxoft.movieLand.dao.MovieDao;
import com.luxoft.movieLand.dao.jdbc.mapper.MovieRowMapper;
import com.luxoft.movieLand.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;


//import org.springframework.stereotype.Repository;

/**
 * Created by red5 on 08.06.2016.
 */
@Service
public class JdbcMovieDao implements MovieDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    private String getMovieByIdSQL;
    @Autowired
    private DataSource dataSource;


    @Override
    public Movie getById(int id) {
        Movie movie = jdbcTemplate.queryForObject(getMovieByIdSQL, new Object[]{id},new MovieRowMapper());
        return movie;
    }
}
