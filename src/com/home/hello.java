package com.home;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class hello extends HttpServlet {
    private String message;

    public void init() throws ServletException {
        message = "Hello World!. You are my world";

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.println("<h1>" + message + "</h1>");

    }

    public void destroy() {

    }

}
