package com.luxoft.movieLand.dao.jdbc.mapper;

import com.luxoft.movieLand.entity.Genre;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreRowMapper  implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        Genre country = new Genre();
        country.setName(resultSet.getString("name"));
        return country;
    }
}
