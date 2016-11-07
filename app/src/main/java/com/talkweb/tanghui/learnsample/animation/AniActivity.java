package com.talkweb.tanghui.learnsample.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.talkweb.tanghui.learnsample.R;

public class AniActivity extends Activity {

    private ImageView mImageview;
    private LinearLayout linearLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani);
        linearLayout = (LinearLayout) findViewById(R.id.ani_ll);
        mImageview = (ImageView) findViewById(R.id.image_ani);
//        beginAnimation();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                beginQQTremble();
            }
        },3000);
//        beginQQTremble();
    }
    
    private void beginAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim12);
//        mImageview.setAnimation(animation);
        mImageview.startAnimation(animation);
        
    }
    
    private void beginAnintion2() {
        RotateAnimation rotateAnimation = new RotateAnimation(0,360,200,200);
        rotateAnimation.setDuration(4000);
        mImageview.setAnimation(rotateAnimation);
    }
    
    private void beginAniSet() {
        AnimationSet set = new AnimationSet(false);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(4000);
        set.addAnimation(alphaAnimation);

        TranslateAnimation translateAnimation = new TranslateAnimation(0,0,200,200);
        translateAnimation.setDuration(3000);
        set.addAnimation(translateAnimation);
        
        mImageview.setAnimation(set);
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    
    private void beginQQTremble() {
        QQTrembleAni ani = new QQTrembleAni();
        ani.setDuration(1000);
        ani.setRepeatCount(3);
        linearLayout.startAnimation(ani);
    }
    
    
    private void startAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mImageview,"alpha",0f,1f);
        AnimatorSet animationSet = new AnimatorSet();
        animationSet.setDuration(4000);
        animationSet.setInterpolator(new BounceInterpolator());
        animationSet.playTogether(animator);
        animationSet.start();
    }
}
