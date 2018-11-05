package com.example.framgia.myapplication.screen;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.example.framgia.myapplication.R;
import com.example.framgia.myapplication.data.local.BikeLocalDataSource;
import com.example.framgia.myapplication.data.local.dao.AppDataBase;
import com.example.framgia.myapplication.data.local.model.Bike;
import com.example.framgia.myapplication.databinding.ActivityMainBinding;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mActivityMainBinding;

    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BikeLocalDataSource bikeLocalDataSource = new BikeLocalDataSource(
                AppDataBase.getInstance(this).getBikeDao());

        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mMainViewModel.setContext(this.getApplicationContext());
        mMainViewModel.setBikeLocalDataSource(bikeLocalDataSource);
        mMainViewModel.setMainAdapter(new MainAdapter(mMainViewModel));
        mActivityMainBinding.setViewModel(mMainViewModel);
        mMainViewModel.getAllListByLiveData().observe(this, new Observer<List<Bike>>() {
            @Override
            public void onChanged(@Nullable final List<Bike> bikes) {
                mMainViewModel.updateAdapter(bikes);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_delete:
                mMainViewModel.deleteAll();
        }
        return true;
    }
}
