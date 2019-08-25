package com.ibrahim.egyadv_task.data.network;


import com.ibrahim.egyadv_task.data.network.response.LoginResponse;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {


    @POST("LoginUser")
    Observable<LoginResponse> logIn(@Body HashMap<String, String> user);

}
