package com.example.framgia.myapplication.data.local.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "bike")
/** Một số trường là duy nhất nên dùng unique true
 * (indices = {@Index(value = {"first_name", "last_name"},
unique = true)})**/

public class Bike {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int mID;

    @ColumnInfo(name = "name")
    private String mName;

    public Bike() {
    }

    @Ignore
    public Bike(String name) {
        mName = name;
    }

    public int getID() {
        return mID;
    }

    public void setID(final int ID) {
        mID = ID;
    }

    public String getName() {
        return mName;
    }

    public void setName(final String name) {
        mName = name;
    }
}
