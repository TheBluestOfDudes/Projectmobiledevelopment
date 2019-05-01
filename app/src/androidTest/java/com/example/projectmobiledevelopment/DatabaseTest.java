package com.example.projectmobiledevelopment;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.projectmobiledevelopment.Classes.DogObject;
import com.example.projectmobiledevelopment.Database.Database;
import com.example.projectmobiledevelopment.Database.dao;
import com.example.projectmobiledevelopment.Database.dates;
import com.example.projectmobiledevelopment.Database.dogs;
import com.example.projectmobiledevelopment.Database.todo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    private dao myDao;
    private Database db;

    @Before
    public void setup() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, Database.class)
                .allowMainThreadQueries()
                .build();
        myDao = db.mydao();

        myDao.addDog(new dogs("kelly", 2, "labrador", "Tom", "12334566", "hihi", true, "jjdd", new byte[0]));
        myDao.addDate(new dates(2019, 4, 29));
        myDao.addTodo(new todo(2019, 4, 29, "hei"));
    }

    @Test
    public void testAllInsertMethods() {

        List<dogs> dog = myDao.GetDogsFromName("kelly");
        assertEquals("correct added dog", "kelly", dog.get(0).getDogName());

        dates date = myDao.getDate(2019, 4, 29);
        assertEquals("correct date", 2019, date.getYear());

        List<String> todo = myDao.getTodoItems(2019, 4, 29);
        assertEquals("correct todoitem", "hei", todo.get(0));

    }

    @Test
    public void DeleteAllMethods() {

        myDao.DeleteDog("Tom", "kelly");
        assertNotEquals("correct",myDao.GetDogsFromName("kelly"), "");

        myDao.deleteTodoItem(2019, 4, 29, "hei");
        List<String> array = myDao.getTodoItems(2019, 4, 29);
        assertEquals("Correct equals",array.size(), 0);

    }


}
