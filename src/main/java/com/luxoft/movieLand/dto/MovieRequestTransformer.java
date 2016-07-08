package com.luxoft.movieland.dto;

import com.luxoft.movieland.util.Order;
import org.springframework.stereotype.Component;

@Component("movieRequestTransformer")
public class MovieRequestTransformer {

    public MovieRequest getMovieRequest(String rating, String price){
        MovieRequest movieRequest = new MovieRequest();
        movieRequest.setRating(Order.getOrderForParams(rating));
        movieRequest.setPrice(Order.getOrderForParams(price));

        return movieRequest;
    }

}
