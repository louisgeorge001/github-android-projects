package com.example.george.json;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText editText,editText2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String JSONfromURL = "{" +
                "\t\"info\":\n" +
                "\t{\n" +
                "\t\t\"name\":\"George\",\n" +
                "\t\t\"age\":20\n" +
                "\t},\n" +
                "\t\"jobs\":\n" +
                "\t{\n" +
                "\t\t\"jobtitle\":\"Web Developer\",\n" +
                "\t\t\"joblocation\":\"Makati City\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\":2,\n" +
                "\t\t\"title\":\"tester\",\n" +
                "\t\t\"desc\":\"building apps\",\n" +
                "\t}\n" +
                "}";
        try {
            JSONObject jsonObject = new JSONObject(JSONfromURL);
            JSONObject info = jsonObject.getJSONObject("info");
            String name = info.getString("name");
            int age = info.getInt("age");
            JSONArray jsonArray = jsonObject.getJSONArray("jobs");
            for(int i = 0; i<jsonArray.length();i++)
            {
                JSONObject singlejob = jsonArray.getJSONObject(i);
                String title=singlejob.getString("jobtitle");
                String location=singlejob.getString("joblocation");
                int id=singlejob.getInt("id");
            }

        }catch (Exception e)
        {

        }
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getdata();
            }
        });
    }
    public void getdata()
    {
        String url="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places" +
                "(1)%20where%20text%3D%22"+ editText.getText().toString() +"%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        new MyAsyncTaskgetNews().execute(url, "news");
    }
    public class MyAsyncTaskgetNews extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            //before works
        }
        @Override
        protected String  doInBackground(String... params) {
            // TODO Auto-generated method stub
            try {
                String NewsData;
                //define the url we have to connect with
                URL url = new URL(params[0]);
                //make connect with url and send request
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                //waiting for 7000ms for response
                urlConnection.setConnectTimeout(7000);//set timeout to 5 seconds

                try {
                    //getting the response data
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    //convert the stream to string
                    NewsData = ConvertInputToStringNoChange(in);
                    //send to display data
                    publishProgress(NewsData);
                } finally {
                    //end connection
                    urlConnection.disconnect();
                }

            }catch (Exception ex){}
            return null;
        }
        protected void onProgressUpdate(String... progress) {

            try {
                //display response data
                JSONObject jsonObject = new JSONObject(progress[0]);
                JSONObject query = jsonObject.getJSONObject("query");
                JSONObject results = query.getJSONObject("results");
                JSONObject channel = results.getJSONObject("channel");
                JSONObject astronomy = channel.getJSONObject("astronomy");
                String sunset  = astronomy.getString("sunset");
                String sunrise = astronomy.getString("sunrise");

                Toast.makeText(getApplicationContext(),"Sunrise: "+sunrise+" Sunset: "+sunset,Toast.LENGTH_LONG).show();
                editText2.setText("Sunrise: "+sunrise+" Sunset: "+sunset);
               // Log.d("message:",progress[0]);

            } catch (Exception ex) {
                Toast.makeText(getApplicationContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
            }


        }
        protected void onPostExecute(String  result2){


        }
    }
    // this method convert any stream to string
    public static String ConvertInputToStringNoChange(InputStream inputStream) {

        BufferedReader bureader=new BufferedReader( new InputStreamReader(inputStream));
        String line ;
        String linereultcal="";

        try{
            while((line=bureader.readLine())!=null) {

                linereultcal+=line;

            }
            inputStream.close();


        }catch (Exception ex){}

        return linereultcal;
    }
}
