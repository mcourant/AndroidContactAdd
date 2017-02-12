package com.example.maximecours.mescontact.items;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MaximeCours on 07/02/2017.
 */

public class People implements Parcelable {

    private String name;
    private String prenom;
    private String profession;

    public People(String name, String prenom, String profession){
        this.name = name;
        this.prenom = prenom;
        this.profession = profession;
    }

    public People(){

    }

    public People(Parcel in) {
        name = in.readString();
        prenom = in.readString();
        profession = in.readString();
    }

    public static final Creator<People> CREATOR = new Creator<People>() {
        @Override
        public People createFromParcel(Parcel in) {
            return new People(in);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };

    public String getProfession() {
        return profession;
    }

    public String getFullName(){
        return name+" "+prenom;
    }

    public String getName() {
        return name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(prenom);
        dest.writeString(profession);
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", prenom='" + prenom + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
