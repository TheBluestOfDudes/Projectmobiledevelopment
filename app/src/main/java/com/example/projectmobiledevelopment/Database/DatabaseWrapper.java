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
        this.mDB = Room.databaseBuilder(ctx,Database.class,dbName).fallbackToDestructiveMigration().build();
        this.transform = new ObjectTransform();
    }

    //DOGS database function comes here
    public void insertToDogs(DogObject dog) {
        // remeber to change id
        dogs insert = new dogs(dog.dogName(), dog.dogYear(), dog.dogRace(), dog.name(), dog.tlf(), dog.epost(), dog.picture(), dog.spesial());

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

    public List<DogObject> GetDogsFromName(final String dogName) {
        List<dogs> array = null;
        try {
            array = new AsyncTask<Void,Void,List<dogs>>() {

                @Override
                protected List<dogs> doInBackground(Void... voids) {
                    return mDB.mydao().GetDogsFromName(dogName);
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

    public void Deletedog(final String ownerName, final String dogName) {
        new AsyncTask<Void,Void,Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                mDB.mydao().DeleteDog(ownerName,dogName);
                return null;
            }
        }.execute();
    }

    public List<DogObject> getAll(){
        List<dogs> array = null;
        try{
            array = new AsyncTask<Void, Void, List<dogs>>(){
                @Override
                protected List<dogs> doInBackground(Void... voids){
                    return mDB.mydao().getAllDogs();
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
    /*
    * From here it will be dates database functions
    * Nothing else
    * */

    public void insertDate(int year, int month, int day) {

        dates item = new dates(year, month, day);

        new AsyncTask<dates, Void, Void>() {

            @Override
            protected Void doInBackground(dates... dates) {
                mDB.mydao().addDate(dates[0]);
                return null;
            }
        }.execute(item);
    }

    public List<dates> getDates() {
        List<dates> array = null;

        try {
            array = new AsyncTask<Void, Void, List<dates>>() {

                @Override
                protected List<dates> doInBackground(Void... voids) {
                    return mDB.mydao().getAllDates();
                }
            }.execute().get();
        }
        catch (ExecutionException e) {
            Log.e(TAG, e.getMessage());
        }
        catch (InterruptedException e) {
            Log.e(TAG, e.getMessage());
        }
        return array;
    }

    public dates getSingleDate(final int year, final int month, final int day) {
        dates item = null;

        try {
            item = new AsyncTask<Void, Void, dates>() {

                @Override
                protected dates doInBackground(Void... voids) {
                    return mDB.mydao().getDate(year, month, day);
                }
            }.execute().get();
        }
        catch (ExecutionException e) {
            Log.e(TAG, e.getMessage());
        }
        catch (InterruptedException e) {
            Log.e(TAG, e.getMessage());
        }
        return item;
    }

    /*
    * Here will all of the database function for
    * todolist be
    * */

    public List<String> getTodoList(final int year, final int month, final int day) {
        List<String> array = null;

        try {
            array = new AsyncTask<Void, Void, List<String>>() {

                @Override
                protected List<String> doInBackground(Void... voids) {
                    return mDB.mydao().getTodoItems(year, month, day);
                }
            }.execute().get();

        }
        catch (ExecutionException e) {
            Log.e(TAG, e.getMessage());
        }
        catch (InterruptedException e) {
            Log.e(TAG, e.getMessage());
        }
        return array;
    }

    public void insertTodoItem(dates date, String todoItem) {

        todo item = new todo(date.getYear(), date.getMonth(), date.getDay(), todoItem);

        new AsyncTask<todo, Void, Void>() {

            @Override
            protected Void doInBackground(todo... todos) {
                mDB.mydao().addTodo(todos[0]);
                return null;
            }
        }.execute(item);

    }
}
