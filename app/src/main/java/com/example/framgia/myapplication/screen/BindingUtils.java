package com.example.framgia.myapplication.screen;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

public class BindingUtils {

    @BindingAdapter("bind:setAdapter")
    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
