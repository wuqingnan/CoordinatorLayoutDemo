package com.shizy.coordinatorlayoutdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by shizhongyong on 5/24/2016.
 */
public class TabLayoutAdapter extends FragmentPagerAdapter {

    private String[] mTitles = new String[20];

    public TabLayoutAdapter(FragmentManager fm) {
        super(fm);

        for (int i = 0; i < mTitles.length; i++) {
            mTitles[i] = "ITEM-" + i;
        }
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragment_.builder().mTitle(mTitles[position]).build();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
