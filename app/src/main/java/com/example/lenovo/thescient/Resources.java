package com.example.lenovo.thescient;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Resources extends AppCompatActivity {
    BottomSheetBehavior bottomSheetBehavior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources2);
        Typeface karla_regular =  Typeface.createFromAsset(getAssets(),"fonts/Karla-Regular.ttf");
        LinearLayout bottom_sheet1 = (LinearLayout) findViewById(R.id.bottom_sheet);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_resources);
        TextView Made_By = (TextView) findViewById(R.id.Made_by);
        FrameLayout registration =  bottom_sheet1.findViewById(R.id.Regitration);
        FrameLayout gallery =  bottom_sheet1.findViewById(R.id.gallery);
        FrameLayout events =  bottom_sheet1.findViewById(R.id.events);
        FrameLayout projects =  bottom_sheet1.findViewById(R.id.Project);
        FrameLayout resources =  bottom_sheet1.findViewById(R.id.Resources);
        FrameLayout idea = bottom_sheet1.findViewById(R.id.Idea_sub);
        FrameLayout faq1 = bottom_sheet1.findViewById(R.id.faq);
        final FrameLayout contact =  bottom_sheet1.findViewById(R.id.Contact);
        final ImageView arrow = (ImageView) bottom_sheet1.findViewById(R.id.arrow);
        FrameLayout announcements = bottom_sheet1.findViewById(R.id.Announcements);
        announcements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Announcement.class));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);
            }
        });
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Register.class));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);
            }
        });
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Gallery.class));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);

            }
        });
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Events.class));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);

            }
        });
        projects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),project.class));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);

            }
        });
        resources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),contactus.class));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);

            }
        });
        idea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),ideasub.class));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);
            }
        });
        faq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),faq.class));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);

            }
        });
        Made_By.setTypeface(karla_regular);
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
    }
}
