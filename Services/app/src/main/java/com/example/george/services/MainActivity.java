package com.example.george.services;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bunotify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bunotify = (Button) findViewById(R.id.bunotify);

        bunotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifythis();
            }
        });
    }
    int notId=0;
    public void notifythis()
    {
//        NotificationCompat.Builder notificationCompat = new NotificationCompat.Builder(this);
//        notificationCompat.setContentTitle("Danger!")
//                .setContentText("It will run soon")
//                .setSmallIcon(R.drawable.games_icon);
//        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        manager.notify(notId,notificationCompat.build());
//        notId++;
        NewMessageNotification newMessageNotification = new NewMessageNotification();
        newMessageNotification.notify(this,"This is the beginning of our last dance",notId);
        notId++;
    }

}
