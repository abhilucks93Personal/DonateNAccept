package com.donatenaccept.dna._notifications;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.donatenaccept.dna.R;

import java.util.List;


public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private Activity context;
    private List<ResponseModelNotificationData> notificationDataList;
    private int mLayoutResourceId;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;

        View convertView;


        MyViewHolder(View view) {
            super(view);
            convertView = view;

            tvText = (TextView) view.findViewById(R.id.tv_text);

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
        // final ResponseModelNotificationData notificationData = notificationDataList.get(position);


        //holder.tvName.setText(notificationData.getSub_service_name());


        SpannableString styledString
                = new SpannableString("John Appleseeds requires Blood (B-). Its time to save a life.");   // index 103 - 112

        // make text bold
        styledString.setSpan(new StyleSpan(Typeface.BOLD), 0, 15, 0);

        styledString.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 15, 0);

        holder.tvText.setText(styledString);


        holder.convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // holder.tvRequest.setText("Request\nAccepted");
            }
        });

    }

    @Override
    public int getItemCount() {
        // return notificationDataList.size();
        return 1;
    }


}