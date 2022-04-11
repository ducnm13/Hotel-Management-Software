/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.Model;

/**
 *
 * @author Admin
 */
public class Model_Phong {

    private String MaPhong;
    private String TenPhong;
    private int TrangThai;
    private String GhiChu;
    private String MaLoaiPhong;
    private String Tang;

    public Model_Phong() {
    }

    public Model_Phong(String MaPhong, String TenPhong, int TrangThai, String GhiChu, String MaLoaiPhong, String Tang) {
        this.MaPhong = MaPhong;
        this.TenPhong = TenPhong;
        this.TrangThai = TrangThai;
        this.GhiChu = GhiChu;
        this.MaLoaiPhong = MaLoaiPhong;
        this.Tang = Tang;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public void setMaLoaiPhong(String MaLoaiPhong) {
        this.MaLoaiPhong = MaLoaiPhong;
    }
    
    public void setTang(String Tang) {
        this.Tang = Tang;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public String getMaLoaiPhong() {
        return MaLoaiPhong;
    }
    
    public String getTang() {
        return Tang;
    }
}
