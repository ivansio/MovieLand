package com.luxoft.movieland.service;

import com.luxoft.movieland.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie getById(int id);
    List<Movie> getAll();
}
