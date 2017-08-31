package com.example.george.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

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
    void LoadElement()
    {
        loaddata();
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
    ArrayList<Adapterclass> listnewsData = new ArrayList<Adapterclass>();
    MyCustomAdapter myadapter;
     void loaddata()
    {


        //add data and view it



        //String[] projections = {"user_name","user_password"};
        listnewsData.clear();
        Cursor cursor = Dbmanager.query(null,null,null,Dbmanager.user_name);
        if(cursor.moveToFirst())
        {
            String tabledata = "";
            do{
                //tabledata+="Username: "+cursor.getString(cursor.getColumnIndex(Dbmanager.user_name))+" Password: "+cursor.getString(cursor.getColumnIndex(Dbmanager.user_password))+" | ";
                listnewsData.add(new Adapterclass(cursor.getString(cursor.getColumnIndex(Dbmanager.colid)),cursor.getString(cursor.getColumnIndex(Dbmanager.user_name)),cursor.getString(cursor.getColumnIndex(Dbmanager.user_password))));
            } while(cursor.moveToNext());
            Toast.makeText(getApplicationContext(),tabledata,Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"No data!",Toast.LENGTH_SHORT).show();
        }

        //listnewsData.add(new Adapterclass(1,"developer"," develop apps"));




//update  data in listview
        //listnewsData.add(new Adapterclass(2,"tester"," test apps"));


        myadapter=new MyCustomAdapter(listnewsData);
        myadapter.notifyDataSetChanged();
        ListView lsNews=(ListView)findViewById(R.id.lvdata);
        lsNews.setAdapter(myadapter);//intisal with data
        txtuname.setText("");
        txtpass.setText("");

    }

    private class MyCustomAdapter extends BaseAdapter {
        public ArrayList<Adapterclass> listnewsDataAdpater ;

        public MyCustomAdapter(ArrayList<Adapterclass>  listnewsDataAdpater) {
            this.listnewsDataAdpater=listnewsDataAdpater;
        }


        @Override
        public int getCount() {
            return listnewsDataAdpater.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.layout_ticket, null);

            final Adapterclass s = listnewsDataAdpater.get(position);

            TextView txtJobTitle=( TextView)myView.findViewById(R.id.tv_uname);
            txtJobTitle.setText(s.username);

            TextView txtJobTitle1=( TextView)myView.findViewById(R.id.tv_id);
            txtJobTitle1.setText(s.ID);

            TextView txtJobTitle2=( TextView)myView.findViewById(R.id.tv_pass);
            txtJobTitle2.setText(s.password);

           Button btnDel = (Button) myView.findViewById(R.id.btnDelete);
            btnDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String[] SelectionArgs={s.username};
                    int count = Dbmanager.delete("user_name=?",SelectionArgs);
                    if(count>0)
                    {
                        loaddata();
                    }
                    else
                    {
                        loaddata();
                    }
                }
            });

            return myView;
        }



    }


}
