package com.luxoft.movieLand.entity;

import java.util.List;

public class Movie {
    private int id;
    private String name;
    private String englishName;
    private int year;
    private List<Country> countryList;
    private List<Genre> genreList;
    private String description;
    private double rating;
    private double price;
    private List<Review> reviewList;
    private static final String COMMA_SEPARATOR = ", ";

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getReview(){
        StringBuilder result = new StringBuilder("");
        int i=1;
        for (Review review : reviewList ) {
            result.append(review);
            if(i++!=reviewList.size()){result.append("    ");}
        }
        return result.toString();
    }
}
