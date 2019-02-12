package com.example.lenovo.thescient;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ViewFlipper vfMyViewFlipper;

    TextView tt;int i=0;

    String[] text={"IDEATE","INNOVATE","CREATE"};
    private ViewFlipper mViewFlipper;
    private Context mContext;
    private LinearLayout dots;
    private int custom_position=0;
    private GestureDetectorCompat mDetector;
    BottomSheetBehavior bottomSheetBehavior;
    ImageView bulb_transition;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //prepareDots(custom_position++);
        final LinearLayout bottom_sheet = (LinearLayout) findViewById(R.id.bottom_sheet);
        bulb_transition = (ImageView) findViewById(R.id.bulb_transition);
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet);
        bottomSheetBehavior.setHideable(false);
        bottomSheetBehavior.setPeekHeight(150);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {

            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                Log.d("Offset",v+"");
                if(v<=0.150){
                    bulb_transition.setVisibility(View.INVISIBLE);
                }else{
                    bulb_transition.setVisibility(View.VISIBLE);
                }
                if(v<=0.0169)
                    bulb_transition.setImageResource(R.drawable.i0);
                else if(v<=0.0169*2&&v>0.0169)
                    bulb_transition.setImageResource(R.drawable.i1);
                else if(v<=0.0169*3&&v>0.0169*2)
                    bulb_transition.setImageResource(R.drawable.i2);
                else if(v<=0.0169*4&&v>0.0169*3)
                    bulb_transition.setImageResource(R.drawable.i3);
                else if(v<=0.0169*5&&v>0.0169*4)
                    bulb_transition.setImageResource(R.drawable.i4);
                else if(v<=0.0169*6&&v>0.0169*5)
                    bulb_transition.setImageResource(R.drawable.i5);
                else if(v<=0.0169*7&&v>0.0169*6)
                    bulb_transition.setImageResource(R.drawable.i6);
                else if(v<=0.0169*8&&v>0.0169*7)
                    bulb_transition.setImageResource(R.drawable.i7);
                else if(v<=0.0169*9&&v>0.0169*8)
                    bulb_transition.setImageResource(R.drawable.i8);
                else if(v<=0.0169*10&&v>0.0169*9)
                    bulb_transition.setImageResource(R.drawable.i9);
                else if(v<=0.0169*11&&v>0.0169*10)
                    bulb_transition.setImageResource(R.drawable.i10);
                else if(v<=0.0169*12&&v>0.0169*11)
                    bulb_transition.setImageResource(R.drawable.i11);
                else if(v<=0.0169*13&&v>0.0169*12)
                    bulb_transition.setImageResource(R.drawable.i12);
                else if(v<=0.0169*14&&v>0.0169*13)
                    bulb_transition.setImageResource(R.drawable.i13);
                else if(v<=0.0169*15&&v>0.0169*14)
                    bulb_transition.setImageResource(R.drawable.i14);
                else if(v<=0.0169*16&&v>0.0169*15)
                    bulb_transition.setImageResource(R.drawable.i15);
                else if(v<=0.0169*17&&v>0.0169*16)
                    bulb_transition.setImageResource(R.drawable.i16);
                else if(v<=0.0169*18&&v>0.0169*17)
                    bulb_transition.setImageResource(R.drawable.i17);
                else if(v<=0.0169*19&&v>0.0169*18)
                    bulb_transition.setImageResource(R.drawable.i18);
                else if(v<=0.0169*20&&v>0.0169*19)
                    bulb_transition.setImageResource(R.drawable.i19);
                else if(v<=0.0169*21&&v>0.0169*20)
                    bulb_transition.setImageResource(R.drawable.i20);
                else if(v<=0.0169*22&&v>0.0169*23)
                    bulb_transition.setImageResource(R.drawable.i21);
                else if(v<=0.0169*23&&v>0.0169*24)
                    bulb_transition.setImageResource(R.drawable.i22);
                else if(v<=0.0169*24&&v>0.0169*23)
                    bulb_transition.setImageResource(R.drawable.i23);
                else if(v<=0.0169*25&&v>0.0169*24)
                    bulb_transition.setImageResource(R.drawable.i24);
                else if(v<=0.0169*26&&v>0.0169*25)
                    bulb_transition.setImageResource(R.drawable.i25);
                else if(v<=0.0169*27&&v>0.0169*26)
                    bulb_transition.setImageResource(R.drawable.i26);
                else if(v<=0.0169*28&&v>0.0169*27)
                    bulb_transition.setImageResource(R.drawable.i27);
                else if(v<=0.0169*29&&v>0.0169*28)
                    bulb_transition.setImageResource(R.drawable.i28);
                else if(v<=0.0169*30&&v>0.0169*29)
                    bulb_transition.setImageResource(R.drawable.i29);
                else if(v<=0.0169*31&&v>0.0169*30)
                    bulb_transition.setImageResource(R.drawable.i30);
                else if(v<=0.0169*32&&v>0.0169*31)
                    bulb_transition.setImageResource(R.drawable.i31);
                else if(v<=0.0169*33&&v>0.0169*32)
                    bulb_transition.setImageResource(R.drawable.i32);
                else if(v<=0.0169*34&&v>0.0169*33)
                    bulb_transition.setImageResource(R.drawable.i33);
                else if(v<=0.0169*35&&v>0.0169*34)
                    bulb_transition.setImageResource(R.drawable.i34);
                else if(v<=0.0169*36&&v>0.0169*35)
                    bulb_transition.setImageResource(R.drawable.i35);
                else if(v<=0.0169*37&&v>0.0169*34)
                    bulb_transition.setImageResource(R.drawable.i36);
                else if(v<=0.0169*38&&v>0.0169*37)
                    bulb_transition.setImageResource(R.drawable.i37);
                else if(v<=0.0169*39&&v>0.0169*38)
                    bulb_transition.setImageResource(R.drawable.i38);
                else if(v<=0.0169*40&&v>0.0169*39)
                    bulb_transition.setImageResource(R.drawable.i39);
                else if(v<=0.0169*41&&v>0.0169*40)
                    bulb_transition.setImageResource(R.drawable.i40);
                else if(v<=0.0169*42&&v>0.0169*41)
                    bulb_transition.setImageResource(R.drawable.i41);
                else if(v<=0.0169*43&&v>0.0169*42)
                    bulb_transition.setImageResource(R.drawable.i42);
                else if(v<=0.0169*44&&v>0.0169*43)
                    bulb_transition.setImageResource(R.drawable.i43);
                else if(v<=0.0169*45&&v>0.0169*44)
                    bulb_transition.setImageResource(R.drawable.i44);
                else if(v<=0.0169*46&&v>0.0169*45)
                    bulb_transition.setImageResource(R.drawable.i45);
                else if(v<=0.0169*47&&v>0.0169*46)
                    bulb_transition.setImageResource(R.drawable.i46);
                else if(v<=0.0169*48&&v>0.0169*47)
                    bulb_transition.setImageResource(R.drawable.i47);
                else if(v<=0.0169*49&&v>0.0169*48)
                    bulb_transition.setImageResource(R.drawable.i48);
                else if(v<=0.0169*50&&v>0.0169*49)
                    bulb_transition.setImageResource(R.drawable.i49);
                else if(v<=0.0169*51&&v>0.0169*50)
                    bulb_transition.setImageResource(R.drawable.i50);
                else if(v<=0.0169*52&&v>0.0169*51)
                    bulb_transition.setImageResource(R.drawable.i51);
                else if(v<=0.0169*53&&v>0.0169*52)
                    bulb_transition.setImageResource(R.drawable.i52);
                else if(v<=0.0169*54&&v>0.0169*53)
                    bulb_transition.setImageResource(R.drawable.i53);
                else if(v<=0.0169*55&&v>0.0169*54)
                    bulb_transition.setImageResource(R.drawable.i54);
                else if(v<=0.0169*56&&v>0.0169*55)
                    bulb_transition.setImageResource(R.drawable.i55);
                else if(v<=0.0169*57&&v>0.0169*56)
                    bulb_transition.setImageResource(R.drawable.i56);
                else if(v<=0.0169*58&&v>0.0169*57)
                    bulb_transition.setImageResource(R.drawable.i57);
                else if(v>=0.0169*58)
                    bulb_transition.setImageResource(R.drawable.i58);
            }
        });
        final List<Integer> list = new ArrayList<>();
        list.add(R.drawable.image1);
        list.add(R.drawable.i0);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        SimplePager simplePager = new SimplePager(this,list);
        viewPager.setAdapter(simplePager);
        CirclePageIndicator titleIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        titleIndicator.setViewPager(viewPager);
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(count == list.size()){
                    count = 0;
                }
                viewPager.setCurrentItem(count++);
            }
        };
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },2000,2000);
        /*dots=(LinearLayout)findViewById(R.id.dotLayout) ;
        vfMyViewFlipper = (ViewFlipper) findViewById(R.id.vf);
        tt=(TextView)findViewById(R.id.txtv);
        final Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(3000);
        final Animation out = new AlphaAnimation(1.0f, 0.0f);
        out.setDuration(3000);
        tt.setText(text[i]);
        Intent i1=new Intent(MainActivity.this,Register.class);
        startActivity(i1);
        
        vfMyViewFlipper.setOnTouchListener(new OnFlingListner(this) {

            @Override
            public void onRightToLeft() {
                vfMyViewFlipper.setInAnimation(getApplicationContext(), R.anim.fade_in);
                vfMyViewFlipper.showPrevious();
                if(custom_position>3)
                    custom_position=0;
            }

            @Override
            public void onLeftToRight() {

                vfMyViewFlipper.setInAnimation(getApplicationContext(), R.anim.fade_in);
                vfMyViewFlipper.showNext();
                if (custom_position<0)
                    custom_position=2;
            }

            @Override
            public void onBottomToTop() {

            }

            @Override
            public void onTopToBottom() {

            }
        });

        vfMyViewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
    public void flipperhandler(View view)
    {
        switch (view.getId()){
            default:vfMyViewFlipper.setFlipInterval(1000);
                    vfMyViewFlipper.setAutoStart(true);
                    vfMyViewFlipper.setInAnimation(getApplicationContext(),R.anim.fade_in);
                    vfMyViewFlipper.startFlipping();
        }
    }*/


   /* private void prepareDots(int currentslidep){
        ImageView dot[]=new ImageView[3];
        for(int i=0;i<3;i++)
        {
            dot[i]=new ImageView(this);
            if(i==currentslidep)
                dot[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dots));
            else
                dot[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.inactive));
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(4,0,4,0);
            dots.addView(dot[i],layoutParams);
        }

    }*/
    }
}

