package com.talkweb.tanghui.learnsample.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.talkweb.tanghui.learnsample.R;

/**
 * author：tanghui on 16/5/22
 */

public class MyViewGroup extends ViewGroup {
    private static final String TAG = "MyViewGroup";
    
    private Context mContext;
    MyView myView;
    
    public MyViewGroup(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }
    
    private void init() {
        
        //add button
        Button button = new Button(mContext);
        button.setText("button");
        addView(button);
        
        //add imageview
        ImageView imageView = new ImageView(mContext);
        imageView.setBackgroundResource(R.drawable.ic_launcher);
        addView(imageView);
        
        //add text
        TextView textView = new TextView(mContext);
        textView.setText("jjlslll");
        addView(textView);
        
        //add myview
        myView = new MyView(mContext);
        addView(myView);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();
        Log.v(TAG,"onMeasure count = "+count+",widthMeasureSpec="+widthMeasureSpec+"," +
                "heightMeasureSpec="+heightMeasureSpec);
        int specSize_width =  MeasureSpec.getSize(widthMeasureSpec);
        int specSize_height = MeasureSpec.getSize(heightMeasureSpec);
        
        setMeasuredDimension(specSize_width, specSize_height);
        Log.v(TAG,"onMeasure specSize_width="+specSize_width+",specSize_height="+specSize_height);
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            child.measure(300,300);    //没有效果....最终执行getsuggestedsize();
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        
        int startLeft = 0;
        int startTop = 10;
        Log.v(TAG,"onLayout");
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            child.layout(startLeft, startTop, startLeft + child.getMeasuredWidth(),
                    startTop + child.getMeasuredHeight());
            startLeft = startLeft + child.getMeasuredWidth() + 10;
        }
        
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        Log.v(TAG,"dispatchDraw");
        super.dispatchDraw(canvas);
    }

    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        Log.v(TAG,"drawChild="+child.toString());
        return super.drawChild(canvas, child, drawingTime);
    }
    
    public void scroolMy(int x ,int y) {
        myView.smoothScrollTo(x,y);
    }
}
