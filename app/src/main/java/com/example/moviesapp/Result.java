package com.example.moviesapp;

public class Result {

    private boolean adult;
    private String backdropPath;
    private long[] genreIDS;
    private long id;
    private String originalTitle;
    private String overview;
    private double popularity;
    private String poster_path;
    private String title;
    private boolean video;
    private double vote_average;
    private long voteCount;

    public boolean getAdult() { return adult; }
    public void setAdult(boolean value) { this.adult = value; }

    public String getBackdropPath() { return backdropPath; }
    public void setBackdropPath(String value) { this.backdropPath = value; }

    public long[] getGenreIDS() { return genreIDS; }
    public void setGenreIDS(long[] value) { this.genreIDS = value; }

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }


    public String getOriginalTitle() { return originalTitle; }
    public void setOriginalTitle(String value) { this.originalTitle = value; }

    public String getOverview() { return overview; }
    public void setOverview(String value) { this.overview = value; }

    public double getPopularity() { return popularity; }
    public void setPopularity(double value) { this.popularity = value; }

    public String getPoster_path() { return poster_path; }
    public void setPoster_path(String value) { this.poster_path = value; }


    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public boolean getVideo() { return video; }
    public void setVideo(boolean value) { this.video = value; }

    public double getvote_average() { return vote_average; }
    public void setvote_average(double value) { this.vote_average = value; }

    public long getVoteCount() { return voteCount; }
    public void setVoteCount(long value) { this.voteCount = value; }
}
