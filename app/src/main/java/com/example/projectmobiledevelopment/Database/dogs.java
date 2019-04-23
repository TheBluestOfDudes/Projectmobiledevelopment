package com.example.projectmobiledevelopment.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "dogs")
public class dogs {

    @PrimaryKey
    private int id;

    private String dogName;

    private int dogYear;

    private String OwnerName;

    private String OwnerNumber;

    private String OwnerEpost;

    private Boolean Picture;

    private String special;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public int getDogYear() {
        return dogYear;
    }

    public void setDogYear(int dogYear) {
        this.dogYear = dogYear;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getOwnerNumber() {
        return OwnerNumber;
    }

    public void setOwnerNumber(String ownerNumber) {
        OwnerNumber = ownerNumber;
    }

    public String getOwnerEpost() {
        return OwnerEpost;
    }

    public void setOwnerEpost(String ownerEpost) {
        OwnerEpost = ownerEpost;
    }

    public Boolean getPicture() {
        return Picture;
    }

    public void setPicture(Boolean picture) {
        Picture = picture;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }
}
