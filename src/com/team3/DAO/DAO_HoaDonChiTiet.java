/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.DAO;

import com.team3.Helpers.ConnectorJDBC;
import com.team3.Helpers.DateHelper;
import com.team3.Model.Model_HoaDonChiTiet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DAO_HoaDonChiTiet {

    public void insert(Model_HoaDonChiTiet model) {
        String sql = "Insert into HoaDonChiTiet (MaHoaDon, MaDichVu, SoLuong, NgayThem, GhiChu) Values (?,?,?,?,?)";
        ConnectorJDBC.executeUpdate(sql, model.getMaHD(), model.getMaDV(), model.getSoLuong(), model.getNgayThem(), model.getGhiChu());
    }

    public void update(Model_HoaDonChiTiet model) {
        String sql = "Update HoaDonChiTiet Set SoLuong = ?, NgayThem = ?, GhiChu = ? Where MaHoaDon = ? AND MaDichVu = ?";
        ConnectorJDBC.executeUpdate(sql, model.getSoLuong(), model.getNgayThem(), model.getGhiChu(), model.getMaHD(), model.getMaDV());
    }

    public void delete(int maHD, int maDV) {
        String sql = "Delete From HoaDonChiTiet Where MaHoaDon = ? AND MaDichVu = ?";
        ConnectorJDBC.executeUpdate(sql, maHD, maDV);
    }

    public void deletea(int maHD) {
        String sql = "Delete From HoaDonChiTiet Where MaHoaDon = ? ";
        ConnectorJDBC.executeUpdate(sql, maHD);
    }

    public List<Model_HoaDonChiTiet> select() {
        String sql = "Select * From HoaDonChiTiet";
        return this.select(sql, new Object[0]);
    }
    
    public List<Model_HoaDonChiTiet> selectHDCTandDV(int maHD) {
        List<Model_HoaDonChiTiet> list = new ArrayList<Model_HoaDonChiTiet>();
        String sql = "SELECT MaHoaDon, DichVu.MaDichVu, Soluong, Ten, DonGia "
                + "FROM dbo.HoaDonChiTiet JOIN dbo.DichVu ON DichVu.MaDichVu = HoaDonChiTiet.MaDichVu Where MaHoaDon = ?";
        list = this.selectHDCTandDV(sql, maHD);
        if (list.size() == 0) {
            list = null;
        }
        return list;
    }

    public List<Model_HoaDonChiTiet> TongGiaDV(int maHD) {
        String sql = "SELECT SUM(DonGia*Soluong) AS N'TongGia'\n"
                + "FROM dbo.HoaDonChiTiet JOIN dbo.DichVu ON DichVu.MaDichVu = HoaDonChiTiet.MaDichVu\n"
                + "WHERE MaHoaDon = ?";
        return this.selectTongGiaDV(sql, maHD);
    }

//    public List<Model_HoaDonChiTiet> selectbyMaHoaDon(int maHD) {
//        String sql = "Select * From HoaDonChiTiet WHERE MaHoaDon = ? ";
//        return this.select(sql, maHD);
//    }
    public List<Model_HoaDonChiTiet> selectbyMaHoaDon(int maHD) {
        List<Model_HoaDonChiTiet> list = new ArrayList<Model_HoaDonChiTiet>();
        String sql = "Select * From HoaDonChiTiet WHERE MaHoaDon = ?";
        list = this.select(sql, maHD);
        if (list.size() == 0) {
            list = null;
        }
        return list;
    }

    public Model_HoaDonChiTiet findById(String iD) {
        String sql = "Select * From HoaDonChiTiet Where ID = ?";
        List<Model_HoaDonChiTiet> list = this.select(sql, iD);
        return list.size() > 0 ? list.get(0) : null;
    }

    public Model_HoaDonChiTiet findByMaHD(int maHD) {
        String sql = "Select * From HoaDonChiTiet Where MaHoaDon = ?";
        List<Model_HoaDonChiTiet> list = this.select(sql, maHD);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<Model_HoaDonChiTiet> select(String sql, Object... args) {
        ArrayList<Model_HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectorJDBC.executeQuery(sql, args);
                while (rs.next()) {
                    Model_HoaDonChiTiet model = this.readfromresultset(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();

        }
        return list;
    }

    private List<Model_HoaDonChiTiet> selectHDCTandDV(String sql, Object... args) {
        ArrayList<Model_HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectorJDBC.executeQuery(sql, args);
                while (rs.next()) {
                    Model_HoaDonChiTiet model = this.readfromresultsetHDCTandDV(rs);
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
    
    private List<Model_HoaDonChiTiet> selectTongGiaDV(String sql, int maHD) {
        ArrayList<Model_HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectorJDBC.executeQuery(sql, maHD);
                while (rs.next()) {
                    Model_HoaDonChiTiet model = this.readfromresultsetTongGiaDV(rs);
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

    private Model_HoaDonChiTiet readfromresultset(ResultSet rs) throws SQLException {
        Model_HoaDonChiTiet model = new Model_HoaDonChiTiet();
        model.setMaHD(rs.getInt("MaHoaDon"));
        model.setMaDV(rs.getInt("MaDichVu"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setNgayThem(rs.getDate("NgayThem"));
        model.setGhiChu(rs.getNString("GhiChu"));
        return model;
    }

    private Model_HoaDonChiTiet readfromresultsetHDCTandDV(ResultSet rs) throws SQLException {
        Model_HoaDonChiTiet model = new Model_HoaDonChiTiet();
        model.setMaHD(rs.getInt("MaHoaDon"));
        model.setMaDV(rs.getInt("MaDichVu"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setTendv(rs.getString("Ten"));
        model.setDongia(rs.getDouble("DonGia"));
        return model;
    }

    private Model_HoaDonChiTiet readfromresultsetTongGiaDV(ResultSet rs) throws SQLException {
        Model_HoaDonChiTiet model = new Model_HoaDonChiTiet();
        model.setTongtiendichvu(rs.getDouble("TongGia"));
        return model;
    }

    
}
