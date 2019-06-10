package com.example.healthtracker.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.healthtracker.database.Exercise;
import com.example.healthtracker.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExerciseLayoutAdapter extends RecyclerView.Adapter<ExerciseLayoutAdapter.ExerciseHolder> {

    public static class ExerciseHolder extends RecyclerView.ViewHolder {

        public TextView textTitle;
        public TextView textQuantity;
        public TextView textDescription;
        public TextView textDate;

        public ExerciseHolder(@NonNull View itemView) {
            super(itemView);

            this.textTitle = itemView.findViewById(R.id.text_title);
            this.textQuantity = itemView.findViewById(R.id.text_quantity);
            this.textDescription = itemView.findViewById(R.id.text_description);
            this.textDate = itemView.findViewById(R.id.text_date);
        }

        public void setExercise(Exercise exercise) {
            this.textTitle.setText(exercise.getTitle());
            this.textQuantity.setText(Integer.toString(exercise.getQuantity()));
            this.textDescription.setText(exercise.getDescription());
            this.textDate.setText(exercise.getPerformedDate().toString());
        }
    }

    private List<Exercise> exercises;

    public ExerciseLayoutAdapter(List<Exercise> exercises) {
        this.exercises = exercises;

    }

    @NonNull
    @Override
    public ExerciseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.exercise_view, parent, false);

        ExerciseHolder holder = new ExerciseHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseHolder holder, int position) {

        Exercise exercise = exercises.get(position);

        holder.setExercise(exercise);

    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }
}
