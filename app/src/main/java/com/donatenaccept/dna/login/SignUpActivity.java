package com.donatenaccept.dna.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.donatenaccept.dna.R;
import com.donatenaccept.dna.parent.BaseActivity;
import com.donatenaccept.dna.utils.Utility;


/**
 * Created by abhi on 17/04/17.
 */

public class SignUpActivity extends BaseActivity implements View.OnClickListener {


    ImageView ivBack;
    TextView tvSignup, tvBloodGroup;
    EditText etName, etPhone, etEmail, etPassword, etConfirmPassword, etAge, etAddress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utility.setStatusBarTranslucent(this, true);
        setContentView(R.layout.activity_signup);

        findViewById();

    }

    private void findViewById() {

        ivBack = (ImageView) findViewById(R.id.iv_back);
        ivBack.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.signup_et_name);
        etPhone = (EditText) findViewById(R.id.signup_et_phone);
        etEmail = (EditText) findViewById(R.id.signup_et_email);
        etPassword = (EditText) findViewById(R.id.signup_et_password);
        etConfirmPassword = (EditText) findViewById(R.id.signup_et_confirm_password);
        etAge = (EditText) findViewById(R.id.signup_et_age);
        tvBloodGroup = (TextView) findViewById(R.id.signup_et_blood_group);
        etAddress = (EditText) findViewById(R.id.signup_et_address);


        tvSignup = (TextView) findViewById(R.id.signup_tv_create);
        tvSignup.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.iv_back:
                finish();
                break;

            case R.id.signup_tv_create:

                startActivity(new Intent(SignUpActivity.this, OTPActivity.class));
                break;
        }
    }
}
