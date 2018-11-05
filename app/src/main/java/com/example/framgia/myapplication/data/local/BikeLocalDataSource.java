package com.example.framgia.myapplication.data.local;

import android.arch.lifecycle.LiveData;
import com.example.framgia.myapplication.data.local.dao.BikeDao;
import com.example.framgia.myapplication.data.local.model.Bike;

import io.reactivex.Flowable;
import java.util.List;

public class BikeLocalDataSource implements LocalDataSource {

    private static BikeLocalDataSource sInstance;

    private BikeDao mBikeDao;

    private List<Bike> mBikes;


    public BikeLocalDataSource(BikeDao bikeDao) {
        mBikeDao = bikeDao;
    }

    public static synchronized BikeLocalDataSource getsInstance(BikeDao bikeDao) {
        if (sInstance == null) {
            return new BikeLocalDataSource(bikeDao);
        }
        return sInstance;
    }

    @Override
    public Flowable<List<Bike>> getAll() {
        return mBikeDao.getAll();
    }

    @Override
    public Flowable<List<Bike>> getAllRequiment(int id) {
        return mBikeDao.getAllRequiment(id);
    }

    @Override
    public void insertBike(Bike bike) {
        mBikeDao.insertBike(bike);
    }


    @Override
    public void deleteBike(int id) {
        mBikeDao.deleteBike(id);
    }

    @Override
    public void deleteAll() {
        mBikeDao.deleteAll();
    }

    @Override
    public LiveData<List<Bike>> getAllListData() {
        return mBikeDao.getAllLiveData();
    }
}
