package com.example.hackathon2020;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class FoodTracker extends AppCompatActivity {

        ArrayList<String> itemlist;

        ArrayAdapter<String> adapter;

        EditText itemText;

        Button addButton;

        ListView lv;

        RecyclerView mRecyclerView;
        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager;

        List<String> myDataset = new ArrayList<>()





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
                myDataset.add(itemText.getText().toString());
                itemText.setText("");
                mAdapter.notifyDataSetChanged();
            }
        };

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                myDataset.remove(position);
                mAdapter.notifyDataSetChanged();
            }
        });

        helper.attachToRecyclerView(recyclerView);

   lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
       @Override
       public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
/*
           OkHttpClient client = new OkHttpClient();

           final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


           String demoQuery = "{\"query\":\"ran ."+ ((workTime/1000)*(cyclesNum/2)) +" miles\",\"gender\":\"female\",\"weight_kg\":72.5,\"height_cm\":167.64,\"age\":30}";

           RequestBody body = RequestBody.create(demoQuery, JSON);
           final Request request = new Request.Builder()
                   .url("https://trackapi.nutritionix.com/v2/natural/exercise")
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

                       WorkoutTimer.this.runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               try {
                                   JSONObject obj = new JSONObject(myResponse);
                                   //Log.d("idk", "run: "+obj);
                                   JSONArray balls = obj.getJSONArray("exercises");
                                   //Log.d("idk", "run: "+balls);
                                   JSONObject balls2 = balls.getJSONObject(0);
                                   //Log.d("idk", "run: "+balls2);
                                   String balls3 = balls2.getString("nf_calories");
                                   Log.d("idk", "makePost: " + balls3);
                                   activityCalories = balls3;
                               } catch (JSONException e) {
                                   e.printStackTrace();
                               }
                           }
                       });
                   }
               }
           });

       }
   });
   */
           //itemlist.remove(position);

                  // positionchecker.clear();

                   adapter.notifyDataSetChanged();

                   return false;

               }

          });

        addButton.setOnClickListener(addlistener);

        lv.setAdapter(adapter);

    }

}


