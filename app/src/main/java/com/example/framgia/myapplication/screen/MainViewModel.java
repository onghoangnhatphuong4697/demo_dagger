package com.example.framgia.myapplication.screen;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.databinding.ObservableField;
import com.example.framgia.myapplication.data.local.BikeLocalDataSource;
import com.example.framgia.myapplication.data.local.model.Bike;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private Context mContext;


    private BikeLocalDataSource mBikeLocalDataSource;

    public final ObservableField<String> name = new ObservableField<>();

    public final ObservableField<String> aaa = new ObservableField<>();

    public final ObservableField<MainAdapter> mMainAdapterObservableField = new ObservableField<>();

    private CompositeDisposable mCompositeDisposable;

    private MainAdapter mMainAdapter;

    public void setMainAdapter(MainAdapter mainAdapter) {
        mMainAdapter = mainAdapter;
        mMainAdapterObservableField.set(mMainAdapter);
    }

    public MainViewModel(@NonNull Application application) {
        super(application);
        mCompositeDisposable = new CompositeDisposable();
    }

    public void setContext(final Context context) {
        mContext = context;
    }

    public void setBikeLocalDataSource(BikeLocalDataSource bikeLocalDataSource) {
        mBikeLocalDataSource = bikeLocalDataSource;
    }

    public void onCLickButton() {
        Bike bike = new Bike(this.name.get());
        mBikeLocalDataSource.insertBike(bike);
    }

    public void onClickbuttonDelete(){
     // mBikeLocalDataSource.deleteBike();
    }

    public void deleteAll() {
        mBikeLocalDataSource.deleteAll();
    }

    public LiveData<List<Bike>> getAllListByLiveData(){
       return mBikeLocalDataSource.getAllListData();
    }

    void updateAdapter(List<Bike> bikes){
        mMainAdapter.updateData(bikes);
    }
//    public void getAllList() {
//        Disposable disposable = mBikeLocalDataSource.getAll().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<List<Bike>>() {
//                    @Override
//                    public void accept(final List<Bike> bikes) throws Exception {
//                        mMainAdapter.updateData(bikes);
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(final Throwable throwable) throws Exception {
//                        throwable.printStackTrace();
//                    }
//                });
//        mCompositeDisposable.add(disposable);
//
//    }

    public MainAdapter getMainAdapter() {
        return mMainAdapter;
    }
}
