package com.example.moviesapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface api_call_upcoming {
    @GET("3/movie/upcoming")
    Call<MoviesResult> getmovies(@Query("api_key") String apikey);

}
