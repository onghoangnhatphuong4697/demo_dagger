package com.example.framgia.myapplication.screen;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.framgia.myapplication.R;
import com.example.framgia.myapplication.data.local.model.Bike;
import com.example.framgia.myapplication.databinding.ItemListBinding;
import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Bike> mBikes;

    MainViewModel mMainViewModel;

    public MainAdapter(final MainViewModel mainViewModel) {
        mBikes = new ArrayList<>();
        mMainViewModel = mainViewModel;
    }

    public void updateData(List<Bike> bikes) {
        mBikes = bikes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        ItemListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                R.layout.item_list, viewGroup, false);
        return new ViewHolder(binding, mMainViewModel);
    }

    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.bind(mBikes.get(i));
    }

    @Override
    public int getItemCount() {
        return mBikes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ItemListBinding mItemListBinding;

        MainViewModel mMainViewModel;

        public ViewHolder(ItemListBinding itemListBinding,
                final MainViewModel mainViewModel) {
            super(itemListBinding.getRoot());
            mItemListBinding = itemListBinding;
            mMainViewModel = mainViewModel;
        }

        public void bind(Bike bike) {
            mItemListBinding.setBike(bike);
            mItemListBinding.setViewModel(mMainViewModel);
            mItemListBinding.buttonDeleteOne.setOnClickListener(this);
            mItemListBinding.executePendingBindings();
        }

        @Override
        public void onClick(final View v) {

        }
    }


}
