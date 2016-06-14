package com.luxoft.movieland.dao.jdbc.mapper;

import com.luxoft.movieland.entity.Country;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ContryRowMapperTest {
    @Test
    public void testMapRowWithProperCountry() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getString(any())).thenReturn("Name1");
        CountryRowMapper countryRowMapper = new CountryRowMapper();
        Country actualCountry = countryRowMapper.mapRow(resultSet, 0);
        assertEquals(actualCountry.getName(), "Name1");
    }
}
