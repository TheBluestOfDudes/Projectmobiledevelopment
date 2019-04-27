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

    @Insert
    public void addDate(dates date);

    @Insert
    public void addTodo(todo todo);

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

    @Query("SELECT * FROM dates")
    public List<dates> getAllDates();

    @Query("SELECT * FROM dates WHERE year = :year AND month = :month AND day = :day")
    public dates getDate(int year, int month, int day);

    @Query("SELECT todoItem FROM todo WHERE dyear = :year AND dmonth = :month AND dday = :day")
    public List<String> getTodoItems(int year, int month, int day);
}
