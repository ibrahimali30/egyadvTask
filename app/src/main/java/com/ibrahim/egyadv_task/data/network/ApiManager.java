package com.ibrahim.egyadv_task.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {



    private static Retrofit retrofitInstance;
    private static Retrofit getInstance(){
        if(retrofitInstance==null){//create

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

           retrofitInstance = new Retrofit.Builder()
                   .baseUrl("https://cpanels.shop/testTask/api/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                   .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                   .build();
        }
        return retrofitInstance;
    }

    public static LoginApi getAPIs(){
        LoginApi services = getInstance().create(LoginApi.class);
        return services;
    }
}




