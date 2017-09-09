package com.example.george.seekbarandthread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    int Maxcounter = 100;
    Button bustart,bustop;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(100);
        bustart = (Button) findViewById(R.id.bustart);
        bustart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startthread();
            }
        });
        bustop = (Button) findViewById(R.id.bustop);
        bustop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopthread();
            }
        });
        textView = (TextView) findViewById(R.id.textView);

    }


    Boolean isRunning = false;
    int counterup = 0;
    public void startthread()
    {
        isRunning=true;
        //counterup=0;
        myThread t = new myThread();
        t.start();
        counterup=0;
    }
    public void stopthread()
    {
        isRunning=false;
        counterup=0;
    }
    class myThread extends Thread
    {
        @Override
        public void run()
        {
            while(isRunning)
            {
                if(counterup<=Maxcounter)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            seekBar.setProgress(counterup);
                            textView.setText(Integer.toString(counterup));
                        }
                    });
                    counterup=counterup+1;
                    try
                    {
                        Thread.sleep(10);
                        //bustop.setText("Reset");
                    } catch (InterruptedException er)
                    {
                        er.printStackTrace();
                       // bustop.setText("Reset");
                    }

                }


            }

        }

    }
}
