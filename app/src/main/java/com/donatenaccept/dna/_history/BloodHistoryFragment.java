package com.donatenaccept.dna._history;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.donatenaccept.dna.R;
import com.donatenaccept.dna._memories.ResponseModelMemories;
import com.donatenaccept.dna.retrofit.RetrofitApi;
import com.donatenaccept.dna.utils.Constants;
import com.donatenaccept.dna.utils.Utility;

import java.util.ArrayList;


/**
 * Created by Abhi on 2/12/2017.
 */
public class BloodHistoryFragment extends Fragment implements View.OnClickListener, RetrofitApi.ResponseListener {
    RecyclerView rvBloodHistory;
    ArrayList<ResponseModelBloodHistoryData> bloodHistoryDatas;
    BloodHistoryAdapter mAdapter;
    ProgressBar progressBar;
    String userId;
    TextView tvNoHistory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blood_history, container, false);

        findViewById(view);

        initUi();

        return view;
    }

    private void initUi() {

        progressBar.setVisibility(View.GONE);

        userId = Utility.getProfileData(getActivity(), Constants.keyProfileData).getUser_blood_group_id();

        bloodHistoryDatas = new ArrayList<>();
        mAdapter = new BloodHistoryAdapter(getActivity(), R.layout.item_blood_history, bloodHistoryDatas);
        rvBloodHistory.setAdapter(mAdapter);

        getHistories();
    }

    private void findViewById(View view) {

        tvNoHistory = (TextView) view.findViewById(R.id.tv_no_history);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        rvBloodHistory = (RecyclerView) view.findViewById(R.id.rv_blood_history);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

        }
    }

    private void getHistories() {

        progressBar.setVisibility(View.VISIBLE);

      //  RetrofitApi.getInstance().getHistoryApi(getActivity(), this, userId);
    }

    private void updateUi() {
        if (bloodHistoryDatas.size() > 0) {
            tvNoHistory.setVisibility(View.GONE);
            rvBloodHistory.setVisibility(View.VISIBLE);
        } else {
            tvNoHistory.setVisibility(View.VISIBLE);
            rvBloodHistory.setVisibility(View.GONE);
        }
    }


    @Override
    public void _onNext(Object obj) {
        progressBar.setVisibility(View.GONE);
        ResponseModelBloodHistory history = (ResponseModelBloodHistory) obj;
        if (history.getCode().equals(Constants.codeSuccess)) {
            bloodHistoryDatas.clear();
            bloodHistoryDatas.addAll(history.getData());
            mAdapter.notifyDataSetChanged();

            updateUi();
        } else {
            Utility.showToast(getActivity(), history.getMessage());
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
