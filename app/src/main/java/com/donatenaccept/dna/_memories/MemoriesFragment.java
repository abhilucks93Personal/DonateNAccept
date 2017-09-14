package com.donatenaccept.dna._memories;

import android.Manifest;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;

import com.donatenaccept.dna.R;
import com.donatenaccept.dna.crop.CropActivity;
import com.donatenaccept.dna.login.SignUpActivity;
import com.donatenaccept.dna.retrofit.RetrofitApi;
import com.donatenaccept.dna.utils.Constants;
import com.donatenaccept.dna.utils.Utility;
import com.theartofdev.edmodo.cropper.CropImage;

import java.util.ArrayList;
import java.util.Calendar;

import static android.R.attr.data;
import static android.app.Activity.RESULT_OK;


/**
 * Created by Abhi on 2/12/2017.
 */
public class MemoriesFragment extends Fragment implements View.OnClickListener, RetrofitApi.ResponseListener {
    RecyclerView rvMemories;
    ArrayList<ResponseModelMemoriesData> memoriesDatas;
    MemoriesAdapter mAdapter;
    TextView tvNoMemories;
    Bundle bundle;
    AlertDialog dialog;
    ProgressBar progressBar;

    public static String readExternalPermission = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static String writeExternalPermission = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public static String cameraPermission = Manifest.permission.CAMERA;
    public static int galleryRequestCode = 51;
    public static int cameraRequestCode = 52;
    public static final int SELECT_FILE = 200;
    public static final int REQUEST_CAMERA = 100;
    Uri mCapturedImageURI;
    String userId = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_memories, container, false);
        bundle = savedInstanceState;

        findViewById(view);

        initUi();

        return view;
    }

    private void initUi() {

        progressBar.setVisibility(View.GONE);

        userId = Utility.getProfileData(getActivity(), Constants.keyProfileData).getUser_blood_group_id();

        memoriesDatas = new ArrayList<>();
        mAdapter = new MemoriesAdapter(getActivity(), R.layout.item_memories, memoriesDatas);
        rvMemories.setAdapter(mAdapter);

        getMemories();


    }

    private void getMemories() {

        progressBar.setVisibility(View.VISIBLE);

        //  RetrofitApi.getInstance().getMemoriesApi(getActivity(), this, userId);
    }

    public void addMemories() {

        showImageDialog();


    }

    private void showImageDialog() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = this.getLayoutInflater(bundle);
        View dialogView = inflater.inflate(R.layout.dialog_pick_image, null);
        dialogBuilder.setView(dialogView);

        TextView dialog_gallery = (TextView) dialogView.findViewById(R.id.dialog_pick_image_tv_gallery);
        dialog_gallery.setOnClickListener(this);
        TextView dialog_camera = (TextView) dialogView.findViewById(R.id.dialog_pick_image_tv_camera);
        dialog_camera.setOnClickListener(this);

        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();

    }


    private void findViewById(View view) {

        tvNoMemories = (TextView) view.findViewById(R.id.tv_no_memories);
        rvMemories = (RecyclerView) view.findViewById(R.id.rv_memories);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.dialog_pick_image_tv_gallery:
                if (dialog.isShowing())
                    dialog.dismiss();
                galleryIntent();
                break;

            case R.id.dialog_pick_image_tv_camera:
                if (dialog.isShowing())
                    dialog.dismiss();
                cameraIntent();
                break;

        }
    }

    public void cameraIntent() {
        if (Utility.checkPermissions(getActivity(), readExternalPermission, writeExternalPermission, cameraPermission)) {
            ContentValues values = new ContentValues();
            values.put(MediaStore.MediaColumns.TITLE, getActivity().getPackageName());
            mCapturedImageURI = getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraIntent.putExtra(MediaStore.EXTRA_SCREEN_ORIENTATION, ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, mCapturedImageURI);
            startActivityForResult(cameraIntent, REQUEST_CAMERA);
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{readExternalPermission, writeExternalPermission, cameraPermission}, cameraRequestCode);
        }
    }

    public void galleryIntent() {
        if (Utility.checkPermissions(getActivity(), readExternalPermission, writeExternalPermission, cameraPermission)) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);//
            startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{readExternalPermission, writeExternalPermission, cameraPermission}, galleryRequestCode);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case 101:
                if (resultCode == RESULT_OK) {
                    ResponseModelMemoriesData memoriesData = (ResponseModelMemoriesData) data.getSerializableExtra("data");
                    memoriesDatas.add(0, memoriesData);
                    mAdapter.notifyDataSetChanged();
                    updateUi();

                }
                break;

            case 100:
                if (resultCode == RESULT_OK) {
                    startActivityForResult(new Intent(getActivity(), CropActivity.class)
                            .putExtra("uri", mCapturedImageURI), 500);
                }
                break;

            case 200:
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if (resultCode == RESULT_OK) {
                    Uri imageUri = CropImage.getPickImageResultUri(getActivity(), data);
                    startActivityForResult(new Intent(getActivity(), CropActivity.class)
                            .putExtra("uri", imageUri), 500);
                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    Exception error = result.getError();
                }
                break;

            case 500:
                if (resultCode == RESULT_OK) {
                    Uri imageUri = data.getParcelableExtra("URI");

                    startActivityForResult(new Intent(getActivity(), AddMemoryActivity.class)
                            .putExtra("uri", imageUri.toString()), 101);
                }
                break;
        }
    }

    @Override
    public void _onNext(Object obj) {
        progressBar.setVisibility(View.GONE);
        ResponseModelMemories memories = (ResponseModelMemories) obj;
        if (memories.getCode().equals(Constants.codeSuccess)) {
            memoriesDatas.clear();
            memoriesDatas.addAll(memories.getData());
            mAdapter.notifyDataSetChanged();

            updateUi();
        } else {
            Utility.showToast(getActivity(), memories.getMessage());
        }

    }

    private void updateUi() {
        if (memoriesDatas.size() > 0) {
            tvNoMemories.setVisibility(View.GONE);
            rvMemories.setVisibility(View.VISIBLE);
        } else {
            tvNoMemories.setVisibility(View.VISIBLE);
            rvMemories.setVisibility(View.GONE);
        }
    }

    @Override
    public void _onCompleted() {

    }

    @Override
    public void _onError(Throwable e) {
        progressBar.setVisibility(View.GONE);
    }
}
