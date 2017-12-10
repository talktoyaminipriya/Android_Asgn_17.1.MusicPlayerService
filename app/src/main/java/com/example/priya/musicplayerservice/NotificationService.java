package com.example.priya.musicplayerservice;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class NotificationService extends IntentService {
    private NotificationManager notificationManager;
 Context context;
    public static final String channelId = "4565";
    public NotificationService() {
        super("NotificationService");
    }

    @Override
    //Handler of messages
    public void onHandleIntent(Intent intent) {
        sendNotification("Music Charlie started!");
    }

    private void sendNotification(String msg) {

        Log.d("NotificationService", "Preparing to send notification...: " + msg);

        notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = new Notification.Builder(this)
                .setContentTitle("New Message")
                .setContentText("You've received new messages.")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setChannelId(channelId)
                .build();

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, MainActivity.class), 0);


        // Issue the notification.
        notificationManager.notify(1, notification);
        Log.d("Notification Service", "Notification sent.");
    }
}