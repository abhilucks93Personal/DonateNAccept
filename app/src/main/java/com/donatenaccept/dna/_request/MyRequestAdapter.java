package com.donatenaccept.dna._request;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.donatenaccept.dna.R;

import java.util.ArrayList;
import java.util.List;


public class MyRequestAdapter extends RecyclerView.Adapter<MyRequestAdapter.MyViewHolder> {

    private Activity context;
    private List<ResponseModelMyRequestData> myRequestDataList;
    private ArrayList<ResponseModelMyRequestData> selectedMyRequestDataList;
    private int mLayoutResourceId;


    public ArrayList<ResponseModelMyRequestData> getSelectedMyRequestDataList() {
        return selectedMyRequestDataList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvStatus;

        View convertView;


        MyViewHolder(View view) {
            super(view);
            convertView = view;

            tvStatus = (TextView) view.findViewById(R.id.tv_status);

        }
    }


    public MyRequestAdapter(Activity context, int mLayoutResourceId, List<ResponseModelMyRequestData> myRequestDataList) {
        this.myRequestDataList = myRequestDataList;
        this.mLayoutResourceId = mLayoutResourceId;
        this.context = context;
        selectedMyRequestDataList = new ArrayList<>();

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(mLayoutResourceId, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        // final ResponseModelMyRequestData myRequestData = myRequestDataList.get(position);
        if (position == 1) {
            holder.tvStatus.setText("Confirm");
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.colorGreen));
        }

        //holder.tvName.setText(myRequestData.getSub_service_name());


        holder.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // holder.tvRequest.setText("Request\nAccepted");
            }
        });

    }

    @Override
    public int getItemCount() {
        // return myRequestDataList.size();
        return 2;
    }


}