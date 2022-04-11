/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.DAO;

import com.team3.Helpers.ConnectorJDBC;
import com.team3.Helpers.DateHelper;
import com.team3.Model.Model_PhieuDangKy;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
public class DAO_PhieuDangKy {

    public void insert(Model_PhieuDangKy model) {
        String sql = "Insert into PhieuDangKy (NgayLap, NgayNhanPhong, NgayTraPhongDuKien, NgayTraPhongThucTe, TrangThai, MaKhachHang, MaNhanVien, MaPhong) Values(?,?,?,?,?,?,?,?)";
        ConnectorJDBC.executeUpdate(sql,
                DateHelper.toString(model.getNgayLap(), "MM/dd/yyyy"),
                DateHelper.toString(model.getNgayNhanPhong(), "MM/dd/yyyy"),
                DateHelper.toString(model.getNgayTraPhongDuKien(), "MM/dd/yyyy"),
                DateHelper.toString(model.getNgayTraPhongThucTe(), "MM/dd/yyyy"),
                model.getTrangThai(),
                model.getMaKH(),
                model.getMaNV(),
                model.getMaPhong());
    }
    
    public void update(Model_PhieuDangKy model){
        String sql = "Update PhieuDangKy Set NgayLap = ?, NgayNhanPhong = ?, NgayTraPhongDuKien = ?, NgayTraPhongThucTe = ?, TrangThai = ?, MaKhachHang = ?, MaNhanVien = ?, MaPhong = ? Where MaPhieuDK = ?";
        ConnectorJDBC.executeUpdate(sql, 
                DateHelper.toString(model.getNgayLap(), "MM/dd/yyyy"),
                DateHelper.toString(model.getNgayNhanPhong(), "MM/dd/yyyy"),
                DateHelper.toString(model.getNgayTraPhongDuKien(), "MM/dd/yyyy"),
                DateHelper.toString(model.getNgayTraPhongThucTe(), "MM/dd/yyyy"),
                model.getTrangThai(),
                model.getMaKH(),
                model.getMaNV(),
                model.getMaPhong(),
                model.getMaPhieuDK());
    }
    
    public void delete(int maDK){
        String sql = "Delete From PhieuDangKy Where MaPhieuDK = ?";
        ConnectorJDBC.executeUpdate(sql, maDK);
    }
    
    public List<Model_PhieuDangKy> select() {
        String sql = "Select * From PhieuDangKy";
        return this.select(sql, new Object[0]);
    }
    
    public List<Model_PhieuDangKy> selectbyOverdue() {
        List<Model_PhieuDangKy> list = new ArrayList<Model_PhieuDangKy>();
        String sql = "Select PDK.* From PhieuDangKy PDK join Phong P ON PDK.MaPhong=P.MaPhong WHERE NgayNhanPhong < GETDATE() AND P.TrangThai=5 AND PDK.TrangThai = 0";
        list = this.select(sql);
        if(list.size()==0){list=null;}
        return list;
    }
    
    public List<Model_PhieuDangKy> selectbyOverdueRoom() {
        List<Model_PhieuDangKy> list = new ArrayList<Model_PhieuDangKy>();
        String sql = "Select PDK.* From PhieuDangKy PDK join Phong P ON PDK.MaPhong=P.MaPhong WHERE NgayTraPhongDuKien < GETDATE() AND P.TrangThai=1 AND PDK.TrangThai = 0";
        list = this.select(sql);
        if(list.size()==0){list=null;}
        return list;
    }
    public List<Model_PhieuDangKy> selectbyOverduedRoom() {
        List<Model_PhieuDangKy> list = new ArrayList<Model_PhieuDangKy>();
        String sql = "Select PDK.* From PhieuDangKy PDK join Phong P ON PDK.MaPhong=P.MaPhong WHERE NgayTraPhongDuKien < GETDATE() AND P.TrangThai=3 AND PDK.TrangThai = 0";
        list = this.select(sql);
        if(list.size()==0){list=null;}
        return list;
    }
    
