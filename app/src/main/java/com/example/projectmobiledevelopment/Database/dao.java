package com.example.projectmobiledevelopment.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.projectmobiledevelopment.Classes.DogObject;

import java.util.List;

@Dao
public interface dao {

    @Insert
    public void addDog(dogs dog);

    @Query("DELETE FROM dogs")
    public void DeleteAllDogs();

    @Query("SELECT * FROM dogs WHERE OwnerName LIKE :ownerName")
    public List<dogs> GetOwnerDogs(String ownerName);



}
