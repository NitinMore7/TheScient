package com.example.lenovo.thescient;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    ImageView scientLogo;
    ImageView spiderLogo;
    ImageView spiderText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        scientLogo = (ImageView) findViewById(R.id.scientLogo);
        spiderLogo = (ImageView) findViewById(R.id.spiderLogo);
        spiderText = (ImageView) findViewById(R.id.spiderText);
        final Animation upToDown = AnimationUtils.loadAnimation(this, R.anim.up_to_down);
        final Animation downToUp = AnimationUtils.loadAnimation(this, R.anim.down_to_up);
        downToUp.setInterpolator(new DecelerateInterpolator(5));
        downToUp.setDuration(2000);
        upToDown.setInterpolator(new DecelerateInterpolator(5));
        upToDown.setDuration(2000);
        scientLogo.startAnimation(upToDown);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        }, 3000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                spiderLogo.setVisibility(View.VISIBLE);
                spiderText.setVisibility(View.VISIBLE);
                spiderLogo.startAnimation(downToUp);
                spiderText.startAnimation(downToUp);
            }
        }, 1000);
    }
}
