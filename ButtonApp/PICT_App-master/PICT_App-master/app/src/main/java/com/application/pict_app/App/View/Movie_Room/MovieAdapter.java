package com.application.pict_app.App.View.Movie_Room;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.application.pict_app.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.TasksViewHolder> {

    private Context mCtx;
    private List<Movies> movieList;

    public MovieAdapter(Context mCtx, List<Movies> movieList) {
        this.mCtx = mCtx;
        this.movieList = movieList;
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_movies, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        Movies movies = movieList.get(position);
        holder.textViewTask.setText(movies.getMovie());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewStatus, textViewTask, textViewDesc, textViewFinishBy;

        public TasksViewHolder(View itemView) {
            super(itemView);

            textViewTask = itemView.findViewById(R.id.textViewMovies);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Movies movies = movieList.get(getAdapterPosition());
            Intent intent = new Intent(mCtx, UpdateMovie.class);
            intent.putExtra("movie", movies);
            mCtx.startActivity(intent);
        }
    }
}