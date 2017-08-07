package com.example.georg.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void buClick(View view)
    {
        Button buSelected = (Button) view;
        buSelected.setBackgroundColor(Color.RED);
        int CellID = 0;

        switch ((buSelected.getId()))
        {
            case R.id.bu1:
                CellID=1;
                break;
            case R.id.bu2:
                CellID=2;
                break;
            case R.id.bu3:
                CellID=3;
                break;
            case R.id.bu4:
                CellID=4;
                break;
            case R.id.bu5:
                CellID=5;
                break;
            case R.id.bu6:
                CellID=6;
                break;
            case R.id.bu7:
                CellID=7;
                break;
            case R.id.bu8:
                CellID=8;
                break;
            case R.id.bu9:
                CellID=9;
                break;
        }
        Playgame(CellID,buSelected);
    }
   // boolean activePlayer = true;
    int activePlayer = 1;
    ArrayList<Integer>Player1 = new ArrayList<Integer>();
    ArrayList<Integer>Player2 = new ArrayList<Integer>();
    void Playgame(int CellID, Button button)
    {
        button.setBackgroundColor(Color.RED);
        Log.d("Player:",String.valueOf(CellID));
        Log.d("Button:",button.getText().toString());
        if(activePlayer==1)
        {
            button.setBackgroundColor(Color.BLUE);
            button.setText("X");
            Player1.add(CellID);
            activePlayer =2;
            button.setEnabled(false);
        }
        else if(activePlayer==2)
        {
            button.setBackgroundColor(Color.GREEN);
            button.setText("O");
            Player2.add(CellID);
            activePlayer=1;
            button.setEnabled(false);
        }
        checkwinner();
    }
    void checkwinner()
    {
        int winner = -1;
        if(Player1.contains(1)&&Player1.contains(2)&&Player1.contains(3))
        {
        winner = 1;
        }
        if(Player1.contains(4)&&Player1.contains(5)&&Player1.contains(6))
        {
            winner = 1;
        }
        if(Player1.contains(7)&&Player1.contains(8)&&Player1.contains(9))
        {
            winner = 1;
        }

        if(Player2.contains(1)&&Player2.contains(2)&&Player2.contains(3))
        {
            winner = 2;
        }
        if(Player2.contains(4)&&Player2.contains(5)&&Player2.contains(6))
        {
            winner = 2;
        }
        if(Player2.contains(7)&&Player2.contains(8)&&Player2.contains(9))
        {
            winner = 2;
        }

        if(Player1.contains(1)&&Player1.contains(4)&&Player1.contains(7))
        {
            winner = 1;
        }
        if(Player1.contains(2)&&Player1.contains(5)&&Player1.contains(8))
        {
            winner = 1;
        }
        if(Player1.contains(3)&&Player1.contains(6)&&Player1.contains(9))
        {
            winner = 1;
        }

        if(Player2.contains(1)&&Player2.contains(4)&&Player2.contains(7))
        {
            winner = 2;
        }
        if(Player2.contains(2)&&Player2.contains(5)&&Player2.contains(8))
        {
            winner = 2;
        }
        if(Player2.contains(3)&&Player2.contains(6)&&Player2.contains(9))
        {
            winner = 2;
        }

        if(winner!=-1)
        {
            if(winner==1)
            {
                Toast.makeText(getApplicationContext(),"Player 1 is the winner",Toast.LENGTH_LONG).show();
                AutoPlay();
            }
            else if(winner==2)
            {
                Toast.makeText(getApplicationContext(),"Player 2 is the winner",Toast.LENGTH_LONG).show();
            }
        }



    }
    void AutoPlay()
    {
        ArrayList<Integer> EmptyCells = new ArrayList();//all not selected cellsr
        for(int i = 1; i<10;i++)
        {
            if(!(Player1.contains(1) || Player2.contains(1)))
            {
                EmptyCells.add(i);
            }
        }
        Random r = new Random();
        int RandIndex = r.nextInt(EmptyCells.size()-0)+0;
        int CellID = EmptyCells.get(RandIndex);
        Button buSelected;
      //  Rand
        switch (CellID)
        {
            case 1:
               // CellID=1;
                buSelected = (Button) findViewById(R.id.bu1);
                break;
            case 2:
                buSelected = (Button) findViewById(R.id.bu2);
                break;
            case 3:
                buSelected = (Button) findViewById(R.id.bu2);
                break;
            case 4:
                buSelected = (Button) findViewById(R.id.bu2);
                break;
            case 5:
                buSelected = (Button) findViewById(R.id.bu2);
                break;
            case 6:
                buSelected = (Button) findViewById(R.id.bu2);
                break;
            case 7:
                buSelected = (Button) findViewById(R.id.bu2);
                break;
            case 8:
                buSelected = (Button) findViewById(R.id.bu2);
                break;
            case 9:
                buSelected = (Button) findViewById(R.id.bu2);
                break;
            default:
                buSelected = (Button) findViewById(R.id.bu1);
                break;
        }
        Playgame(CellID,buSelected);
    }

}
