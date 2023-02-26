package com.course;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.utils.Components;
import com.utils.UploadFile;
import com.jdbc.Database;
import com.models.Course;
import com.models.CourseMaterial;
import com.oreilly.servlet.MultipartRequest;

public class CourseServlet extends HttpServlet {
    private String filepath;
    private int maxSize = 1024 * 1024 * 10;

    public void init() {

        filepath = getServletContext().getInitParameter("file-upload");

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        MultipartRequest upload = new MultipartRequest(req, filepath, maxSize);

        Iterator<String> it = upload.getFileNames().asIterator();

        String name = upload.getParameter("name");
        String desc = upload.getParameter("description");
        System.out.println(desc + name);
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        if (it.hasNext()) {
            System.out.println("it is coming heree...");
            out.print("<script>alert(\"Succesfully uploaded\");</script>");
            String url = it.next();
            File file = upload.getFile(url);
            String filename = file.getName();
            try {
                Course cors = new Course(name);
                cors.setCover(UploadFile.buildPath(filename));
                cors.setDescription(desc);
                Database.setCourse(cors);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();

            }
            // RequestDispatcher dis = req.getRequestDispatcher("course");

            res.sendRedirect("course");
            // dis.forward(req, res);
        }

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // RequestDispatcher dis = req.getRequestDispatcher("/fileupload.html");
        // dis.forward(req, res);
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        String course_id = req.getParameter("course");

        try {
            int id = Integer.parseInt(course_id);
            System.out.println("welcome to the hell");

            Course cors = Database.getCourse(id);
            System.out.println(cors);
            if (cors != null) {
                String content = Components.COURSEVIEW;
                content = content.replace("description-here", cors.getDescription()).replace("course-here",
                        cors.getName());

                String material = "";
                System.out.println(cors.getMaterials());

                for (CourseMaterial mat : cors.getMaterials()) {
                    material += """
                            <div class="materials">
                                <div><p><a href="link-here">item-here</a></p></div>
                                <div><a href="link-here"><button class="btn download"><i class="fa fa-download"></i> </button></i></a></div></div>
                                </div>\n
                                    """
                            .replaceAll("link-here", mat.getUrl()).replace("item-here", mat.getName());

                }
                content = content.replace("material-here", material).replace("description-here", cors.getDescription());

                out.print(content);
                // System.out.println("welcome to the hell twice");

            } else {

            }

        } catch (NumberFormatException e) {
            // PrintWriter out = res.getWriter();
            res.setContentType("text/html");

            out.print(Components.UPLOADCOURSE);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void courseview(HttpServletRequest req, HttpServletResponse res, Course cors) throws IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        String content = Components.COURSEVIEW;
        content = content.replace("description", cors.getDescription()).replace("course", cors.getName());

        String material = "";

        for (CourseMaterial mat : cors.getMaterials()) {
            material += """
                        <li>
                        <div><p><a href=link-here>item-here</a></p></div>
                        <div><a href=link-here><button class="btn download"><i class="fa fa-download"></i> </button></i></a></div></div>
                    </li>
                            """
                    .replaceAll("link-here", mat.getUrl()).replace("item-here", mat.getName());

        }
        content.replace("material-here", material);

        out.print(content);

    }

}
