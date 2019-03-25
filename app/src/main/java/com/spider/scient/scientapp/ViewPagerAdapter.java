package com.spider.scient.scientapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new electronics();
        } else if (position == 1) {
            fragment = new mechanical();
        }
        return fragment;
    }


    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "ELECTRONICS TOOLS";
        } else if (position == 1) {
            title = "MECHANICAL TOOLS";
        }
        return title;
    }
}
