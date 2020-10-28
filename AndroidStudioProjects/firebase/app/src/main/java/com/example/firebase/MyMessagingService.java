package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyMessagingService  extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        //ISSE NOTIFICATION GENERATE KRENGE
        showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
        
    }
//TITLE OR MSG JO FIREBASE K THROUGH BHEJA HAI
    private void showNotification(String title, String message) {

        //NotificationCompat.Builder== NOTIFICATION BUILD KREGA
        //CHANNNEL ID ==CHANNEL MAI BATENGE

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"MyNotifications")
        .setContentTitle(title)
         .setSmallIcon(R.drawable.common_google_signin_btn_text_light_normal_background)
                .setAutoCancel(true)
                .setContentText(message);

        NotificationManagerCompat manager=NotificationManagerCompat.from(this);
        manager.notify(999,builder.build());
        //manager.notify===NOTIFICATION GENERATE KRENGE
    }
}
