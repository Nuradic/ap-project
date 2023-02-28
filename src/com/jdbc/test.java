
package com.jdbc;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

// import java.sql.*;
// import java.util.stream.Stream;
// import java.time.*;
// import java.time.format.DateTimeFormatter;
// import java.util.*;

import java.sql.SQLException;
// import java.text.SimpleDateFormat;

import com.models.Course;
import com.models.User;

// import javax.xml.crypto.Data;

public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, MalformedURLException {

        // Connection con = Database.connect();

        // ArrayList<Object> field = new ArrayList<>();

        // field.add(0, "Murad");
        // field.add(1, "Hussen");
        // field.add(2, "nurad@gmail.com");

        // Date d = new Date();
        // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // String date = format.format(d);

        // field.add(3, date);

        // LocalDateTime nol = LocalDateTime.now();
        // nol.time

        // field.add(3, Date.from(LocalDateTime.now()));

        // String[] columns = { "fname", "lname", "email", "last_login" };
        // columns = (String[]) Stream.of("fname", "lname", "email").toArray();

        // Database.insert(field, columns, Tables.STUDENT);

        // ResultSet rs = Database.get("'nurad@gmail.com'", "email", Tables.STUDENT);
        // rs.next();
        // System.out.println(rs.getString("fname"));

        // ArrayList<Object> val = new ArrayList<Object>();
        // val.add("Geography");
        // val.add("Department of geography");

        // String[] col1 = { "name", "description" };
        // Department dep = new Department();

        // dep.setName("Geography");
        // dep.setDesc("Department of geography");

        // Database.setDepartment(dep);

        // Course co = new Course("Data Structures and Algorithims");
        // co.setDescription("ADT Searchs Optimizations");

        // co.setDeparment(1);

        // Database.setCourse(co);

        // Course cors = new Course("Jakarta");
        // cors.setDescription("Java change name");

        // Database.setCourse(cors);

        // Database.addCourseForUser(1, 1);

        // ArrayList<Course> lk = Database.getCourses(1);

        // System.out.println(lk.size());

        // System.out.println("hello me".replaceAll("me", "it is me"));
        // try {
        // System.setSecurityManager(new RMISecurityManager());
        // SampleServer s = new SampleServer();
        // Naming.rebind("Sample1", s);
        // System.out.println("Server Waiting...");
        // } catch (RemoteException e) {

        // }

        User user = new User("Mr", "mure@ko.com");
        user.setIsAdminUser(true);
        user.setPassword("1234567");
        user.setLname("");
        Database.setUser(user);

    }
}
