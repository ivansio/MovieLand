package com.luxoft.movieland.dao.jdbc.mapper;

import com.luxoft.movieland.entity.Movie;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieRowMapperTest {
    @Test
    public void testMapRowWithProperMovie() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt(any())).thenReturn(666).thenReturn(2016);
        when(resultSet.getString(any())).thenReturn("Название фильма").thenReturn("Name movie").thenReturn("Suuuupppppeeeeerrrrr......");
        when(resultSet.getDouble(any())).thenReturn(8.23);

        MovieRowMapper movieRowMapper = new MovieRowMapper();
        Movie actualMovie = movieRowMapper.mapRow(resultSet, 0);
        assertEquals(actualMovie.getId(), 666);
        assertEquals(actualMovie.getName(), "Название фильма");
        assertEquals(actualMovie.getEnglishName(), "Name movie");
        assertEquals(actualMovie.getDescription(), "Suuuupppppeeeeerrrrr......");
        assertEquals(actualMovie.getYear(), 2016);
        Double.compare(actualMovie.getRating(), 8.23);
    }
}
