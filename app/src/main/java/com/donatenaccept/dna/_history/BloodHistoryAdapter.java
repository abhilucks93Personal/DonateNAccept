package com.donatenaccept.dna._history;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class BloodHistoryAdapter extends RecyclerView.Adapter<BloodHistoryAdapter.MyViewHolder> {

    private Activity context;
    private List<ResponseModelBloodHistoryData> bloodHistoryDataList;
    private int mLayoutResourceId;


   

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvRequest;

        View convertView;


        MyViewHolder(View view) {
            super(view);
            convertView = view;

            // tvRequest = (TextView) view.findViewById(R.id.tv_request);

        }
    }


    public BloodHistoryAdapter(Activity context, int mLayoutResourceId, List<ResponseModelBloodHistoryData> bloodHistoryDataList) {
        this.bloodHistoryDataList = bloodHistoryDataList;
        this.mLayoutResourceId = mLayoutResourceId;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(mLayoutResourceId, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        // final ResponseModelBloodHistoryData bloodHistoryData = bloodHistoryDataList.get(position);


        //holder.tvName.setText(bloodHistoryData.getSub_service_name());


        holder.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // holder.tvRequest.setText("Request\nAccepted");
            }
        });

    }

    @Override
    public int getItemCount() {
        // return bloodHistoryDataList.size();
        return 2;
    }


}