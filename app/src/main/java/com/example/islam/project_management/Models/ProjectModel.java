package com.example.islam.project_management.Models;

/**
 * Created by islam on 09/03/17.
 */

import java.util.List;

/**
 * Created by Ali on 3/8/2017.
 */

public class ProjectModel {
    @Override
    public String toString() {
        return "ProjectModel{" +
                "approvedActivity=" + approvedActivity +
                ", pendActivity=" + pendActivity +
                ", deadline='" + deadline + '\'' +
                ", hourRate='" + hourRate + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    List<ActivityModel> approvedActivity;
    List<ActivityModel> pendActivity;
    String deadline;
    String hourRate;
    String name;

    ProjectModel(){}
    public ProjectModel(List<ActivityModel> approvedActivity,
                        List<ActivityModel> pendeActivity, String deadline, String hourRate,
                        String name) {
        this.approvedActivity = approvedActivity;
        this.pendActivity = pendeActivity;
        this.deadline = deadline;
        this.hourRate = hourRate;
        this.name = name;
    }
    public List<ActivityModel> getApprovedActivity() {
        return approvedActivity;
    }

    public void setApprovedActivity(
            List<ActivityModel> approvedActivity) {
        this.approvedActivity = approvedActivity;
    }

    public List<ActivityModel> getPendActivity() {
        return pendActivity;
    }

    public void setPendActivity(List<ActivityModel> pendActivity) {
        this.pendActivity = pendActivity;
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

}