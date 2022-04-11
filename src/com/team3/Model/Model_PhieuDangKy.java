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
public class Model_PhieuDangKy {

    int maPhieuDK;
    Date ngayLap;
    Date ngayNhanPhong;
    Date ngayTraPhongDuKien;
    Date ngayTraPhongThucTe;
    int trangThai;
    int maKH;
    String maNV;
    int maPhong;

    public Model_PhieuDangKy() {
    }

    public Model_PhieuDangKy(int maPhieuDK, Date ngayLap, Date ngayNhanPhong, Date ngayTraPhongDuKien, Date ngayTraPhongThucTe, int trangThai, int maKH, String maNV, int maPhong) {
        this.maPhieuDK = maPhieuDK;
        this.ngayLap = ngayLap;
        this.ngayNhanPhong = ngayNhanPhong;
        this.ngayTraPhongDuKien = ngayTraPhongDuKien;
        this.ngayTraPhongThucTe = ngayTraPhongThucTe;
        this.trangThai = trangThai;
        this.maKH = maKH;
        this.maNV = maNV;
        this.maPhong = maPhong;
    }

    public int getMaPhieuDK() {
        return maPhieuDK;
    }

    public void setMaPhieuDK(int maPhieuDK) {
        this.maPhieuDK = maPhieuDK;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public Date getNgayNhanPhong() {
        return ngayNhanPhong;
    }

    public void setNgayNhanPhong(Date ngayNhanPhong) {
        this.ngayNhanPhong = ngayNhanPhong;
    }

    public Date getNgayTraPhongDuKien() {
        return ngayTraPhongDuKien;
    }

    public void setNgayTraPhongDuKien(Date ngayTraPhongDuKien) {
        this.ngayTraPhongDuKien = ngayTraPhongDuKien;
    }

    public Date getNgayTraPhongThucTe() {
        return ngayTraPhongThucTe;
    }

    public void setNgayTraPhongThucTe(Date ngayTraPhongThucTe) {
        this.ngayTraPhongThucTe = ngayTraPhongThucTe;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

}
