/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.DAO;

import com.team3.Helpers.ConnectorJDBC;
import com.team3.Helpers.DateHelper;
import com.team3.Model.Model_KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DAO_KhachHang {

    public void insert(Model_KhachHang model) throws SQLException {
        String sql = "Insert into KhachHang (HoTen, QuocTich, Email, DiaChi, GioiTinh, SDT, CMND, Hinh, NgayThem) Values (?,?,?,?,?,?,?,?,?)";
        ConnectorJDBC.executeUpdate(sql,
                model.getHoTen(),
                model.getQuocTich(),
                model.getEmail(),
                model.getDiaChi(),
                model.isGioiTinh(),
                model.getSdt(),
                model.getCmnd(),
                model.getHinh(),
                model.getNgayThem());
    }

    public void update(Model_KhachHang model) throws SQLException {
        String sql = "Update KhachHang Set HoTen = ?, QuocTich = ?, Email = ?, DiaChi = ?, GioiTinh = ?, SDT = ?, CMND = ?, Hinh = ?, NgayThem = ? Where MaKhachHang = ?";
        ConnectorJDBC.executeUpdate(sql,
                model.getHoTen(),
                model.getQuocTich(),
                model.getEmail(),
                model.getDiaChi(),
                model.isGioiTinh(),
                model.getSdt(),
                model.getCmnd(),
                model.getHinh(),
                DateHelper.toString(model.getNgayThem(), "MM/dd/yyyy"),
                model.getMaKH());
    }

    public void delete(String maKH) throws SQLException {
        String sql = "Delete From KhachHang Where MaKhachHang = ?";
        ConnectorJDBC.executeUpdate(sql, maKH);
    }

    public List<Model_KhachHang> select() {
        String sql = "Select * From KhachHang";
        return this.select(sql, new Object[0]);
    }
    
    public Model_KhachHang findById(int maKH) {
        String sql = "Select * From KhachHang Where MaKhachHang = ?";
        List<Model_KhachHang> list = this.select(sql, maKH);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public Model_KhachHang findByCMND(String soCMND) {
        String sql = "Select * From KhachHang Where CMND = ?";
        List<Model_KhachHang> list = this.select(sql, soCMND);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public List<Model_KhachHang> findByKeyword(String keyword) {
        String sql = "Select * From KhachHang Where HoTen LIKE ?";
        return this.select(sql, "%" + keyword + "%");
    }

    private List<Model_KhachHang> select(String sql, Object... args) {
        ArrayList<Model_KhachHang> list = new ArrayList<Model_KhachHang>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectorJDBC.executeQuery(sql, args);
                while (rs.next()) {
                    Model_KhachHang model = this.readfromresultset(rs);
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

    private Model_KhachHang readfromresultset(ResultSet rs) throws SQLException {
        Model_KhachHang model = new Model_KhachHang();
        model.setMaKH(rs.getInt("MaKhachHang"));
        model.setHoTen(rs.getString("HoTen"));
        model.setQuocTich(rs.getString("QuocTich"));
        model.setEmail(rs.getString("Email"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setSdt(rs.getString("SDT"));
        model.setCmnd(rs.getString("CMND"));
        model.setHinh(rs.getString("Hinh"));
        model.setNgayThem(rs.getDate("NgayThem"));
        return model;
    }
}
