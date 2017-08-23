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

import com.donatenaccept.dna.R;

import java.util.ArrayList;


/**
 * Created by Abhi on 2/12/2017.
 */
public class NotificationFragment extends Fragment implements View.OnClickListener {
    RecyclerView rvNotifications;
    ArrayList<ResponseModelNotificationData> notificationDatas;
    NotificationAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        findViewById(view);

        initUi();

        return view;
    }

    private void initUi() {
        notificationDatas = new ArrayList<>();
        mAdapter = new NotificationAdapter(getActivity(), R.layout.item_notification, notificationDatas);
        rvNotifications.setAdapter(mAdapter);



    }

    private void findViewById(View view) {

        rvNotifications = (RecyclerView) view.findViewById(R.id.rv_notifications);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

        }
    }


}
