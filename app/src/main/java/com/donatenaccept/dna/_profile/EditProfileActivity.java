package com.donatenaccept.dna._profile;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.donatenaccept.dna.R;
import com.donatenaccept.dna.login.ModelRegistration;
import com.donatenaccept.dna.utils.Constants;
import com.donatenaccept.dna.utils.Utility;


/**
 * Created by abhi on 17/04/17.
 */

public class EditProfileActivity extends Activity implements View.OnClickListener {


    ImageView iconLeft;
    TextView tv_title;
    TextView tvSubmit, tvBloodGroup;
    EditText etName, etPhone, etEmail, etAge, etAddress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_profile);

        setActionBarView();
        findViewById();
        initUi();

    }

    private void initUi() {
        ModelRegistration profileData = Utility.getProfileData(this, Constants.keyProfileData);

        etName.setText(profileData.getFull_name());
        etPhone.setText(profileData.getUser_mobile());
        etEmail.setText(profileData.getUser_email());
        etAge.setText(profileData.getUser_age());
        etAddress.setText("");
    }

    private void findViewById() {
        etName = (EditText) findViewById(R.id.signup_et_name);
        etPhone = (EditText) findViewById(R.id.signup_et_phone);
        etEmail = (EditText) findViewById(R.id.signup_et_email);
        etAge = (EditText) findViewById(R.id.signup_et_age);
        tvBloodGroup = (TextView) findViewById(R.id.signup_et_blood_group);
        etAddress = (EditText) findViewById(R.id.signup_et_address);


        tvSubmit = (TextView) findViewById(R.id.signup_tv_create);
        tvSubmit.setOnClickListener(this);

    }

    private void setActionBarView() {

        tv_title = (TextView) findViewById(R.id.actionbar_view_title);
        tv_title.setText("Edit Profile");

        iconLeft = (ImageView) findViewById(R.id.actionbar_view_icon_left);
        iconLeft.setVisibility(View.VISIBLE);
        iconLeft.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.actionbar_view_icon_left:
                finish();
                break;

            case R.id.signup_tv_create:
                break;

        }
    }
}
