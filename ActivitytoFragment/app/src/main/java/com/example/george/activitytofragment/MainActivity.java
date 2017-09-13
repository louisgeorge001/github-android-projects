package com.example.george.activitytofragment;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button bulogin,bureg;
    EditText txtuname,txtpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        bulogin = (Button) findViewById(R.id.bulogin);
//        bureg = (Button) findViewById(R.id.bureg);
//
//        txtuname = (EditText) findViewById(R.id.txtuname);
//        txtpass = (EditText) findViewById(R.id.txtpass);
//        bureg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                changetofrag();
//            }
//        });
    }

    public void changetofrag()
    {

    }
}
