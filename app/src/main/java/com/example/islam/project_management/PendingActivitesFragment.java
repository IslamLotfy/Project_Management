package com.example.islam.project_management;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.islam.project_management.Adapters.ActivityAdapter;
import com.example.islam.project_management.Models.ProjectModel;

/**
 * Created by islam on 15/03/17.
 */

public class PendingActivitesFragment extends android.support.v4.app.Fragment {
    private ActivityAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ProjectModel model = (ProjectModel) getActivity().getIntent().getSerializableExtra("project");
        adapter = new ActivityAdapter(model.getPendingActivity());
        Toast.makeText(getActivity(), model.toString(), Toast.LENGTH_SHORT).show();
        adapter.setListener(activityModel -> {
            Toast.makeText(getActivity(), activityModel.toString(), Toast.LENGTH_SHORT).show();
        });
        recyclerView.setAdapter(adapter);
        return view;
    }
}
