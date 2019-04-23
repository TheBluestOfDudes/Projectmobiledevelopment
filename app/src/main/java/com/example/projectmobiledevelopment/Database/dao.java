package com.example.projectmobiledevelopment.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface dao {

    @Insert
    public void addDog(dogs dog);

    // add more functions here
}
