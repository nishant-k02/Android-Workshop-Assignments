package com.application.pict_app.App.View.Movie_Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM movies")
    List<Movies> getAll();

    @Insert
    void insert(Movies movies);

    @Delete
    void delete(Movies movies);

    @Update
    void update(Movies movies);
}
