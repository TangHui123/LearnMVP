package com.talkweb.tanghui.learnsample;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GithubService {
    String ENDPOINT = "https://api.github.com";
    
    @GET("/users/{user}")
    Observable<String> getUserData(@Path("user") String user);
    
    @GET("/users/{user}/repos")
    Observable<String[]> getData(@Path("user") String user);
}
