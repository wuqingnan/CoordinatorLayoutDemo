package com.shizy.coordinatorlayoutdemo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

/**
 * Created by shizhongyong on 5/24/2016.
 */
@EFragment(R.layout.fragment_tab)
public class TabFragment extends Fragment {

    @ViewById(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @FragmentArg
    String mTitle;

    private FragmentAdapter mAdapter;

    @AfterViews
    protected void afterViews() {
        mAdapter = new FragmentAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);

        Drawable drawable = getResources().getDrawable(R.drawable.divider, getActivity().getTheme());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST, drawable));
    }

}
