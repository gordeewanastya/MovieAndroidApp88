package com.example.movieapplication.domain;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Film {
    private int id;
    private String title;
    private int poster;
    private float imdbRating;
    private int runTime;
    private String plot;
    private String actors;

    public Film(int id, String title, int poster) {
        this.id = id;
        this.title = title;
        this.poster = poster;
    }

    public Film(int id, String title, int poster, float imdbRating, int runTime, String plot) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.imdbRating = imdbRating;
        this.runTime = runTime;
        this.plot = plot;
    }

    public Film(int id, String title, int poster, float imdbRating, int runTime, String plot, String actors) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.imdbRating = imdbRating;
        this.runTime = runTime;
        this.plot = plot;
        this.actors = actors;
    }

    public float getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(float imdbRating) {
        this.imdbRating = imdbRating;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
