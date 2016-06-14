package com.luxoft.movieLand.dao.jdbc.mapper;

import com.luxoft.movieLand.entity.Review;
import org.junit.Test;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class testMapRowWithProperReview {
    @Test
    public void testMapRowWithProperReview() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getString(any())).thenReturn("description");

        ReviewRowMapper reviewRowMapper = new ReviewRowMapper();
        Review actualReview = reviewRowMapper.mapRow(resultSet, 0);
        assertEquals(actualReview.getDescription(), "description");
    }
}
