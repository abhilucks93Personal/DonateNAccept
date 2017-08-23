package com.donatenaccept.dna.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.donatenaccept.dna.R;
import com.donatenaccept.dna.parent.BaseActivity;
import com.donatenaccept.dna.utils.Utility;


/**
 * Created by abhi on 17/04/17.
 */

public class ForgotPasswordActivity extends BaseActivity implements View.OnClickListener {


    ImageView ivBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utility.setStatusBarTranslucent(this, true);
        setContentView(R.layout.activity_forgot_password);

        findViewById();

    }

    private void findViewById() {

        ivBack = (ImageView) findViewById(R.id.iv_back);
        ivBack.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.iv_back:
                finish();
                break;
        }
    }
}
