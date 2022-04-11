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
public class Model_KhachHang {

    int maKH;
    String hoTen;
    String quocTich;
    String email;
    String diaChi;
    boolean gioiTinh;
    String sdt;
    String cmnd;
    String hinh;
    Date ngayThem;

    public Model_KhachHang() {
    }

    public Model_KhachHang(int maKH, String hoTen, String quocTich, String email, String diaChi, boolean gioiTinh, String sdt, String cmnd, String hinh, Date ngayThem) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.quocTich = quocTich;
        this.email = email;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.cmnd = cmnd;
        this.hinh = hinh;
        this.ngayThem = ngayThem;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public Date getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Date ngayThem) {
        this.ngayThem = ngayThem;
    }

}
