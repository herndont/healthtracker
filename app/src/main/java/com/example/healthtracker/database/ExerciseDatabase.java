package com.example.healthtracker.database;

import com.example.healthtracker.Converters;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


@Database(entities = {Exercise.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class ExerciseDatabase extends RoomDatabase {
    public abstract ExerciseDao exerciseDao();
}
