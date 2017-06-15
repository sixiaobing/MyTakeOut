package com.letv.takeout.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.letv.takeout.view.fragment.HomeFragment;
import com.letv.takeout.view.fragment.MoreFragment;
import com.letv.takeout.view.fragment.MyFragment;
import com.letv.takeout.view.fragment.OrderFragment;


/**
 * Created by 10198 on 2017/6/15.
 */

public class MainAdapter extends FragmentPagerAdapter {
    private String[] arrayTitles ;
    public MainAdapter(FragmentManager fm,String[] arrs) {
        super(fm);
        this.arrayTitles = arrs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new OrderFragment();
            case 2:
                return new MyFragment();
            case 3:
                return new MoreFragment();
        }
        return  new HomeFragment();
    }

    @Override
    public int getCount() {
        return arrayTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arrayTitles[position];
    }
}
