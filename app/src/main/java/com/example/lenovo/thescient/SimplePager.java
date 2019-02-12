package com.example.lenovo.thescient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

public class SimplePager extends PagerAdapter {
    Context context;
    List<Integer> arrayList;
    public SimplePager(Context context, List<Integer> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Integer image_resId = arrayList.get(position);
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(R.layout.pager_layout,container,false);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.image_pager);
        imageView.setImageResource(image_resId);
        container.addView(viewGroup);
        return viewGroup;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
