package com.example.georg.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buta = (Button) findViewById(R.id.buta);
        buta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerta(v);
            }
        });
    }
    public void alerta(View view)
    {
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
        alertdialog.setMessage("Are you sure you want to delete?");
        alertdialog.setTitle("Confirm");
//        alertdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getApplicationContext(),"Data not deleted!",Toast.LENGTH_SHORT).show();
//            }
//        });
        alertdialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Data deleted!",Toast.LENGTH_SHORT).show();
                    }
                });

        alertdialog.show();
    }
}
