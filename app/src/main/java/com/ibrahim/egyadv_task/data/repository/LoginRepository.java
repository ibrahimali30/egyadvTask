package com.ibrahim.egyadv_task.data.repository;

import com.ibrahim.egyadv_task.data.network.ApiManager;
import com.ibrahim.egyadv_task.data.network.response.LoginResponse;

import java.util.HashMap;

import io.reactivex.Observable;

public class LoginRepository {
    private static final String TAG = "LoginRepository";


    public Observable<LoginResponse> executeLogin(String email, String password) {
        HashMap<String , String> map = new HashMap<>();
        map.put("login" , email);
        map.put("password" , password);
        return ApiManager.getAPIs().logIn(map);
    }
}
