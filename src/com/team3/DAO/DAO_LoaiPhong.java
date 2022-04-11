/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.DAO;

import com.team3.Helpers.ConnectorJDBC;
import com.team3.Model.Model_LoaiPhong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DAO_LoaiPhong {

    public void insert(Model_LoaiPhong model) {
        String sql = "Insert into LoaiPhong (TenLoaiPhong, DonGia, SoNguoi, HinhAnh) VALUES(?,?,?,?)";
        ConnectorJDBC.executeUpdate(sql, model.getTenLP(), model.getDonGia(), model.getSoNguoi(), model.getHinh()
        );
    }

    public void update(Model_LoaiPhong model) {
        String sql = "Update LoaiPhong Set TenLoaiPhong = ?, DonGia = ?, SoNguoi = ?, HinhAnh = ? Where MaLoaiPhong = ?";
        ConnectorJDBC.executeUpdate(sql, model.getTenLP(), model.getDonGia(), model.getSoNguoi(), model.getHinh(), model.getMaLP());
    }

    public void delete(String maLP) {
        String sql = "Delete From LoaiPhong Where MaLoaiPhong = ?";
        ConnectorJDBC.executeUpdate(sql, maLP);
    }

    public List<Model_LoaiPhong> select() {
        String sql = "Select * From LoaiPhong";
        return this.select(sql, new Object[0]);
    }

    public Model_LoaiPhong findById(String MaLoaiPhong) {
        String sql = "SELECT * FROM LoaiPhong WHERE MaLoaiPhong=?";
        List<Model_LoaiPhong> list = select(sql, MaLoaiPhong);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Model_LoaiPhong> findByKeyword(String keyword) {
        String sql = "Select * From LoaiPhong Where TenLoaiPhong LIKE ?";
        return this.select(sql, "%" + keyword + "%");
    }
    
    public List<Model_LoaiPhong> findExactKeyword(String keyword) {
        String sql = "Select * From LoaiPhong Where TenLoaiPhong = ?";
        return this.select(sql,keyword);
    }

    private List<Model_LoaiPhong> select(String sql, Object... args) {
        List<Model_LoaiPhong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectorJDBC.executeQuery(sql, args);
                while (rs.next()) {
                    Model_LoaiPhong model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private Model_LoaiPhong readFromResultSet(ResultSet rs) throws SQLException {
        Model_LoaiPhong model = new Model_LoaiPhong();
        model.setMaLP(rs.getInt("MaLoaiPhong"));
        model.setTenLP(rs.getString("TenLoaiPhong"));
        model.setDonGia(rs.getDouble("DonGia"));
        model.setSoNguoi(rs.getInt("SoNguoi"));
        model.setHinh(rs.getString("HinhAnh"));
        return model;
    }
}
