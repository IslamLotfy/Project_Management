package com.example.islam.project_management.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islam.project_management.Models.ProjectModel;
import com.example.islam.project_management.ProjectSelectedlistener;
import com.example.islam.project_management.R;

import java.util.List;

/**
 * Created by islam on 12/03/17.
 */

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsViewHolder> {

    private List<ProjectModel> list;
    private ProjectSelectedlistener ProjectSelectedlistener;

    public ProjectsAdapter(List<ProjectModel> list) {
        this.list = list;
    }

    @Override
    public ProjectsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.projecst_view_item, parent, false);
        return new ProjectsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProjectsViewHolder holder, int position) {
        ProjectModel projectModel = list.get(position);
        holder.setData(projectModel);
        holder.itemView.setOnClickListener(view -> {
            ProjectSelectedlistener.onItemClicked(list.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setProjectSelectedlistener(ProjectSelectedlistener projectSelectedlistener) {
        this.ProjectSelectedlistener = projectSelectedlistener;
    }
}
