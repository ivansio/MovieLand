package com.luxoft.movieland.util;

import com.luxoft.movieland.entity.Country;
import com.luxoft.movieland.entity.Genre;
import com.luxoft.movieland.entity.Movie;
import com.luxoft.movieland.entity.Review;

import java.util.List;

public class TransformerConverter {

    private static final String COMMA_SEPARATOR = ", ";

    public static String getGenres(Movie movie){
        StringBuilder result = new StringBuilder("");
        int i=1;
        for (Genre genre : movie.getGenreList() ) {
            result.append(genre);
            if(i++!=movie.getGenreList().size()){result.append(COMMA_SEPARATOR);}
        }
        return result.toString();
    }

    public static String getListGenres(List<Genre> genreList){
        StringBuilder result = new StringBuilder("");
        int i=1;
        for (Genre genre : genreList ) {
            result.append(genre);
            if(i++!=genreList.size()){result.append(COMMA_SEPARATOR);}
        }
        return result.toString();
    }

    public static String getGenresALL(Movie movie){
        StringBuilder result = new StringBuilder("");
        int i=1;
        for (Genre genre : movie.getGenreList() ) {
            result.append(genre);
            if(i++!=movie.getGenreList().size()){result.append(COMMA_SEPARATOR);}
        }
        return result.toString();
    }

    public static String getCounties(Movie movie){
        StringBuilder result = new StringBuilder("");
        int i=1;
        for (Country country : movie.getCountryList() ) {
            result.append(country);
            if(i++!=movie.getCountryList().size()){result.append(COMMA_SEPARATOR);}
        }
        return result.toString();
    }

    public static String getReview(Movie movie){
        StringBuilder result = new StringBuilder("");
        int i=1;
        for (Review review : movie.getReviewList() ) {
            result.append(review);
            if(i++!=movie.getReviewList().size()){result.append("    ");}
        }
        return result.toString();
    }

    public static String getTitle(Movie movie){
        return movie.getName()+"/"+movie.getEnglishName();
    }
}
