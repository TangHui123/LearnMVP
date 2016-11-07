package com.talkweb.tanghui.learnsample.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Scroller;

import com.talkweb.tanghui.learnsample.R;

/**
 * author：tanghui on 16/5/22
 */

public class MyView extends View {
    
    private Paint mPaint;
    private Context mContext;
    private Scroller mScroller;
    
    public MyView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }
    
    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(mContext.getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin));
        mScroller = new Scroller(mContext);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.v("Myview","myview.onmeasure....");
        setMeasuredDimension(200,200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        Log.v("Myview","myview.onDraw....");
        canvas.drawRect(0,0,100,100,mPaint);
        canvas.drawText("jjjj",100,100,mPaint);
    }
    
    public void smoothScrollTo(int dx, int dy) {
        int scrollX = getScrollX();
        int delta = dx - scrollX;
        int scrollY = getScrollY();
        mScroller.startScroll(scrollX, scrollY ,dx, dy ,2000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if(mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }
}
