package com.example.george.phplogin;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buregister,bulogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bulogin = (Button) findViewById(R.id.bulogin);
        buregister = (Button) findViewById(R.id.buregister);
        bulogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert login method here
            }
        });
        buregister = (Button) findViewById(R.id.buregister);
        buregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert register method here
                registerfragment();
            }
        });
    }
    public void registerfragment()
    {
//        Fragment fragment = new FragmentName();
//        FragmentManager fragmentManager = ((Activity) context).getFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.fragment_main, fragment).commit();
//        Fragment fragment_register = new fragment_registeraccount();
//        FragmentManager fragmentManager = ((Activity)getApplicationContext()).getFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.activity_main)
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment_registeraccount hello = new fragment_registeraccount();
        fragmentTransaction.add(R.id.foofragment, hello, "");
        fragmentTransaction.commit();
    }
}
