package com.example.georg.sharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtuname,txtpword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnsave = (Button) findViewById(R.id.btnsave);
        txtuname  = (TextView) findViewById(R.id.txtuname);
        txtpword = (TextView) findViewById(R.id.txtpword);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                busave();
            }
        });
        Button btnLoad = (Button) findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buload();
            }
        });
    }
    public void busave()
    {
        SharedRef sharedRef = new SharedRef(this);
        sharedRef.saveData(txtuname.getText().toString(),txtpword.getText().toString());
        Toast.makeText(getApplicationContext(),"Information Saved!",Toast.LENGTH_SHORT).show();
    }
    public void buload()
    {
        SharedRef sharedRef = new SharedRef(this);
        String Data = sharedRef.loadData();
        Toast.makeText(getApplicationContext(),Data,Toast.LENGTH_SHORT).show();
    }
}
