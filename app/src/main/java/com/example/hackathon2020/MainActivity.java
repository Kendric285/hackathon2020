package com.example.hackathon2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button toTimer;
    Button toFoodTracker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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