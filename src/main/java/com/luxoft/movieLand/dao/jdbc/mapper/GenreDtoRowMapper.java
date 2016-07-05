package com.luxoft.movieland.dao.jdbc.mapper;

import com.luxoft.movieland.dto.GenreDto;
import com.luxoft.movieland.entity.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreDtoRowMapper implements RowMapper<GenreDto> {
    @Override
    public GenreDto mapRow(ResultSet resultSet, int i) throws SQLException {
        GenreDto genre = new GenreDto();
        genre.setName(resultSet.getString("name"));
        return genre;
    }
}
