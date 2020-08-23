package com.example.hackathon2020;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;


import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class FoodTracker extends AppCompatActivity {

        ArrayList<String> itemlist;

        ArrayAdapter<String> adapter;

        EditText itemText;

        Button addButton;

        ListView lv;

        OkHttpClient client;

        Double cal;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_tracker);

        lv = (ListView) findViewById(R.id.ListView);
        itemText= (EditText) findViewById(R.id.addtext);
        addButton = (Button) findViewById(R.id.addbutton);

        client = new OkHttpClient();


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



    public int getFoodCalories(String food){



        String url = "https://api.nutritionix.com/v1_1/search/" + food + "?results=0:20&fields=nf_calories&appId=0f3b890a&appKey=3d447e1e0e5624f64283de31e44a3333";
        final Request request = new Request.Builder()
                .url(url)
                .post()
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.d("mode", "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    // Log.d("mode", "onResponse: " + myResponse);

                    FoodTracker.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONObject obj = new JSONObject(myResponse);
                                //JSONArray info = obj.getJSONArray("sprites");
                                cal = obj.getDouble("nf_calories");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        });



        return (int)Math.round(cal);



    }

}
