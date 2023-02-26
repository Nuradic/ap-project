package com.models;

import java.util.ArrayList;
import java.util.Date;

public class Question {

    private int id;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private ArrayList<Discussion> discussions;

    public ArrayList<Discussion> getDiscussion() {
        return discussions;
    }

    public void setDiscussion(ArrayList<Discussion> discussions) {
        this.discussions = discussions;
    }

}
