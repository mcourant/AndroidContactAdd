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

    protected People(Parcel in) {
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
}
