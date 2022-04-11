/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.Model;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Model_HoaDon {

    int maHD;
    int maKH;
    Date ngayThanhToan;
    int hinhThucThanhToan;
    String maKM;
    double tongTien;
    int maPhieuDK;
    String maNV;
    int trangThai;

    public Model_HoaDon() {
    }

    public Model_HoaDon(int maHD, int maKH, Date ngayThanhToan, int hinhThucThanhToan, String maKM, double tongTien, int maPhieuDK, String maNV, int trangthai) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.ngayThanhToan = ngayThanhToan;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.maKM= maKM;
        this.tongTien = tongTien;
        this.maPhieuDK = maPhieuDK;
        this.maNV = maNV;
        this.trangThai =trangthai;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }
     public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangthai) {
        this.trangThai = trangthai;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(int hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }
    
    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }
    
    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getMaPhieuDK() {
        return maPhieuDK;
    }

    public void setMaPhieuDK(int maPhieuDK) {
        this.maPhieuDK = maPhieuDK;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

}
