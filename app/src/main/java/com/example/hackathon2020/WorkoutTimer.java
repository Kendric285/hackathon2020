package com.example.hackathon2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class WorkoutTimer extends AppCompatActivity {


    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private Button mButtonSet;
    private EditText mEditTextInput;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;

    private long mStartTimeInMillis;
    private long mTimerLeftInMillis = mStartTimeInMillis;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_timer);

        mEditTextInput = findViewById(R.id.edit_text_input);


        mTextViewCountDown = findViewById(R.id.text_view_countdown);

        mButtonSet = findViewById(R.id.button_timer_set);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);


        mButtonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = mEditTextInput.getText().toString();
                if (input.length() == 0){
                    Toast.makeText(WorkoutTimer.this, "Field can't be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                long millisInput = Long.parseLong(input) * 60000;
                if(millisInput == 0){
                    Toast.makeText(WorkoutTimer.this, "Please enter a positive number", Toast.LENGTH_SHORT).show();
                    return;
                }

                setTime(millisInput);
                mEditTextInput.setText("");
            }

        });


        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTimerRunning){
                    pauseTimer();
                }
                else{
                    startTimer();
                }

            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();

            }
        });

        updateCountDownText();



    }
    private void setTime(long milliseconds){
        mStartTimeInMillis = milliseconds;
        resetTimer();
    }


    public void startTimer(){
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
            }
        }.start();

        mTimerRunning = true;
        updateWatchInterface();



    }
    public void resetTimer(){
        mTimerLeftInMillis = mStartTimeInMillis;
        updateCountDownText();
        updateWatchInterface();



    }
    public void pauseTimer(){
        mCountDownTimer.cancel();
        mTimerRunning = false;
        updateWatchInterface();



    }
    public void updateCountDownText(){
        int hours = (int) mTimerLeftInMillis/1000 / 3600;
        int minutes = (int) mTimerLeftInMillis / 1000 % 3600 / 60;
        int seconds = (int) mTimerLeftInMillis / 1000 % 60;

        String timeLeftFormated;
        if(hours > 0){
            timeLeftFormated = String.format(Locale.getDefault(),"%02d:%02d:%02d",hours, minutes, seconds);


        }else {
            timeLeftFormated = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        }



        mTextViewCountDown.setText(timeLeftFormated);

    }

    private void updateWatchInterface() {
        if (mTimerRunning) {
            mEditTextInput.setVisibility(View.INVISIBLE);
            mButtonSet.setVisibility(View.INVISIBLE);
            mButtonReset.setVisibility(View.INVISIBLE);
            mButtonStartPause.setText("Pause");
        } else {
            mEditTextInput.setVisibility(View.VISIBLE);
            mButtonSet.setVisibility(View.VISIBLE);
            mButtonStartPause.setText("Start");
            if (mTimerLeftInMillis < 1000) {
                mButtonStartPause.setVisibility(View.INVISIBLE);
            } else {
                mButtonStartPause.setVisibility(View.VISIBLE);
            }
            if (mTimerLeftInMillis < mStartTimeInMillis) {
                mButtonReset.setVisibility(View.VISIBLE);
            } else {
                mButtonReset.setVisibility(View.INVISIBLE);
            }
        }
    }







}