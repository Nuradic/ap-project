package com.home;

import javax.servlet.*;
import javax.servlet.http.*;

import com.utils.Authentication;

import java.io.*;
import java.sql.SQLException;

public class Homepage extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        HttpServletResponse res2;

        try {
            res2 = Authentication.authenticate(req, res);
            req.setAttribute("user", "hero one");
            if (res2 == null) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/login.html");
                dispatcher.forward(req, res);

            } else {
                RequestDispatcher dis = req.getRequestDispatcher("/home.jsp");

                out.println("<h1>Hello Dispatcherss</h1>");

                dis.forward(req, res2);

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // out.println("<!Doctype html><html><head><title>Hello
        // There</title></head><body>");

        // out.println("<h1>" + "Working just fine" + "</h1>");

        // out.println("</body></html>");

        // try {
        // dispatcher.include(req, res);
        // } catch (ServletException e) {
        // e.printStackTrace();
        // }

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

                RequestDispatcher dis = req.getRequestDispatcher("/home.jsp");

                out.println("<h1>Hello Dispatcherss</h1>");

                dis.forward(req, res2);

            }

        } catch (ClassNotFoundException | SQLException e) {
            // RequestDispatcher dis = req.getRequestDispatcher("/home.jsp");

            // System.out.println("calling from else");

            // dis.forward(req, res);
            e.printStackTrace();
        }

    }

}
