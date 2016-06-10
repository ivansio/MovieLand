package com.luxoft.movieLand.dao.jdbc.mapper;

import com.luxoft.movieLand.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by red5 on 08.06.2016.
 */
public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        Movie movie = new Movie();
        movie.setId(resultSet.getInt("id"));
        movie.setName(resultSet.getString("name"));
        movie.setEnglishName(resultSet.getString("english_name"));
        movie.setYear(resultSet.getInt("year"));
        //movie.setCountry(resultSet.getString("country"));
        //movie.setStory(resultSet.getString("story"));
        movie.setRating(resultSet.getDouble("rating"));
        //movie.setPrice(resultSet.getDouble("price"));

        return movie;
    }
}
