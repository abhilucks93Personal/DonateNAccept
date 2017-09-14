package com.donatenaccept.dna._notifications;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.donatenaccept.dna.R;
import com.donatenaccept.dna._history.ResponseModelBloodHistory;
import com.donatenaccept.dna.retrofit.RetrofitApi;
import com.donatenaccept.dna.utils.Constants;
import com.donatenaccept.dna.utils.Utility;

import java.util.ArrayList;

import retrofit2.Response;


/**
 * Created by Abhi on 2/12/2017.
 */
public class NotificationFragment extends Fragment implements View.OnClickListener, RetrofitApi.ResponseListener {
    RecyclerView rvNotifications;
    ArrayList<ResponseModelNotificationData> notificationDatas;
    NotificationAdapter mAdapter;
    TextView tvNoNotification;
    ProgressBar progressBar;
    String userId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        findViewById(view);

        initUi();

        return view;
    }

    private void initUi() {

        progressBar.setVisibility(View.GONE);

        userId = Utility.getProfileData(getActivity(), Constants.keyProfileData).getUser_blood_group_id();

        notificationDatas = new ArrayList<>();
        mAdapter = new NotificationAdapter(getActivity(), R.layout.item_notification, notificationDatas);
        rvNotifications.setAdapter(mAdapter);

        getNotifications();


    }

    private void getNotifications() {

        progressBar.setVisibility(View.VISIBLE);

        //  RetrofitApi.getInstance().getNotificationsApi(getActivity(), this, userId);
    }

    private void findViewById(View view) {
        tvNoNotification = (TextView) view.findViewById(R.id.tv_no_history);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        rvNotifications = (RecyclerView) view.findViewById(R.id.rv_notifications);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

        }
    }

    private void updateUi() {
        if (notificationDatas.size() > 0) {
            tvNoNotification.setVisibility(View.GONE);
            rvNotifications.setVisibility(View.VISIBLE);
        } else {
            tvNoNotification.setVisibility(View.VISIBLE);
            rvNotifications.setVisibility(View.GONE);
        }
    }


    @Override
    public void _onNext(Object obj) {
        progressBar.setVisibility(View.GONE);
        ResponseModelNotification notification = (ResponseModelNotification) obj;
        if (notification.getCode().equals(Constants.codeSuccess)) {
            notificationDatas.clear();
            notificationDatas.addAll(notification.getData());
            mAdapter.notifyDataSetChanged();

            updateUi();
        } else {
            Utility.showToast(getActivity(), notification.getMessage());
        }
    }

    @Override
    public void _onCompleted() {

    }

    @Override
    public void _onError(Throwable e) {

    }
}
