package com.luxoft.movieland.service;

import com.luxoft.movieland.dao.MovieDao;
import com.luxoft.movieland.dto.MovieAllDto;
import com.luxoft.movieland.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieDao movieDao;


   @Override
    public Movie getById(int id) {
        return movieDao.getById(id);
    }

    @Override
    public List<MovieAllDto> getAll(){return movieDao.getAll();};
    @Override
    public List<MovieAllDto> getAllSort(String ratingSort, String priceSort){return movieDao.getAll();}
}
