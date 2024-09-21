/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Admin
 */
public class Local {
    private String maND, hoTen, soDT, diaChi, soTien;
    private boolean gioiTinh;

    public Local(String maND, String hoTen, String soDT, String diaChi, boolean gioiTinh, String soTien) {
    this.maND = maND;
    this.hoTen = hoTen;
    this.soDT = soDT;
    this.diaChi = diaChi;
    this.gioiTinh = gioiTinh;
    this.soTien = soTien;
}
    public Local() {
}

    public Local(String maND) {
        this.maND = maND;
    }

    public String getMaND() {
        return maND;
    }

    public void setMaND(String maND) {
        this.maND = maND;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoTien() {
        return soTien;
    }

    public void setSoTien(String soTien) {
        this.soTien = soTien;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return "Local{" + "maND=" + maND + ", hoTen=" + hoTen + ", soDT=" + soDT + ", diaChi=" + diaChi + ", soTien=" + soTien + ", gioiTinh=" + gioiTinh + '}';
    }
    
    
    
    
}
