package com.example.lenovo.thescient;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    BottomSheetBehavior bottomSheetBehavior;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_main);
        Typeface karla_regular = Typeface.createFromAsset(getAssets(), "fonts/Karla-Regular.ttf");
        Typeface karla_bold = Typeface.createFromAsset(getAssets(), "fonts/Karla-Bold.ttf");
        Typeface high_tide = Typeface.createFromAsset(getAssets(), "fonts/HighTide-Demo.ttf");
        TextView title = (TextView) findViewById(R.id.title);
        TextView about_us_title = (TextView) findViewById(R.id.About_us_title);

        TextView Made_By = (TextView) findViewById(R.id.Made_by);
        LinearLayout bottom_sheet1 = (LinearLayout) findViewById(R.id.bottom_sheet);
        FrameLayout registration = bottom_sheet1.findViewById(R.id.Regitration);
        FrameLayout gallery = bottom_sheet1.findViewById(R.id.gallery);
        FrameLayout events = bottom_sheet1.findViewById(R.id.events);
        FrameLayout projects = bottom_sheet1.findViewById(R.id.Project);
        FrameLayout resources = bottom_sheet1.findViewById(R.id.Resources);
        FrameLayout idea = bottom_sheet1.findViewById(R.id.Idea_sub);
        FrameLayout faq1 = bottom_sheet1.findViewById(R.id.faq);
        final FrameLayout contact = bottom_sheet1.findViewById(R.id.Contact);
        final ImageView arrow = (ImageView) bottom_sheet1.findViewById(R.id.arrow);
        FrameLayout announcements = bottom_sheet1.findViewById(R.id.Announcements);
        announcements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Announcement.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);
            }
        });
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Register.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);
            }
        });
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Gallery.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);

            }
        });
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Events.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);

            }
        });
        projects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), project.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);

            }
        });
        resources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Resources.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), contactus.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);

            }
        });
        idea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ideasub.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);
            }
        });
        faq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), faq.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);

            }
        });

        Made_By.setTypeface(karla_regular);
        about_us_title.setTypeface(karla_bold);
        about_us_title.setText("About Us");
        about_us_title.setGravity(Gravity.CENTER);
        TextView about_us = (TextView) findViewById(R.id.About_us);
        about_us.setTypeface(karla_regular);
        about_us.setText(
                "SCIEnT is a multi-disciplinary innovation centre, " +
                        "providing opportunities to students to delve into the ever expanding world of technology, " +
                        "and discover, hands on, the incredible scope for innovation that the world offers today. " +
                        "The lab allows students to explore and experiment with technology, " +
                        "without having to deal with the fear and cost of failure. " +
                        "At SCIEnT, students are offered a multitude of tools, machines, " +
                        "consumables and services, and a space in which to work, learn and grow.");
        about_us.setGravity(Gravity.CENTER);
        final LinearLayout bottom_sheet = (LinearLayout) findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet);
        bottomSheetBehavior.setHideable(false);
        bottomSheetBehavior.setPeekHeight(125);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {

            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                arrow.setRotation(v * 180);
                linearLayout.setAlpha(1 - v);
            }
        });
        final ArrayList<Slide_Objects> arrayList = new ArrayList<>();
        arrayList.add(new Slide_Objects(R.drawable.carousel1compressed, "IDEA", "GET STARTED ON YOUR NEXT PROJECT"));
        arrayList.add(new Slide_Objects(R.drawable.carousel2compressed, "INNOVATE", "GET STARTED ON YOUR NEXT PROJECT"));
        arrayList.add(new Slide_Objects(R.drawable.carousel3compressed, "CREATE", "GET STARTED ON YOUR NEXT PROJECT"));
        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                viewPager.setCurrentItem(1);
            }
        }, 5000);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            Handler handler = new Handler();
            Runnable runnable1 = new Runnable() {
                @Override
                public void run() {
                    viewPager.setCurrentItem(1);
                }
            };
            Runnable runnable2 = new Runnable() {
                @Override
                public void run() {
                    viewPager.setCurrentItem(2);
                }
            };
            Runnable runnable3 = new Runnable() {
                @Override
                public void run() {
                    viewPager.setCurrentItem(0);
                }
            };

            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == 0) {
                    handler.removeCallbacks(runnable2);
                    handler.removeCallbacks(runnable3);
                    handler = new Handler();
                    handler.postDelayed(runnable1, 5000);
                } else if (i == 1) {
                    handler.removeCallbacks(runnable1);
                    handler.removeCallbacks(runnable3);
                    handler = new Handler();
                    handler.postDelayed(runnable2, 5000);
                } else if (i == 2) {
                    handler.removeCallbacks(runnable1);
                    handler.removeCallbacks(runnable2);
                    handler = new Handler();
                    handler.postDelayed(runnable3, 5000);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        SimplePager simplePager = new SimplePager(this, arrayList);
        viewPager.setAdapter(simplePager);
        CirclePageIndicator titleIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        titleIndicator.setViewPager(viewPager);
    }

    @Override
    protected void onStop() {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }
}

