package com.luxoft.movieland.dao;

import com.luxoft.movieland.entity.Movie;

import java.util.List;

public interface MovieDao {
    Movie getById(int id);
    List<Movie> getAll();
}
