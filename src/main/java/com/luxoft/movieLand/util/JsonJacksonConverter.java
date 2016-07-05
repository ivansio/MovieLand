package com.luxoft.movieland.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luxoft.movieland.dto.MovieAllDto;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonJacksonConverter {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(JsonJacksonConverter.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    public String movieToJson(MovieAllDto movie) throws JsonProcessingException {
        return objectMapper.writeValueAsString(movie);
    }

    public String listMovieToJson(List<MovieAllDto> movies) {
        LOGGER.debug("Start converting movies {} to json", movies);
        StringBuilder json = new StringBuilder("[");
        for (MovieAllDto movie : movies) {
            try {
                json.append(movieToJson(movie));
                json.append(",");
            } catch (JsonProcessingException e) {
                LOGGER.error("Error converting movies {} to json {}",e.getMessage(),movie);
                e.printStackTrace();
            }
        }
        json.append("]");
        LOGGER.debug("Receiving movies as json {}", json);
        return json.toString();
    }
}
