package com.ibrahim.egyadv_task.data.network.response;

import com.ibrahim.egyadv_task.data.network.response.loginResponseData.Data;
import com.ibrahim.egyadv_task.util.Status;

import io.reactivex.annotations.NonNull;

import static com.ibrahim.egyadv_task.util.Status.LOADING;
import static com.ibrahim.egyadv_task.util.Status.SUCCESS;
import static com.ibrahim.egyadv_task.util.Status.ERROR;

/**
 * Author: ib
 * Created by: ModelGenerator on 8/24/2019
 */
public class LoginResponse {
    //login API response
    public int status;
    public String message;
    public Data data;//all DATA object inner classes was auto generated using ModelGenerator plugin (in loginResponseData package)

    //helper values
    Status loginStatus;
    Throwable mThrowable;


    public LoginResponse(Status status  , Throwable throwable) {
        this.loginStatus = status;
        this.mThrowable= throwable;
    }

    public static LoginResponse loading() {
        return new LoginResponse(LOADING, null);
    }

    public static LoginResponse success(@NonNull LoginResponse loginResponse) {
        loginResponse.setLoginStatus(SUCCESS);
        return loginResponse ;
    }

    public static LoginResponse error(@NonNull Throwable error) {
        return new LoginResponse(ERROR , error);
    }

    //getters and setters
    public Status getLoginStatus() {
        return loginStatus;
    }

    public Throwable getThrowable() {
        return mThrowable;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Data getData() {
        return data;
    }

    public void setLoginStatus(Status loginStatus) {
        this.loginStatus = loginStatus;
    }
}