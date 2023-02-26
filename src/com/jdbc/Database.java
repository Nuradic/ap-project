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

    public static Course getCourse(int id) throws ClassNotFoundException, SQLException {
        String statement = "SELECT* FROM COURSE WHERE id=" + id;

        ResultSet rs = get(statement);

        if (rs.next()) {
            Course cors = new Course(rs.getString("name"));
            cors.setCover(rs.getString("cover"));
            cors.setDescription(rs.getString("description"));
            cors.setId(rs.getInt("id"));
            cors.setMaterials(getCourseMaterials(cors));

            return cors;

        }

        return null;

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

    public static Boolean setQuestion(Question q) throws ClassNotFoundException, SQLException {

        ArrayList<Object> values = new ArrayList<Object>();
        values.add(q.getBody());
        values.add(q.getUser().getId());

        String[] columns = { "body", "user" };

        return insert(values, columns, Tables.QUESTION);
    }

    public static ArrayList<Question> getQuestions() {
        ArrayList<Question> vals = new ArrayList<Question>();
        String statement = "SELECT* FROM QUESTION ORDER BY date";

        return vals;
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

    public static ArrayList<Course> getCourses(String name) throws ClassNotFoundException, SQLException {
        String st = "SELECT* from COURSE where name LIKE " + "'%" + name + "%'";

        System.out.println(st);

        ResultSet rs = get(st);
        ArrayList<Course> courses = new ArrayList<Course>();

        Course cors;

        while (rs.next()) {
            String nam = rs.getString("name");
            String desc = rs.getString("description");
            String cover = rs.getString("cover");
            int id = rs.getInt("id");
            cors = new Course(nam);
            cors.setId(id);
            cors.setDescription(desc);
            cors.setCover(cover);
            cors.setMaterials(getCourseMaterials(cors));

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
            String cover = rs.getString("cover");

            int id = rs.getInt("id");
            cors = new Course(name);
            cors.setId(id);
            cors.setDescription(desc);
            cors.setCover(cover);
            cors.setMaterials(getCourseMaterials(cors));

            courses.add(cors);

        }

        return courses;
    }

    public static Boolean setCourse(Course course) throws ClassNotFoundException, SQLException {
        ArrayList<Object> values = new ArrayList<Object>();

        values.add(course.getName());
        values.add(course.getDescription());
        values.add(course.getCover());

        String[] columns = { "name", "description", "cover" };

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
            String email = rs.getString("email");
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

    private static Boolean Delete(String column, Tables table, String value)
            throws ClassNotFoundException, SQLException {

        Connection con = connect();

        Statement st = con.createStatement();

        return st.execute("DELETE FROM " + getTable(table) + " where " + column + "=" + value);

    }

    public static Boolean deleteCourse(int id) throws ClassNotFoundException, SQLException {
        return Delete("id", Tables.COURSE, "" + id);

    }

    public static Boolean deleteUser(String email) throws ClassNotFoundException, SQLException {
        return Delete("email", Tables.USER, email);
    }

}