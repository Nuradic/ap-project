package com.login;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.Authentication;

import java.io.*;
import java.sql.SQLException;

public class Login extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        HttpServletResponse res2;

        try {
            res2 = Authentication.authenticate(req, res);
            if (res2 == null) {
                RequestDispatcher dis = req.getRequestDispatcher("login");

                dis.forward(req, res);

            } else {
                RequestDispatcher dis = req.getRequestDispatcher("home");
                dis.forward(req, res2);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // out.print("<html><body>");
        // out.print("</body></html>");
    }

}