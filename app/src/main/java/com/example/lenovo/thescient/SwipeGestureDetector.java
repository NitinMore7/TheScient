package com.example.lenovo.thescient;

import android.view.GestureDetector;
import android.view.MotionEvent;


public class SwipeGestureDetector extends GestureDetector.SimpleOnGestureListener {
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        // Swipe left (next)
        if (e1.getX() > e2.getX()) {
            //viewFlipper.showNext();
        }

        // Swipe right (previous)
        if (e1.getX() < e2.getX()) {
            //viewFlipper.showPrevious();
        }

        return super.onFling(e1, e2, velocityX, velocityY);
    }
}
