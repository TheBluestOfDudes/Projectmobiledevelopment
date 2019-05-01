package com.example.projectmobiledevelopment.BaseApplication;

import android.annotation.TargetApi;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.SystemClock;

import com.example.projectmobiledevelopment.Database.Database;
import com.example.projectmobiledevelopment.Database.DatabaseWrapper;
import com.example.projectmobiledevelopment.Database.dates;

import java.util.Calendar;
import java.util.List;


public class app extends Application {

    public static final String CHANNEL_1_ID = "channel1";
    private DatabaseWrapper db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = new DatabaseWrapper(this, "Database");
        createNotificationChannels();
        checkDBForOldDates();

    }
    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This channel is used to notify the user when a notification are made");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }


    }

    // doesnt check for all dates, or times but over time will be deleted
    private void checkDBForOldDates() {
        Calendar calendar = Calendar.getInstance();
        List<dates> list = db.getDates();
        for (dates date : list) {
            if(date.getYear() < calendar.get(Calendar.YEAR)) {
                db.deleteDate(date.getYear(), date.getMonth(), date.getDay());
            } else if (date.getMonth() < calendar.get(Calendar.MONTH)) {
                db.deleteDate(date.getYear(), date.getMonth(), date.getDay());
            } else if (date.getMonth() == calendar.get(Calendar.MONTH) && date.getDay() < calendar.get(Calendar.DAY_OF_MONTH)){
                db.deleteDate(date.getYear(), date.getMonth(), date.getDay());
            }
        }
    }
}
