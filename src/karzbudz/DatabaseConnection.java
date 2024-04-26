/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karzbudz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Typical default settings for a MySQL database accessed via phpMyAdmin
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/user_auth";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASS = "";  // phpMyAdmin often has no password for 'root' by default

    public static Connection getConnection() throws SQLException {
        // Ensure the MySQL JDBC driver is loaded
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL Driver not found", e);
        }
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASS);
    }
}   