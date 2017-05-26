package com.ricky.happyes.ui.mine.collection;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ricky.happyes.ui.mine.collection.shop.ShopCollectionFragment;
import com.ricky.happyes.ui.mine.collection.travel.TravelCollectionFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的收藏滑动适配器
 * Created by Ricky on 2017-5-26.
 */

public class MyCollectionVPAdapter extends FragmentStatePagerAdapter {

    private String titles[] = {"景点收藏", "店铺收藏"};
    private List<Fragment> fragments = new ArrayList<>();

    public MyCollectionVPAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(new TravelCollectionFragment());
        fragments.add(new ShopCollectionFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
