package com.example.hackathon2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPref sharedpref;

    Button toTimer;
    Button toFoodTracker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedpref = new SharedPref(this);
        if (sharedpref.mode() == 1) {
            setTheme(R.style.darkTheme);
            Log.d("mode", "" + sharedpref.mode() + "Choice 1");
        }
        if (sharedpref.mode() == 2) {
            setTheme(R.style.liteTheme);
            Log.d("mode", "" + sharedpref.mode() + "Choice 2");
        }
        toTimer = findViewById(R.id.toTimer);
        toFoodTracker = findViewById(R.id.toFoodTracker);


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







    }

    public void toTimer(){
        Intent toTimer = new Intent(this, WorkoutTimer.class);
        startActivity(toTimer);

    }

    public void toTracker(){
        Intent toTracker = new Intent(this, FoodTracker.class);
        startActivity(toTracker);

    }

}