package com.fitlog.fitlogai.session;

public class UserSession {

    private static String currentUser;

    public static void setUser(String username) {
        currentUser = username;
    }

    public static String getUser() {
        return currentUser;
    }

    public static void logout() {
        currentUser = null;
    }
}