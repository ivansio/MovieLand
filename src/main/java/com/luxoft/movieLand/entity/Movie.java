package com.luxoft.movieLand.entity;

/**
 * Created by red5 on 08.06.2016.
 */
public class Movie {
    private int id;
    private String name;
    private String englishName;
    private int year;
    private String country;
    private String story;
    private double rating;
    private double price;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
}
