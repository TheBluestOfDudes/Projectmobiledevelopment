package com.example.projectmobiledevelopment.Database;

import android.arch.persistence.room.RoomDatabase;

@android.arch.persistence.room.Database(entities = {dogs.class, dates.class, todo.class}, version = 4, exportSchema = false)
public abstract class Database extends RoomDatabase{

    public abstract dao mydao();
}
