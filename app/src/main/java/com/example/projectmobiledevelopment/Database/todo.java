package com.example.projectmobiledevelopment.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

@Entity(tableName = "todo", primaryKeys = {"year", "month", "day"}, foreignKeys = {
         @ForeignKey(
                 entity = dates.class,
                 parentColumns = {"year", "month", "day"},
                 childColumns = {"dyear", "dmonth", "dday"}
         )
})
public class todo {

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

    public int getYear() {
        return dyear;
    }

    public void setYear(int dyear) {
        this.dyear = dyear;
    }

    public int getMonth() {
        return dmonth;
    }

    public void setMonth(int dmonth) {
        this.dmonth = dmonth;
    }

    public int getDay() {
        return dday;
    }

    public void setDay(int dday) {
        this.dday = dday;
    }

    public String getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(String todoItem) {
        this.todoItem = todoItem;
    }
}
