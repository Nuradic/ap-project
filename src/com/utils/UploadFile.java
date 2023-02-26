package com.utils;

import javax.servlet.http.HttpServlet;

import com.jdbc.Database;
import com.models.Course;
import com.models.CourseMaterial;
import com.oreilly.servlet.MultipartRequest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

@MultipartConfig
public class UploadFile extends HttpServlet {
    private String filepath;

    private int maxFileSize = 1024 * 1024 * 1024;

    public void init() {

        filepath = getServletContext().getInitParameter("file-upload");

    }

    public static String buildPath(String filename) {
        return "/files/" + filename;
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        MultipartRequest upload = new MultipartRequest(req, filepath, maxFileSize);

        Iterator<String> it = upload.getFileNames().asIterator();
        int course_id = Integer.parseInt(upload.getParameter("course"));

        while (it.hasNext()) {
            String url = it.next();
            File file = upload.getFile(url);
            String filename = file.getName();
            CourseMaterial material = new CourseMaterial(buildPath(filename), course_id);
            System.out.println();
            material.setName(filename.replaceAll("\\..+", ""));
            try {
                Database.setCourseMaterial(material);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, java.io.IOException {

        try {
            ArrayList<Course> cors = Database.getCourses();

            PrintWriter out = res.getWriter();
            // RequestDispatcher dis = req.getRequestDispatcher("https://dev.temarico.com");
            // res.sendRedirect("https://dev.temarico.com");

            res.setContentType("text/html");

            String content = """
                    <!DOCTYPE html>
                    <html>
                        <head>

                            <link rel="stylesheet" href="css/fileupload.css">
                        </head>
                        <header>

                            <nav>
                                <h1 class="main_text">AISS</h1>
                              <ul>
                                <li><a href="/academy/home">Home</a></li>
                                <li><a href="/academy/addCourse">Add Course</a></li>
                                <li><a href="#">Help</a></li>
                              </ul>
                            </nav>

                          </header>
                         <div class="home">
                          <section>

                            <form method="post" action="/academy/upload" enctype="multipart/form-data">
                              <h4>Add Material</h4>
                              <div>

                                <label for="options">Course:</label><select name="course">
                        """;
            String choice = "";
            for (int i = 0; i < cors.size(); i++) {

                choice = choice
                        + "<option value=id>course</option>".replace("id", "" + cors.get(i).getId()).replace("course",
                                cors.get(i).getName());
            }

            String close = """
                                </select>


                                <label for="file-upload">File Upload:</label>
                                <input name="file" type="file" id="file-upload" multiple>

                              </div>
                              <input type="submit" value="Submit">
                            </form>

                          </section></div>

                    </html>
                                    """;
            out.println(content);
            out.println(choice);
            out.println(close);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
