package com.luxoft.movieland.dao.jdbc.mapper;

import com.luxoft.movieland.dto.MovieAllDto;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieAllRowMapper implements RowMapper<MovieAllDto> {
    @Override
    public MovieAllDto mapRow(ResultSet resultSet, int i) throws SQLException {
        MovieAllDto movie = new MovieAllDto();
        movie.setId(resultSet.getInt("id"));
        movie.setName(resultSet.getString("name"));
        movie.setEnglishName(resultSet.getString("english_name"));
        movie.setYear(resultSet.getInt("year"));
        movie.setRating(resultSet.getDouble("rating"));
        return movie;
    }
}
