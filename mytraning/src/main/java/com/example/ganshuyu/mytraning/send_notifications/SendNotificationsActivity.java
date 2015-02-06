package com.example.ganshuyu.mytraning.send_notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.ganshuyu.mytraning.R;

public class SendNotificationsActivity extends Activity {
    //private final String TAG = "SendNotificationsActivity";
    private int mId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_send_notifications);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_send_notifications, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendButtonClick (View view){
        NotificationCompat.Builder mBuilder;
        mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("My notification")
                .setContentText("Hello World! " + mId);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(mId++, mBuilder.build());
    }

    public void sendBigContentViewButtonClick (View view){
        final String someLongText = "fkdljfdldkfj;ldaksjfkladj;flja;lkjdfljadslfjaddfdsfafjdfad" +
                "fdl;akjf;lkdf;lkaj;flkjda;lkfjadljflk;adsjfladjflk;dfjlkdjflakdfjdaffjdlfjdjjj" +
                "adjflkjadlkfjad;lkfjad;sljf;ladkjajlkfjad;lksfjl;akdjf;lkdsajf;lkdjfkadj;flkad" +
                "jf;lkadjfkldas;lkfja;dljf;lkdasjf;lkadjs;lfjas;ldkfj;lkadsjfl;kadljfl;kasdjf;l" +
                "jdlskfjklda;fjadslkfj;sdalkfj;ladjf;lajdl;fkajld;kfjlajfl;adjfl;kajdl;fjadl;kfj;";

        final Notification.Builder builder = new Notification.Builder(this);
        builder.setStyle((new Notification.BigTextStyle(builder).bigText(someLongText))
                .setBigContentTitle("Big title")
                .setSummaryText("Big summary"))
                .setContentTitle("Title")
                .setContentText("Summary")
                .setSmallIcon(android.R.drawable.sym_def_app_icon);

        final NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(mId++, builder.build());
    }

    public static class mReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            NotificationCompat.Builder mBuilder;
            mBuilder = new NotificationCompat.Builder(context)
                    .setSmallIcon(R.drawable.notification_icon)
                    .setContentTitle("My notification")
                    .setPriority(2)
                    .setContentText("Hello World! Pri ");

            NotificationManager mNotificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(1000, mBuilder.build());
        }
    }
}
