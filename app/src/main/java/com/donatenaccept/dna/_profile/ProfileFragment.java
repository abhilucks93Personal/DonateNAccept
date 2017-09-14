package com.donatenaccept.dna._profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.donatenaccept.dna.R;
import com.donatenaccept.dna.login.ModelRegistration;
import com.donatenaccept.dna.utils.Constants;
import com.donatenaccept.dna.utils.Utility;

import java.text.BreakIterator;


/**
 * Created by ng on 2/12/2017.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {
    TabLayout tabLayout;
    ViewPager viewPager;
    ProfilePagerAdapter adapter;
    TextView tvName, tvBloodGroup;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        findViewById(view);

        initUi();

        return view;
    }

    private void findViewById(View view) {

        tvName = (TextView) view.findViewById(R.id.tv_name);
        tvBloodGroup = (TextView) view.findViewById(R.id.tv_blood_group);

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

        }
    }


    private void initUi() {

        ModelRegistration data = Utility.getProfileData(getActivity(), Constants.keyProfileData);
        if (data != null) {
            tvName.setText(data.getFull_name());
            tvBloodGroup.setText(data.getUser_blood_group());
        }


        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("More About Me"));
        tabLayout.addTab(tabLayout.newTab().setText("Members"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Creating our pager adapter
        adapter = new ProfilePagerAdapter(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void editProfile() {
        startActivity(new Intent(getActivity(),EditProfileActivity.class));
    }
}
