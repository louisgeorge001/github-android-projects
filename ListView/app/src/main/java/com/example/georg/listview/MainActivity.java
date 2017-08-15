package com.example.georg.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<AdapterItems>  listnewsData = new ArrayList<AdapterItems>();
    MyCustomAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.lvlist);

        listnewsData.add(new AdapterItems(1,"developer"," develop apps"));
        listnewsData.add(new AdapterItems(1,"tester"," develop apps"));
        listnewsData.add(new AdapterItems(1,"admin"," develop apps"));
        listnewsData.add(new AdapterItems(1,"developer"," develop apps"));
        listnewsData.add(new AdapterItems(1,"developer"," develop apps"));
        listnewsData.add(new AdapterItems(1,"developer"," develop apps"));
        listnewsData.add(new AdapterItems(1,"developer"," develop apps"));
        myadapter=new MyCustomAdapter(listnewsData);
        listView.setAdapter(myadapter);

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final AdapterItems s = listnewsData.get(position);
                TextView tvJob = (TextView) view.findViewById(R.id.textView_ID);
                Toast.makeText(getApplicationContext(),""+tvJob,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    private class MyCustomAdapter extends BaseAdapter {
        public ArrayList<AdapterItems> listnewsDataAdpater ;

        public MyCustomAdapter(ArrayList<AdapterItems>  listnewsDataAdpater) {
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
            //  (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.layoutticket, null);

            final   AdapterItems s = listnewsDataAdpater.get(position);

            TextView textView_ID=( TextView)myView.findViewById(R.id.textView_ID);
            textView_ID.setText("ID: "+s.ID);


            TextView textView3_Title=( TextView)myView.findViewById(R.id.textView3_Title);
            textView3_Title.setText(s.JobTitle);

            textView3_Title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),s.JobTitle,Toast.LENGTH_SHORT).show();
                }
            });

            TextView textView2_Desc=( TextView)myView.findViewById(R.id.textView2_Desc);
            textView2_Desc.setText(s.Description);


            return myView;
        }


    }
}
