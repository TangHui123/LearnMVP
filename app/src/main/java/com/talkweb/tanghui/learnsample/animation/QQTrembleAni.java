package com.talkweb.tanghui.learnsample.animation;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class QQTrembleAni extends Animation {

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        t.getMatrix().setTranslate((float) Math.sin(interpolatedTime * 50) * 8, 
                (float) Math.sin(interpolatedTime * 50) * 8);
        super.applyTransformation(interpolatedTime, t);
    }
}
