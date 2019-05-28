package com.example.healthtracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
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

    ExerciseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_diary);


        db = Room.databaseBuilder(getApplicationContext(), ExerciseDatabase.class,"exercise-db")
               .allowMainThreadQueries()
                .build();

        Date date = new Date();
        long time = date.getTime();


        List<Exercise> exercises = db.exerciseDao().getAll();



        RecyclerView recyclerView = findViewById(R.id.exerciseText);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ExerciseLayoutAdapter(exercises);
        recyclerView.setAdapter(adapter);

    }

    public void submitButtonClick(View view) throws Exception{

        EditText titleInput = findViewById(R.id.title);
        EditText quantityInput = findViewById(R.id.quantity);
        EditText descriptionInput = findViewById(R.id.description);
        EditText dateInput = findViewById(R.id.date);

        String title = titleInput.getText().toString();
        String quantity = quantityInput.getText().toString();
        String description = descriptionInput.getText().toString();
        String date = dateInput.getText().toString();

        int quant = Integer.parseInt(quantity);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date performedDate = sdf.parse(date);

        Exercise exercise = new Exercise(title, quant, description, performedDate);

        db.exerciseDao().add(exercise);

        finish();
        startActivity(getIntent());

    }

}
