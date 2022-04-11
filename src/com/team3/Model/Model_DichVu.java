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
public class Model_DichVu {
    int madv;
    String ten;
    double dongia;

    public Model_DichVu() {
    }

    public Model_DichVu(int madv, String ten, double dongia) {
        this.madv = madv;
        this.ten = ten;
        this.dongia = dongia;
    }

    public int getMadv() {
        return madv;
    }

    public void setMadv(int madv) {
        this.madv = madv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }
    
}
