package com.example.hackathon2020;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;



public class Workoutvids extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPref sharedpref = new SharedPref(this);
        if (sharedpref.mode() == 1) {
            setTheme(R.style.darkTheme);
            Log.d("mode", "" + sharedpref.mode() + "Choice 1");
        }
        if (sharedpref.mode() == 2) {
            setTheme(R.style.liteTheme);
            Log.d("mode", "" + sharedpref.mode() + "Choice 2");
        }

        setContentView(R.layout.activity_workout_timer);
//        post = new post();
        if (sharedpref.mode() == 1) {
            RelativeLayout root = findViewById(R.id.root);
            root.setBackgroundResource(R.drawable.background);
        }
        if (sharedpref.mode() == 2) {
            RelativeLayout root = findViewById(R.id.root);
            root.setBackgroundResource(R.drawable.background2);
        }
        setContentView(R.layout.activity_workoutvids);

        Button button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=50kH47ZztHs"));
                startActivity(intent);



            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=CBWQGb4LyAM"));
                startActivity(intent);

            }
        });
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=BMLhJvhWZ0E"));
                startActivity(intent);

            }
        });
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fitnessblender.com/videos/home-upper-body-workout-without-weights-bodyweight-workout-for-beginners"));
                startActivity(intent);
            }
        });
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=W5IiasNutB8"));
                startActivity(intent);

            }
        });
        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=HRvFxrFGqA4"));
                startActivity(intent);

            }
        });
        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=aclHkVaku9U"));
                startActivity(intent);

            }
        });
        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=lpgWK7wYMU4"));
                startActivity(intent);

            }
        });

    }

    public void settings(View view) {
        Intent intentSettings = new Intent(this, Settings.class);
        startActivity(intentSettings);
    }

    public void home(View view) {
        Intent intentHome = new Intent(this, MainActivity.class);
        startActivity(intentHome);
    }


}