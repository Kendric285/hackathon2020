package com.example.hackathon2020;


import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    SharedPreferences mySharedPref;
    SharedPreferences.Editor editor;
    public SharedPref(Context context) {
        mySharedPref = context.getSharedPreferences("filename",Context.MODE_PRIVATE);
        editor = mySharedPref.edit();
    }

    public int mode() {
        return mySharedPref.getInt("MODE",0);
    }

    public void changeMode (int x) {
        int mode = x;
        editor.putInt("MODE",mode).commit();
        //Log.d("mode","MODE HAS BEEN CHANGED TO--"+x);
    }
}
