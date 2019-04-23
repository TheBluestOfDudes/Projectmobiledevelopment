package com.example.projectmobiledevelopment.Database;

@android.arch.persistence.room.Database(entities = {dogs.class}, version = 1, exportSchema = false)
public abstract class Database {

    public abstract dao mydao();
}
