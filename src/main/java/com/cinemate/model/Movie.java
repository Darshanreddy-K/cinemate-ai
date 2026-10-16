package com.cinemate.model;

public class Movie {
    private String title;
    private String genre;
    private String synopsis;
    private double rating;

    // Constructor to initialize a movie
    public Movie(String title, String genre, String synopsis, double rating) {
        this.title = title;
        this.genre = genre;
        this.synopsis = synopsis;
        this.rating = rating;
    }

    // Getters
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public String getSynopsis() { return synopsis; }
    public double getRating() { return rating; }

    @Override
    public String toString() {
        return title + " [" + genre + "] - Rating: " + rating + "★";
    }
}