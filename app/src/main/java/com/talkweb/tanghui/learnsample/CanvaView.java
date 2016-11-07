package com.talkweb.tanghui.learnsample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class CanvaView extends View {
    
    private Paint mPaint;
    private int mWidth,mHeight;
    
    public CanvaView(Context context) {
        this(context,null);
    }

    public CanvaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(200,200);
        canvas.drawCircle(0,0,50,mPaint);
        
        mPaint.setColor(Color.BLUE);
        canvas.translate(200,200);
        canvas.drawCircle(0,0,50,mPaint);
        
        mPaint.setStyle(Paint.Style.STROKE);
        Rect rect = new Rect(0,-200,200,0);
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(rect,mPaint);
        
        canvas.scale(0.5f,0.5f);
        canvas.drawRect(rect,mPaint);
        
        canvas.translate(0,200);
        mPaint.setColor(Color.RED);
        Rect rect1 = new Rect(-100,-100,100,100);
        for (int i = 0 ; i < 10; i++) {
            canvas.scale(0.8f,0.8f);
            canvas.drawRect(rect1,mPaint);
        }
        
        canvas.restore();
        
        canvas.translate(mWidth/2, mHeight/2);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rect1,mPaint);
        
    }
}
