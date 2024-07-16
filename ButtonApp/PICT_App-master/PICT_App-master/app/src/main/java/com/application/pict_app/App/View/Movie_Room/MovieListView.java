package com.application.pict_app.App.View.Movie_Room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.application.pict_app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MovieListView extends AppCompatActivity {

    private FloatingActionButton buttonAddTask;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list_view);
        getSupportActionBar().setTitle("Movie List");
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonAddTask = findViewById(R.id.floating_button_add);
        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MovieListView.this, AddMovie.class);
                startActivity(intent);
            }
        });
        getMovieList();
    }

    private void getMovieList() {

        class GetMovies extends AsyncTask<Void,Void, List<Movies>>{

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                // display a progress dialog
                progressDialog = new ProgressDialog(MovieListView.this);
                progressDialog.setCancelable(false); // set cancelable to false
                progressDialog.setMessage("Please Wait"); // set message
                progressDialog.show(); // show progress dialog
            }

            @Override
            protected List<Movies> doInBackground(Void... voids) {
                List<Movies> taskList = MoviesDatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .moviesDao()
                        .getAll();
                return taskList;
            }

            @Override
            protected void onPostExecute(List<Movies> movies) {
                super.onPostExecute(movies);
                MovieAdapter adapter = new MovieAdapter(MovieListView.this, movies);
                recyclerView.setAdapter(adapter);
                progressDialog.dismiss();
            }
        }
            GetMovies getMovies = new GetMovies();
            getMovies.execute();
    }
}