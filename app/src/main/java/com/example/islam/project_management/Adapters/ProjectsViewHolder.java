package com.example.islam.project_management.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.islam.project_management.Models.ProjectModel;
import com.example.islam.project_management.R;

/**
 * Created by islam on 12/03/17.
 */

public class ProjectsViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView deadline;
    private View mView;

    public ProjectsViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
    }

    public void setData(final ProjectModel item) {
        title = (TextView) mView.findViewById(R.id.projecttitle);
        deadline = (TextView) mView.findViewById(R.id.projectdeadline);
        title.setText(item.getName());
        deadline.setText(item.getDeadline());
    }
}
