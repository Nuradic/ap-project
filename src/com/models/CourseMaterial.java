package com.models;

public class CourseMaterial {
    private int id;
    private String url;
    private String name;
    private int course_id;

    public CourseMaterial(String url, int course_id) {

        this.url = url;
        this.course_id = course_id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    // private String ;

}
