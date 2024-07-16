package com.application.pict_app.App.View.Movie_Room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.application.pict_app.R;

public class AddMovie extends AppCompatActivity {

    private EditText editTextMovies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);
        getSupportActionBar().setTitle("Add Movie");
        editTextMovies = findViewById(R.id.editTextMovies);

        findViewById(R.id.btn_Save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTask();
            }
        });
    }

    private void saveTask() {
        final String sMovies = editTextMovies.getText().toString().trim();

        if (sMovies.isEmpty()) {
            editTextMovies.setError("Cannot be blank");
            editTextMovies.requestFocus();
            return;
        }
        class SaveMovie extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                //creating a movie
                Movies task = new Movies();
                task.setMovie(sMovies);

                //adding to database
                MoviesDatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .moviesDao()
                        .insert(task);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                startActivity(new Intent(getApplicationContext(), MovieListView.class));
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
                finish();
            }
        }

        SaveMovie saveMovie = new SaveMovie();
        saveMovie.execute();
    }
}