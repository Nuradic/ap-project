package com.models;

// import java.sql.SQLException;
import java.util.ArrayList;

// import com.jdbc.*;

public class Student extends User {
    public Student(String fname, String email) {
        super(fname, email);
    }

    @Override
    public void save() {

        ArrayList<Object> val = new ArrayList<Object>();

        val.add(getFname());
        val.add(getLname());
        val.add(getEmail());
        val.add(getPassword());
        val.add(getEmail_otp());
        val.add(getIsAdminUser());

        String[] columns = { "fname", "lname", "email", "password", "email_otp", "isAdminUser" };

        // try {
        // Database.insert(val, columns, Tables.STUDENT);
        // } catch (ClassNotFoundException | SQLException e) {
        // e.printStackTrace();
        // }

    }

    // public Student getStudent(){
    // return new Student();
    // }

    @Override
    public void getStatement(String stm) {
        // TODO Auto-generated method stub

    }

    @Override
    public void refresh() {
        // TODO Auto-generated method stub

    }

}
