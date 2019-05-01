package com.example.projectmobiledevelopment.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectmobiledevelopment.Classes.DogObject;
import com.example.projectmobiledevelopment.Classes.RecAdapter;
import com.example.projectmobiledevelopment.R;
import com.example.projectmobiledevelopment.Utils.BitmapConverter;

/**
 * A simple {@link Fragment} subclass.
 */

public class ViewDogFragment extends Fragment {

    private DogObject dog;
    private TextView dogName;
    private TextView dogRace;
    private TextView dogAge;
    private TextView dogSpecial;
    private ImageView dogImage;
    private TextView ownerName;
    private TextView ownerPhone;
    private TextView ownerEmail;



    public ViewDogFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_view_dog, container, false);

        dog = RecAdapter.selectedDog;
        dogName = v.findViewById(R.id.txt_dogname);
        dogRace = v.findViewById(R.id.txt_dograce);
        dogAge = v.findViewById(R.id.txt_dogage);
        dogSpecial = v.findViewById(R.id.txt_dogspecial);
        dogImage = v.findViewById(R.id.img_dogimage);
        ownerName = v.findViewById(R.id.txt_dogowner);
        ownerPhone = v.findViewById(R.id.txt_ownerphone);
        ownerEmail = v.findViewById(R.id.txt_owneremail);
        dogName.setText("Name: " + dog.dogName());
        dogRace.setText("Race: " + dog.dogRace());
        dogAge.setText(("Age: " + (Integer)dog.dogYear()).toString());
        dogSpecial.setText("Special info: " + dog.spesial());
        dogImage.setImageBitmap(BitmapConverter.toBitmap(dog.image()));
        ownerName.setText("Name: " + dog.name());
        ownerPhone.setText("Phone: " + dog.tlf());
        ownerEmail.setText("Email: " + dog.epost());

        return v;
    }
}
