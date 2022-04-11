/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.DAO;

import com.team3.Model.Model_NhanVien;
import com.team3.Helpers.ConnectorJDBC;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author MyPC
 */
public class DAO_NhanVien {
    public void insert(Model_NhanVien model) throws SQLException {
        String sql = "Insert into NhanVien (MaNhanVien,Password,Ho,Ten,Email,SDT,DiaChi,GioiTinh,Hinh,VaiTro) Values (?,?,?,?,?,?,?,?,?,?)";
        ConnectorJDBC.executeUpdate(sql, model.getMaNV(), model.getMatKhau(), model.getHo(), model.getTen(), model.getEmail(), model.getSDT(), model.getDiaChi(), model.getGioiTinh(), model.getHinh(), model.getVaiTro());
    }

    public void update(Model_NhanVien model) throws SQLException {
        String sql = "Update NhanVien Set Password = ?,Ho = ?,Ten = ?,Email = ? ,SDT = ?,DiaChi = ?,GioiTinh = ?,Hinh =?,VaiTro = ? Where MaNhanVien=?";
        ConnectorJDBC.executeUpdate(sql, model.getMatKhau(),model.getHo(), model.getTen(), model.getEmail(), model.getSDT(), model.getDiaChi(), model.getGioiTinh(), model.getHinh(), model.getVaiTro(), model.getMaNV() );
    }
    
    public void updateFGPass(String pass,String Email) throws SQLException {
        String sql = "Update NhanVien Set Password=? Where Email=?";
        ConnectorJDBC.executeUpdate(sql, pass,Email);
    }

    public void delete(String MaNV) throws SQLException {
        String sql = "Delete From NhanVien Where MaNhanVien=?";
        ConnectorJDBC.executeUpdate(sql, MaNV);
    }

    public List<Model_NhanVien> select() {
        String sql = "Select * From NhanVien";
        return this.select(sql, new Object[0]);
    }

    public Model_NhanVien findById(String manv) {
        String sql = "Select*From NhanVien Where MaNhanVien=?";
        List<Model_NhanVien> list = this.select(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }
    public Model_NhanVien findByEmail(String Email) {
        String sql = "Select*From NhanVien Where Email=?";
        List<Model_NhanVien> list = this.select(sql, Email);
        return list.size() > 0 ? list.get(0) : null;
    }
    public List<Model_NhanVien> findByKeyword(String keyword) {
        String sql = "SELECT * FROM NhanVien WHERE Ten LIKE ?";
        return this.select(sql, "%" + keyword + "%");
    }

    private List<Model_NhanVien> select(String sql, Object ... args) {
        ArrayList<Model_NhanVien> list = new ArrayList<Model_NhanVien>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectorJDBC.executeQuery(sql, args);
                while (rs.next()) {
                    Model_NhanVien model = this.readfromresultset(rs);
                    list.add(model);
                }
            }
            finally {
                rs.getStatement().getConnection().close();
            }
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private Model_NhanVien readfromresultset(ResultSet rs) throws SQLException {
        Model_NhanVien model = new Model_NhanVien();
        model.setMaNV(rs.getString("MaNhanVien"));
        model.setMatKhau(rs.getString("Password"));
        model.setHo(rs.getString("Ho"));
        model.setTen(rs.getString("Ten"));
        model.setEmail(rs.getString("Email"));
        model.setSDT(rs.getString("SDT"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setHinh(rs.getString("Hinh"));
        model.setVaiTro(rs.getInt("VaiTro"));
        return model;
    }
}
