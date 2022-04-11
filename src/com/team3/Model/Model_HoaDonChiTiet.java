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
public class Model_HoaDonChiTiet {

    int iD;
    int maHD;
    int maDV;
    int soLuong;
    Date ngayThem;
    String ghiChu;
    String tendv;
    double dongia;
    double tongtiendichvu;

    public Model_HoaDonChiTiet() {
    }

    public Model_HoaDonChiTiet(int maHD, int maDV, int soLuong, String tendv, double dongia) {
        this.maHD = maHD;
        this.maDV = maDV;
        this.soLuong = soLuong;
        this.tendv = tendv;
        this.dongia = dongia;
    }

    public Model_HoaDonChiTiet(int iD, int maHD, int maDV, int soLuong, Date ngayThem, String ghiChu) {
        this.iD = iD;
        this.maHD = maHD;
        this.maDV = maDV;
        this.soLuong = soLuong;
        this.ngayThem = ngayThem;
        this.ghiChu = ghiChu;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaDV() {
        return maDV;
    }

    public void setMaDV(int maDV) {
        this.maDV = maDV;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Date ngayThem) {
        this.ngayThem = ngayThem;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public double getTongtiendichvu() {
        return tongtiendichvu;
    }

    public void setTongtiendichvu(double tongtiendichvu) {
        this.tongtiendichvu = tongtiendichvu;
    }

}
