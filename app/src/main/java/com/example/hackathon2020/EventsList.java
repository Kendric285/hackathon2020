package com.example.hackathon2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EventsList extends AppCompatActivity {

    Integer month;
    Integer day;
    Integer year;
    String monthName;

    String date;
    TextView textView_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list);

        Intent intent = getIntent();

        textView_date = findViewById(R.id.textview_date);






        month = intent.getIntExtra("month", 0);
        day = intent.getIntExtra("day", 0);
        year = intent.getIntExtra("year", 0);

        if(month + 1 == 1){
            monthName = "January";
        }
        else if(month + 1 == 2){
            monthName = "February";
        }
        else if(month + 1 == 3){
            monthName = "March";
        }
        else if(month + 1 == 4){
            monthName = "April";
        }
        else if(month + 1 == 5){
            monthName = "May";
        }
        else if(month + 1 == 6){
            monthName = "June";
        }
        else if(month + 1 == 7){
            monthName = "July";
        }
        else if(month + 1 == 8){
            monthName = "August";
        }
        else if(month + 1 == 9){
            monthName = "September";
        }
        else if(month + 1 == 10){
            monthName = "October";
        }
        else if(month + 1 == 11){
            monthName = "November";
        }
        else if(month + 1 == 12){
            monthName = "December";
        }
        else{
            monthName = "Fall";
        }

        date = monthName + " " + day + ", " + year;


        textView_date.setText(date);






    }
}