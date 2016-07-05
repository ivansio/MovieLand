package com.luxoft.movieland.dto;

public class GenreDto {
    private String name;

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

