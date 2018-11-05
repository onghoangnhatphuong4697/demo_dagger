package com.example.framgia.myapplication.data.local.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.example.framgia.myapplication.data.local.model.Bike;
import io.reactivex.Flowable;
import java.util.List;


@Dao
public interface BikeDao {

    @Query("Select * from bike")
    Flowable<List<Bike>> getAll();

    @Query("Select * from bike")
    LiveData<List<Bike>> getAllLiveData();

    @Query("Select * from bike Where id > :iD ")
    List<Bike> getBike(int iD);

    @Query("Select * from bike Where id = :iD ")
    Bike getBikeByID(int iD);

    @Query("Select * from bike Where id IN (:id)")
    Flowable<List<Bike>> getAllRequiment(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBike(Bike bike);

    @Query("DELETE FROM bike where id = :id")
    void deleteBike(int id);

    @Query("DELETE from bike ")
    void deleteAll();

    @Delete
    public void deleteUsers(Bike... bikes);

}
