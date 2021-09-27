package com.example.moviesapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.moviesapp.adapter.Adapterclass;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Fragment_TopRated extends Fragment {
    public static String Json_url = "https://api.themoviedb.org/3/movie/top_rated?api_key=f95436d72b182429105097fb8b1ecfb1";
    public static String key = "f95436d72b182429105097fb8b1ecfb1";
    List<Result> Result;
    RecyclerView recyclerView;
    private ProgressBar spinner;
    Adapterclass.OnNoteClickListner onNoteClickListner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        Result = new ArrayList<>();

        recyclerView = view.findViewById(R.id.rv_main_page);
        spinner = (ProgressBar) view.findViewById(R.id.progressBar2);
        spinner.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api_call_to_toprated api_call = retrofit.create(api_call_to_toprated.class);
        Call<MoviesResult> call = api_call.getmovies(key);
        call.enqueue(new Callback<MoviesResult>() {
            @Override
            public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {

                if (response.code() != 200) {
                    return;
                }
                spinner.setVisibility(View.GONE);
                Result[] results = response.body().getResults();

                for (Result result : results) {
                    Result.add(result);
                }
                putdataintorecyclerview(Result);


            }

            @Override
            public void onFailure(Call<MoviesResult> call, Throwable t) {
                CheckNetwork checkNetwork = new CheckNetwork();
                if (!checkNetwork.isInternetAvailable(getContext())) {
                    Toast.makeText(getContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), t.getStackTrace().toString(), Toast.LENGTH_LONG).show();
                }
            }

        });
        return view;
    }

    public void putdataintorecyclerview(List<Result> Result) {
        Adapterclass adapter = new Adapterclass(Result, getContext(), onNoteClickListner);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(adapter);

    }
}
