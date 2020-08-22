package com.example.hackathon2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;



public class Settings extends AppCompatActivity {
     SharedPref sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedpref = new SharedPref(this);
        if (sharedpref.mode() == 1){ setTheme(R.style.darkTheme);
            Log.d("mode",""+sharedpref.mode()+"Choice 1");}
        if (sharedpref.mode() == 2){ setTheme(R.style.liteTheme);
            Log.d("mode",""+sharedpref.mode()+"Choice 2");}
        setContentView(R.layout.activity_settings);

        if (sharedpref.mode() == 1){
            RelativeLayout root = findViewById(R.id.root);
            root.setBackgroundResource(R.drawable.background);
        }
        if (sharedpref.mode() == 2){
            RelativeLayout root = findViewById(R.id.root);
            root.setBackgroundResource(R.drawable.background2);
        }

        final Button lite = findViewById(R.id.lite);
        lite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedpref.changeMode(2);
                setTheme(R.style.liteTheme);
                restartApp();
            }
        });

        final Button dark = findViewById(R.id.dark);
        dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedpref.changeMode(1);
                setTheme(R.style.darkTheme);
                restartApp();
            }
        });

    }

    public void home(View view) {
        Intent intentHome = new Intent(this, MainActivity.class);
        startActivity(intentHome);
    }

    public void restartApp() {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }

}
