package com.app.master.petagramsocial.Presentador;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.app.master.petagramsocial.MainActivity;
import com.app.master.petagramsocial.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Rafael p on 25/6/2017.
 */

public class NotificacionToken extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intent intent=new Intent(this, MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_ONE_SHOT);
        Uri timbre= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder ConstruyendoNotificacion=new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.hueso)
                .setContentTitle(remoteMessage.getNotification().getTitle())
                .setContentText(remoteMessage.getNotification().getBody())
                .setSound(timbre)
                .setContentIntent(pendingIntent);
        NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }
}
