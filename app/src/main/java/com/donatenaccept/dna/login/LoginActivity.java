package com.donatenaccept.dna.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.donatenaccept.dna.MainActivity;
import com.donatenaccept.dna.R;
import com.donatenaccept.dna.navigation.NavigationActivity;
import com.donatenaccept.dna.parent.BaseActivity;
import com.donatenaccept.dna.retrofit.RetrofitApi;
import com.donatenaccept.dna.utils.Constants;
import com.donatenaccept.dna.utils.Utility;


/**
 * Created by abhi on 17/04/17.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener, RetrofitApi.ResponseListener {


    TextView tvSignup;
    TextView tvForgotPassword;
    TextView tvSignin;
    EditText etUserName, etPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utility.setStatusBarTranslucent(this, true);
        setContentView(R.layout.activity_login);

        findViewById();

    }

    private void findViewById() {

        tvSignup = (TextView) findViewById(R.id.login_tv_signup);
        tvSignup.setOnClickListener(this);

        tvSignin = (TextView) findViewById(R.id.login_tv_signin);
        tvSignin.setOnClickListener(this);

        tvForgotPassword = (TextView) findViewById(R.id.login_tv_forgot_password);
        tvForgotPassword.setOnClickListener(this);

        etUserName = (EditText) findViewById(R.id.et_user_name);
        etPassword = (EditText) findViewById(R.id.et_user_password);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.login_tv_signup:

                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                break;

            case R.id.login_tv_signin:
                fetchData();
                break;

            case R.id.login_tv_forgot_password:

                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
                break;
        }
    }

    private void fetchData() {

        String userName = etUserName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (isValidated(userName, password)) {

            String registrationType;
            if (userName.contains("@"))
                registrationType = "2";
            else
                registrationType = "1";

            RetrofitApi.getInstance().loginApi(LoginActivity.this, this, userName, password, registrationType);
        }

    }

    private boolean isValidated(String userName, String password) {

        if (userName.length() == 0) {
            Utility.showToast(this, Constants.msgInvalidUserName);
            return false;
        }

        if (!Utility.isValidEmail(userName)) {
            if (!Utility.isValidMobileNo(userName)) {
                Utility.showToast(this, Constants.msgInvalidUserName);
                return false;
            }
        }

        if (password.length() < 5) {
            Utility.showToast(this, Constants.msgInvalidPassword);
            return false;
        }


        return true;
    }

    @Override
    public void _onNext(Object obj) {
        ModelRegistrationMain responseMain = (ModelRegistrationMain) obj;
        if (responseMain.getCode().equals(Constants.codeSuccess)) {
            ModelRegistration registrationData = responseMain.getData();
            Utility.addPreferences(LoginActivity.this, Constants.keyProfileData, registrationData);
            Utility.addPreferences(LoginActivity.this, Constants.keyLoginCheck, true);
            startActivity(new Intent(LoginActivity.this, NavigationActivity.class));
            finishAffinity();
        } else {
            Utility.showToast(LoginActivity.this, responseMain.getMessage());
        }

    }

    @Override
    public void _onCompleted() {

    }

    @Override
    public void _onError(Throwable e) {

    }
}
