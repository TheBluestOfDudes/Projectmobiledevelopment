package com.example.projectmobiledevelopment.Utils;

import android.util.Log;

import com.example.projectmobiledevelopment.Classes.DogObject;
import com.example.projectmobiledevelopment.Database.dogs;

import java.util.ArrayList;
import java.util.List;

public class ObjectTransform {

    public List<DogObject> getDogObject(List<dogs> list) {

        List<DogObject> doglist = new ArrayList<DogObject>();

        for (dogs item : list) {
            doglist.add(new DogObject(item.getDogName(), item.getDogYear(), item.getDogRace(), item.getOwnerName(), item.getOwnerNumber(),
                    item.getOwnerEpost(), item.getPicture(), item.getSpecial()));
        }
        return doglist;
    }
}
