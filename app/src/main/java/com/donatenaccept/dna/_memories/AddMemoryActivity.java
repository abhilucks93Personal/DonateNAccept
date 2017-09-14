package com.donatenaccept.dna._memories;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.donatenaccept.dna.R;
import com.donatenaccept.dna.retrofit.RetrofitApi;
import com.donatenaccept.dna.utils.Constants;
import com.donatenaccept.dna.utils.Utility;


/**
 * Created by abhi on 17/04/17.
 */

public class AddMemoryActivity extends Activity implements View.OnClickListener, RetrofitApi.ResponseListener {


    ImageView iconLeft;
    TextView tvRight;
    TextView tv_title;
    ImageView ivImage;
    EditText etContent;
    Uri imageUri;
    String receiverId, donorId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_memories);

        setActionBarView();
        findViewById();

        initUi();

    }

    private void initUi() {
        imageUri = Uri.parse(getIntent().getStringExtra("uri"));
        ivImage.setImageURI(imageUri);
    }

    private void findViewById() {

        ivImage = (ImageView) findViewById(R.id.iv_image);
        etContent = (EditText) findViewById(R.id.et_content);

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

                fetchData();

                break;


        }
    }

    private void fetchData() {

        String image = Utility.getEncoded64ImageStringFromUri(this, imageUri);
        String description = etContent.getText().toString().trim();

        //  RetrofitApi.getInstance().addMemoriesApi(this, this, receiverId, donorId, image, description);
    }

    @Override
    public void _onNext(Object obj) {
        ResponseModelAddMemory memory = (ResponseModelAddMemory) obj;
        if (memory.getCode().equals(Constants.codeSuccess)) {
            Intent intent = new Intent();
            intent.putExtra("data", memory.getData());
            setResult(RESULT_OK, intent);
            finish();
        } else {
            Utility.showToast(AddMemoryActivity.this, memory.getMessage());
        }
    }

    @Override
    public void _onCompleted() {

    }

    @Override
    public void _onError(Throwable e) {

    }
}
