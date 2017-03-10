package com.example.islam.project_management.Models;

import java.util.List;
import java.util.Map;

/**
 * Created by islam on 09/03/17.
 */

public class UserModel {
    private String userID;
    private String firstName;
    private String lastName;
    private List<ActivityModel> activities;
    private List<Map<String,String>> projects;
    private String role;


    public UserModel(String userID, String firstName, String lastName, List<ActivityModel> activities, List<Map<String, String>> projects, String role) {
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<ActivityModel> getActivities() {
        return activities;
    }

    public List<Map<String, String>> getProjects() {
        return projects;
    }

    public String getRole() {
        return role;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setActivities(List<ActivityModel> activities) {
        this.activities = activities;
    }

    public void setProjects(List<Map<String, String>> projects) {
        this.projects = projects;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