    public List<Model_PhieuDangKy> selectSapDi(Date time) {
        List<Model_PhieuDangKy> list = new ArrayList<Model_PhieuDangKy>();
        String sql = "Select PDK.* From PhieuDangKy PDK join Phong P ON PDK.MaPhong=P.MaPhong WHERE NgayTraPhongDuKien = DATEADD(day, -1, ?)  AND P.TrangThai=1 AND PDK.TrangThai = 0";
        list = this.select(sql, time);
        if(list.size()==0){list=null;}
        return list;
    }
    
    public Model_PhieuDangKy findByMaPhongActive(String maPhong) {
        String sql = "Select * From PhieuDangKy Where MaPhong = ? AND TrangThai = 0";
        List<Model_PhieuDangKy> list = this.select(sql, maPhong);
        return list.size() > 0 ? list.get(0) : null;
    }
    
     public Model_PhieuDangKy findByMaPhongActive2(String maPhong) {
        String sql = "Select * From PhieuDangKy pdk JOIN dbo.Phong p ON pdk.MaPhong =p.MaPhong WHERE P.MaPhong = ? AND pdk.TrangThai = 0 AND p.TrangThai = 1";
        List<Model_PhieuDangKy> list = this.select(sql, maPhong);
        return list.size() > 0 ? list.get(0) : null;
    }
     
     public Model_PhieuDangKy findByMaPhongActive3(String maPhong) {
        String sql = "Select * From PhieuDangKy pdk JOIN dbo.Phong p ON pdk.MaPhong =p.MaPhong WHERE P.MaPhong = ? AND pdk.TrangThai = 0 AND (p.TrangThai = 1 OR p.TrangThai = 5 OR p.TrangThai = 3)";
        List<Model_PhieuDangKy> list = this.select(sql, maPhong);
        return list.size() > 0 ? list.get(0) : null;
    }

    public Model_PhieuDangKy findByIdActive(String iD) {
        String sql = "Select * From PhieuDangKy Where MaPhieuDK = ? AND TrangThai = 0";
        List<Model_PhieuDangKy> list = this.select(sql, iD);
        return list.size() > 0 ? list.get(0) : null;
    }
    public Model_PhieuDangKy findByIdKHActive(String iD) {
        String sql = "Select * From PhieuDangKy Where MaKhachHang = ? AND TrangThai = 0";
        List<Model_PhieuDangKy> list = this.select(sql, iD);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public Model_PhieuDangKy findByMaPhong(String maPhong) {
        String sql = "Select * From PhieuDangKy Where MaPhong = ?";
        List<Model_PhieuDangKy> list = this.select(sql, maPhong);
        return list.size() > 0 ? list.get(0) : null;
    }

    public Model_PhieuDangKy findById(String iD) {
        String sql = "Select * From PhieuDangKy Where MaPhieuDK = ?";
        List<Model_PhieuDangKy> list = this.select(sql, iD);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<Model_PhieuDangKy> select(String sql, Object... args) {
        ArrayList<Model_PhieuDangKy> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectorJDBC.executeQuery(sql, args);
                while (rs.next()) {
                    Model_PhieuDangKy model = this.readfromresultset(rs);
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

    private Model_PhieuDangKy readfromresultset(ResultSet rs) throws SQLException {
        Model_PhieuDangKy model = new Model_PhieuDangKy();
        model.setMaPhieuDK(rs.getInt("MaPhieuDK"));
        model.setNgayLap(rs.getDate("NgayLap"));
        model.setNgayNhanPhong(rs.getDate("NgayNhanPhong"));
        model.setNgayTraPhongDuKien(rs.getDate("NgayTraPhongDuKien"));
        model.setNgayTraPhongThucTe(rs.getDate("NgayTraPhongThucTe"));
        model.setTrangThai(rs.getInt("TrangThai"));
        model.setMaKH(rs.getInt("MaKhachHang"));
        model.setMaNV(rs.getString("MaNhanVien"));
        model.setMaPhong(rs.getInt("MaPhong"));
        return model;
    }
}
