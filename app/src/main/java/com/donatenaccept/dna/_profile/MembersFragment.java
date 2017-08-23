package com.donatenaccept.dna._profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.donatenaccept.dna.R;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


/**
 * Created by Abhi on 2/12/2017.
 */

public class MembersFragment extends Fragment implements View.OnClickListener {
    TextView tvAddMembers;
    LinearLayout llNoMembers;
    RelativeLayout rlMembers;
    ArrayList<ResponseModelMemberData> memberDatas;
    MemberAdapter mAdapter;
    RecyclerView rvMembers;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_members, container, false);

        findViewById(view);

        initUi();

        return view;
    }

    private void initUi() {
        memberDatas = new ArrayList<>();
        mAdapter = new MemberAdapter(getActivity(), R.layout.item_members, memberDatas);
        rvMembers.setAdapter(mAdapter);
    }

    private void findViewById(View view) {

        tvAddMembers = (TextView) view.findViewById(R.id.tv_add_members);
        tvAddMembers.setOnClickListener(this);

        llNoMembers = (LinearLayout) view.findViewById(R.id.ll_no_member);
        rlMembers = (RelativeLayout) view.findViewById(R.id.rl_members);

        rvMembers = (RecyclerView) view.findViewById(R.id.rv_members);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.tv_add_members:
                startActivityForResult(new Intent(getActivity(), AddMemberActivity.class), 101);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case 101:

                if (resultCode == RESULT_OK) {
                    rlMembers.setVisibility(View.VISIBLE);
                    llNoMembers.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
}
