package com.example.islam.project_management.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islam.project_management.ActivitySelectedListener;
import com.example.islam.project_management.Models.ActivityModel;
import com.example.islam.project_management.R;

import java.util.List;

/**
 * Created by islam on 15/03/17.
 */

public class ActivityAdapter extends RecyclerView.Adapter<ActivityViewHolder> {

    private List<ActivityModel> list;
    private ActivitySelectedListener listener;

    public ActivityAdapter(List<ActivityModel> list) {
        this.list = list;
    }

    @Override
    public ActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_item, parent, false);
        return new ActivityViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ActivityViewHolder holder, int position) {
        ActivityModel model = list.get(position);
        holder.setData(model);
        holder.itemView.setOnClickListener(view -> {
            listener.onActivtySelected(list.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setListener(ActivitySelectedListener listener) {
        this.listener = listener;
    }
}
