package com.example.healthtracker;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Exercise.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class ExerciseDatabase extends RoomDatabase {
    public abstract ExerciseDao exerciseDao();
}
