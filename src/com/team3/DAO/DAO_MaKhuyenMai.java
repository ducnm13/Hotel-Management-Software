/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.DAO;

import com.team3.Helpers.ConnectorJDBC;
import com.team3.Helpers.DateHelper;
import com.team3.Model.Model_MaKhuyenMai;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DAO_MaKhuyenMai {
    public void insert(Model_MaKhuyenMai model) {
        String sql = "Insert into MaKhuyenMai (MaKhuyenMai, GiaTri, ThoiHan, TrangThai, NgayTao) Values (?,?,?,?,?)";
        ConnectorJDBC.executeUpdate(sql,
                model.getMaKM(),
                model.getGiaTri(),
                DateHelper.toString(model.getThoiHan(), "MM/dd/yyyy"),
                model.getTrangThai(),
                DateHelper.toString(model.getNgayTao(), "MM/dd/yyyy"));
    }

    public void update(Model_MaKhuyenMai model) {
        String sql = "Update MaKhuyenMai Set GiaTri = ?, ThoiHan = ?, TrangThai = ? Where MaKhuyenMai = ?";
        ConnectorJDBC.executeUpdate(sql,
                model.getGiaTri(),
                DateHelper.toString(model.getThoiHan(), "MM/dd/yyyy"),
                model.getTrangThai(),
                model.getMaKM());
    }

    public void delete(String maKM) {
        String sql = "Delete From MaKhuyenMai Where MaKhuyenMai = ?";
        ConnectorJDBC.executeUpdate(sql, maKM);
    }
    
    public List<Model_MaKhuyenMai> select() {
        String sql = "Select * From MaKhuyenMai";
        return this.select(sql, new Object[0]);
    }

    public Model_MaKhuyenMai findByMa(String maKM) {
        String sql = "Select * From MaKhuyenMai Where MaKhuyenMai = ?";
        List<Model_MaKhuyenMai> list = this.select(sql, maKM);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    private List<Model_MaKhuyenMai> select(String sql, Object... args) {
        ArrayList<Model_MaKhuyenMai> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectorJDBC.executeQuery(sql, args);
                while (rs.next()) {
                    Model_MaKhuyenMai model = this.readfromresultset(rs);
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

    private Model_MaKhuyenMai readfromresultset(ResultSet rs) throws SQLException {
        Model_MaKhuyenMai model = new Model_MaKhuyenMai();
        model.setMaKM(rs.getString("MaKhuyenMai"));
        model.setGiaTri(rs.getDouble("GiaTri"));
        model.setThoiHan(rs.getDate("ThoiHan"));
        model.setTrangThai(rs.getInt("TrangThai"));
        return model;
    }
}
