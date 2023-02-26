package com.login;

import com.utils.Authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Logout extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        RequestDispatcher dis = req.getRequestDispatcher("/login.html");

        HttpServletResponse res2 = Authentication.logout(req, res);

        dis.forward(req, res2);

    }

}
