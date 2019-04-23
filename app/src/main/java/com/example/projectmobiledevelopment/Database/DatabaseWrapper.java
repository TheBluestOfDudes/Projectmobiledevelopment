package com.example.projectmobiledevelopment.Database;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseWrapper {

    private Database mDB;
    private String dbName;

    public DatabaseWrapper(Context ctx, String dbName) {
        this.dbName = dbName;
        this.mDB = Room.databaseBuilder(ctx,Database.class,dbName).build();
    }
}
