package com.example.hackathon2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPref sharedpref;

    Button toTimer;
    Button toFoodTracker;
    Button toCalendar;
    Button toWorkouts;
    ImageView settings;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedpref = new SharedPref(this);
        //sharedpref.changeMode(2);
        if (sharedpref.mode() == 1) {
            setTheme(R.style.darkTheme);
            Log.d("mode", "" + sharedpref.mode() + "Choice 1");
        }
        if (sharedpref.mode() == 2) {
            setTheme(R.style.liteTheme);
            Log.d("mode", "" + sharedpref.mode() + "Choice 2");
        }
        setContentView(R.layout.activity_main);
        sharedpref = new SharedPref(this);
        settings = findViewById(R.id.settings);

        if (sharedpref.mode() == 1) {
            ImageView settings = findViewById(R.id.settings);
            settings.setImageResource(R.drawable.settings);
        }
        if (sharedpref.mode() == 2) {
            ImageView settings = findViewById(R.id.settings);
            settings.setImageResource(R.drawable.settings2);
        }

        if (sharedpref.mode() == 1) {
            RelativeLayout root = findViewById(R.id.root);
            root.setBackgroundResource(R.drawable.background);
        }
        if (sharedpref.mode() == 2) {
            RelativeLayout root = findViewById(R.id.root);
            root.setBackgroundResource(R.drawable.background2);
        }

        toCalendar = findViewById(R.id.toCalendar);
        toTimer = findViewById(R.id.toTimer);
        toFoodTracker = findViewById(R.id.toFoodTracker);
        toWorkouts = findViewById(R.id.toWorkouts);

        toTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTimer();
            }
        });

        toFoodTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTracker();
            }
        });

        toCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toCalendar();
            }
        });

        toWorkouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toWorkoutExample();
            }
        });






    }

    public void restartApp() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }

    public void settings(View view) {
        Intent intentSettings = new Intent(this, Settings.class);
        startActivity(intentSettings);
    }

    public void toTimer(){
        Intent toTimer = new Intent(this, WorkoutTimer.class);
        startActivity(toTimer);

    }

    public void toTracker(){
        Intent toTracker = new Intent(this, FoodTracker.class);
        startActivity(toTracker);
    }

    public void toCalendar(){
        Intent toCalendar = new Intent(this, Calendar.class);
        startActivity(toCalendar);
    }
    public void toWorkouts(){
        Intent toWorkouts = new Intent(this, WorkoutTimer.class);
        startActivity(toWorkouts);
    }
    public void toWorkoutExample(){
        Intent toExamples = new Intent(this, WorkoutExamples.class);
        startActivity(toExamples);
    }



}