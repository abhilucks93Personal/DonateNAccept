package com.donatenaccept.dna._profile;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MyViewHolder> {

    private Activity context;
    private List<ResponseModelMemberData> memberDataList;

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


    public MemberAdapter(Activity context, int mLayoutResourceId, List<ResponseModelMemberData> memberDataList) {
        this.memberDataList = memberDataList;
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
        // final ResponseModelMemberData = memberDataList.get(position);


        //holder.tvName.setText(bloodRequestData.getSub_service_name());




    }

    @Override
    public int getItemCount() {
        // returnmemberDataList.size();
        return 1;
    }


}