/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.DAO;

import com.team3.Helpers.ConnectorJDBC;
import com.team3.Helpers.DateHelper;
import com.team3.Model.Model_HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DAO_HoaDon {

    public void insert(Model_HoaDon model) {
        String sql = "Insert into HoaDon (NgayThanhToan, HinhThucThanhToan, MaKhuyenMai, TongTien, MaPhieuDK, MaNhanVien, TrangThai) Values (?,?,?,?,?,?,?)";
        ConnectorJDBC.executeUpdate(sql,
                model.getNgayThanhToan(),
                model.getHinhThucThanhToan(),
                model.getMaKM(),
                model.getTongTien(),
                model.getMaPhieuDK(),
                model.getMaNV(),
                model.getTrangThai());
    }

    public void update(Model_HoaDon model) {
        String sql = "Update HoaDon Set NgayThanhToan = ?, HinhThucThanhToan = ?, MaKhuyenMai = ?, TongTien = ?, MaPhieuDK = ?, MaNhanVien = ?, TrangThai = ? Where MaHoaDon = ?";
        ConnectorJDBC.executeUpdate(sql,
                DateHelper.toString(model.getNgayThanhToan(), "MM/dd/yyyy"),
                model.getHinhThucThanhToan(),
                model.getMaKM(),
                model.getTongTien(),
                model.getMaPhieuDK(),
                model.getMaNV(),
                model.getTrangThai(),
                model.getMaHD());
    }

    public void delete(int maHD) {
        String sql = "Delete From HoaDon Where MaHoaDon = ?";
        ConnectorJDBC.executeUpdate(sql, maHD);
    }

    public List<Model_HoaDon> select() {
        String sql = "Select * From HoaDon";
        return this.select(sql, new Object[0]);
    }
    
    public Model_HoaDon findById(String maHD) {
        String sql = "Select * From HoaDon Where MaHoaDon = ?";
        List<Model_HoaDon> list = this.select(sql, maHD);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public Model_HoaDon findByMaPDK(int maPDK) {
        String sql = "Select * From HoaDon Where MaPhieuDK = ?";
        List<Model_HoaDon> list = this.select(sql, maPDK);
        return list.size() > 0 ? list.get(0) : null;
    }

    public Model_HoaDon findUnpaidByMaPDK(int maPDK) {
        String sql = "Select * From HoaDon Where MaPhieuDK = ? AND TrangThai=0";
        List<Model_HoaDon> list = this.select(sql, maPDK);
        return list.size() > 0 ? list.get(0) : null;
    }    

    private List<Model_HoaDon> select(String sql, Object... args) {
        ArrayList<Model_HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectorJDBC.executeQuery(sql, args);
                while (rs.next()) {
                    Model_HoaDon model = this.readfromresultset(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return list;
    }

    private Model_HoaDon readfromresultset(ResultSet rs) throws SQLException {
        Model_HoaDon model = new Model_HoaDon();
        model.setMaHD(rs.getInt("MaHoaDon"));
        model.setNgayThanhToan(rs.getDate("NgayThanhToan"));
        model.setHinhThucThanhToan(rs.getInt("HinhThucThanhToan"));
        model.setMaKM(rs.getString("MaKhuyenMai"));
        model.setTongTien(rs.getDouble("TongTien"));
        model.setMaPhieuDK(rs.getInt("MaPhieuDK"));
        model.setMaNV(rs.getString("MaNhanVien"));
        model.setTrangThai(rs.getInt("TrangThai"));
        return model;
    }
}
