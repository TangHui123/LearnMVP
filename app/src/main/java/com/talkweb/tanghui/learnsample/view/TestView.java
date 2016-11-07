package com.talkweb.tanghui.learnsample.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.talkweb.tanghui.learnsample.R;

public class TestView extends FrameLayout {
    
    private TextView textView1;
    private TextView textView2;
    
    public TestView(Context context) {
        super(context);
        init(context,null);
    }

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }
    
    private void init(Context context,AttributeSet attrs) {
        View view = View.inflate(context, R.layout.test_view,null);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.TestView);
        boolean bool = typedArray.getBoolean(R.styleable.TestView_isTest,false);
        int left = typedArray.getDimensionPixelSize(R.styleable.TestView_offLeft,0);
        int right = typedArray.getDimensionPixelSize(R.styleable.TestView_offRight,0);
        textView1 = (TextView) view.findViewById(R.id.text1);
        textView2 = (TextView) view.findViewById(R.id.text2);
        textView2.setText("kkkk"+left);
        textView1.setText("jjjj"+right);
        addView(view);
    }
}
