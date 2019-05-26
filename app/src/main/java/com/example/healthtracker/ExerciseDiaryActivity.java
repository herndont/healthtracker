package com.example.healthtracker;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

public class ExerciseDiaryActivity extends AppCompatActivity {

    TextView exerciseText;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_diary);

        RecyclerView recyclerView = findViewById(R.id.exerciseText);

        ArrayList<Exercise> exercises = new ArrayList<>();

//        recyclerView.setLayoutManager();

//        recyclerView.setAdapter();

        ExerciseDatabase db = Room.databaseBuilder(getApplicationContext(), ExerciseDatabase.class,"exercise-db")
               .allowMainThreadQueries()
                .build();

        Date date = new Date();
        long time = date.getTime();


        Exercise ToeStrength = new Exercise("Strong Toe", 5, "Core toe strength is the most under utilized exercise around. Have strong toesies!", date);

        db.exerciseDao().add(ToeStrength);

        Exercise exercise = db.exerciseDao().findByName("Strong Toe");


        exerciseText = findViewById(R.id.exerciseText);
        exerciseText.setText(exercise.getTitle());


    }

}
