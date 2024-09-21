/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import database.DatabaseHelper;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import models.Local;


/**
 *
 * @author Admin
 */
public class LocalDAO {
        Connection conn = null;
        PreparedStatement sttm = null;
  public int add(Local lc){
      try {
          String sSQL = "insert TienDien(MaND,HoTen,soDT,Diachi,GioiTinh,soTien) values(?,?,?,?,?,?)";
          //chú ý: khong sử dụng'?'//sai
         Connection conn = DatabaseHelper.getDBConnect();
         sttm = conn.prepareStatement(sSQL);
         sttm.setString(1, lc.getMaND());
         sttm.setString(2, lc.getHoTen());
         sttm.setString(3, lc.getSoDT());
         sttm.setString(4, lc.getDiaChi());
         sttm.setBoolean(5, lc.isGioiTinh());
         sttm.setString(6, lc.getSoTien());
         if(sttm.executeUpdate()>0) {
             System.out.println("Insert thanh công");
             return 1;
         }
      } catch (Exception e) {
          System.out.println("Error:"+e.toString());
      }
      return -1;
  } 
  public int update(Local lc){
      try {
          String sSQL = "update TienDien set HoTen = ?, soDT = ?, Diachi = ?, GioiTinh = ?, soTien = ? where MaND =?";
          //chú ý: khong sử dụng'?'//sai
         Connection conn = DatabaseHelper.getDBConnect();
         sttm = conn.prepareStatement(sSQL);
         sttm.setString(6, lc.getMaND());
         sttm.setString(1, lc.getHoTen());
         sttm.setString(2, lc.getSoDT());
         sttm.setString(3, lc.getDiaChi());
         sttm.setBoolean(4, lc.isGioiTinh());
         sttm.setString(5, lc.getSoTien());
         if(sttm.executeUpdate()>0) {
             System.out.println("update thanh công");
             return 1;
         }
      } catch (Exception e) {
          System.out.println("Error:"+e.toString());
      }
      return -1;
  }
  public int delete(String maND){
      try {
          String sSQL = "delete TienDien where MaND = ?";
          //chú ý: khong sử dụng'?'//sai
         Connection conn = DatabaseHelper.getDBConnect();
         sttm = conn.prepareStatement(sSQL);
         sttm.setString(1, maND);
         if(sttm.executeUpdate()>0) {
             System.out.println("delete thanh công");
             return 1;
         }
      } catch (Exception e) {
          System.out.println("Error:"+e.toString());
      }
      return -1;
  } 
  public List<Local> getAll(){
      List<Local> ls = new ArrayList<>();
      ResultSet rs = null;
      Statement sttm = null;
      
      try {
          String sSQL = "select * from tiendien";
          conn = DatabaseHelper.getDBConnect();
          sttm = conn.createStatement();
          rs = sttm.executeQuery(sSQL);
          while (rs.next()){
              Local lc = new Local();
              lc.setMaND(rs.getString(1));
               lc.setHoTen(rs.getString(2));
                lc.setSoDT(rs.getString(3));
                 lc.setDiaChi(rs.getString(4));
                  lc.setGioiTinh(rs.getBoolean(5));
                   lc.setSoTien(rs.getString(6));
                ls.add(lc);
          }
          
      } catch (Exception e) {
          System.out.println("Error: "+ e.toString());
      }
      finally{
          try {
              rs.close(); sttm.close(); conn.close();
          } catch (Exception e) {
          }
      }
      return ls;
  }
  public Local findLocalByID(String maND){
      ResultSet rs = null;
      Statement sttm = null;
      
      try {
          String sSQL = "select * from tiendien where MaND='"+maND+"'";
          conn = DatabaseHelper.getDBConnect();
          sttm = conn.createStatement();
          rs = sttm.executeQuery(sSQL);
          while (rs.next()){
              Local lc = new Local();
              lc.setMaND(rs.getString(1));
               lc.setHoTen(rs.getString(2));
                lc.setSoDT(rs.getString(3));
                 lc.setDiaChi(rs.getString(4));
                  lc.setGioiTinh(rs.getBoolean(5));
                   lc.setSoTien(rs.getString(6));
                return lc;
          }
          
      } catch (Exception e) {
          System.out.println("Error: "+ e.toString());
      }
      finally{
          try {
              rs.close(); sttm.close(); conn.close();
          } catch (Exception e) {
          }
      }
      return null;
  }
  
}
