package com.example.moviesapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface api_call_popular {
    @GET("3/movie/popular")
    Call<MoviesResult> getmovies(@Query("api_key") String apikey);

    }
