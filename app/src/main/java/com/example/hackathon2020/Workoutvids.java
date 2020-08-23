package com.example.hackathon2020;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;



public class Workoutvids extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPref sharedpref = new SharedPref(this);
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
        setContentView(R.layout.activity_workoutvids);

        Button button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WebView webview;
                webview = findViewById(R.id.website);
                webview.loadUrl("https://www.youtube.com/watch?v=50kH47ZztHs");
                webview.setInitialScale(100);

                webview.getSettings().setLoadsImagesAutomatically(true);
                webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webview.getSettings().setPluginState(WebSettings.PluginState.ON);
                WebSettings webSettings = webview.getSettings();
                webview.setWebViewClient(new MyBrowser());
                webSettings.setJavaScriptEnabled(true);
                webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WebView webview;
                webview = findViewById(R.id.website);
                webview.loadUrl("https://www.youtube.com/watch?v=CBWQGb4LyAM");
                webview.setInitialScale(100);

                webview.getSettings().setLoadsImagesAutomatically(true);
                webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webview.getSettings().setPluginState(WebSettings.PluginState.ON);
                WebSettings webSettings = webview.getSettings();
                webview.setWebViewClient(new MyBrowser());
                webSettings.setJavaScriptEnabled(true);
                webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

            }
        });
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WebView webview;
                webview = findViewById(R.id.website);
                webview.loadUrl("https://greatist.com/move/best-free-workout-videos-youtube");
                webview.setInitialScale(100);

                webview.getSettings().setLoadsImagesAutomatically(true);
                webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webview.getSettings().setPluginState(WebSettings.PluginState.ON);
                WebSettings webSettings = webview.getSettings();
                webview.setWebViewClient(new MyBrowser());
                webSettings.setJavaScriptEnabled(true);
                webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

            }
        });
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WebView webview;
                webview = findViewById(R.id.website);
                webview.loadUrl("https://www.youtube.com/watch?v=gC_L9qAHVJ8");
                webview.setInitialScale(100);

                webview.getSettings().setLoadsImagesAutomatically(true);
                webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webview.getSettings().setPluginState(WebSettings.PluginState.ON);
                WebSettings webSettings = webview.getSettings();
                webview.setWebViewClient(new MyBrowser());
                webSettings.setJavaScriptEnabled(true);
                webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

            }
        });
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WebView webview;
                webview = findViewById(R.id.website);
                webview.loadUrl("https://www.youtube.com/watch?v=UItWltVZZmE");
                webview.setInitialScale(100);

                webview.getSettings().setLoadsImagesAutomatically(true);
                webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webview.getSettings().setPluginState(WebSettings.PluginState.ON);
                WebSettings webSettings = webview.getSettings();
                webview.setWebViewClient(new MyBrowser());
                webSettings.setJavaScriptEnabled(true);
                webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

            }
        });
        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WebView webview;
                webview = findViewById(R.id.website);
                webview.loadUrl("https://www.youtube.com/watch?v=1fbU_MkV7NE");
                webview.setInitialScale(100);

                webview.getSettings().setLoadsImagesAutomatically(true);
                webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webview.getSettings().setPluginState(WebSettings.PluginState.ON);
                WebSettings webSettings = webview.getSettings();
                webview.setWebViewClient(new MyBrowser());
                webSettings.setJavaScriptEnabled(true);
                webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

            }
        });
        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WebView webview;
                webview = findViewById(R.id.website);
                webview.loadUrl("https://www.youtube.com/watch?v=aclHkVaku9U");
                webview.setInitialScale(100);

                webview.getSettings().setLoadsImagesAutomatically(true);
                webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webview.getSettings().setPluginState(WebSettings.PluginState.ON);
                WebSettings webSettings = webview.getSettings();
                webview.setWebViewClient(new MyBrowser());
                webSettings.setJavaScriptEnabled(true);
                webSettings.setJavaScriptCanOpenWindowsAutomatically(true);


            }
        });
        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WebView webview;
                webview = findViewById(R.id.website);
                webview.loadUrl("https://www.youtube.com/watch?v=lpgWK7wYMU4");
                webview.setInitialScale(100);

                webview.getSettings().setLoadsImagesAutomatically(true);
                webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webview.getSettings().setPluginState(WebSettings.PluginState.ON);
                WebSettings webSettings = webview.getSettings();
                webview.setWebViewClient(new MyBrowser());
                webSettings.setJavaScriptEnabled(true);
                webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

            }
        });

    }

    public void settings(View view) {
        Intent intentSettings = new Intent(this, Settings.class);
        startActivity(intentSettings);
    }

    public void home(View view) {
        Intent intentHome = new Intent(this, MainActivity.class);
        startActivity(intentHome);
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            view.addJavascriptInterface(new Object() {
                @JavascriptInterface
                public void performClick() throws Exception {
                    Log.d("LOGIN::", "Clicked");
                }
            }, "login");
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub

            System.out.println("started");

            super.onPageStarted(view, url, favicon);

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub

            System.out.println("ends");
            super.onPageFinished(view, url);

        }

    }

    @Override
    public void onBackPressed() {
        WebView webview;
        webview = findViewById(R.id.website);
        if (webview.canGoBack()){
            webview.goBack();
        }else{finish();}
    }

}