package com.example.islam.project_management.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.islam.project_management.Models.ActivityModel;
import com.example.islam.project_management.R;

/**
 * Created by islam on 15/03/17.
 */

public class ActivityViewHolder extends RecyclerView.ViewHolder {

    View mView;
    private TextView date;
    private TextView duration;
    private TextView user;

    public ActivityViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
    }

    public void setData(final ActivityModel item) {
        date = (TextView) mView.findViewById(R.id.activitydate);
        duration = (TextView) mView.findViewById(R.id.activityduration);
        user = (TextView) mView.findViewById(R.id.activityuser);
        date.setText(item.getDate());
        duration.setText(item.getDuration());
        user.setText(item.getUser());
    }
}
