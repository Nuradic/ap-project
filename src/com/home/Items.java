package com.home;

import javax.servlet.http.HttpServlet;

import com.jdbc.Database;
import com.models.Course;
import com.models.CourseMaterial;
import com.models.Question;
import com.models.User;
import com.utils.Authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Items extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        User uw;
        try {
            uw = Authentication.authenticate(req);
            if (uw == null) {
                RequestDispatcher dis = req.getRequestDispatcher("login");
                dis.forward(req, res);

            }
            if (!uw.getIsAdminUser()) {
                RequestDispatcher dis = req.getRequestDispatcher("home");
                dis.forward(req, res);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        String content = """
                <!DOCTYPE html>
                <html>
                  <head>
                    <link rel="stylesheet" href="css/fileupload.css" />
                  </head>
                  <header>
                    <nav>
                      <h1 class="main_text">AISS</h1>
                      <ul>
                        <li><a href="home">Home</a></li>
                      </ul>
                    </nav>
                  </header>
                  <div class="home">
                    <section>
                      <form action="" method="post">
                        <h4>Delete Items</h4>
                        <div>
                          <label for="user">User:</label>
                          <select name="user">
                          <option value=1>------</option>
                          user-heres
                          </select>

                          <label for="course">Course:</label>

                          <select name="course">
                          <--<option value=1>------</option>
                          course-heres
                          </select>
                          <label for="material-name">Material Name:</label>
                          <select name="material">
                          <option value=1>------</option>
                          material-heres
                          </select>
                          <label for="question">Question</label>
                          <select name="question">
                          <option value=1>------</option>
                          question-heres
                          </select>


                      <input type="submit" value="Delete" />
                      </form>
                    </section>
                  </div>
                </html>

                    """;

        try {
            ArrayList<User> users = Database.getUsers();
            ArrayList<CourseMaterial> materials = Database.getCourseMaterials();
            ArrayList<Course> courses = Database.getCourses();
            ArrayList<Question> questions = Database.getQuestions();
            String choice_user = "";
            String choice_material = "";
            String choice_question = "";
            String choice_cors = "";

            for (User us : users) {
                choice_user = choice_user
                        + "<option value=id>course</option>".replace("id", "" + us.getId()).replace("course",
                                us.getFname());

            }
            for (CourseMaterial mats : materials) {
                choice_material = choice_material
                        + "<option value=id>course</option>".replace("id", "" + mats.getId()).replace("course",
                                mats.getName());

            }
            for (Question que : questions) {
                choice_question = choice_question
                        + "<option value=id>course</option>".replace("id", "" + que.getId()).replace("course",
                                que.getBody());

            }
            for (Course cors : courses) {
                choice_cors = choice_cors
                        + "<option value=id>course</option>".replace("id", "" + cors.getId()).replace("course",
                                cors.getName());

            }

            content = content.replace("user-heres", choice_user).replace("question-here", choice_question)
                    .replace("material-heres", choice_material).replace("course-heres", choice_cors);

            out.print(content);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String user = req.getParameter("user");
        String material = req.getParameter("material");
        String course = req.getParameter("course");
        String question = req.getParameter("question");
        System.out.println(user);
        System.out.println(material);
        System.out.println(course);
        System.out.println(question);
        try {
            User us = Authentication.authenticate(req);

            if (us == null) {
                RequestDispatcher dis = req.getRequestDispatcher("login");
                dis.forward(req, res);

            }
            if (!us.getIsAdminUser()) {
                RequestDispatcher dis = req.getRequestDispatcher("home");

                dis.forward(req, res);

            }

            if (!us.getIsAdminUser()) {
                RequestDispatcher dis = req.getRequestDispatcher("home");
                dis.forward(req, res);
            }

            PrintWriter out = res.getWriter();

            if (user != null) {
                try {
                    Database.deleteUser(user);
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }

            }
            if (material != null) {
                try {
                    Database.deleteMaterial(material);
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }

            }
            if (course != null) {
                try {
                    Database.deleteCourse(course);
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }

            }
            if (question != null) {
                try {
                    Database.deleteQuestion(question);
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }

            }
            res.sendRedirect("items");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
