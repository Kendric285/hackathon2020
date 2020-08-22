package com.example.hackathon2020;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

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

/**    public void lite(View view) {
        try {
            String filepath = "setting_main.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            Node company = doc.getFirstChild();

            Node staff = doc.getElementById("hi");

            NamedNodeMap attr = staff.getAttributes();
            Node nodeAttr = attr.getNamedItem("id");
            nodeAttr.setTextContent("2");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }**/

    /** public void parseXML() {
        XmlPullParserFactory parserFactory;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = getAssets().open("setting_main.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);

            processParsing(parser);


        } catch (XmlPullParserException e) {

        } catch (IOException e) {

        }
    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException{


    }   **/
}
