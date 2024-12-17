package com.example.lab4_java;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Context;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab4_java.R;

public class MyPushNotification {
    private static String CHANNEL_ID="Base channel";
    private static String CHANNEL_DESCRIPTION="it's a base channel";
    private static final int NOTIFY_ID=123;
    private NotificationManager notificationManager;
    private Context context;

    public MyPushNotification(Context context,NotificationManager manager){
        notificationManager=manager;
        this.context=context;
        createNotificationChannel();
    }

    public void sendNotify(String title,String text){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(R.drawable.day);
        notificationManager.notify(NOTIFY_ID,builder.build());
    }

    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            int importance= NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID,CHANNEL_ID,importance);
            channel.setDescription(CHANNEL_DESCRIPTION);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
