package com.example.georg.spinneranddialog;

import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
       final List<String> arr = new ArrayList<String>();
        final TextView txthel = (TextView) findViewById(R.id.txthel);
        arr.add("admin");
        arr.add("programmers");
        arr.add("developers");
        arr.add("tester");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,arr);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),arr.get(position),Toast.LENGTH_SHORT).show();
                txthel.setText(arr.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickshow();
            }
        });

        Button button3 = (Button) findViewById(R.id.buttonalert);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showalertdiag(v);
              //  Toast.makeText(getApplicationContext(),"clicked!",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showalertdiag(View view)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Are you sure you want to delete?")
                .setTitle("Confirm")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
    }
    public void settime(String time)
    {
        Toast.makeText(getApplicationContext(),time,Toast.LENGTH_SHORT).show();
    }
    public void clickshow()
    {
        android.app.FragmentManager fm = getFragmentManager();
        poptime_fragment popfrag = new poptime_fragment();
        popfrag.show(fm,"Show Fragment");
    }
}
