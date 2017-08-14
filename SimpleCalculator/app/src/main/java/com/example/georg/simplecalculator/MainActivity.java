package com.example.georg.simplecalculator;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText3,editText4;
    TextView textView3;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        textView3 = (TextView) findViewById(R.id.textView3);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getsum();
            }
        });
    }
    public void getsum()
    {
        String num1 = editText3.getText().toString();
        String num2 = editText4.getText().toString();
        int num1_parse = Integer.parseInt(num1);
        int num2_parse = Integer.parseInt(num2);
        int ans = num1_parse+num2_parse;
        String ans_parse = Integer.toString(ans);
        textView3.setText(ans_parse);
    }

}
