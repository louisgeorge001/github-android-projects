package com.example.george.phplogin;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button buregister,bulogin;
    EditText txtuname,txtpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtuname = (EditText) findViewById(R.id.txtuname);
        txtpass = (EditText) findViewById(R.id.txtpass);
        bulogin = (Button) findViewById(R.id.bulogin);
        buregister = (Button) findViewById(R.id.buregister);
        bulogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        buregister = (Button) findViewById(R.id.buregister);
        buregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //insert register method here
               // registerfragment();
                reg();
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
    public void reg()
    {

        String url = "http://10.0.2.2/php_android/login.php?username="+txtuname.getText().toString()+"&password="+txtpass.getText().toString()+"";
       // Log.d("error:",url);
        new MyAsyncTaskgetNews().execute(url);
    }
    public void login()
    {
        String url = "http://10.0.2.2/php_android/login_reg.php?username="+txtuname.getText().toString()+"&password="+txtpass.getText().toString()+"";
       // Log.d("error:",url);
        new MyAsyncTaskgetNews().execute(url);
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
                Toast.makeText(getApplicationContext(),jsonObject.getString("msg"),Toast.LENGTH_LONG).show();

            } catch (Exception ex) {
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
