package com.talkweb.tanghui.learnsample.retrofit;

import com.talkweb.tanghui.learnsample.MainActivity;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HttpMethods {
    
    public static final String BASE_URL = "https://api.douban.com/v2/movie/";
    
    private static final int DEFAULT_TIMEOUT = 5;
    private Retrofit retrofit;
    private MovieService movieService;
    
    private static HttpMethods instance;

    public HttpMethods() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        
        retrofit = new Retrofit.Builder().client(builder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        
        movieService = retrofit.create(MovieService.class);
    }
    
    public static HttpMethods getInstance() {
        if(instance == null) {
            synchronized (HttpMethods.class) {
                if(instance == null) {
                    instance = new HttpMethods();
                }
            }
        }
        return instance;
    }
    
    public void getTopMovie(Subscriber<MainActivity> subscriber, int start, int count) {
        movieService.getTopMovie(start,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
