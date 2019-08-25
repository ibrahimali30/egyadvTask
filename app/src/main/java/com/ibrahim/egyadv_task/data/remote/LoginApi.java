package com.ibrahim.egyadv_task.data.remote;


import com.ibrahim.egyadv_task.data.remote.response.LoginResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {

    @POST("LoginUser")
    Call<LoginResponse> logIn(@Body HashMap<String, String> user);

}
