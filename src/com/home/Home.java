package com.home;

import javax.servlet.*;
import javax.servlet.http.*;

import com.jdbc.Database;
import com.models.Course;
import com.utils.Authentication;
import com.utils.Components;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Home extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        HttpServletResponse res2;

        try {
            res2 = Authentication.authenticate(req, res);
            if (res2 == null) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/login.html");
                dispatcher.forward(req, res);

            } else {
                RequestDispatcher dis = req.getRequestDispatcher("/footer.html");

                ArrayList<Course> courses = Database.getCourses();

                out.println(Components.HEADER);
                String card = "";

                for (int i = 0; i < courses.size(); i++) {
                    String url = courses.get(i).getCover() == null ? ""
                            : "http://localhost:8580" + courses.get(i).getCover();

                    card += """
                                <div class="inner-card">
                                <img src= "image" alt="dies picture" width="300">
                                <h2>name</h2>
                                <p>desc</p>
                                <button class="mabtn" type="button">Add Course</button>
                            </div>
                                    """.replace("name", courses.get(i).getName()).replace("desc",
                            courses.get(i).getDescription())

                            .replace("image", url);

                    System.out.println(courses.get(i).getCover());

                }
                out.println(card + "</div></section>");

                dis.include(req, res2);

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        HttpServletResponse res2;
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        try {
            res2 = Authentication.authenticate(req, res);
            req.setAttribute("user", "hero one");

            if (res2 == null) {
                System.out.println("calling from if");

                RequestDispatcher dis = req.getRequestDispatcher("/login.html");
                String o = """
                        <script>
                        alert("Invalid Login Credentials")
                        </script>
                        """;

                out.println(o);

                dis.include(req, res);

            } else {

                ArrayList<Course> cors = Database.getCourses();

                req.setAttribute("courses", cors);

                RequestDispatcher dis = req.getRequestDispatcher("/head.html");

                dis.include(req, res2);

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}
