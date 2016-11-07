package com.talkweb.tanghui.learnsample.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * author：tanghui on 16/7/28
 */

public class myButton extends Button {
    
    public myButton(Context context) {
        super(context);
    }

    public myButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.v("jj", "onTouchEvent down.");
                break;
            case  MotionEvent.ACTION_MOVE:
                Log.v("jj", "onTouchEvent move.");
                break;
            case MotionEvent.ACTION_UP:
                Log.v("jj", "onTouchEvent up.");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
    
    

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.v("jj", "dispatchTouchEvent down.");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.v("jj", "dispatchTouchEvent move.");
                break;
            case MotionEvent.ACTION_UP:
                Log.v("jj", "dispatchTouchEvent up.");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(event);
    }
}
