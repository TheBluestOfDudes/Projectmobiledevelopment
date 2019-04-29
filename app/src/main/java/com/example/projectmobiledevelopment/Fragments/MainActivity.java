package com.example.projectmobiledevelopment.Fragments;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.os.Build;

import com.example.projectmobiledevelopment.Classes.DogObject;
import com.example.projectmobiledevelopment.Database.DatabaseWrapper;
import com.example.projectmobiledevelopment.R;
import com.example.projectmobiledevelopment.Utils.BitmapConverter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public FragmentManager fragmentManager;
    public DatabaseWrapper db;
    public List<String> todolist;

    public static final int REQUEST_IMAGE_CAPTURE = 1;
    public static boolean hasCamera;

    public Uri imageUri;
    private final String CHANNEL_ID = "LODDD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context c = this;
        imageUri = null;

        PackageManager pm = c.getPackageManager();
        if(pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)){
            hasCamera = true;
        }
        else{
            hasCamera = false;
        }

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
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.dogtxt);
        for(int i = 0; i < 5; i++){
            Log.d("dogs", "makeTestDogs: " + i);
            DogObject d = new DogObject("Dog" + i, 3, "poodle", "Owner" + i, "123", "Owner" + 1 + "@mail.com", false, "Something", BitmapConverter.toBytes(b));
            db.insertToDogs(d);
            DogObject nD = (db.GetDogsFromName("Dog" + i)).get(0);
            Log.d("Dogs", nD.dogName());
            Log.d("Dogs", nD.name());
        }
    }

    public void dispatchTakePictureIntent(){
        Intent picture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(picture.resolveActivity(getPackageManager()) != null){
            startActivityForResult(picture, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle dogInfo = RegisterDogFragment.dogInfo;
            Bundle extras = data.getExtras();
            Bitmap image = (Bitmap)extras.get("data");
            DogObject newDog = new DogObject(dogInfo.getString("dName"),
                    dogInfo.getInt("dAge"),
                    dogInfo.getString("dRace"),
                    dogInfo.getString("oName"),
                    dogInfo.getString("oNumber"),
                    dogInfo.getString("oEpost"),
                    dogInfo.getBoolean("picture"),
                    dogInfo.getString("special"),
                    BitmapConverter.toBytes(image));
            db.insertToDogs(newDog);
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
