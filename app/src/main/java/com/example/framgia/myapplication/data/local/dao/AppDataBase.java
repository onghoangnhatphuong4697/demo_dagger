package com.example.framgia.myapplication.data.local.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.framgia.myapplication.data.local.model.Bike;

@Database(entities = {Bike.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase sInstance;

    public abstract BikeDao getBikeDao();

    public static AppDataBase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context, AppDataBase.class, "bike")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }

}
