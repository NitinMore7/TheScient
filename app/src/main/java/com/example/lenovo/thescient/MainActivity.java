package com.example.lenovo.thescient;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper vfMyViewFlipper;

    private ViewFlipper mViewFlipper;
    private Context mContext;
    private GestureDetectorCompat mDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vfMyViewFlipper = (ViewFlipper) findViewById(R.id.vf);
        vfMyViewFlipper.setOnTouchListener(new OnFlingListner(this) {

            @Override
            public void onRightToLeft() {

                vfMyViewFlipper.setInAnimation(getApplicationContext(), R.anim.right_to_left);

                vfMyViewFlipper.showPrevious();
            }

            @Override
            public void onLeftToRight() {

                vfMyViewFlipper.setInAnimation(getApplicationContext(), R.anim.left_to_right);
                vfMyViewFlipper.showNext();
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


    }

