package com.home;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// import com.jdbc.*;
// import com.models.Student;
// import com.models.User;
import com.utils.Authentication;

import java.io.*;
// import java.sql.*;
// import java.util.*;
import java.sql.SQLException;

public class Login extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        // Map<String, String[]> data = req.getParameterMap();

        // String email = data.get("email").toString();
        // String fname = data.get("fname").toString();
        // String pass = data.get("password").toString();

        // String email = req.getParameter("email");

        // String pass = req.getParameter("password");

        HttpServletResponse res2;

        try {
            res2 = Authentication.authenticate(req, res);
            if (res2 == null) {
                RequestDispatcher dis = req.getRequestDispatcher("/login.html");

                String o = """
                        <script>
                        alert("Invalid Login Credentials")
                        </script>
                        """;

                out.println(o);
                dis.include(req, res);

            } else {
                // RequestDispatcher dis=req.getRequestDispatcher("/");

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Student std = new Student(fname, email);

        // Student std2 = new Student(null, null, null);
        // std.setPassword(pass);

        // System.out.println(std);

        out.print("<html><body>");
        // out.print("<b>Registered Succesfully email: " + email + std.getPassword() +
        // "</b>");
        out.print("</body></html>");
    }

}