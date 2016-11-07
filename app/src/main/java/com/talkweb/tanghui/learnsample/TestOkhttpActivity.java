package com.talkweb.tanghui.learnsample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * author：tanghui on 16/5/4
 */

public class TestOkhttpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani);
        initHttp();
    }
    
    private void initHttp() {
        
        //get
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://github.com/hongyangAndroid")
                .build();
        com.squareup.okhttp.Call tCall = okHttpClient.newCall(request);
        tCall.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String htmlStr = response.body().string();
                Log.d("huihui", htmlStr);
            }
        });
        
        
        //post
        FormEncodingBuilder builder = new FormEncodingBuilder();
        builder.add("username","huihui");
        Request requestPost = new Request.Builder()
                .url("jjjj")
                .post(builder.build())
                .build();
        okHttpClient.newCall(requestPost).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                
            }

            @Override
            public void onResponse(Response response) throws IOException {

            }
        });
    }
}
