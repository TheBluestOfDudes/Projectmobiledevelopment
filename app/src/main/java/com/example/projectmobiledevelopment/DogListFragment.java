package com.example.projectmobiledevelopment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.projectmobiledevelopment.Classes.DogObject;
import com.example.projectmobiledevelopment.Classes.RecAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DogListFragment extends Fragment {

    private MainActivity mainActivity;
    private RecyclerView rv;
    private EditText search;

    private List<DogObject> tmp;

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

        // gets the recyclerview
        rv = v.findViewById(R.id.rec_dogList);

        // gets the editext
        search = v.findViewById(R.id.search);

        // init list
        tmp = new ArrayList<>();

        //here
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecAdapter ra = new RecAdapter(mainActivity.db.getAll());
        rv.setAdapter(ra);

        // here we will go through searching
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tmp = mainActivity.db.GetDogsFromName(search.getText().toString());
                for(DogObject item: mainActivity.db.GetDogsOwnerName(search.getText().toString())){
                    tmp.add(item);
                }
                rv.setAdapter(new RecAdapter(tmp));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        return v;
    }

}
