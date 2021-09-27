package com.example.moviesapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface api_call_MovieDetails {
    @GET("3/movie/{movie_id}")
    Call<MovieDetailModel> getmovies(
            @Path("movie_id") Long movie_id,
            @Query("api_key") String apikey);

}

