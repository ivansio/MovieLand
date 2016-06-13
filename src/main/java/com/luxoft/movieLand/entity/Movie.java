package com.luxoft.movieLand.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by red5 on 08.06.2016.
 */
public class Movie {
    //private final Logger log = LoggerFactory.getLogger(getClass());
    private int id;
    private String name;
    private String englishName;
    private int year;
    private List<Country> countryList;
    private List<Genre> genreList;
    private String story;
    private double rating;
    private double price;
    private static final String COMMA_SEPARATOR = ", ";

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /*@Override
    public String toString() {
        return "Movie{" +
                "id =" + id +
                ", name=" + name +
                ", englishName=" + englishName +
                ", year='" + year + '\'' +
                //", country='" + country + '\'' +
                //", story='" + story + '\'' +
                ", rating=" + rating +//'\'' +
                //", price=" + price +
                '}';
    }*/
    public String getGenres(){
        StringBuilder result = new StringBuilder("");
        int i=1;
        for (Genre genre : genreList ) {
            result.append(genre);
            if(i++!=genreList.size()){result.append(COMMA_SEPARATOR);}
        }

        return result.toString();
    }
    public String getCounties(){
        StringBuilder result = new StringBuilder("");
        int i=1;
        for (Country country : countryList ) {
            result.append(country);
            if(i++!=countryList.size()){result.append(COMMA_SEPARATOR);}
        }

        return result.toString();
    }
}
