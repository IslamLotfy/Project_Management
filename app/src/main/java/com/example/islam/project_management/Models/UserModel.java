package com.example.islam.project_management.Models;

import java.util.List;

/**
 * Created by islam on 09/03/17.
 */

public class UserModel {
    private String userID;
    private String firstName;
    private String lastName;
    private List<ActivityModel> activities;
    private List<String> projects;
    private String role;


    public UserModel(String userID, String firstName, String lastName, List<ActivityModel> activities, List<String> projects, String role) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.activities = activities;
        this.projects = projects;
        this.role = role;
    }

    public UserModel() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ActivityModel> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityModel> activities) {
        this.activities = activities;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
