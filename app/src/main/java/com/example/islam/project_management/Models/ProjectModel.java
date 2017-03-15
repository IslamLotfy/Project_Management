package com.example.islam.project_management.Models;

/**
 * Created by islam on 09/03/17.
 */

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Ali on 3/8/2017.
 */

public class ProjectModel implements Serializable {

    private Map<String, ActivityModel> approvedActivity;
    private Map<String, ActivityModel> pendingActivity;
    private List<String> Users;

    private String deadline;
    private String hourRate;
    private String name;
    private String projectId;

    ProjectModel() {
    }

    public ProjectModel(Map<String, ActivityModel> approvedActivity, Map<String, ActivityModel> pendingActivity, List<String> users, String deadline, String hourRate, String name, String projectId) {
        this.approvedActivity = approvedActivity;
        this.pendingActivity = pendingActivity;
        Users = users;
        this.deadline = deadline;
        this.hourRate = hourRate;
        this.name = name;
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "ProjectModel{" +
                "approvedActivity=" + approvedActivity +
                ", pendingActivity=" + pendingActivity +
                ", deadline='" + deadline + '\'' +
                ", hourRate='" + hourRate + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Map<String, ActivityModel> getApprovedActivity() {
        return approvedActivity;
    }

    public void setApprovedActivity(Map<String, ActivityModel> approvedActivity) {
        this.approvedActivity = approvedActivity;
    }

    public Map<String, ActivityModel> getPendingActivity() {
        return pendingActivity;
    }

    public void setPendingActivity(Map<String, ActivityModel> pendingActivity) {
        this.pendingActivity = pendingActivity;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getHourRate() {
        return hourRate;
    }

    public void setHourRate(String hourRate) {
        this.hourRate = hourRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public List<String> getUsers() {
        return Users;
    }

    public void setUsers(List<String> users) {
        Users = users;
    }
}