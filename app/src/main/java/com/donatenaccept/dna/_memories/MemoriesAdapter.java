package com.donatenaccept.dna._memories;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.donatenaccept.dna.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class MemoriesAdapter extends RecyclerView.Adapter<MemoriesAdapter.MyViewHolder> {

    private Activity context;
    private List<ResponseModelMemoriesData> memoriesDataList;
    private int mLayoutResourceId;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvContent;
        ImageView ivImage;

        View convertView;


        MyViewHolder(View view) {
            super(view);
            convertView = view;

            tvContent = (TextView) view.findViewById(R.id.tv_content);
            ivImage = (ImageView) view.findViewById(R.id.iv_image);
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
        final ResponseModelMemoriesData memoriesData = memoriesDataList.get(position);
        holder.tvContent.setText(memoriesData.getDescription());
        Picasso.with(context).load(memoriesData.getImage_url()).into(holder.ivImage);

    }

    @Override
    public int getItemCount() {
        return memoriesDataList.size();
        // return 1;
    }


}