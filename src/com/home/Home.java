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

                for (Course cors : courses) {
                    String url = cors.getCover() == null ? ""
                            : "http://localhost:8580" + cors.getCover();

                    card += """
                                <div class="inner-card">
                                <img src= "image" alt="dies picture" width="300">
                                <h2>name</h2>
                                <p>desc</p>
                                <button formaction="param-here" class="mabtn" type="button"><a href="param-here">View Course</a></button>
                            </div>
                                    """
                            .replace("name", cors.getName()).replace("desc",
                                    cors.getDescription())
                            .replace("param-here", "course?course=" + cors.getId())

                            .replace("image", url);

                    System.out.println(cors.getCover());

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
