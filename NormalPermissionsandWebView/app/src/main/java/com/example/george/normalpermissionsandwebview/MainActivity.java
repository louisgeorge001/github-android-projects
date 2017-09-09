package com.example.george.normalpermissionsandwebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv1 = (WebView) findViewById(R.id.wv1);
        wv1.loadUrl("https://github.com/louisgeorge001/github-android-projects");
    }
}
