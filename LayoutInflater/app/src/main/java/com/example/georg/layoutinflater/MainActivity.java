package com.example.georg.layoutinflater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buShow();
            }
        });
    }
    public void buShow()
    {
        LayoutInflater mylayoutinflater = getLayoutInflater();
        View view = mylayoutinflater.inflate(R.layout.showlayout,null);
        EditText et = (EditText) view.findViewById(R.id.uname);
        et.setText("Yeah");
        Toast toast = new Toast (getApplicationContext());
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.show();
    }
}
