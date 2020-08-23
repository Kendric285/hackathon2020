package com.example.hackathon2020;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class WorkoutTimer extends AppCompatActivity {

    SharedPref sharedpref;
    //post post;

    // OkHttpClient client;

    private TextView mTextViewCountDown;
    private Button mButtonReset;
    private Button mButtonSet;
    private EditText mEditTextInputWork;
    private EditText mEditTextInputRest;
    private EditText mEditTextInputCycles;
    private TextView countdown_task;


    private EditText editText_workoutName;
    private View background;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;

    private long mStartTimeWork;
    private int mStartTimeCycles;
    private long mStartTimeRest;
    private long mTimerLeftInMillis = mStartTimeWork;


    String workoutName;


    long millisInputWork;
    long millisInputRest;
    long workTime;
    long restTime;

    Boolean isWorking;

    Integer inputCyclesNum;
    int cyclesNum;
    String activityCalories;

    ResponseBody food;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedpref = new SharedPref(this);
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


        mEditTextInputWork = findViewById(R.id.edit_text_work);
        mEditTextInputCycles = findViewById(R.id.edit_text_cycles);
        mEditTextInputRest = findViewById(R.id.edit_text_rest);
        editText_workoutName = findViewById(R.id.edit_text_workoutname);


        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        countdown_task = findViewById(R.id.countdown_task);

        mButtonSet = findViewById(R.id.button_timer_set);
        mButtonReset = findViewById(R.id.button_reset);

        background = findViewById(R.id.view2);

        isWorking = true;


        mButtonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countdown_task.setText("Work");
                String inputWork = mEditTextInputWork.getText().toString();
                String inputRest = mEditTextInputRest.getText().toString();
                String inputCycles = mEditTextInputCycles.getText().toString();
                workoutName = editText_workoutName.getText().toString();


                if (inputWork.length() == 0 || inputRest.length() == 0 || inputCycles.length() == 0) {
                    Toast.makeText(WorkoutTimer.this, "Field can't be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                long millisInputWork = Long.parseLong(inputWork) * 1000;
                long millisInputRest = Long.parseLong(inputRest) * 1000;
                inputCyclesNum = (Integer.parseInt(inputCycles)) * 2;
                cyclesNum = inputCyclesNum;

                if (millisInputWork == 0) {
                    Toast.makeText(WorkoutTimer.this, "Please enter a positive number", Toast.LENGTH_SHORT).show();
                    return;
                }


                setTime(millisInputWork);
                workTime = millisInputWork + 500;
                restTime = millisInputRest + 500;
                mEditTextInputWork.setText("");
                mEditTextInputCycles.setText("");
                mEditTextInputRest.setText("");
                editText_workoutName.setText("");

            }

        });


        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputCyclesNum = cyclesNum;
                resetTimer();
                setTime(workTime);

                OkHttpClient client = new OkHttpClient();

                final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


                String demoQuery = "{\"query\":\""+ workoutName +" for "+ ((workTime/1000)*(cyclesNum/2)) +" minutes\",\"gender\":\"female\",\"weight_kg\":72.5,\"height_cm\":167.64,\"age\":30}";

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

        updateCountDownText();
//String , String gender, double weight_kg, double height_cm, int age


    }


    private void setTime(long milliseconds) {
        if (inputCyclesNum % 2 == 0) {
            background.setBackgroundColor(Color.parseColor("#00E400"));
            countdown_task.setText("Work");
        } else {
            background.setBackgroundColor(Color.parseColor("#E42000"));
            countdown_task.setText("Rest");
        }
        mStartTimeWork = milliseconds;
        resetTimer();
        startTimer();


    }


    public void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimerLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimerLeftInMillis = millisUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                updateWatchInterface();


                inputCyclesNum = inputCyclesNum - 1;
                if (inputCyclesNum % 2 == 0) {
                    if (inputCyclesNum > 0) {
                        setTime(workTime);
                    }
                } else {
                    if (inputCyclesNum > 0) {
                        setTime(restTime);
                    }
                }
            }
        }.start();

        //mTimerRunning = true;
        //updateWatchInterface();
        /*
        if(inputCyclesNum > 0) {
            if (isWorking == true) {
                setTime(millisInputRest);
                isWorking = false;


            } else {
                setTime(millisInputWork);
                isWorking = true;

            }
            inputCyclesNum--;
        }

         */


    }



    public void resetTimer() {
        mTimerLeftInMillis = mStartTimeWork;
        updateCountDownText();
        updateWatchInterface();


    }

    public void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        updateWatchInterface();


    }

    public void updateCountDownText() {
        int minutes = (int) mTimerLeftInMillis / 60000;
        int seconds = (int) mTimerLeftInMillis / 1000;

        String timeLeftFormated;

        timeLeftFormated = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);


        mTextViewCountDown.setText(timeLeftFormated);

    }

    private void updateWatchInterface() {
        if (mTimerRunning) {
            mEditTextInputWork.setVisibility(View.INVISIBLE);
            mEditTextInputRest.setVisibility(View.INVISIBLE);
            mEditTextInputCycles.setVisibility(View.INVISIBLE);
            mButtonSet.setVisibility(View.INVISIBLE);
            mButtonReset.setVisibility(View.INVISIBLE);
        } else {
            mEditTextInputWork.setVisibility(View.VISIBLE);
            mEditTextInputRest.setVisibility(View.VISIBLE);
            mEditTextInputCycles.setVisibility(View.VISIBLE);
            mButtonSet.setVisibility(View.VISIBLE);

            if (mTimerLeftInMillis < mStartTimeWork) {
                mButtonReset.setVisibility(View.VISIBLE);
            } else {
                mButtonReset.setVisibility(View.INVISIBLE);
            }
        }
    }
}

