package com.luxoft.movieLand.service;

import com.luxoft.movieLand.dao.MovieDao;
import com.luxoft.movieLand.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by red5 on 08.06.2016.
 */
@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie getById(int id) {
        return movieDao.getById(id);
    }
    //@Override
    //public void add(Movie movie) {movieDao.add(movie);}
}
