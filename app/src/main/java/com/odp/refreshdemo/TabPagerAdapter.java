package com.odp.refreshdemo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author odp
 **/

public class TabPagerAdapter extends FragmentPagerAdapter {
    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();


    public TabPagerAdapter(FragmentManager fragmentManager, List<String> list, List<Fragment> fragmentList) {
        super(fragmentManager);
        titles.clear();
        fragments.clear();
        titles.addAll(list);
        fragments.addAll(fragmentList);
    }


    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
