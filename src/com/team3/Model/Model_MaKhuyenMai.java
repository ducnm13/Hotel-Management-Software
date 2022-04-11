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
public class Model_MaKhuyenMai {

    String maKM;
    double giaTri;
    Date thoiHan;
    int trangThai;
    Date ngayTao;

    public Model_MaKhuyenMai() {
    }

    public Model_MaKhuyenMai(String maKM, double giaTri, Date thoiHan, int trangThai, Date ngayTao) {
        this.maKM = maKM;
        this.giaTri = giaTri;
        this.thoiHan = thoiHan;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public double getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(double giaTri) {
        this.giaTri = giaTri;
    }

    public Date getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(Date thoiHan) {
        this.thoiHan = thoiHan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

}
