package com.example.healthtracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

public class ExerciseDiaryActivity extends AppCompatActivity {

    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    Button button;

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

        List<Exercise> exercises = db.exerciseDao().getAll();



        RecyclerView recyclerView = findViewById(R.id.exerciseText);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ExerciseLayoutAdapter(exercises);
        recyclerView.setAdapter(adapter);

    }

    public void submitButtonClick(View view) {
        button = findViewById(R.id.submitButton);
        String title;
        String quantity;
        String description;
        Date date;

        View layout = findViewById(R.id.textInputLayout);
        title = layout.findViewById(R.id.title);
        quantity = findViewById(R.id.quantity);
        description = layout.findViewById(R.id.description);
        date = layout.findViewById(R.id.date);
    }

}
