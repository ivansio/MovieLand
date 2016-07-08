package com.luxoft.movieland.dto;

import com.luxoft.movieland.util.Order;

public class MovieRequest {

    private Order rating;
    private Order price;

    public Order getRating() {
        return rating;
    }

    public void setRating(Order rating) {
        this.rating = rating;
    }

    public Order getPrice() {
        return price;
    }

    public void setPrice(Order price) {
        this.price = price;
    }
}
