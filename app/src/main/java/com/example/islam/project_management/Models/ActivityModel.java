package com.example.islam.project_management.Models;

/**
 * Created by islam on 09/03/17.
 */

public class ActivityModel {

    private String date;
    private String duration;
    private String user;
    private String activityId;
    private String project;
    ActivityModel(){}

    public ActivityModel(String date, String duration, String user, String activityId, String project) {
        this.date = date;
        this.duration = duration;
        this.user = user;
        this.activityId = activityId;
        this.project = project;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}