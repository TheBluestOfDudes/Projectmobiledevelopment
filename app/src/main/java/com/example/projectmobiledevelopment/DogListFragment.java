package com.example.projectmobiledevelopment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class DogListFragment extends Fragment {

    private MainActivity mainActivity;

    //buttons add them here
    private Button dogs;

    public DogListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dog_list, container, false);

        // get the activity to be used in the fragment if needed
        mainActivity = (MainActivity) getActivity();

        // here we will define buttons
        dogs = v.findViewById(R.id.btn_dogs);



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


        return v;
    }

}
