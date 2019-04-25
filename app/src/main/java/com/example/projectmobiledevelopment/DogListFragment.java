package com.example.projectmobiledevelopment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.projectmobiledevelopment.Classes.DogObject;
import com.example.projectmobiledevelopment.Classes.RecAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DogListFragment extends Fragment {

    private MainActivity mainActivity;
    private RecyclerView rv;

    //buttons add them here
    //private Button dogs;

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
        rv = v.findViewById(R.id.rec_dogList);
        RecAdapter ra = new RecAdapter(mainActivity.db.getAll());
        rv.setAdapter(ra);
        rv.setLayoutManager(new LinearLayoutManager(mainActivity));



        return v;
    }

}
