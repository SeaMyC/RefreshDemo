package com.odp.refreshdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        ViewPager bannerViewPager = findViewById(R.id.vp_banner);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.vp_module);
        List<String> titles = new ArrayList<>();
        List<Fragment> fragments = new ArrayList<>();
        List<ImageView> imageViews = new ArrayList<>();
        ImageView imageView = new ImageView(this);
        ImageView imageView1 = new ImageView(this);
        ImageView imageView2 = new ImageView(this);
        ImageView imageView3 = new ImageView(this);
        ImageView imageView4 = new ImageView(this);
        imageView.setImageResource(R.mipmap.test);
        imageView1.setImageResource(R.mipmap.test_01);
        imageView2.setImageResource(R.mipmap.test_02);
        imageView3.setImageResource(R.mipmap.test_03);
        imageView4.setImageResource(R.mipmap.test_04);
        imageViews.add(imageView);
        imageViews.add(imageView1);
        imageViews.add(imageView2);
        imageViews.add(imageView3);
        imageViews.add(imageView4);
        for (int i = 0; i < 5; i++) {
            titles.add("test :" + i);
            fragments.add(new TestFragment());
        }
        bannerViewPager.setAdapter(new ImageAdapter(imageViews));
        viewPager.setAdapter(new TabPagerAdapter(getSupportFragmentManager(), titles, fragments));
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(3);
    }
}
