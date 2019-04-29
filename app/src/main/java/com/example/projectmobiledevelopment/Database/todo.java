package com.example.projectmobiledevelopment.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "todo",
        foreignKeys = {
         @ForeignKey(
                 entity = dates.class,
                 parentColumns = {"year", "month", "day"},
                 childColumns = {"dyear", "dmonth", "dday"},
                 onDelete = CASCADE, onUpdate = CASCADE
         )
}, indices = {@Index({"dyear", "dmonth", "dday"})})
public class todo {

    public int getDyear() {
        return dyear;
    }

    public void setDyear(int dyear) {
        this.dyear = dyear;
    }

    public int getDmonth() {
        return dmonth;
    }

    public void setDmonth(int dmonth) {
        this.dmonth = dmonth;
    }

    public int getDday() {
        return dday;
    }

    public void setDday(int dday) {
        this.dday = dday;
    }

    public String getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(String todoItem) {
        this.todoItem = todoItem;
    }

    public todo() {}

    // foreign key to dates
    @PrimaryKey(autoGenerate = true)
    private int id;
    //year
    private int dyear;
    //month
    private int dmonth;
    //day
    private int dday;
    // data will be here
    private String todoItem;

    public todo(int year, int month, int day, String todoItem) {
        this.dyear = year;
        this.dmonth = month;
        this.dday = day;
        this.todoItem = todoItem;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
