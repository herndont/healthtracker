package com.example.healthtracker;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class ExerciseDiaryActivity extends AppCompatActivity {

    TextView exerciseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_diary);

        ExerciseDatabase db = Room.databaseBuilder(getApplicationContext(), ExerciseDatabase.class,"exercise-db")
               .allowMainThreadQueries()
                .build();

        Date date = new Date();
        long time = date.getTime();


        Exercise ToeStrength = new Exercise("Strong Toe", 5, "Core toe strength is the most under utilized exercise around. Have strong toesies!", date);

        db.exerciseDao().add(ToeStrength);

        Exercise exercise = db.exerciseDao().findByName("Strong Toe");
        String t = "What what";


        exerciseText = findViewById(R.id.exerciseText);
        exerciseText.setText(exercise.getTitle());
    }


}
