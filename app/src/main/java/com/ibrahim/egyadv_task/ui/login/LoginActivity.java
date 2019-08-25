package com.ibrahim.egyadv_task.ui.login;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.ibrahim.egyadv_task.R;

public class LoginActivity extends AppCompatActivity implements AuthListener {
    private static final String TAG = "LoginActivity";

    LoginActivityViewModel mViewModel;

    //views
    EditText emailET , passwordET ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = findViewById(R.id.emailEditText);
        passwordET = findViewById(R.id.passwordEditText);

        //transparent status bar
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(Color.TRANSPARENT);

        mViewModel = ViewModelProviders.of(this).get(LoginActivityViewModel.class);

        mViewModel.setAuthListener(this);

    }

    public void logIn(View view) {
        mViewModel.onLoginClicked(emailET.getText().toString() , passwordET.getText().toString());
    }

    @Override
    public void onLoginStarted() {

    }

    @Override
    public void onLoginSucess() {

    }

    @Override
    public void onLoginFailed() {

    }
}
