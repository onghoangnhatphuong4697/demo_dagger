package com.example.framgia.myapplication.data.local;

import android.arch.lifecycle.LiveData;
import com.example.framgia.myapplication.data.local.model.Bike;

import io.reactivex.Flowable;
import java.util.List;

public interface LocalDataSource {

    Flowable<List<Bike>> getAll();

    Flowable<List<Bike>> getAllRequiment(int id);

    void insertBike(Bike bike);

    void deleteBike(int id);

    void deleteAll();

    LiveData<List<Bike>> getAllListData();
}
