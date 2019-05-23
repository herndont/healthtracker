package com.example.healthtracker;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class FingerActivity extends AppCompatActivity {

    TextView counter;
    Button button;
    int count = 0;

    CarouselView carouselView;

    int[] sampleImages = {R.drawable.got_ya, R.drawable.strong_finger, R.drawable.strong_fingerbkwt};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);
    }

    public void fingerButtonClick(View view) {
        counter = findViewById(R.id.counter);
        button = findViewById(R.id.button);

        counter.setText("0");

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                count = count + 1;
                counter.setText(String.valueOf(count));
            }
        });
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}
