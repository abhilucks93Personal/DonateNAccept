package com.donatenaccept.dna._memories;

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

public class AddMemoryActivity extends Activity implements View.OnClickListener {


    ImageView iconLeft;
    TextView tvRight;
    TextView tv_title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_memories);

        setActionBarView();
        findViewById();

    }

    private void findViewById() {


    }

    private void setActionBarView() {

        tv_title = (TextView) findViewById(R.id.actionbar_view_title);
        tv_title.setText("Add Memories");

        iconLeft = (ImageView) findViewById(R.id.actionbar_view_icon_left);
        iconLeft.setVisibility(View.VISIBLE);
        iconLeft.setOnClickListener(this);

        tvRight = (TextView) findViewById(R.id.actionbar_view_tv_right);
        tvRight.setText("Post");
        tvRight.setVisibility(View.VISIBLE);
        tvRight.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.actionbar_view_icon_left:
                finish();
                break;

            case R.id.actionbar_view_tv_right:
                setResult(RESULT_OK);
                finish();
                break;


        }
    }
}
