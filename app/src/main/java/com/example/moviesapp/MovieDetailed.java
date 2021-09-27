package com.example.moviesapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieDetailed extends AppCompatActivity {
    TextView Overview;
    TextView Original_language;
    TextView Popularity;
    TextView Revenue;
    TextView Release ;
    TextView ProductionCountries ;
    List<MovieDetailModel> Result;
    List<ProductionCountry> ProductionCountry;
    private ProgressBar spinner;

    api_call_MovieDetails api_call_movieDetails;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);
        Result = new ArrayList<>();
        ProductionCountry = new ArrayList<>();
        Bundle bundle=getIntent().getExtras();
        String key="f95436d72b182429105097fb8b1ecfb1";
        Long Movie_id=bundle.getLong("Movie_id");
        Overview=findViewById(R.id.txt_overview);
        Original_language=findViewById(R.id.txt_Original_language);
        Popularity=findViewById(R.id.txt_popularity);
        Revenue=findViewById(R.id.txt_revenue);
        Release=findViewById(R.id.txt_release_date);
        ProductionCountries=findViewById(R.id.txt_pc);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.VISIBLE);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api_call_MovieDetails api_call_movieDetails= retrofit.create(api_call_MovieDetails.class);
        Call<MovieDetailModel> call=api_call_movieDetails.getmovies(Movie_id,key);
        call.enqueue(new Callback<MovieDetailModel>() {
            @Override
            public void onResponse(Call<MovieDetailModel> call, Response<MovieDetailModel> response) {

                if (response.code() != 200) {
                    return;
                }
                spinner.setVisibility(View.GONE);
                MovieDetailModel results = response.body();
                ProductionCountry=response.body().getProductionCountries();
                Overview.setText(results.getOverview());
                Original_language.setText(results.getOriginalLanguage());
                Release.setText(results.getReleaseDate());
                Revenue.setText(results.getProductionCompanies().get(0).getName());
                ProductionCountries.setText(results.getProductionCompanies().get(0).getOriginCountry());
                Popularity.setText(results.getStatus());
               // putdataintorecyclerview(Result);
            }

            @Override
            public void onFailure(Call<MovieDetailModel> call, Throwable t) {
                Log.d("1", "onFailure: ");
                CheckNetwork checkNetwork = new CheckNetwork();
                if (!checkNetwork.isInternetAvailable(MovieDetailed.this)) {
                    Toast.makeText(MovieDetailed.this, "No Internet Connection", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MovieDetailed.this, t.getStackTrace().toString(), Toast.LENGTH_LONG).show();
                }
            }

        });

    }

    }

