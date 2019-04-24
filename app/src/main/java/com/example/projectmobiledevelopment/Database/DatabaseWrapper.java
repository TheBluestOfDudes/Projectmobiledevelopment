package com.example.projectmobiledevelopment.Database;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.projectmobiledevelopment.Classes.DogObject;
import com.example.projectmobiledevelopment.Utils.ObjectTransform;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static android.content.ContentValues.TAG;

public class DatabaseWrapper {

    private Database mDB;
    private String dbName;
    private ObjectTransform transform;

    public DatabaseWrapper(Context ctx, String dbName) {
        this.dbName = dbName;
        this.mDB = Room.databaseBuilder(ctx,Database.class,dbName).build();
        this.transform = new ObjectTransform();
    }

    public void insertToDogs(DogObject dog) {
        // remeber to change id
        dogs insert = new dogs(dog.dogName(), dog.dogYear(), dog.name(), dog.tlf(), dog.epost(), dog.picture(), dog.spesial());

        new AsyncTask<dogs,Void,Void>() {

            @Override
            protected Void doInBackground(dogs... dogs) {
                mDB.mydao().addDog(dogs[0]);
                return null;
            }
        }.execute(insert);
    }

    public void deleteAllDogs() {
        new AsyncTask<Void,Void,Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                mDB.mydao().DeleteAllDogs();
                return null;
            }
        }.execute();
    }
    public List<DogObject> GetDogsOwnerName(final String ownerName) {
        List<dogs> array = null;
        try {
            array = new AsyncTask<Void, Void, List<dogs>>() {

                @Override
                protected List<dogs> doInBackground(Void... voids) {
                    return mDB.mydao().GetOwnerDogs(ownerName);
                }
            }.execute().get();
        }
        catch (ExecutionException e) {
            Log.e(TAG, e.getMessage());
        }
        catch (InterruptedException e) {
            Log.e(TAG, e.getMessage());
        }
        return transform.getDogObject(array);
    }
}
