package com.jdbc;

import java.sql.*;
import java.util.ArrayList;

import com.models.*;

public class Database {
    private final static String url = "jdbc:mysql://localhost:3306/academy";
    private final static String user = "academy";
    private final static String password = "pass123456";
    public Connection conn;

    public static Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(url, user, password);

    }

    // public ResultSet getQueryResult(String stmp) throws ClassNotFoundException,
    // SQLException {
    // Connection con = connect();
    // Statement statement = con.createStatement();
    // PreparedStatement prestmp = con.prepareStatement("CREATE TABLE STD");
    // return statement.executeQuery(stmp);

    // }

    public static void closeConnection() {

    }

    public static ResultSet get(String value, String column, Tables table) throws ClassNotFoundException, SQLException {
        Connection con = connect();
        Statement statement = con.createStatement();
        String stm = "SELECT* FROM " + getTable(table) + " WHERE " + column + " LIKE " + value;

        System.out.println(stm);

        return statement.executeQuery(stm);

    }

    public static ResultSet get(String statement) throws ClassNotFoundException, SQLException {
        Connection con = connect();

        Statement stat = con.createStatement();

        return stat.executeQuery(statement);

        // return null;
    }

    public static ResultSet get(int value, String column, Tables table) throws ClassNotFoundException, SQLException {

        Connection con = connect();
        Statement statement = con.createStatement();

        String stm = "SELECT* FROM " + getTable(table) + " WHERE " + column + " = " + value;

        System.out.println(stm);

        return statement.executeQuery(stm);

    }

    public static ResultSet get(int id, Tables table) throws ClassNotFoundException, SQLException {

        Connection con = connect();
        Statement statement = con.createStatement();

        String stm = "SELECT* FROM " + getTable(table) + " WHERE id=" + " = " + id;

        System.out.println(stm);

        return statement.executeQuery(stm);

    }

    public static ResultSet search(String value, String column, Tables table)
            throws ClassNotFoundException, SQLException {
        Connection con = connect();
        Statement statement = con.createStatement();
        return statement.executeQuery("stmp");

    }

    public static ResultSet search(String statement)
            throws ClassNotFoundException, SQLException {
        Connection con = connect();
        Statement state = con.createStatement();
        return state.executeQuery(statement);

    }

    public static String getTable(Tables table) {
        String t = table == Tables.COURSE ? "COURSE"
                : table == Tables.STUDENT ? "STUDENT"
                        : table == Tables.INSTRUCTOR ? "INSTRUCTOR"
                                : table == Tables.DEPARTMENT ? "DEPARTMENT"
                                        : table == Tables.USER ? "USER"
                                                : Tables.COURSE_MATERIAL == table ? "COURSE_MATERIAL"
                                                        : Tables.COURSE_USER == table ? "COURSE_USER" : "DEFAULT";
        return t;
    }

    /**
     * @param values:
     * @param columns
     * @param table
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Boolean insert(ArrayList<Object> values, String[] columns, Tables table)
            throws ClassNotFoundException, SQLException {
        Connection con = connect();
        String base = "INSERT INTO " + getTable(table);

        String cols = base + " (";
        String val = " VALUES(";

        for (int i = 0; i < columns.length; i++) {
            if (i == 0) {
                cols += columns[i] + ",";
                val += "?,";
                continue;

            }
            if (i == columns.length - 1) {
                cols += columns[i] + ")";
                val += "?)";
                continue;
            }
            cols += columns[i] + ",";
            val += "?,";

        }
        cols += val;
        PreparedStatement statement = con.prepareStatement(cols);
        for (int i = 0; i < columns.length; i++) {
            if (values.get(i) instanceof Integer) {
                statement.setInt(i + 1, (int) values.get(i));

            } else if (values.get(i) instanceof String) {
                statement.setString(i + 1, (String) values.get(i));
            } else if (values.get(i) instanceof Boolean) {
                statement.setBoolean(i + 1, (boolean) values.get(i));
            } else if (values.get(i) instanceof Date) {

                statement.setDate(i + 1, (Date) values.get(i));
            }

        }
        System.out.println(cols);
        return statement.execute();

    }

    public static Boolean setDepartment(Department dep) throws ClassNotFoundException, SQLException {

        ArrayList<Object> values = new ArrayList<Object>();

        values.add(dep.getName());
        values.add(dep.getDesc());

        String[] columns = { "name", "description" };

        return insert(values, columns, Tables.DEPARTMENT);

    }

    public static Department getDepartment(String name) throws ClassNotFoundException, SQLException {

        ResultSet rs = get(name, "name", Tables.DEPARTMENT);

        if (rs.next()) {
            Department dep = new Department();

            dep.setName(name);
            dep.setDesc(rs.getString("description"));

            return dep;
        }

        return null;
    }

    public static ArrayList<Course> getCourses(int user_id) throws ClassNotFoundException, SQLException {
        String statement = "SELECT course_user.payment,course.name,course.description,course.id FROM course_user INNER JOIN COURSE ON course.id=course_user.course_id WHERE user_id="
                + user_id;

        ResultSet rs = get(statement);
        ArrayList<Course> courses = new ArrayList<Course>();

        Course cors;

        while (rs.next()) {
            String name = rs.getString("name");
            String desc = rs.getString("description");

            int id = rs.getInt("id");
            cors = new Course(name);
            cors.setId(id);
            cors.setDescription(desc);
            courses.add(cors);

        }

        return courses;

    }

    public static ArrayList<Course> getCourses() throws ClassNotFoundException, SQLException {

        String statement = "SELECT* FROM COURSE";

        ResultSet rs = get(statement);

        ArrayList<Course> courses = new ArrayList<Course>();

        Course cors;

        while (rs.next()) {
            String name = rs.getString("name");
            String desc = rs.getString("description");

            int id = rs.getInt("id");
            cors = new Course(name);
            cors.setId(id);
            cors.setDescription(desc);

            courses.add(cors);

        }

        return courses;
    }

    public static Boolean setCourse(Course course) throws ClassNotFoundException, SQLException {
        ArrayList<Object> values = new ArrayList<Object>();

        values.add(course.getName());
        values.add(course.getDescription());

        String[] columns = { "name", "description" };

        return insert(values, columns, Tables.COURSE);
    }

    public static Boolean setCourseMaterial(CourseMaterial courseMaterial) throws ClassNotFoundException, SQLException {

        ArrayList<Object> values = new ArrayList<Object>();
        values.add(courseMaterial.getName());
        values.add(courseMaterial.getUrl());
        values.add(courseMaterial.getCourse_id());

        String[] columns = { "name", "url", "course_id" };

        return insert(values, columns, Tables.COURSE_MATERIAL);

    }

    public static ArrayList<CourseMaterial> getCourseMaterials(Course course)
            throws ClassNotFoundException, SQLException {
        String column = "course_id";

        ResultSet rs = get(course.getId(), column, Tables.COURSE_MATERIAL);

        ArrayList<CourseMaterial> mats = new ArrayList<CourseMaterial>();

        while (rs.next()) {
            String url = rs.getString("url");
            String name = rs.getString("name");
            int id = rs.getInt("id");
            int course_id = rs.getInt("course_id");

            CourseMaterial material = new CourseMaterial(url, course_id);
            material.setName(name);
            material.setId(id);

            mats.add(material);

        }

        return mats;

    }

    public static Boolean addCourseForUser(int user, int course) throws ClassNotFoundException, SQLException {

        ArrayList<Object> values = new ArrayList<Object>();
        values.add(user);
        values.add(course);

        String[] columns = { "user_id", "course_id" };

        return insert(values, columns, Tables.COURSE_USER);

    }

    // public static Student getStudent(String email) throws ClassNotFoundException,
    // SQLException {

    //

    // ResultSet rs = get(email, "email", Tables.STUDENT);

    // if (rs.next()) {
    // String fname = rs.getString("fname");
    // String lname = rs.getString("lname");
    // String r = rs.getString("lname");
    // int dep_id = rs.getInt("dep_id");
    // Student student = new Student(fname, email);
    // student.setLname(lname);
    // student.setDep_id(dep_id);

    // String email=rs.getString("email");

    // return student;

    // }

    // return new Student(email, email);

    // }

    public static User getUser(String email) throws SQLException, ClassNotFoundException {
        ResultSet rs = get(email, "email", Tables.USER);

        if (rs.next()) {
            String fname = rs.getString("fname");
            String lname = rs.getString("lname");
            String password = rs.getString("password");
            Boolean isAdminUser = rs.getBoolean("isAdminUser");
            int id = rs.getInt("id");
            User user = new User(fname, email);
            user.setLname(lname);
            user.setId(id);
            user.setIsAdminUser(isAdminUser);
            user.setPassword(password);

            return user;
        } else {
            return null;
        }

    }

    public static User getUser(int id) throws ClassNotFoundException, SQLException {
        ResultSet rs = get(id, "id", Tables.USER);

        if (rs.next()) {
            String fname = rs.getString("fname");
            String lname = rs.getString("lname");
            String password = rs.getString("password");
            Boolean isAdminUser = rs.getBoolean("isAdminUser");
            // int dep_id = rs.getInt("dep_id");
            String email = rs.getString("email");
            User user = new User(fname, email);
            // user.setDep_id(dep_id);
            user.setLname(lname);
            user.setId(id);
            user.setIsAdminUser(isAdminUser);
            user.setPassword(password);

            return user;
        } else {
            return null;
        }

    }

    public static Boolean setUser(User user) throws ClassNotFoundException, SQLException {

        ArrayList<Object> values = new ArrayList<Object>();

        values.add(user.getFname());
        values.add(user.getLname());
        values.add(user.getEmail());
        values.add(user.getPassword());
        values.add(user.getEmail_otp());
        values.add(user.getIsAdminUser());

        String[] columns = { "fname", "lname", "email", "password", "email_otp", "isAdminUser" };

        return insert(values, columns, Tables.USER);

    }

    public static Boolean delete(String value, String column, Tables table) {
        return false;
    }

}