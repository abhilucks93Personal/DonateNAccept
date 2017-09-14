package com.donatenaccept.dna._profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.donatenaccept.dna.R;
import com.donatenaccept.dna.login.ModelRegistration;
import com.donatenaccept.dna.utils.Constants;
import com.donatenaccept.dna.utils.Utility;


/**
 * Created by ng on 2/12/2017.
 */
public class AboutMeFragment extends Fragment implements View.OnClickListener {
    TextView tvEmail, tvNumber, tvAge, tvAddress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_me, container, false);

        findViewById(view);

        initUi();

        return view;
    }

    private void initUi() {
        ModelRegistration data = Utility.getProfileData(getActivity(), Constants.keyProfileData);
        if (data != null) {
            tvEmail.setText(data.getUser_email());
            tvNumber.setText(data.getUser_mobile());
            tvAge.setText(data.getUser_age());
            tvAddress.setText("");
        }
    }

    private void findViewById(View view) {

        tvEmail = (TextView) view.findViewById(R.id.tv_email);
        tvNumber = (TextView) view.findViewById(R.id.tv_number);
        tvAge = (TextView) view.findViewById(R.id.tv_age);
        tvAddress = (TextView) view.findViewById(R.id.tv_address);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

        }
    }

}
