package com.example.hackathon2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

public class FoodTracker extends AppCompatActivity {

    SharedPref sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedpref = new SharedPref(this);
        if (sharedpref.mode() == 1){ setTheme(R.style.darkTheme);
            Log.d("mode",""+sharedpref.mode()+"Choice 1");}
        if (sharedpref.mode() == 2){ setTheme(R.style.liteTheme);
            Log.d("mode",""+sharedpref.mode()+"Choice 2");}
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_tracker);

        if (sharedpref.mode() == 1){
            RelativeLayout root = findViewById(R.id.root);
            root.setBackgroundResource(R.drawable.background);
        }
        if (sharedpref.mode() == 2){
            RelativeLayout root = findViewById(R.id.root);
            root.setBackgroundResource(R.drawable.background2);
        }
    }
}