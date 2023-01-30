package com.models;

import java.util.*;

public class Course implements Model {
    private int id;
    private String name;
    private String description;
    private String cover;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    private ArrayList<CourseMaterial> materials;

    private ArrayList<Student> students;

    public Course(String name) {
        this.name = name;
    }

    // Getters

    public ArrayList<CourseMaterial> getMaterials() {
        return materials;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    // Setterss
    public void setDescription(String desc) {
        description = desc;
    }

    public void setMaterials(ArrayList<CourseMaterial> materials) {
        this.materials = materials;
    }

    public void addMaterial(CourseMaterial material) {

        this.materials.add(material);
    }

    // public void setDeparment(int deparment) {
    // this.deparment = deparment;
    // }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void save() {
        // print(this.fname);

    }

    @Override
    public void getStatement(String stm) {
        // TODO Auto-generated method stub

    }

    @Override
    public void refresh() {
        // TODO Auto-generated method stub

    }

}
