package com.donatenaccept.dna.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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

public class SignUpActivity extends BaseActivity implements View.OnClickListener, RetrofitApi.ResponseListener {


    ImageView ivBack;
    TextView tvSignup, tvBloodGroup;
    EditText etName, etPhone, etEmail, etPassword, etConfirmPassword, etAge, etAddress;
    ModelRegistration modelRegistration;

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

                //startActivity(new Intent(SignUpActivity.this, OTPActivity.class));

                fetchData();

                break;
        }
    }

    private void fetchData() {
        modelRegistration = new ModelRegistration();

        modelRegistration.setFull_name(etName.getText().toString().trim());
        modelRegistration.setDevice_token("abcdefghijklmnop");
        modelRegistration.setDevice_type(Constants.deviceType);
        modelRegistration.setPassword(etPassword.getText().toString().trim());
        modelRegistration.setRegistration_type(Constants.registrationTypeNormal);
        modelRegistration.setUser_age(etAge.getText().toString().trim());
        modelRegistration.setUser_blood_group_id("1");
        modelRegistration.setUser_email(etEmail.getText().toString().trim());
        modelRegistration.setUser_lat("0.0");
        modelRegistration.setUser_long("0.0");
        modelRegistration.setUser_mobile(etPhone.getText().toString().trim());

        RetrofitApi.getInstance().signUpApi(SignUpActivity.this, this, modelRegistration);
    }

    @Override
    public void _onNext(Object obj) {
        ModelRegistrationMain responseMain = (ModelRegistrationMain) obj;
        if (responseMain.getCode().equals(Constants.codeSuccess)) {
            Utility.showToast(SignUpActivity.this, "yureka");
            ModelRegistration registrationData = responseMain.getData();
            Utility.addPreferences(SignUpActivity.this, Constants.keyProfileData, registrationData);
            Utility.addPreferences(SignUpActivity.this, Constants.keyLoginCheck, true);
            startActivity(new Intent(SignUpActivity.this, NavigationActivity.class));
            finishAffinity();
        } else {
            Utility.showToast(SignUpActivity.this, responseMain.getMessage());
        }

    }

    @Override
    public void _onCompleted() {

    }

    @Override
    public void _onError(Throwable e) {

    }
}
