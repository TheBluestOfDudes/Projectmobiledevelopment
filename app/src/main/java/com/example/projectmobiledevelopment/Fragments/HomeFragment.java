package com.example.projectmobiledevelopment.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.projectmobiledevelopment.Fragments.Calender.CalenderFragment;
import com.example.projectmobiledevelopment.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private MainActivity mainActivity;
    private Button dogs;
    private Button insertDog;
    private Button btnCalendar;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        // gets fragmentactivity and cast it to mainactivity
        mainActivity = (MainActivity) getActivity();

        // here we will define buttons
        dogs = v.findViewById(R.id.btn_dogs);
        insertDog = v.findViewById(R.id.btn_insertDog);
        btnCalendar = v.findViewById(R.id.btn_calendar);


        //dogs button onclicklistener
        dogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // here is how we replace a fragment and add it to backstack
                // so when back button pressed it will go to last fragment instead
                // of quit the app
                FragmentTransaction fragmentTransaction = mainActivity.fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new DogListFragment(), null)
                        .addToBackStack(null)
                        .commit();
            }
        });

        // add a dog to the db button
        insertDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = mainActivity.fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new RegisterDogFragment(), null)
                        .addToBackStack(null)
                        .commit();
            }
        });

        // gets the calendar fragment
        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = mainActivity.fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new CalenderFragment(), null)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;
    }

}
