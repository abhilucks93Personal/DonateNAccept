package com.donatenaccept.dna.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.donatenaccept.dna.R;
import com.donatenaccept.dna.navigation.NavigationActivity;
import com.donatenaccept.dna.parent.BaseActivity;
import com.donatenaccept.dna.utils.Constants;
import com.donatenaccept.dna.utils.Utility;


/**
 * Created by abhi on 17/04/17.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {


    TextView tvSignup;
    TextView tvForgotPassword;
    TextView tvSignin;

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

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.login_tv_signup:

                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                break;

            case R.id.login_tv_signin:
                Utility.addPreferences(LoginActivity.this, Constants.keyLoginCheck, true);
                startActivity(new Intent(LoginActivity.this, NavigationActivity.class));
                finishAffinity();
                break;

            case R.id.login_tv_forgot_password:

                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
                break;
        }
    }
}
