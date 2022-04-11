/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.Model;

/**
 *
 * @author PC
 */
public class Model_HoaDonTamTinh {
    
    int maHDtamtinh;
    int maHD;
    double tongTien;
    int trangThai;

    public Model_HoaDonTamTinh() {
    }

    public Model_HoaDonTamTinh(int maHDtamtinh, int maHD, double tongTien, int trangThai) {
        this.maHDtamtinh = maHDtamtinh;
        this.maHD = maHD;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public int getMaHDtamtinh() {
        return maHDtamtinh;
    }

    public void setMaHDtamtinh(int maHDtamtinh) {
        this.maHDtamtinh = maHDtamtinh;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
