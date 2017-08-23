package com.donatenaccept.dna._setting.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.donatenaccept.dna.R;


/**
 * Created by abhi on 17/04/17.
 */

public class ChangePasswordActivity extends Activity implements View.OnClickListener {


    ImageView iconLeft, iconRight;
    TextView tv_title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_change_password);

        setActionBarView();
        findViewById();

    }

    private void findViewById() {


    }

    private void setActionBarView() {

        tv_title = (TextView) findViewById(R.id.actionbar_view_title);
        tv_title.setText("Change Password");

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


        }
    }
}
