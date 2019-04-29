package com.example.projectmobiledevelopment.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

import com.example.projectmobiledevelopment.Utils.BitmapConverter;

@Entity(tableName = "dogs")
public class dogs {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String dogName;

    private int dogYear;

    private String dogRace;

    private String OwnerName;

    private String OwnerNumber;

    private String OwnerEpost;

    private Boolean picture;

    private String special;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;

    public dogs(String dogName, int dogYear, String dogRace, String OwnerName, String OwnerNumber, String OwnerEpost, Boolean picture, String special, byte[] image) {
        this.dogName = dogName;
        this.dogYear = dogYear;
        this.dogRace = dogRace;
        this.OwnerName = OwnerName;
        this.OwnerNumber = OwnerNumber;
        this.OwnerEpost = OwnerEpost;
        this.picture = picture;
        this.special = special;
        this.image = image;

    }

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
        return picture;
    }

    public void setPicture(Boolean picture) {
        this.picture = picture;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getDogRace() {
        return dogRace;
    }

    public void setDogRace(String dogRace) {
        this.dogRace = dogRace;
    }

    public byte[] getImage(){return image;}

    public void setImage(Bitmap image){this.image = BitmapConverter.toBytes(image);}
}
