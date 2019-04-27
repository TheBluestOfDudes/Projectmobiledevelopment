package com.example.projectmobiledevelopment.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

@Entity(tableName = "todo", primaryKeys = {"dyear", "dmonth", "dday"}, foreignKeys = {
         @ForeignKey(
                 entity = dates.class,
                 parentColumns = {"year", "month", "day"},
                 childColumns = {"dyear", "dmonth", "dday"}
         )
}, indices = {@Index("dyear"), @Index("dmonth"), @Index("dday")})
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


}
