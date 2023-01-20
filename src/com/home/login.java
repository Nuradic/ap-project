package com.home;

import javax.servlet.*;
import java.io.*;

public class login extends GenericServlet {
    public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.print("<html><body>");
        out.print("<b>hello generic servlet again and again</b>");
        out.print("</body></html>");
    }

}