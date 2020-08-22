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
    private EditText mEditTextInputWork;
    private EditText mEditTextInputRest;
    private EditText mEditTextInputCycles;
    private TextView countdown_task;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;

    private long mStartTimeWork;
    private int mStartTimeCycles;
    private long mStartTimeRest;
    private long mTimerLeftInMillis = mStartTimeWork;


    long millisInputWork;
    long millisInputRest;
    long workTime;

    Boolean isWorking;

    Integer inputCyclesNum;
    int cyclesNum;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_timer);

        mEditTextInputWork = findViewById(R.id.edit_text_work);
        mEditTextInputCycles = findViewById(R.id.edit_text_cycles);
        mEditTextInputRest = findViewById(R.id.edit_text_rest);


        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        countdown_task = findViewById(R.id.countdown_task);

        mButtonSet = findViewById(R.id.button_timer_set);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);

        isWorking = true;


        mButtonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputWork = mEditTextInputWork.getText().toString();
                String inputRest = mEditTextInputRest.getText().toString();
                String inputCycles = mEditTextInputCycles.getText().toString();
                if (inputWork.length() == 0 || inputRest.length() == 0 || inputCycles.length() == 0){
                    Toast.makeText(WorkoutTimer.this, "Field can't be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                long millisInputWork = Long.parseLong(inputWork) * 1000;
                long millisInputRest = Long.parseLong(inputRest) * 1000;
                inputCyclesNum = Integer.parseInt(inputCycles);
                cyclesNum = inputCyclesNum;

                if(millisInputWork == 0){
                    Toast.makeText(WorkoutTimer.this, "Please enter a positive number", Toast.LENGTH_SHORT).show();
                    return;
                }

                setTime(millisInputWork);
                workTime = millisInputWork+500;
                mEditTextInputWork.setText("");
                mEditTextInputCycles.setText("");
                mEditTextInputRest.setText("");
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
                inputCyclesNum = cyclesNum;
                resetTimer();
                setTime(workTime);

            }
        });

        updateCountDownText();



    }
    private void setTime(long milliseconds){
        mStartTimeWork = milliseconds;
        resetTimer();
        startTimer();


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

                inputCyclesNum = inputCyclesNum-1;
                if (inputCyclesNum > 0) {
                    setTime(workTime);
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
    public void resetTimer(){
        mTimerLeftInMillis = mStartTimeWork;
        updateCountDownText();
        updateWatchInterface();



    }
    public void pauseTimer(){
        mCountDownTimer.cancel();
        mTimerRunning = false;
        updateWatchInterface();



    }
    public void updateCountDownText(){
        int minutes = (int) mTimerLeftInMillis / 60000;
        int seconds = (int) mTimerLeftInMillis  / 1000;

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
            mButtonStartPause.setText("Pause");
        } else {
            mEditTextInputWork.setVisibility(View.VISIBLE);
            mEditTextInputRest.setVisibility(View.VISIBLE);
            mEditTextInputCycles.setVisibility(View.VISIBLE);
            mButtonSet.setVisibility(View.VISIBLE);
            mButtonStartPause.setText("Start");
            if (mTimerLeftInMillis < 1000) {
                mButtonStartPause.setVisibility(View.INVISIBLE);
            } else {
                mButtonStartPause.setVisibility(View.VISIBLE);
            }
            if (mTimerLeftInMillis < mStartTimeWork) {
                mButtonReset.setVisibility(View.VISIBLE);
            } else {
                mButtonReset.setVisibility(View.INVISIBLE);
            }
        }
    }







}