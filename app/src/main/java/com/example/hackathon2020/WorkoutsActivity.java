package com.example.hackathon2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkoutsActivity extends AppCompatActivity {

    List<String> workouts;

    Button getWork;
    ImageView workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);
        SharedPref sharedpref = new SharedPref(this);

        if (sharedpref.mode() == 1) {
            ConstraintLayout root = findViewById(R.id.root);
            root.setBackgroundResource(R.drawable.background);
        }
        if (sharedpref.mode() == 2) {
            ConstraintLayout root = findViewById(R.id.root);
            root.setBackgroundResource(R.drawable.background2);
        }
        workouts = new ArrayList<String>();
        workouts.add("https://darebee.com/images/workouts/lazy-bear-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/ultra-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/prep-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/total-blast-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/cant-stop-me-now-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/stopgap-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/less-is-more-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/iron-tendons-lowerbody-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/blaze-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/never-give-up-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/victory-lap-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/pecs-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/fight-back-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/move-it-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/rock-hard-abs-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/my-time-is-now-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/zen-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/roundabout-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/cronus-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/hall-of-fame-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/epic-glutes-workout-intro.jpg");
        workouts.add("https://darebee.com/images/workouts/something-i-can-do-workout-intro.jpg");


        getWork = findViewById(R.id.img);
        workout = findViewById(R.id.imageView);
        Picasso.get().load(workouts.get(0)).into(workout);

        getWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random = new Random().nextInt(workouts.size());
                Picasso.get().load(workouts.get(random)).into(workout);
            }
        });


    }
}