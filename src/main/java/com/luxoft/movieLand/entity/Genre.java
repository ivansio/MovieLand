package com.luxoft.movieLand.entity;

/**
 * Created by red5 on 13.06.2016.
 */
public class Genre {
    private int id;
    private String name;

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
    @Override
    public  String toString(){
        return name;
    }
}

