package com.talkweb.tanghui.learnsample.interf;

import com.talkweb.tanghui.learnsample.bean.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * author：tanghui on 16/5/4
 */

public interface IUserBizPost {
    @POST("add")
    Call<List<User>> addUser(@Body User user);
}
