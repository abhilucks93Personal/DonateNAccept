package com.donatenaccept.dna.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.donatenaccept.dna.R;
import com.donatenaccept.dna.navigation.NavigationActivity;
import com.donatenaccept.dna.parent.BaseActivity;
import com.donatenaccept.dna.utils.Constants;
import com.donatenaccept.dna.utils.Utility;

import java.util.ArrayList;


/**
 * Created by abhi on 17/04/17.
 */

public class OTPActivity extends BaseActivity implements View.OnClickListener {


    ImageView ivBack;
    TextView tvDone;
    private EditText etOtp1, etOtp2, etOtp3, etOtp4;
    ArrayList<EditText> etOtps = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utility.setStatusBarTranslucent(this, true);
        setContentView(R.layout.activity_otp);

        findViewById();

        setOtpTextWatcher();

    }

    private void setOtpTextWatcher() {
        etOtp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    etOtp2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etOtp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    etOtp3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etOtp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    etOtp4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etOtp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void findViewById() {

        ivBack = (ImageView) findViewById(R.id.iv_back);
        ivBack.setOnClickListener(this);

        etOtp1 = (EditText) findViewById(R.id.otp_et1);
        etOtps.add(etOtp1);
        etOtp2 = (EditText) findViewById(R.id.otp_et2);
        etOtps.add(etOtp2);
        etOtp3 = (EditText) findViewById(R.id.otp_et3);
        etOtps.add(etOtp3);
        etOtp4 = (EditText) findViewById(R.id.otp_et4);
        etOtps.add(etOtp4);

        tvDone = (TextView) findViewById(R.id.otp_tv_done);
        tvDone.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.iv_back:
                finish();
                break;

            case R.id.otp_tv_done:
                Utility.addPreferences(OTPActivity.this, Constants.keyLoginCheck, true);
                startActivity(new Intent(OTPActivity.this, NavigationActivity.class));
                finishAffinity();
                break;
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_DEL &&
                event.getAction() == KeyEvent.ACTION_UP) {
            if (etOtp4.hasFocus()) {
                etOtp3.requestFocus();
                etOtp3.setText("");
                return true;
            } else if (etOtp3.hasFocus()) {
                etOtp2.requestFocus();
                etOtp2.setText("");
                return true;
            } else if (etOtp2.hasFocus()) {
                etOtp1.requestFocus();
                etOtp1.setText("");
                return true;
            } else {
                return super.dispatchKeyEvent(event);
            }
        } else {
            return super.dispatchKeyEvent(event);
        }

    }


}
