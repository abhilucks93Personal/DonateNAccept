package com.donatenaccept.dna._request;

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

public class AddRequestActivity extends Activity implements View.OnClickListener {


    ImageView iconLeft;
    TextView tv_title;
    ModelAddRequest modelAddRequest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_request);

        setActionBarView();
        findViewById();

    }

    private void findViewById() {

        TextView tvAdd = (TextView) findViewById(R.id.tv_add);
        tvAdd.setOnClickListener(this);
    }

    private void setActionBarView() {

        tv_title = (TextView) findViewById(R.id.actionbar_view_title);
        tv_title.setText("Add Request");

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

            case R.id.tv_add:
                fetchData();
                break;
        }
    }

    private void fetchData() {

        modelAddRequest = new ModelAddRequest();


    }
}
