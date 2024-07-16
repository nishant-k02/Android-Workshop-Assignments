package com.application.pict_app.App.View.Movie_Room;

import android.content.Context;

import androidx.room.Room;

public class MoviesDatabaseClient {

    private Context mCtx;
    private static MoviesDatabaseClient mInstance;

    //our app database object
    private AppDatabase appDatabase;

    private MoviesDatabaseClient(Context mCtx) {
        this.mCtx = mCtx;

        //creating the app database with Room database builder
        //MyMovies is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase.class, "MyMovies").build();
    }

    public static synchronized MoviesDatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new MoviesDatabaseClient(mCtx);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
