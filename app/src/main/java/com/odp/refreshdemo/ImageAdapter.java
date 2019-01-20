package com.odp.refreshdemo;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * @author odp
 **/
public class ImageAdapter extends PagerAdapter {

    private List<ImageView> imageViews;


    public ImageAdapter(List<ImageView> imageViews) {
        this.imageViews = imageViews;
    }

    /**
     *      * 获取当前要显示对象的数量
     *      
     */
    @Override
    public int getCount() {
        return imageViews.size();
    }

    /**
     *      * 判断是否用对象生成界面
     *      
     */

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    /**
     *      * 从ViewGroup中移除当前对象（图片）
     *      
     */

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViews.get(position));
    }

    /**
     *      * 当前要显示的对象（图片）
     *      
     */

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imageViews.get(position));
        return imageViews.get(position);
    }


}
