package com.talkweb.tanghui.learnsample.interf;

import com.talkweb.tanghui.learnsample.bean.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * author：tanghui on 16/5/4
 */

public interface IUserLogin {
    @POST("login")
    @FormUrlEncoded
    Call<User> login(@Field("username") String username, @Field("password") String pwd);
}
