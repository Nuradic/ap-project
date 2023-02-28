package com.question;

import javax.servlet.http.HttpServlet;

import com.jdbc.Database;
import com.models.Question;
import com.models.User;
import com.utils.Authentication;
import com.utils.Components;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

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
            User user = Authentication.authenticate(req);
            String body = req.getParameter("post");
            Question q = new Question();
            q.setBody(body);
            q.setDate(new Date(new java.util.Date().getTime()));
            q.setUser(user);
            Database.setQuestion(q);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    void toSign(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        RequestDispatcher dis = req.getRequestDispatcher("/login.html");
        dis.forward(req, res);

    }

    void showQuestion(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ClassNotFoundException, SQLException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String img = """
                    <div class="w3-row-padding" style="margin:0 -16px">
                    <div class="w3-half">
                      <img src="/img/jbook2.jpg" style="width:100px; height: 120px;">
                    </div>
                </div><br>
                        """;

        User user = Authentication.authenticate(req);
        String s = Components.SOCIAL.replace("user-here", user.getFname() + " " + user.getLname());
        ArrayList<Question> ques = Database.getQuestions();
        String card = "";

        for (Question q : ques) {
            card += """
                      <div class="w3-container w3-card w3-white w3-round w3-margin"><br>
                      <img src="/img/user1.jpg" alt="Avatar" class="w3-left w3-circle w3-margin-right" style="width:60px">
                      <span class="w3-right w3-opacity">1 min</span>
                      <h4>user-here</h4><br>
                      <hr class="w3-clear">
                      <p>para-here</p>
                      <!--<button type="button" class="w3-button w3-theme-d1 w3-margin-bottom"><i class="fa fa-thumbs-up"></i> &nbsp;<a href="link-here">Like</a></button>-->
                      <button textdecoration="none" type="button" class="w3-button w3-theme-d2 w3-margin-bottom"><i class="fa fa-comment"></i> &nbsp;<a href="link-here">Comment</a></button>
                    </div>
                          """;
            card += card.replace("para-here", q.getBody()).replace("user-here",
                    user.getFname() + " " + user.getLname());
        }
        s = s.replace("cards-here", card);

        out.print(s);

    }

}
