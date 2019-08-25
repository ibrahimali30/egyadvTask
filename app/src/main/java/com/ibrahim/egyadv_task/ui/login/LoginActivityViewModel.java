package com.ibrahim.egyadv_task.ui.login;

import android.app.Application;
import android.text.Editable;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ibrahim.egyadv_task.data.repository.LoginRepository;

public class LoginActivityViewModel extends AndroidViewModel {

    LoginRepository mRepository;
    AuthListener mAuthListener;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        mRepository = new LoginRepository();
    }



    public void setAuthListener(AuthListener listener) {
        this.mAuthListener = listener ;
    }

    public void onLoginClicked(String email, String password) {
        mRepository.logIn(email , password);

    }
}
