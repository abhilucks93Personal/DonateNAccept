package com.donatenaccept.dna._notifications;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.donatenaccept.dna.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private Activity context;
    private List<ResponseModelNotificationData> notificationDataList;
    private int mLayoutResourceId;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;
        ImageView ivImage;

        View convertView;


        MyViewHolder(View view) {
            super(view);
            convertView = view;

            tvText = (TextView) view.findViewById(R.id.tv_text);
            ivImage = (ImageView) view.findViewById(R.id.iv_profile);

        }
    }

    public NotificationAdapter(Activity context, int mLayoutResourceId, List<ResponseModelNotificationData> notificationDataList) {
        this.notificationDataList = notificationDataList;
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
        final ResponseModelNotificationData notificationData = notificationDataList.get(position);

        holder.tvText.setText(notificationData.getDescription());
        Picasso.with(context).load(notificationData.getImage_url()).into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return notificationDataList.size();
        //return 1;
    }


}