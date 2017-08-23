package com.donatenaccept.dna._memories;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MemoriesAdapter extends RecyclerView.Adapter<MemoriesAdapter.MyViewHolder> {

    private Activity context;
    private List<ResponseModelMemoriesData> memoriesDataList;
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


    public MemoriesAdapter(Activity context, int mLayoutResourceId, List<ResponseModelMemoriesData> memoriesDataList) {
        this.memoriesDataList = memoriesDataList;
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
        // final ResponseModelMemoriesData memoriesData = memoriesDataList.get(position);


        //holder.tvName.setText(memoriesData.getSub_service_name());


        holder.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // holder.tvRequest.setText("Request\nAccepted");
            }
        });

    }

    @Override
    public int getItemCount() {
        // return memoriesDataList.size();
        return 1;
    }


}