package gcanadas.com.myplanner.notifications;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import gcanadas.com.myplanner.R;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by gerard on 5/4/17.
 */

public class NotificationProvider {
    private static NotificationProvider instance;
    public static NotificationProvider getInstance() {
        if (instance == null)
            instance = new NotificationProvider();
        return instance;
    }

    protected NotificationProvider() {

    }

    public void showNotification(Context src, Class destinationActivity, String title, String message) {
        Intent resultIntent = new Intent(src, destinationActivity);
        // Because clicking the notification opens a new ("special") activity, there's
        // no need to create an artificial back stack.
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        src,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(src)
                        .setSmallIcon(R.drawable.ic_menu_manage)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setContentIntent(resultPendingIntent)
                        .setAutoCancel(true);

        // Sets an ID for the notification
        int mNotificationId = 001;
        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) src.getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());

    }
}
