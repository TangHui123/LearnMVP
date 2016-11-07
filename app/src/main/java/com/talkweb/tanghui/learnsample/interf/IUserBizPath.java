package com.talkweb.tanghui.learnsample.interf;

import com.talkweb.tanghui.learnsample.bean.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * author：tanghui on 16/5/4
 */
public interface IUserBizPath {
    @GET("{username}")
    Call<User> getUser(@Path("username") String username);
}
