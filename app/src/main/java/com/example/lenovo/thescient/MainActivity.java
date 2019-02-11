package com.example.lenovo.thescient;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.ViewFlipper;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    ViewFlipper vfMyViewFlipper;

    TextView tt;int i=0;

    String[] text={"IDEATE","INNOVATE","CREATE"};
    private ViewFlipper mViewFlipper;
    private Context mContext;
    private LinearLayout dots;
    private int custom_position=0;
    private GestureDetectorCompat mDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //prepareDots(custom_position++);
        dots=(LinearLayout)findViewById(R.id.dotLayout) ;
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
    }


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

