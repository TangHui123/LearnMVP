package com.talkweb.tanghui.learnsample.retrofit;

import com.talkweb.tanghui.learnsample.MainActivity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MovieService {
    @GET("top250")
    Observable<MainActivity> getTopMovie(@Query("start") int start, @Query("count") int count);
}
