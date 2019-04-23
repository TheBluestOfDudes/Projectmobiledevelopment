package com.example.projectmobiledevelopment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //

        // first boot up of app
        if (savedInstanceState == null) {

            //here we will place a fragment
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, new HomeFragment(), null)
                    .commit();
        }
    }
}
