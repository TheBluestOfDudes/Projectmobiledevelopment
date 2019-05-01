package com.example.projectmobiledevelopment.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectmobiledevelopment.Classes.DogObject;
import com.example.projectmobiledevelopment.Classes.RecAdapter;
import com.example.projectmobiledevelopment.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DogListFragment extends Fragment {

    private MainActivity mainActivity;
    private RecyclerView rv;
    private EditText search;
    private Button btnDeleteSelected;
    private Button btnViewSelected;

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

        //gets the delete button
        btnDeleteSelected = v.findViewById(R.id.btn_delete_selected);

        //gets the view button
        btnViewSelected = v.findViewById(R.id.btn_view_selected);

        // init list
        tmp = new ArrayList<>();


        btnDeleteSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DogObject dog = RecAdapter.selectedDog;
                mainActivity.db.Deletedog(dog.name(), dog.dogName());
                ((MainActivity)getActivity()).fragmentManager.popBackStackImmediate();
            }
        });

        btnViewSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(RecAdapter.selected){
                    FragmentTransaction fragmentTransaction = mainActivity.fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, new ViewDogFragment(), null)
                            .addToBackStack(null)
                            .commit();
                }
                else{
                    Toast.makeText(mainActivity, "No dog selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

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
