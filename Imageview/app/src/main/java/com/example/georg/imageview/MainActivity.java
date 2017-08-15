package com.example.georg.imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;
    RadioButton radioButton2,radioButton;
    Switch switch1;
    Button button;
    TextView textView5;
    boolean isCheckedS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        switch1 = (Switch) findViewById(R.id.switch1);
        textView5 = (TextView) findViewById(R.id.textView5);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkvalues();
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isCheckedS = isChecked;
            }
        });
    }
    public void checkvalues()
    {
        String result = "";
        if(checkBox.isChecked())
            result = "he is married ";
        else
            result = "he is not married";
        if(radioButton2.isChecked())
            result += "he is male";
        else
            result +="she is female";
        if(isCheckedS)
            result+="student is graduating";
        else
            result+="student is not graduating";

        textView5.setText(result);


    }

}
