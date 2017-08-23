package com.donatenaccept.dna._history;

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
 * Created by Abhi on 2/12/2017.
 */
public class BloodHistoryFragment extends Fragment implements View.OnClickListener {
    RecyclerView rvBloodHistory;
    ArrayList<ResponseModelBloodHistoryData> bloodHistoryDatas;
    BloodHistoryAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blood_history, container, false);

        findViewById(view);

        initUi();

        return view;
    }

    private void initUi() {
        bloodHistoryDatas = new ArrayList<>();
        mAdapter = new BloodHistoryAdapter(getActivity(), R.layout.item_blood_history, bloodHistoryDatas);
        rvBloodHistory.setAdapter(mAdapter);
    }

    private void findViewById(View view) {

        rvBloodHistory = (RecyclerView) view.findViewById(R.id.rv_blood_history);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

        }
    }


}
