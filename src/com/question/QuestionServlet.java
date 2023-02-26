package com.question;

import javax.servlet.http.HttpServlet;

import com.utils.Authentication;
import com.utils.Components;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class QuestionServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        try {
            HttpServletResponse res2 = Authentication.authenticate(req, res);

            if (res2 == null) {
                toSign(req, res);
            } else {
                showQuestion(req, res2);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try {
            HttpServletResponse res2 = Authentication.authenticate(req, res);

            if (res2 == null) {
                toSign(req, res);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    void toSign(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        RequestDispatcher dis = req.getRequestDispatcher("/login.html");
        dis.forward(req, res);

    }

    void showQuestion(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.print(Components.SOCIAL);

    }

}
