package com.talkweb.tanghui.learnsample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class PieView extends View {
    
    private Paint mPaint;
    private int mWidth, mHeigth;
    private float mStartAngle = 90;
    
    public PieView(Context context) {
        this(context,null);
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeigth = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float currentAngle = mStartAngle;
        canvas.translate(mWidth/2,mHeigth/2);
        float radius = (float) (Math.min(mWidth,mHeigth) / 2 * 0.8);
        RectF rectF = new RectF(-radius, -radius,radius,radius);
        
        for (int i = 0; i < 5; i++) {
            if(i % 2 == 0) {
                mPaint.setColor(Color.BLUE);
            } else {
                mPaint.setColor(Color.GREEN);
            }
            canvas.drawArc(rectF,currentAngle,60,true,mPaint);
            currentAngle += 60;
        }
    }
}
