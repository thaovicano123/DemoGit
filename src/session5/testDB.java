/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session5;

import database.DatabaseHelper;
import java.sql.Connection;
import models.Local;
import models.LocalDAO;
/**
 *
 * @author Admin
 */
public class testDB {
    public static void main(String[] args) {
        Connection conn = DatabaseHelper.getDBConnect();
        LocalDAO dao = new LocalDAO();
        if(conn != null) {
            System.out.println("Connect thành công");
            //add
            //Local lc1 = new Local("PD002", "Hoang", "9585", "da nang", true, "43544");
            //dao.add(lc1);
            //dao.update(lc1);
            //Local lc2 = new Local("PD002");
            //dao.delete(lc2);
            for (Local lc : dao.getAll()){
                System.out.println(lc.toString());
            }
           // Local find = dao.findLocalByID("PD003");
            //if(find != null) {
             //   System.out.println("tìm thấy");
             //   System.out.println(find.toString());
           // }
       // } else {
        //    System.out.println("Connect thất bại");
        }
    }
}
