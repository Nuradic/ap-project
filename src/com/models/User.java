package com.models;

import java.sql.SQLException;
import java.io.*;

public class User implements Serializable, Model {
    private int id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String profile_pic;

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    private Boolean isAdminUser = false;
    private int email_otp = 0;

    public int getEmail_otp() {
        return email_otp;
    }

    public void setEmail_otp(int email_otp) {
        this.email_otp = email_otp;
    }

    public Boolean getIsAdminUser() {
        return isAdminUser;
    }

    public void setIsAdminUser(Boolean isAdminUser) {
        this.isAdminUser = isAdminUser;
    }

    private String statement = "INSERT INTO STUDENT(fname,lname,email,password)VALUES(?,?,?,?);";

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public User(String fname, String email) {
        this.fname = fname;
        this.email = email;

    }

    // public int getDep_id() {
    // return dep_id;
    // }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return fname + " " + lname;
    }

    User get(String searchable, String searchKey) throws ClassNotFoundException, SQLException {
        // String stm = "SELECT* FROM " + dbTable + " WHERE " + searchKey + "=" +
        // searchable + ";";

        // ResultSet rs = (new database()).getQueryResult(stm);

        return this;
    }

    @Override
    public void save() {
        // TODO Auto-generated method stub

    }

    @Override
    public void refresh() {
        // TODO Auto-generated method stub

    }

    @Override
    public void getStatement(String stm) {
        // TODO Auto-generated method stub

    }

}
