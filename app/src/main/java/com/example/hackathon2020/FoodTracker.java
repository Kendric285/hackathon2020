package com.example.hackathon2020;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class FoodTracker extends AppCompatActivity {

        ArrayList<String> itemlist;

        ArrayAdapter<String> adapter;

        EditText itemText;

        Button addButton;

        ListView lv;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_tracker);

        lv = (ListView) findViewById(R.id.ListView);
        itemText= (EditText) findViewById(R.id.addtext);
        addButton = (Button) findViewById(R.id.addbutton);

        itemlist = new ArrayList<>();

        adapter = new ArrayAdapter<String>(FoodTracker.this,android.R.layout.simple_list_item_multiple_choice,itemlist);

        View.OnClickListener addlistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemlist.add(itemText.getText().toString());
                itemText.setText("");
                adapter.notifyDataSetChanged();
            }
        };

   lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
       @Override
       public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


           itemlist.remove(position);

                  // positionchecker.clear();

                   adapter.notifyDataSetChanged();

                   return false;

               }

          });

        addButton.setOnClickListener(addlistener);

        lv.setAdapter(adapter);

    }





}
