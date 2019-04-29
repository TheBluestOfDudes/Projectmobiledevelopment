package com.example.projectmobiledevelopment.Classes;

import android.graphics.Bitmap;

import com.example.projectmobiledevelopment.Utils.BitmapConverter;

public class DogObject {
    // name of the dog
    private String name;
    // how old the dog is
    private int old;
    // dog race
    private String race;
    // Owner name
    private String OwnerName;
    // Owner tlf
    private String OwnerNumber;
    // Owners Epost
    private String OwnerEpost;
    // Owners wants picture everyday/ 3 day etc..
    private Boolean OwnerPicture;
    // allergys, equipment, dogfood, etc
    private String spesial;

    private byte[] image;

   public DogObject(String dogName, int dogYear, String race, String OwnerName, String OwnerNumber, String OwnerEpost, Boolean OwnerPicture, String spesial, byte[] image) {
        this.name = dogName;
        this.old = dogYear;
        this.race = race;
        this.OwnerName = OwnerName;
        this.OwnerNumber = OwnerNumber;
        this.OwnerEpost = OwnerEpost;
        this.OwnerPicture = OwnerPicture;
        this.spesial = spesial;
        this.image = image;
    }

    public String dogName() {
        return this.name;
    }

    public int dogYear() {
        return this.old;
    }

    public String dogRace() {return this.race;}

    public String name() {
        return this.OwnerName;
    }

    public String tlf() {
        return this.OwnerNumber;
    }

    public String epost() {
        return this.OwnerEpost;
    }

    public Boolean picture() {
        return this.OwnerPicture;
    }

    public String spesial() {return this.spesial; }

    public byte[] image(){return this.image;}
}
