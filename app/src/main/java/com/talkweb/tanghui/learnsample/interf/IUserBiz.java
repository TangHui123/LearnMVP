package com.talkweb.tanghui.learnsample.interf;

import com.talkweb.tanghui.learnsample.bean.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * author：tanghui on 16/5/4
 */
public interface IUserBiz {
    @GET("users")
    Call<List<User>> getUsers();
}
