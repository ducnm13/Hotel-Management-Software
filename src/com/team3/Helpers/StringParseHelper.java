/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.Helpers;

/**
 *
 * @author MyPC
 */
public class StringParseHelper {
    public static String TrangThaitoString(int IntTrangThai) {
        String StringTrangThai = null;
        switch (IntTrangThai) {
            case 0:
                StringTrangThai = "Đang xử lý";
                break;
            case 1:
                StringTrangThai = "Hoàn thành";
                break;
            case 2:
                StringTrangThai = "Hủy";
                break;
            default:            
        }
        return StringTrangThai;
    }
    public static String VaiTrotoString(int IntVaiTro) {
        String StringVaiTro = null;
        switch (IntVaiTro) {
            case 0:
                StringVaiTro = "Thường";
                break;
            case 1:
                StringVaiTro = "Nhân Viên";
                break;
            case 2:
                StringVaiTro = "Admin";
                break;
            default:            
        }
        return StringVaiTro;
    }
    public static String NhomTBtoString(int IntNhomTB) {
        String StringTrangThai = null;
        switch (IntNhomTB) {
            case 0:
                StringTrangThai = "Chung";
                break;
            case 1:
                StringTrangThai = "Thường";
                break;
            case 2:
                StringTrangThai = "VIP";
                break;
            default:
        }
        return StringTrangThai;
    }
    public static String TrangThaiMKMtoString(int IntMaKM) {
        String StringTrangThai = null;
        switch (IntMaKM) {
            case 0:
                StringTrangThai = "Chưa sử dụng";
                break;
            case 1:
                StringTrangThai = "Đã sử dụng";
                break;
            case 2:
                StringTrangThai = "Hết hạn sử dụng";
                break;
            default:
        }
        return StringTrangThai;
    }
    
    public static String HinhThucThanhToantoString(int IntHinhThuc) {
        String StringTrangThai = null;
        switch (IntHinhThuc) {
            case 0:
                StringTrangThai = "Tiền mặt";
                break;
            case 1:
                StringTrangThai = "Thẻ";
                break;
            default:
        }
        return StringTrangThai;
    }
}
