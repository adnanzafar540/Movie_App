package com.example.moviesapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesapp.adapter.Adapterclass;

import java.util.List;


public class MainActivity extends FragmentActivity{
    Button Top_Rated;
    Button Popular;
    Button Upcoming;
    ImageView imageView;
    FrameLayout frameLayout;
    RecyclerView recyclerView;
    Adapterclass.OnNoteClickListner onNoteClickListner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Top_Rated = findViewById(R.id.btn_Top_Rated);
        Popular = findViewById(R.id.btn_Popular);
        Upcoming = findViewById(R.id.btn_Upcoming);
        imageView=findViewById(R.id.imageView_main_page);
        frameLayout=findViewById(R.id.fragment_place);
        recyclerView=findViewById(R.id.rv_main_page);
        Glide.with(this).load(R.drawable.salamna).into(imageView);
        androidx.fragment.app.FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.fragment_place,new Fragment_TopRated()).commit();

        //recyclerView = recyclerView.findViewById(R.id.rv_main_page);

        Top_Rated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Top_Rated.setBackgroundColor(0xFFFF0000);
                Popular.setBackgroundColor(0xFFFFFF);
                Upcoming.setBackgroundColor(0xFFFFFF);
                androidx.fragment.app.FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_place,new Fragment_TopRated()).commit();


            }
        });  Popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Top_Rated.setBackgroundColor(0xFFFFFF);
                Popular.setBackgroundColor(0xFFFF0000);
                Upcoming.setBackgroundColor(0xFFFFFF);
                androidx.fragment.app.FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_place,new Fragment_Popular()).commit();
            }
        });  Upcoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Top_Rated.setBackgroundColor(0xFFFFFF);
                Popular.setBackgroundColor(0xFFFFFF);
                Upcoming.setBackgroundColor(0xFFFF0000);
                androidx.fragment.app.FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.fragment_place,new Fragment_Upcoming()).commit();

            }
        });
    }

  /*   public void OnitemClick(int position) {
        Intent intent=new Intent(this,MovieDetailed.class);
        Bundle bundle=new Bundle();
        bundle.putLong("key",position);
        intent.putExtras(bundle);
        startActivity(intent);
    }
   public void putdataintorecyclerview(List<Result> Result){
        Adapterclass adapter=new Adapterclass(Result,this,onNoteClickListner);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(adapter);
    }**/
}



