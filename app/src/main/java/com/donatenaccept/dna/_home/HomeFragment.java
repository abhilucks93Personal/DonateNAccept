package com.donatenaccept.dna._home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donatenaccept.dna.R;

import java.util.ArrayList;

/**
 * Created by abhi on 10/07/17.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {

    RecyclerView rvBloodRequest;
    ArrayList<ResponseModelBloodRequestData> bloodRequestDatas;
    BloodRequestAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        findViewById(view);

        initUi();

        return view;
    }

    private void initUi() {
        bloodRequestDatas = new ArrayList<>();
        mAdapter = new BloodRequestAdapter(getActivity(), R.layout.item_blood_request, bloodRequestDatas, 8);
        rvBloodRequest.setAdapter(mAdapter);
    }

    private void findViewById(View view) {

        rvBloodRequest = (RecyclerView) view.findViewById(R.id.rv_blood_request);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

        }
    }


}
