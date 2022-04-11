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
public class Model_LoaiPhong {

    int maLP;
    String tenLP;
    double donGia;
    int soNguoi;
    String hinh;

    public Model_LoaiPhong() {
    }

    public Model_LoaiPhong(int maLP, String tenLP, double donGia, int soNguoi, String hinh) {
        this.maLP = maLP;
        this.tenLP = tenLP;
        this.donGia = donGia;
        this.soNguoi = soNguoi;
        this.hinh = hinh;
    }

    public int getMaLP() {
        return maLP;
    }

    public void setMaLP(int maLP) {
        this.maLP = maLP;
    }

    public String getTenLP() {
        return tenLP;
    }

    public void setTenLP(String tenLP) {
        this.tenLP = tenLP;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(int soNguoi) {
        this.soNguoi = soNguoi;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

}
