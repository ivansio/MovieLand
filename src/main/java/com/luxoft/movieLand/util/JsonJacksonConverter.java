package com.luxoft.movieLand.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luxoft.movieLand.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by red5 on 10.06.2016.
 */
@Service
public class JsonJacksonConverter {

    private ObjectMapper objectMapper = new ObjectMapper();

    public Movie parseMovie(String json) {
        Movie movie = parseValue(json, Movie.class);
        return movie;
    }

    private <T> T parseValue(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
