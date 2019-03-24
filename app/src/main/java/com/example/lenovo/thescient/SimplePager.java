package com.example.lenovo.thescient;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SimplePager extends PagerAdapter {
    Context context;
    ArrayList<Slide_Objects> arrayList;

    public SimplePager(Context context, ArrayList<Slide_Objects> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public int getCount() {
        return arrayList.size();
    }


    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        View viewGroup = (View) o;
        TextView textViewTitle = (TextView) viewGroup.findViewById(R.id.text_pager);
        TextView textViewCaption = (TextView) viewGroup.findViewById(R.id.text_pager_caption);
        textViewTitle.setVisibility(View.INVISIBLE);
        textViewCaption.setVisibility(View.INVISIBLE);
        Animate(textViewTitle);
        Animate(textViewCaption);
        return view == o;
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Integer image_resId = arrayList.get(position).getmImageId();
        String textTitle = arrayList.get(position).getmTitle();
        String textCaption = arrayList.get(position).getmCaption();
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(R.layout.pager_layout, container, false);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.image_pager);
        imageView.setImageResource(image_resId);
        Typeface karla_regular = Typeface.createFromAsset(context.getAssets(), "fonts/Karla-Regular.ttf");
        Typeface karla_bold = Typeface.createFromAsset(context.getAssets(), "fonts/Karla-Bold.ttf");
        TextView textViewTitle = (TextView) viewGroup.findViewById(R.id.text_pager);
        TextView textViewCaption = (TextView) viewGroup.findViewById(R.id.text_pager_caption);
        Animate(textViewTitle);
        Animate(textViewCaption);
        textViewTitle.setTypeface(karla_bold);
        textViewTitle.setTextSize(75);
        textViewCaption.setTypeface(karla_regular);
        textViewTitle.setText(textTitle);
        textViewCaption.setText(textCaption);
        container.addView(viewGroup);
        return viewGroup;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }

    public void Animate(final View view) {
        Animation animation = new AlphaAnimation(0, 1);
        animation.reset();
        animation.setInterpolator(new AccelerateInterpolator());
        animation.setDuration(1000);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(animation);
    }
}
