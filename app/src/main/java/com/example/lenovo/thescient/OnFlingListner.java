package com.example.lenovo.thescient;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public abstract class OnFlingListner implements View.OnTouchListener{
    Context context;
    public OnFlingListner(Context ctx){
        this.context=ctx;
    }
    private final GestureDetectorCompat gdt=new GestureDetectorCompat(context,new GestureListner());
    @Override
    public boolean onTouch(final View v, final MotionEvent event)
    {
        return gdt.onTouchEvent(event);
    }
    private final class GestureListner extends GestureDetector.SimpleOnGestureListener
    {
        private static final int MIN_DISTANCE=190;
        private static final int SWIPE_VELOCITY=250;
        @Override
        public boolean onFling(MotionEvent e1,MotionEvent e2,float velocityx,float velocityy)
        {
            if(e1.getX()-e2.getX()>MIN_DISTANCE && Math.abs(velocityx)>SWIPE_VELOCITY)
            {onRightToLeft();
            return true;}
            else if (e2.getX() - e1.getX() > MIN_DISTANCE && Math.abs(velocityx) > SWIPE_VELOCITY) {
                onLeftToRight();
                return true;
            }
            if (e1.getY() - e2.getY() > MIN_DISTANCE && Math.abs(velocityy) > SWIPE_VELOCITY) {
                onBottomToTop();
                return true;
            } else if (e2.getY() - e1.getY() > MIN_DISTANCE && Math.abs(velocityy) > SWIPE_VELOCITY) {
                onTopToBottom();
                return true;
            }
            return false;
        }

    }
    public abstract void onRightToLeft();

    public abstract void onLeftToRight();

    public abstract void onBottomToTop();

    public abstract void onTopToBottom();
}
