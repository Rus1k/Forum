package com.forumapp.repository;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/forum";
    private static final String USERNAME = "forum_admin";
    private static final String PASSWORD = "123456";

    private Connect() {
    }

    public static Connection getConnect() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("connect successfully!");
            }
        } catch (SQLException e) {
            System.out.println("connect NOT successfully!");
        }
        return connection;
    }
}
