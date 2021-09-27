package com.example.moviesapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesapp.MovieDetailed;
import com.example.moviesapp.R;
import com.example.moviesapp.Result;

import java.util.List;

public class Adapterclass extends RecyclerView.Adapter<Adapterclass.ViewHolder> {

    List<Result> list;
    Context context;
    OnNoteClickListner monNoteClickListner;
    public Adapterclass(List<Result> list, Context context,OnNoteClickListner onNoteClickListner) {
        this.context=context;
        this.list=list;
        this.monNoteClickListner=onNoteClickListner;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movies_item_view, parent, false);
        return new ViewHolder(view,monNoteClickListner);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result Result=list.get(position);
        holder.name_txt.setText(Result.getTitle());
        holder.id.setText(String.valueOf(Result.getvote_average()));
        Glide.with(context).load("https://image.tmdb.org/t/p/w500"+Result.getPoster_path()).into(holder.imageView);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MovieDetailed.class);
                Bundle bundle=new Bundle();
                bundle.putLong("Movie_id",Result.getID());
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name_txt;
        TextView id;
        ImageView imageView;
        OnNoteClickListner onNoteClickListner;

        public ViewHolder(@NonNull View itemView,OnNoteClickListner onNoteClickListner) {
            super(itemView);
            name_txt = itemView.findViewById(R.id.tv_name_txt);
            id = itemView.findViewById(R.id.tv_id_txt);
            imageView = itemView.findViewById(R.id.iv_itemimageview);
            this.onNoteClickListner=onNoteClickListner;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            monNoteClickListner.OnitemClick(getAdapterPosition());
        }
    }
    public interface OnNoteClickListner{
        void OnitemClick(int posotion);
    }
    public static Long getMovieid(Long position){
        return position;
    }
}

























