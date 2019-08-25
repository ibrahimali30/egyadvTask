package com.ibrahim.egyadv_task.ui.login;


import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.ibrahim.egyadv_task.data.network.response.LoginResponse;
import com.ibrahim.egyadv_task.data.repository.LoginRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginActivityViewModel extends AndroidViewModel {
    private static final String TAG = "LoginActivityViewModel";

    private LoginRepository mRepository;
    private CompositeDisposable disposables = new CompositeDisposable();
    private MutableLiveData<LoginResponse> responseLiveData = new MutableLiveData<>();

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        //todo inject repository
        mRepository = new LoginRepository();
    }

    public MutableLiveData<LoginResponse> getResponseLiveData() {
        return responseLiveData;
    }

    public void onLoginClicked(String email, String password) {

        disposables.add(mRepository.executeLogin(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable d) throws Exception {
                        responseLiveData.setValue(LoginResponse.loading());
                    }
                })
                .subscribe(
                        new Consumer<LoginResponse>() {
                            @Override
                            public void accept(LoginResponse result) throws Exception {
                                //success response
                                responseLiveData.setValue(LoginResponse.success(result));
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.d(TAG, "accept: "+throwable.toString());
                                responseLiveData.setValue(LoginResponse.error(throwable));
                            }
                        }
                ));


    }
}
