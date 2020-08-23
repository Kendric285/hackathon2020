package com.example.hackathon2020;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FoodTracker extends AppCompatActivity {

        ArrayList<String> itemlist;

        ArrayAdapter<String> adapter;

        EditText itemText;

        Button addButton;

        ListView lv;

        String calories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_tracker);
        SharedPref sharedpref = new SharedPref(this);

        if (sharedpref.mode() == 1) {
            RelativeLayout root = findViewById(R.id.root);
            root.setBackgroundResource(R.drawable.background);
        }
        if (sharedpref.mode() == 2) {
            RelativeLayout root = findViewById(R.id.root);
            root.setBackgroundResource(R.drawable.background2);
        }


        lv = (ListView) findViewById(R.id.ListView);
        itemText= (EditText) findViewById(R.id.addtext);
        addButton = (Button) findViewById(R.id.addbutton);

        itemlist = new ArrayList<>();

        adapter = new ArrayAdapter<String>(FoodTracker.this,android.R.layout.simple_list_item_multiple_choice,itemlist);

        View.OnClickListener addlistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // itemlist.add(itemText.getText().toString());
                //adapter.notifyDataSetChanged();

                OkHttpClient client = new OkHttpClient();

                final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


                String demoQuery = "{ \"query\":\"today I ate "+ itemText.getText().toString() +"\", \"timezone\": \"US/Eastern\" }";
                //""{\"query\":\"ran ."+ ((workTime/1000)*(cyclesNum/2)) +" miles\",\"gender\":\"female\",\"weight_kg\":72.5,\"height_cm\":167.64,\"age\":30}";

                RequestBody body = RequestBody.create(demoQuery, JSON);
                final Request request = new Request.Builder()
                        .url("https://trackapi.nutritionix.com/v2/natural/nutrients")
                        .addHeader("x-app-id", "e5c6e8a7")
                        .addHeader("x-app-key", "3fe3d379af2b2e4dc6f2d98740fd6287")
                        .addHeader("x-remote-user-id", "0")
                        .post(body)
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
                                        Log.d("idk", "run: "+obj);
                                   JSONArray foods = obj.getJSONArray("foods");
                                   //Log.d("idk", "run: "+balls);
                                   JSONObject foodsJSONObject = foods.getJSONObject(0);
                                   //Log.d("idk", ": "+balls2);
                                    calories = foodsJSONObject.getString("nf_calories");
                                    String fat = foodsJSONObject.getString("nf_total_fat");
                                    String protein = foodsJSONObject.getString("nf_protein");
                                   //itemlist.add(itemText.getText().toString());
                                   Log.d("idk", "makePost: " + calories);
                                   String food = itemText.getText().toString().toUpperCase();
                                   String color = "<font color='#EE0000'></font>";





                                        itemlist.add((food +": "+ calories +"-calories, "+fat+"-fat, "+protein+"-protein"));
                                        itemText.setText("");
                                        adapter.notifyDataSetChanged();
                                   //activityCalories = balls3;
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    }
                });

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
