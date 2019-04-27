package com.example.projectmobiledevelopment.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;

@Entity(tableName = "dates", primaryKeys = {"year", "month", "day"}, indices = {@Index("year"), @Index("month"), @Index("day")})
public class dates {

    // Selected year
    private int year;
    // Selected month
    private int month;
    // Selected day;
    private int day;

    public dates(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}

