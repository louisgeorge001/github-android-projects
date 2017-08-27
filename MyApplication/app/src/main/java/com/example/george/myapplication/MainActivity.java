package com.example.george.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtuname,txtpass;
    Button btnreg,btnlogin,btnload;
    dbmanager Dbmanager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dbmanager = new dbmanager(this);
        txtuname = (EditText) findViewById(R.id.txtuname);
        txtpass = (EditText) findViewById(R.id.txtpass);
        btnreg = (Button) findViewById(R.id.btnreg);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertreg();
            }
        });
        btnload = (Button) findViewById(R.id.btnload);
        btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loaddata();
            }
        });
    }
    public void insertreg()
    {
        ContentValues values = new ContentValues();
        values.put(dbmanager.user_name,txtuname.getText().toString());
        values.put(dbmanager.user_password,txtpass.getText().toString());
        long id = Dbmanager.insertdata(values);
        if(id>0)
            Toast.makeText(getApplicationContext(),"User ID: "+id,Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),"Query failed!",Toast.LENGTH_SHORT).show();
    }
    public void loaddata()
    {
        //String[] projections = {"user_name","user_password"};
        Cursor cursor = Dbmanager.query(null,null,null,Dbmanager.user_name);
        if(cursor.moveToFirst())
        {
            String tabledata = "";
            do{
                tabledata+="Username: "+cursor.getString(cursor.getColumnIndex(Dbmanager.user_name))+" Password: "+cursor.getString(cursor.getColumnIndex(Dbmanager.user_password))+" | ";
            }while(cursor.moveToNext());
            Toast.makeText(getApplicationContext(),tabledata,Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"No data!",Toast.LENGTH_SHORT).show();
        }

    }

}
