package com.example.islam.project_management.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islam.project_management.Adapters.ProjectsAdapter;
import com.example.islam.project_management.Models.ProjectModel;
import com.example.islam.project_management.ProjectDetailsActivity;
import com.example.islam.project_management.R;
import com.example.islam.project_management.RxFirebase.Authenticator;
import com.example.islam.project_management.RxFirebase.RxFireBaseDB;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.LinkedList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private RecyclerView recyclerView;
    private RxFireBaseDB fireBaseDB;
    private List<ProjectModel> projectModels;
    private ProjectsAdapter adapter;
    private Authenticator authenticator;
    private DatabaseReference databaseReference;
    private String companyId;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.projectsView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        fireBaseDB = new RxFireBaseDB();
        projectModels = new LinkedList<>();
        authenticator=Authenticator.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();


        RxFireBaseDB.observeValueEvent(databaseReference.child("Users").child(authenticator.getUserID()).child("companyId"))
                .subscribe(dataSnapshot -> {

                    companyId = dataSnapshot.getValue(String.class);
                    getProjects();
                }, throwable -> {
                    Log.e("error in company", throwable.toString());
                });

        return view;
    }

    public void getProjects() {
        RxFireBaseDB.observeValueEvent(databaseReference.child(companyId).child("projects").child("project1ID"))
                .subscribe(dataSnapshot -> {
                    Log.e("retrieving projects", dataSnapshot.toString());
                    projectModels.clear();
                    for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                        ProjectModel projectModel = singleSnapshot.getValue(ProjectModel.class);
                        projectModels.add(projectModel);
                        Log.e("model", projectModel.toString());
                    }

                    adapter = new ProjectsAdapter(projectModels);
                    adapter.setProjectSelectedlistener(projectModel -> {
                        Intent intent = new Intent(getActivity(), ProjectDetailsActivity.class);
                        intent.putExtra("project", projectModel);
                        startActivity(intent);
                    });
                    recyclerView.setAdapter(adapter);
                }, throwable -> {
                    Log.e("error in projects", throwable.toString());
                });
    }
}
