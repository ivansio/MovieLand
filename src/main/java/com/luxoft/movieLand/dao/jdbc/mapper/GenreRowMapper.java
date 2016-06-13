package com.luxoft.movieLand.dao.jdbc.mapper;

import com.luxoft.movieLand.entity.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by red5 on 13.06.2016.
 */
public class GenreRowMapper  implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        Genre country = new Genre();
        country.setName(resultSet.getString("name"));

        return country;
    }
}
