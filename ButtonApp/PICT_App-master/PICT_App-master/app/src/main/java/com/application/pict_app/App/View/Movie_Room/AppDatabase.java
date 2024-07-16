package com.application.pict_app.App.View.Movie_Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Movies.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MovieDao moviesDao();
}
