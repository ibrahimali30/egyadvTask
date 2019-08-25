package com.ibrahim.egyadv_task.data.repository;

import android.util.Log;

import com.ibrahim.egyadv_task.data.remote.ApiManager;
import com.ibrahim.egyadv_task.data.remote.response.LoginResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {
    private static final String TAG = "LoginRepository";



    public void logIn(String email, String password) {

        HashMap<String , String> map = new HashMap<>();
        map.put("login" , email);
        map.put("password" , password);

        ApiManager.getAPIs().logIn(map).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.d(TAG, "onResponse: "+response.body().message);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}
