package com.ibrahim.egyadv_task.ui.login;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.ibrahim.egyadv_task.R;
import com.ibrahim.egyadv_task.data.network.response.LoginResponse;
import com.ibrahim.egyadv_task.ui.main.MainPageActivity;
import com.ibrahim.egyadv_task.util.Views;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    LoginActivityViewModel mViewModel;

    //views
    EditText emailET, passwordET;
    ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //init views
        progressDialog = Views.getProgressDialog(this, "Please wait...");
        emailET = findViewById(R.id.emailEditText);
        passwordET = findViewById(R.id.passwordEditText);

        //transparent status bar
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(Color.TRANSPARENT);

        //view model and observe live data
        mViewModel = ViewModelProviders.of(this).get(LoginActivityViewModel.class);
        mViewModel.getResponseLiveData().observe(this, new Observer<LoginResponse>() {
            @Override
            public void onChanged(LoginResponse loginResponse) {
                consumeResponse(loginResponse);
            }
        });
    }

    public void loginButtonClicked(View view) {
        mViewModel.onLoginClicked(emailET.getText().toString(), passwordET.getText().toString());
    }

    private void consumeResponse(LoginResponse loginResponse) {

        switch (loginResponse.getLoginStatus()) {

            case LOADING:
                progressDialog.show();
                break;

            case SUCCESS:
                progressDialog.dismiss();
                renderSuccessResponse(loginResponse);
                break;

            case ERROR:
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this, "خطأ فى تسجيل الدخول" , Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    private void renderSuccessResponse(LoginResponse loginResponse) {
        if (loginResponse.status == 1) {
            //login success : navigate to main screen and clear tasks
            Intent intent = new Intent(this , MainPageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            //show a welcom message
            Toast.makeText(LoginActivity.this ,
                    loginResponse.data.user.userFirstname +'\n'+ loginResponse.message ,
                    Toast.LENGTH_SHORT).show();

        }
    }
}
