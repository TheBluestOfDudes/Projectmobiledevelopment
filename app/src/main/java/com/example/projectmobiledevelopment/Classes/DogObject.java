package com.example.projectmobiledevelopment.Classes;

public class DogObject {
    // name of the dog
    private String name;
    // how old the dog is
    private int old;
    // Owner name
    private String OwnerName;
    // Owner tlf
    private String OwnerNumber;
    // Owners Epost
    private String OwnerEpost;
    // Owners wants picture everyday/ 3 day etc..
    private Boolean OwnerPicture;
    // allergys, equipment, dogfood, etc
    private Boolean spesial;

    DogObject(String dogName, int dogYear, String OwnerName, String OwnerNumber, String OwnerEpost, Boolean OwnerPicture) {
        this.name = dogName;
        this.old = dogYear;
        this.OwnerName = OwnerName;
        this.OwnerNumber = OwnerNumber;
        this.OwnerEpost = OwnerEpost;
        this.OwnerPicture = OwnerPicture;
    }

    public String dogName() {
        return this.name;
    }

    public int dogYear() {
        return this.old;
    }

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
}
