package com.talkweb.tanghui.learnsample;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.talkweb.tanghui.learnsample.bean.User;
import com.talkweb.tanghui.learnsample.interf.IUserBiz;
import com.talkweb.tanghui.learnsample.interf.IUserBizPath;
import com.talkweb.tanghui.learnsample.model.OnWeatherLisenter;
import com.talkweb.tanghui.learnsample.model.WeathModelVolley;
import com.talkweb.tanghui.learnsample.model.WeatherModel;
import com.talkweb.tanghui.learnsample.retrofit.MovieService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

import static android.animation.ValueAnimator.RESTART;

public class MainActivity extends AppCompatActivity implements OnWeatherLisenter {

    private WeatherModel weatherModel;
    private String string;
    private TextView hello;
    private Button button;
    private View line;
    private Button buttonAni;
    private Button mButtonOk;
    private Button mMyButton;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    
    
    private void setButtonAni() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mButtonOk, "alpha", 0f, 1f, 0f, 1.0f);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
        
        
        ObjectAnimator animator = ObjectAnimator.ofFloat(mMyButton, "rotation", 0f, 360f);
        animator.setDuration(1000);
        animator.setRepeatMode(RESTART);
        animator.setRepeatCount(2);
        animator.start();
        
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(hello, "scaleY", 1, 3, 1);
        animator1.setDuration(1000);
        animator1.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hello = (TextView) findViewById(R.id.hello);

        ImageView imageView = findView(R.id.image_kk);
        imageView.setImageResource(R.drawable.animation1);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.start();
        
        long mlong = 0;
        try {
            mlong = Long.decode("www.baidu.com");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        ButterKnife.bind(this);
        hello = findView(R.id.hello);
        button = findView(R.id.weatherBtn);
        buttonAni = findView(R.id.button_ani);
        mButtonOk = findView(R.id.btn_okhttp);
        mMyButton = findView(R.id.myBtton);


        for (int i = 0; i < 10; i++) {

        }


        List<String> list = new ArrayList<>();
        for (String s : list) {

        }

        for (int i = 0; i < 10; i++) {

        }

        if (mMyButton != null) {

        }

        boolean bool = false;
        if (bool) {

        }

        int i = 0;

        mMyButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.v("jj", "listen ontouch=" + event.getAction());
                return false;
            }
        });

        mMyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("jj", "listen onclick");
            }
        });

        Button groupButton = findView(R.id.view_button);
        groupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyViewGroupActivity.class);
                startActivity(intent);
            }
        });
        mButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestOkhttpActivity.class);
                startActivity(intent);
            }
        });
        buttonAni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, PaintActivity.class);
//                startActivity(intent);
//                float start = button.getTranslationY();
//                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(button, "translationY", start, start + 200f).setDuration(2000);
//                objectAnimator.setRepeatMode(ObjectAnimator.RESTART);
//                objectAnimator.setInterpolator(new FastOutLinearInInterpolator());
//                objectAnimator.start();
//                objectAnimator.addListener(new Animator.AnimatorListener() {
//                    @Override
//                    public void onAnimationStart(Animator animation) {
//                        
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationCancel(Animator animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animator animation) {
//
//                    }
//                });

                
                float fromX = hello.getTranslationX();
                ValueAnimator valueAnimator = ValueAnimator.ofFloat(fromX, fromX + 100f, fromX);
                valueAnimator.setDuration(1000);
                valueAnimator.setInterpolator(new AccelerateInterpolator());
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (float) animation.getAnimatedValue();
                        hello.setTranslationX(value);
                        hello.setAlpha((Float) animation.getAnimatedValue("alpha"));
                    }
                });
                valueAnimator.start();
                FloatEvaluator floatEvaluator;
                ObjectAnimator oaScaleX = ObjectAnimator.ofFloat(mButtonOk, "scaleX", 1, 0, 1);
                mButtonOk.getScaleX();
                ObjectAnimator oaScaleY = ObjectAnimator.ofFloat(mButtonOk, "scaleY", 1, 0, 1);
                ObjectAnimator oaRotation = ObjectAnimator.ofFloat(mButtonOk, "rotation", 0, 360);
                ObjectAnimator oaAlpha = ObjectAnimator.ofFloat(mButtonOk, "alpha", 1, 0, 1);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(oaScaleX).with(oaScaleY).with(oaRotation);
                animatorSet.play(oaAlpha).after(oaRotation);
                animatorSet.setDuration(1000);
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                });
                animatorSet.start();
                
                
                Animator animator = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.animator);
                animator.setTarget(mMyButton);
                animator.start();


                Animation animation = new TranslateAnimation(0, 500, 0, 500);
                animation.setDuration(1000);
                animation.setFillAfter(true);
                button.startAnimation(animation);
                
                
                Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim12);
                
            }
        });
        line = findView(R.id.line_gap);
        line.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        weatherModel = new WeathModelVolley();

        Observable.just("kkk").observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(this::testL);


        Observable<List<String>> tvShowObservable = Observable.fromCallable(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                return null;
            }
        });

        Single<List<String>> tvShowSingle = Single.fromCallable(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                return null;
            }
        });
        tvShowSingle.subscribe(new Action1<List<String>>() {
            @Override
            public void call(List<String> strings) {

            }
        });

        tvShowSingle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<List<String>>() {
                    @Override
                    public void onSuccess(List<String> value) {

                    }

                    @Override
                    public void onError(Throwable error) {

                    }
                });


        Subject subject = PublishSubject.create();
        subject.subscribe(new Observer() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {

            }
        });
        subject.onNext("jj");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });

        AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();
        testRetrofit();
        checkPermission();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    private void testRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.31.242:8080/springmvc_users/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IUserBiz userBiz = retrofit.create(IUserBiz.class);
        Call<List<User>> call = userBiz.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.d("huihui", "get=" + response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("huihui", "fail=" + t.getMessage());
            }
        });

        IUserBizPath userBizPath = retrofit.create(IUserBizPath.class);
        Call<User> call1 = userBizPath.getUser("zhy");
        call1.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });


//        Retrofit retrofit1 = new Retrofit.Builder()
//                .baseUrl("")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        IUserLogin login = retrofit.create(IUserLogin.class);
//        Call<User> call2 = login.login("zhy","123");
    }

    private void testL(String nam) {
        Log.v("kk", nam);
    }

    @Override
    public void onSuccess(String string) {
        hello.setText("learn mvc");
    }

    @Override
    public void onError() {

    }


    public void click_button(View v) {
        Intent intent = new Intent(this, PaintActivity.class);
        startActivity(intent);
    }

    public void click_button_wocao(View v) {
        Intent intent = new Intent(this, PaintActivity.class);
        startActivity(intent);
    }

    private <E> E findView(int id) {
        return (E) findViewById(id);
    }

    private void getMovie() {
        String baseUrl = "https://api.douban.com/v2/movie/";

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieService movieService = retrofit.create(MovieService.class);
        Observable<MainActivity> call = movieService.getTopMovie(0, 10);
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MainActivity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MainActivity mainActivity) {

                    }
                });
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager
                .PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                Toast.makeText(this, "permission", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void test123() {

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
