package com.donatenaccept.dna._memories;

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

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


/**
 * Created by Abhi on 2/12/2017.
 */
public class MemoriesFragment extends Fragment implements View.OnClickListener {
    RecyclerView rvMemories;
    ArrayList<ResponseModelMemoriesData> memoriesDatas;
    MemoriesAdapter mAdapter;
    TextView tvNoMemories;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_memories, container, false);

        findViewById(view);

        initUi();

        return view;
    }

    private void initUi() {
        memoriesDatas = new ArrayList<>();
        mAdapter = new MemoriesAdapter(getActivity(), R.layout.item_memories, memoriesDatas);
        rvMemories.setAdapter(mAdapter);

        rvMemories.setVisibility(View.VISIBLE);
    }

    public void addMemories() {
        startActivityForResult(new Intent(getActivity(), AddMemoryActivity.class), 101);
    }

    private void findViewById(View view) {

        tvNoMemories = (TextView) view.findViewById(R.id.tv_no_memories);
        rvMemories = (RecyclerView) view.findViewById(R.id.rv_memories);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){

            case 101:
                if(resultCode==RESULT_OK){
                   // tvNoMemories.setVisibility(View.GONE);
                   // rvMemories.setVisibility(View.VISIBLE);
                }
                break;
        }
    }
}
