package com.shizy.coordinatorlayoutdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by shizhongyong on 5/24/2016.
 */
public class FragmentViewHolder extends RecyclerView.ViewHolder {

    TextView mTextView;

    public FragmentViewHolder(View itemView) {
        super(itemView);
        mTextView = (TextView) itemView;
    }

}
