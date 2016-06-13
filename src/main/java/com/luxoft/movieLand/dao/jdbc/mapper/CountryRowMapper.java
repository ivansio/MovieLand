package com.luxoft.movieLand.dao.jdbc.mapper;

import com.luxoft.movieLand.entity.Country;
import com.luxoft.movieLand.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by red5 on 13.06.2016.
 */
public class CountryRowMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet resultSet, int i) throws SQLException {
        Country country = new Country();
        //country.setId(resultSet.getInt("id"));
        country.setName(resultSet.getString("name"));

        return country;
    }
}
