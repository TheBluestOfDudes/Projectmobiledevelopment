package com.example.projectmobiledevelopment.Fragments;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.projectmobiledevelopment.Classes.DogObject;
import com.example.projectmobiledevelopment.Database.DatabaseWrapper;
import com.example.projectmobiledevelopment.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public FragmentManager fragmentManager;
    public DatabaseWrapper db;
    public List<String> todolist;

    private final String CHANNEL_ID = "LODDD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context c = this;

        //

        fragmentManager = getSupportFragmentManager();
        db = new DatabaseWrapper(c, "Database");

        // first boot up of app
        if (savedInstanceState == null) {

            //here we will place a fragment
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, new HomeFragment(), null)
                    .commit();
        }

        makeTestDogs();
    }

    private void makeTestDogs(){
        db.deleteAllDogs();
        for(int i = 0; i < 5; i++){
            Log.d("dogs", "makeTestDogs: " + i);
            DogObject d = new DogObject("Dog" + i, 3, "poodle", "Owner" + i, "123", "Owner" + 1 + "@mail.com", false, "Something");
            db.insertToDogs(d);
            DogObject nD = (db.GetDogsFromName("Dog" + i)).get(0);
            Log.d("Dogs", nD.dogName());
            Log.d("Dogs", nD.name());
        }
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "g";
            String description = "g";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
