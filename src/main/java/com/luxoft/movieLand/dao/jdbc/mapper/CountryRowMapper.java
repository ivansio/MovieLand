package com.luxoft.movieland.dao.jdbc.mapper;

import com.luxoft.movieland.entity.Country;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRowMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet resultSet, int i) throws SQLException {
        Country country = new Country();
        country.setName(resultSet.getString("name"));
        return country;
    }
}
