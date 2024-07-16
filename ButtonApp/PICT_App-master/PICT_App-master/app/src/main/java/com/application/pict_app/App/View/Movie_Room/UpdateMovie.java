package com.application.pict_app.App.View.Movie_Room;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.application.pict_app.R;

public class UpdateMovie extends AppCompatActivity {

    private EditText editTextMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_movie);
        getSupportActionBar().setTitle("Update Movie");
        editTextMovies = findViewById(R.id.editTextMovies);

        final Movies movies = (Movies) getIntent().getSerializableExtra("movie");

        loadTask(movies);

        findViewById(R.id.btn_Update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"Update",Toast.LENGTH_SHORT).show();
                updateMovies(movies);
            }
        });

        findViewById(R.id.btn_Delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"Delete",Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(UpdateMovie.this);
                builder.setTitle("Are you sure?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteMovies(movies);
                    }
                });
               builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {

                   }
               });
               AlertDialog alertDialog = builder.create();
               alertDialog.show();
            }
        });
    }

    private void deleteMovies(Movies movies) {
        class DeleteTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                MoviesDatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .moviesDao()
                        .delete(movies);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(UpdateMovie.this, MovieListView.class));
            }
        }
        DeleteTask deleteTask = new DeleteTask();
        deleteTask.execute();

    }

    private void updateMovies(Movies movies) {
        final String sMovies = editTextMovies.getText().toString().trim();

        if (sMovies.isEmpty()) {
            editTextMovies.setError("Cannot be blank");
            editTextMovies.requestFocus();
            return;
        }

        class UpdateTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                movies.setMovie(sMovies);
                //adding to database
                MoviesDatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .moviesDao()
                        .update(movies);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(UpdateMovie.this, MovieListView.class));
            }
        }
        UpdateTask updateTask = new UpdateTask();
        updateTask.execute();

    }

    private void loadTask(Movies movies) {
        editTextMovies.setText(movies.getMovie());
    }
}