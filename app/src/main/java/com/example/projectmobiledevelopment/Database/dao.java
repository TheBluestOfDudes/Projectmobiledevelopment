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

    @Query("SELECT * FROM dogs WHERE OwnerName LIKE '%' || :ownerName || '%'")
    public List<dogs> GetOwnerDogs(String ownerName);

    @Query("SELECT * FROM dogs WHERE dogName Like '%' || :dogName || '%'")
    public List<dogs> GetDogsFromName(String dogName);

    @Query("DELETE FROM dogs WHERE dogName = :dogName AND OwnerName = :ownerName")
    public void DeleteDog(String ownerName, String dogName);

    @Query("SELECT * FROM dogs")
    public List<dogs> getAllDogs();
}
