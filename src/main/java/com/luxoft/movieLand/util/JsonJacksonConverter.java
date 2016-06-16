package com.luxoft.movieland.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luxoft.movieland.entity.Movie;
import org.springframework.stereotype.Service;

import java.io.IOException;

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
