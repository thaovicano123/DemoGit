/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.DriverManager;
import java.sql.Connection;
/**
 *
 * @author Admin
 */
public class DatabaseHelper {
    public static final String connectionUrl = "jdbc:sqlserver://localhost;databaseName=DBst;user=sa;password=123;encrypt=true;trustServerCertificate=true;";
    public static Connection getDBConnect() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println("Chưa có Driver"+ e.toString());
        }
        try {
            conn = DriverManager.getConnection(connectionUrl);
            return conn;
        } catch (Exception e) {
            System.out.println("Lỗi connect"+ e.toString());
        }
        return null;
    }

    public static Connection getDBCconnect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
