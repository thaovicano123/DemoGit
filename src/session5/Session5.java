/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package session5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Admin
 */
public class Session5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // Create a variable for the connection string.
      String connectionUrl = "jdbc:sqlserver://localhost;databaseName=DBst;user=sa;password=123;encrypt=true;trustServerCertificate=true;";

        try (Connection con = DriverManager.getConnection(connectionUrl);
                Statement stmt = con.createStatement();) {
            String SQL = "SELECT TOP 10 * FROM TienDien";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("MaND") + " " + rs.getString("HoTen")+ " " + rs.getString("soDT")+ " " + rs.getString("soTien"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
