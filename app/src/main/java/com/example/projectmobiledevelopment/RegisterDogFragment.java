package com.example.projectmobiledevelopment;


import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;

import com.example.projectmobiledevelopment.Classes.DogObject;
import com.example.projectmobiledevelopment.Database.DatabaseWrapper;
import com.example.projectmobiledevelopment.Utils.ErrorByUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterDogFragment extends Fragment {

    private EditText dogName;
    private EditText dogAge;
    private EditText dograce;
    private EditText name;
    private EditText number;
    private EditText epost;
    private EditText special;
    private CheckBox picture;
    private Button submit;

    // database wrapper
    private DatabaseWrapper db;

    // ErrorByUser check for error
    private ErrorByUser error;

    public RegisterDogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_register_dog, container, false);

        // edittext find view
        dogName = v.findViewById(R.id.register_dog_name);
        dogAge = v.findViewById(R.id.register_dog_age);
        dograce = v.findViewById(R.id.register_dog_race);
        name = v.findViewById(R.id.register_owner_name);
        number = v.findViewById(R.id.register_owner_number);
        epost = v.findViewById(R.id.register_owner_epost);
        special = v.findViewById(R.id.register_special);

        // checkbox if wanted picture
        picture = v.findViewById(R.id.register_check_picture);

        // errorbyuser object get initialised
        error = new ErrorByUser();

        // button for submit
        submit = v.findViewById(R.id.btn_register_submit);

        // initialising the database wrapper
        db = ((MainActivity) getActivity()).db;

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View l) {
                // we will check for the epost format
                if (error.registerNotFilledRequiredFields((ViewGroup)v)) {
                    if (android.util.Patterns.EMAIL_ADDRESS.matcher(epost.getText().toString()).matches()) {

                        // new dog object ready to be inserted
                        DogObject item = new DogObject((dogName.getText().toString()).toUpperCase(),
                                Integer.parseInt(dogAge.getText().toString()),
                                (dograce.getText().toString()).toUpperCase(),
                                (name.getText().toString()).toUpperCase(),
                                number.getText().toString(),
                                epost.getText().toString(),
                                picture.isChecked(),
                                special.getText().toString());

                        // here we will call the database wrapper
                        db.insertToDogs(item);

                        ((MainActivity)getActivity()).fragmentManager.popBackStackImmediate();
                    }
                    } else {
                        epost.setError("Not correct formated");
                    }
            }

        });

        return v;
    }

}
