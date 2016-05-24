package com.shizy.coordinatorlayoutdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by shizhongyong on 5/24/2016.
 */
public class FragmentAdapter extends RecyclerView.Adapter<FragmentViewHolder> {

    @Override
    public FragmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FragmentViewHolder holder = new FragmentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(FragmentViewHolder holder, int position) {
        holder.mTextView.setText(Cheeses.sCheeseStrings[position]);
    }

    @Override
    public int getItemCount() {
        return Cheeses.sCheeseStrings.length;
    }
}
