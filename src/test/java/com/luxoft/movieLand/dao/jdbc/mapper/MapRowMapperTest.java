package com.luxoft.movieland.dao.jdbc.mapper;

import com.luxoft.movieland.entity.Review;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MapRowMapperTest {
    @Test
    public void testMapRowWithProperReview() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getString(any())).thenReturn("description");

        ReviewRowMapper reviewRowMapper = new ReviewRowMapper();
        Review actualReview = reviewRowMapper.mapRow(resultSet, 0);
        assertEquals(actualReview.getDescription(), "description");
    }
}
