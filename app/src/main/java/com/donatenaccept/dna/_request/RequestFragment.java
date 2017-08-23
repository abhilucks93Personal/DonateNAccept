package com.donatenaccept.dna._request;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.donatenaccept.dna.R;
import com.donatenaccept.dna._home.BloodRequestAdapter;
import com.donatenaccept.dna._home.ResponseModelBloodRequestData;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


/**
 * Created by Abhi on 2/12/2017.
 */
public class RequestFragment extends Fragment implements View.OnClickListener {
    RecyclerView rvMyRequest;
    ArrayList<ResponseModelMyRequestData> myRequestDatas;
    MyRequestAdapter mAdapterMyRequest;

    RecyclerView rvBloodRequest;
    ArrayList<ResponseModelBloodRequestData> bloodRequestDatas;
    BloodRequestAdapter mAdapterBloodRequest;

    TextView tvNoRequest;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_request, container, false);

        findViewById(view);

        initUi();

        return view;
    }

    private void initUi() {
        myRequestDatas = new ArrayList<>();
        mAdapterMyRequest = new MyRequestAdapter(getActivity(), R.layout.item_my_request, myRequestDatas);
        rvMyRequest.setAdapter(mAdapterMyRequest);

        bloodRequestDatas = new ArrayList<>();
        mAdapterBloodRequest = new BloodRequestAdapter(getActivity(), R.layout.item_blood_request, bloodRequestDatas, 1);
        rvBloodRequest.setAdapter(mAdapterBloodRequest);

    }

    private void findViewById(View view) {

        tvNoRequest = (TextView) view.findViewById(R.id.tv_no_request);
        rvMyRequest = (RecyclerView) view.findViewById(R.id.rv_my_request);
        rvMyRequest.setNestedScrollingEnabled(false);
        rvBloodRequest = (RecyclerView) view.findViewById(R.id.rv_blood_request);
        rvBloodRequest.setNestedScrollingEnabled(false);
    }

    public void addRequest() {
        startActivityForResult(new Intent(getActivity(), AddRequestActivity.class), 101);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case 101:
                if (resultCode == RESULT_OK) {

                }
                break;
        }
    }
}
