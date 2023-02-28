package com.home;

import javax.servlet.http.*;

import com.jdbc.Database;
import com.models.User;

// import com.models.Student;

import javax.servlet.*;
import java.io.*;
// import java.net.http.HttpResponse;
// import java.util.*;
import java.sql.SQLException;

public class Register extends HttpServlet {
    // public void service(ServletRequest req, ServletResponse res) throws
    // IOException, ServletException {
    // res.setContentType("text/html");

    // RequestDispatcher disp = req.getRequestDispatcher("/login.html");
    // disp.forward(req, res);

    // PrintWriter out = res.getWriter();
    // Map<String, String[]> data = req.getParameterMap();

    // String email = req.getParameter("email");
    // String fname = req.getParameter("fname");
    // String lname = req.getParameter("lname");
    // String pass = req.getParameter("password");

    // System.out.println(data);

    // Student std = new Student(fname, lname, email);

    // std.setPassword(pass);

    // System.out.println(std);

    // out.print("<html><body>");
    // out.print("<b>Registered Succesfully email: " + email + std.getPassword() +
    // "</b>");
    // out.print("</body></html>");
    // }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        RequestDispatcher disp = req.getRequestDispatcher("/login.html");
        disp = getServletContext().getRequestDispatcher("/login.html");
        disp.forward(req, res);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String email = req.getParameter("email");
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String pass = req.getParameter("password");
        String pass2 = req.getParameter("password2");
        User user = new User(fname, email);
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        user.setLname(lname);
        user.setPassword(pass);
        user.setIsAdminUser(false);

        try {
            Database.setUser(user);
            String o = "<script>alert(\"Succesfully registered\")</script>";
            RequestDispatcher dis = req.getRequestDispatcher("login");
            out.print(o);
            dis.include(req, res);
            // res.sendRedirect("login");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}
