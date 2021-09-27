package com.example.moviesapp;

public class moviemodel {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    String title;
    String vote_average;
    String poster_path;
    public moviemodel( String title, String vote_average, String image){
        this.vote_average=vote_average;
        this.poster_path=poster_path;
        this.title=title;
    }
    public moviemodel(){};


}
