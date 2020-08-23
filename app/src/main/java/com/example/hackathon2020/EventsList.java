package com.example.hackathon2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class EventsList extends AppCompatActivity {
    ArrayList<String> itemList;
    ArrayAdapter<String> adapter;
    EditText itemText;
    Button addbutton;
    ListView lv;

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
        SharedPref sharedpref = new SharedPref(this);

        if (sharedpref.mode() == 1) {
            RelativeLayout root = findViewById(R.id.root);
            root.setBackgroundResource(R.drawable.background);
        }
        if (sharedpref.mode() == 2) {
            RelativeLayout root = findViewById(R.id.root);
            root.setBackgroundResource(R.drawable.background2);
        }

        Intent intent = getIntent();

        textView_date = findViewById(R.id.textview_date);

        lv =(ListView) findViewById(R.id.listView);
        itemText =(EditText) findViewById(R.id.addtext);
        addbutton =(Button) findViewById(R.id.addbutton);

        itemList = new ArrayList<>();

        adapter = new ArrayAdapter<String>(EventsList.this,android.R.layout.simple_list_item_multiple_choice,itemList);

        View.OnClickListener addlistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    itemList.add(itemText.getText().toString());
                    itemText.setText("");
                    adapter.notifyDataSetChanged();

            }

        };

        addbutton.setOnClickListener(addlistener);
        lv.setAdapter(adapter);


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

        date = monthName + " " + day + ", " + year;


        textView_date.setText(date);






    }
}