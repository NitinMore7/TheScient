package com.example.lenovo.thescient;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    private ViewPager viewpager;
    private LinearLayout layoutdot;
    private TextView[] dotstv;
    private int[] layouts;
    private Button btnNext;
    private Button btnSkip;
    private MyPagerAdapter pager;
    BottomSheetBehavior bottomSheetBehavior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!isFirstTimeSatrtApp()){
            startMainActivity();
            finish();

        }
         setStatusBarTransparent();
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_rproject);
        final LinearLayout bottom_sheet = (LinearLayout) findViewById(R.id.bottom_sheet);
        final ImageView arrow = (ImageView) bottom_sheet.findViewById(R.id.arrow);
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet);
        bottomSheetBehavior.setHideable(false);
        bottomSheetBehavior.setPeekHeight(125);
        ImageView home = (ImageView) findViewById(R.id.Home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),MainActivity.class));
                overridePendingTransition(R.anim.left_to_right,R.anim.stay);
            }
        });
        Typeface karla_regular =  Typeface.createFromAsset(getAssets(),"fonts/Karla-Regular.ttf");
        LinearLayout bottom_sheet1 = (LinearLayout) findViewById(R.id.bottom_sheet);
        TextView Made_By = (TextView) findViewById(R.id.Made_by);
        FrameLayout registration = bottom_sheet1.findViewById(R.id.Regitration);
        FrameLayout gallery =  bottom_sheet1.findViewById(R.id.gallery);
        FrameLayout events =  bottom_sheet1.findViewById(R.id.events);
        FrameLayout projects =  bottom_sheet1.findViewById(R.id.Project);
        FrameLayout resources =  bottom_sheet1.findViewById(R.id.Resources);
        final FrameLayout contact =  bottom_sheet1.findViewById(R.id.Contact);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Gallery.class));
            }
        });
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Events.class));
            }
        });
        projects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),project.class));
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

            }
        });
        Made_By.setTypeface(karla_regular);
        setContentView(R.layout.activity_welcome);
        viewpager=findViewById(R.id.view_pager);
        layoutdot=findViewById(R.id.dotLayout);
        btnNext=findViewById(R.id.btn_next);
        btnSkip=findViewById(R.id.btn_skip);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              int currentpage=viewpager.getCurrentItem()+1;
              if(currentpage<layouts.length){
                  viewpager.setCurrentItem(currentpage);

              }
              else{
                  startMainActivity();
              }
            }
        });
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMainActivity();
            }
        });
        layouts=new int[]{R.layout.slider_1,R.layout.slider_2,R.layout.slider_3};
        pager =new MyPagerAdapter(layouts,getApplicationContext());
        viewpager.setAdapter(pager);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
             if (position==layouts.length-1){
                 btnNext.setText("START");
                 btnSkip.setVisibility(View.GONE);
             }
             else{
                 btnNext.setText("NEXT");
                 btnSkip.setVisibility(View.VISIBLE);
             }
             setDotstatus(position);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        setDotstatus(0);

    }
    private boolean isFirstTimeSatrtApp(){
        SharedPreferences ref=getApplicationContext().getSharedPreferences("Scientapp", Context.MODE_PRIVATE);
        return  ref.getBoolean("FirstTime",true);
    }
    private void setFirstTimeStartStatus(boolean s){
        SharedPreferences ref=getApplicationContext().getSharedPreferences("Scientapp", Context.MODE_PRIVATE);
SharedPreferences.Editor editor=ref.edit();
editor.putBoolean("FirstTime",s);
editor.commit();
    }
    private void setDotstatus(int page){
        layoutdot.removeAllViews();
        dotstv=new TextView[layouts.length];
        for (int i=0;i<dotstv.length;i++){
            dotstv[i]=new TextView(this);
            dotstv[i].setText(Html.fromHtml("&#8226;"));
            dotstv[i].setTextSize(30);
            dotstv[i].setTextColor(Color.parseColor("#a9b4bb"));
            layoutdot.addView(dotstv[i]);


        }
        if(dotstv.length>0){
            dotstv[page].setTextColor(Color.parseColor("#ffffff"));
        }
    }
    private void startMainActivity(){
        setFirstTimeStartStatus(false);
        startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
        finish();
    }
    private void setStatusBarTransparent(){
        if(Build.VERSION.SDK_INT>=21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_FULLSCREEN);

            Window window=getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
