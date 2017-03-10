package com.example.islam.project_management.Models;

/**
 * Created by islam on 09/03/17.
 */

public class ActivityModel {
    String date;
    String duration;
    String user;
    ActivityModel(){}

    public ActivityModel(String date, String duration, String user) {
        this.date = date;
        this.duration = duration;
        this.user = user;
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
}