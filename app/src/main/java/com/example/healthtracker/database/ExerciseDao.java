package com.example.healthtracker.database;

import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ExerciseDao {

    @Query("SELECT * FROM Exercise")
    List<Exercise> getAll();

    @Query("SELECT * FROM Exercise WHERE title = :title")
    Exercise findByName(String title);

    @Insert
    void add(Exercise exercise);

    @Delete
    void delete(Exercise exercise);
}
