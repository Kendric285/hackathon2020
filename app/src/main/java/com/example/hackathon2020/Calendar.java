package com.example.hackathon2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Calendar extends AppCompatActivity {

    CalendarView calender;
    TextView date_view;

    Integer globalYear;
    Integer globalMonth;
    Integer globalDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        SharedPref sharedpref = new SharedPref(this);

        if (sharedpref.mode() == 1) {
            RelativeLayout root = findViewById(R.id.root);
            root.setBackgroundResource(R.drawable.background);
        }
        if (sharedpref.mode() == 2) {
            RelativeLayout root = findViewById(R.id.root);
            root.setBackgroundResource(R.drawable.background2);
        }

        calender = (CalendarView) findViewById(R.id.calender);
        date_view = (TextView) findViewById(R.id.date_view);


        date_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        // Add Listener in calendar
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override

                            // In this Listener have one method
                            // and in this method we will
                            // get the value of DAYS, MONTH, YEARS
            public void onSelectedDayChange(
                                    @NonNull CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth
                                    )
                            {

                                // Store the value of date with
                                // format in String type Variable
                                // Add 1 in month because month
                                // index is start with 0

                                globalYear = year;
                                globalDay = dayOfMonth;
                                globalMonth = month;
                                String Date = (month + 1) + "-" + dayOfMonth + "-" + year;

                                // set this date in TextView for Display
                                System.out.println("pressed");

                                date_view.setText(Date);
                                toEventsList();
                            }
                        });




    }
    public void toEventsList(){
        Intent toEvents = new Intent(this, EventsList.class);
        toEvents.putExtra("year", globalYear);
        toEvents.putExtra("month", globalMonth);
        toEvents.putExtra("day", globalDay);
        startActivity(toEvents);
    }
}