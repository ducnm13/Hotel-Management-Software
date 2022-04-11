/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.DAO;

import com.team3.Helpers.ConnectorJDBC;
import com.team3.Model.Model_HoaDonTamTinh;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DAO_HoaDonTamTinh {

    public void insert(Model_HoaDonTamTinh model) {
        String sql = "Insert into HoaDonTamTinh (MaHoaDon, TongTien, TrangThai) Values (?,?,?)";
        ConnectorJDBC.executeUpdate(sql, model.getMaHD(), model.getTongTien(), model.getTrangThai());
    }

    public void update(Model_HoaDonTamTinh model) {
        String sql = "Update HoaDonTamTinh Set TongTien = ?, TrangThai = ? Where MaHoaDonTamTinh = ?";
        ConnectorJDBC.executeUpdate(sql, model.getTongTien(), model.getTrangThai(), model.getMaHDtamtinh());
    }
    
    public void delete(int mahd){
        String sql = "Delete From HoaDonTamTinh Where MaHoaDon = ?";
        ConnectorJDBC.executeUpdate(sql, mahd);
    }

    public List<Model_HoaDonTamTinh> select() {
        String sql = "Select * From HoaDonTamTinh";
        return this.select(sql, new Object[0]);
    }

    public Model_HoaDonTamTinh findByMaHD(int maHD) {
        String sql = "Select * From HoaDonTamTinh Where MaHoaDon = ?";
        List<Model_HoaDonTamTinh> list = this.select(sql, maHD);
        return list.size() > 0 ? list.get(0) : null;
    }
    private List<Model_HoaDonTamTinh> select(String sql, Object ... args) {
        ArrayList<Model_HoaDonTamTinh> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectorJDBC.executeQuery(sql, args);
                while (rs.next()) {
                    Model_HoaDonTamTinh model = this.readfromresultset(rs);
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

    private Model_HoaDonTamTinh readfromresultset(ResultSet rs) throws SQLException {
        Model_HoaDonTamTinh model = new Model_HoaDonTamTinh();
        model.setMaHDtamtinh(rs.getInt("MaHoaDonTamTinh"));
        model.setMaHD(rs.getInt("MaHoaDon"));
        model.setTongTien(rs.getDouble("TongTien"));
        model.setTrangThai(rs.getInt("TrangThai"));
        return model;
    }
}
