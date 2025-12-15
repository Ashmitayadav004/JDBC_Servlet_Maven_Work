package com.library.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
    private static String url;
    private static String user;
    private static String pass;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties p = new Properties();
            try (InputStream is = DBConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
                p.load(is);
            }
            url = p.getProperty("db.url");
            user = p.getProperty("db.username");
            pass = p.getProperty("db.password");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, pass);
    }
}
