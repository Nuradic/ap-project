package com.utils;

import java.sql.SQLException;
import java.util.*;
import javax.servlet.http.*;

import com.jdbc.Database;
import com.models.User;
// how to create java bean object? 

//Source: https://stackoverflow.com/questions/3295496

public class Authentication {

    public static HttpServletResponse authenticate(HttpServletRequest req, HttpServletResponse res)
            throws ClassNotFoundException, SQLException {
        Cookie[] cookies = req.getCookies();
        Cookie cookie;
        Map<String, Object> map = new TreeMap<String, Object>();
        User user;

        if (cookies != null) {

            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                map.put(cookie.getName(), cookie.getValue());

            }

            if ((map.containsKey("id") && map.containsKey("password"))) {
                System.out.println(map.get("id"));

                int id = Integer.parseInt((String) map.get("id"));

                String pass = (String) map.get("password");

                user = authenticate(id, pass);

                if (user != null)
                    return res;

            }
        }

        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        email = "'" + email + "'";

        user = Database.getUser(email);

        if (user == null)
            return null;

        String password = user.getPassword();

        if (password.equals(pass)) {
            return setCookie(res, user);
        }

        return null;

    }

    public static User authenticate(int id, String pass) throws ClassNotFoundException, SQLException {
        User user = Database.getUser(id);

        if (user == null) {
            return null;

        }
        String password = user.getPassword();

        if (password.equals(pass)) {
            return user;
        }
        return null;
    }

    public static HttpServletResponse setCookie(HttpServletResponse res, User user) {

        Cookie cookie = new Cookie("id", "" + user.getId());

        Cookie c2 = new Cookie("password", user.getPassword());

        res.addCookie(cookie);
        res.addCookie(c2);

        return res;

    }

}
