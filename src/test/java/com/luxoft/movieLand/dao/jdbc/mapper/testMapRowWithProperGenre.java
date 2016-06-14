package com.luxoft.movieLand.dao.jdbc.mapper;

import com.luxoft.movieLand.entity.Genre;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class testMapRowWithProperGenre {
    @Test
    public void testMapRowWithProperGenre() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getString(any())).thenReturn("Name1");
        GenreRowMapper genreRowMapper = new GenreRowMapper();
        Genre actualGenre = genreRowMapper.mapRow(resultSet, 0);
        assertEquals(actualGenre.getName(), "Name1");
    }
}
