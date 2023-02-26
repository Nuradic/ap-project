package com.utils;

import java.util.ArrayList;

import javax.servlet.http.Cookie;

public class Session {
    private ArrayList<Cookie> cookies;

    private Session() {

    }

    private static Session instance = null;

    public static Session getInstance() {
        instance = instance == null ? new Session() : instance;
        return instance;
    };

    public ArrayList<Cookie> getCookies() {
        return cookies;
    }

    public void setCookies(ArrayList<Cookie> cookies) {
        this.cookies = cookies;
    }

    public void addCookie(Cookie cookie) {
        cookies.add(cookie);

    }

}
