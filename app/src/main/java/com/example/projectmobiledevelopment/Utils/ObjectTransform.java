package com.example.projectmobiledevelopment.Utils;

import com.example.projectmobiledevelopment.Classes.DogObject;
import com.example.projectmobiledevelopment.Database.dogs;

import java.util.List;

public class ObjectTransform {

    public List<DogObject> getDogObject(List<dogs> list) {

        List<DogObject> doglist = null;

        for (dogs item : list) {

            doglist.add(new DogObject(item.getDogName(), item.getDogYear(), item.getOwnerName(), item.getOwnerNumber(),
                    item.getOwnerEpost(), item.getPicture(), item.getSpecial()));
        }
        return doglist;
    }
}
