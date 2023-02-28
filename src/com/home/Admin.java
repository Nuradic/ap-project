package com.home;

import javax.servlet.http.HttpServlet;

import com.utils.Components;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

public class Admin extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        out.print(Components.ADMIN);

    }

}
