package com.donatenaccept.dna._home;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.donatenaccept.dna.R;

import java.util.ArrayList;
import java.util.List;


public class BloodRequestAdapter extends RecyclerView.Adapter<BloodRequestAdapter.MyViewHolder> {

    private Activity context;
    private List<ResponseModelBloodRequestData> bloodRequestDataList;
    private ArrayList<ResponseModelBloodRequestData> selectedBloodRequestDataList;
    private int mLayoutResourceId;
    int count;


    public ArrayList<ResponseModelBloodRequestData> getSelectedBloodRequestDataList() {
        return selectedBloodRequestDataList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvRequest;
        ImageView ivAccept, ivCall;
        LinearLayout llAction;

        View convertView;


        MyViewHolder(View view) {
            super(view);
            convertView = view;

            tvRequest = (TextView) view.findViewById(R.id.tv_request);
            ivAccept = (ImageView) view.findViewById(R.id.iv_accept);
            ivCall = (ImageView) view.findViewById(R.id.iv_call);
            llAction = (LinearLayout) view.findViewById(R.id.ll_action);

        }
    }


    public BloodRequestAdapter(Activity context, int mLayoutResourceId, List<ResponseModelBloodRequestData> bloodRequestDataList, int count) {
        this.bloodRequestDataList = bloodRequestDataList;
        this.mLayoutResourceId = mLayoutResourceId;
        this.context = context;
        this.count = count;
        selectedBloodRequestDataList = new ArrayList<>();

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(mLayoutResourceId, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        // final ResponseModelBloodRequestData bloodRequestData = bloodRequestDataList.get(position);


        //holder.tvName.setText(bloodRequestData.getSub_service_name());

        if (count == 1) {
            holder.llAction.setVisibility(View.GONE);
            holder.tvRequest.setVisibility(View.VISIBLE);
        }

        holder.ivAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.llAction.setVisibility(View.GONE);
                holder.tvRequest.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public int getItemCount() {
        // return bloodRequestDataList.size();
        return count;
    }


}