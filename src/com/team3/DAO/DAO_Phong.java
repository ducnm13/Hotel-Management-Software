/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.team3.Model.Model_Phong;


import com.team3.Helpers.ConnectorJDBC;
import com.team3.Model.Model_PhieuDangKy;

/**
 *
 * @author Admin
 */
public class DAO_Phong {

    public void insert(Model_Phong model) {
        String sql = "INSERT INTO Phong(TenPhong,TrangThai,GhiChu,MaLoaiPhong,Tang) VALUES(?,?,?,?,?)";
        ConnectorJDBC.executeUpdate(sql,
               model.getTenPhong(),
               model.getTrangThai(),
               model.getGhiChu(),
               model.getMaLoaiPhong(),
               model.getTang()
        );
    }

    public void update(Model_Phong model) {
        String sql = "UPDATE Phong SET TenPhong=?,TrangThai=?,GhiChu=?,MaLoaiPhong=?,Tang=? WHERE MaPhong=?";
        ConnectorJDBC.executeUpdate(sql,
               model.getTenPhong(),
               model.getTrangThai(),
               model.getGhiChu(),
               model.getMaLoaiPhong(),
               model.getTang(),
               model.getMaPhong()  
        );
    }

    public void delete(String MaPhong) {
        String sql = "DELETE FROM Phong WHERE MaPhong=?";
        ConnectorJDBC.executeUpdate(sql, MaPhong);
    }

    public List<Model_Phong> select() {
        String sql = "SELECT * FROM Phong ORDER BY TenPhong ASC";
        return select(sql,new Object[0]);
    }
    
    public List<Model_Phong> sortData(String tang, String maLoaiPhong, String ngay, String keyword, int truongHop) {
        List<Model_Phong> list = new ArrayList<Model_Phong>();
       
        switch(truongHop){
            case 0://WITH LOAI PHONG
                String sql ="SELECT P.* FROM PHONG P FULL OUTER JOIN PhieuDangKy Dk on P.MaPhong = Dk.MaPhong \n" +
                "WHERE P.MaLoaiPhong =? ORDER BY TenPhong ASC";
                list = select(sql, maLoaiPhong);
                if(list.size()==0){list=null;}
                break;
            case 1://TANG CHECKED
                String sql2 ="SELECT P.* FROM PHONG P FULL OUTER JOIN PhieuDangKy Dk on P.MaPhong = Dk.MaPhong \n" +
                "WHERE P.Tang =? ORDER BY TenPhong ASC";
                list = select(sql2,tang);
                if(list.size()==0){list=null;}
                break;
            case 2://TANG AND FINDER CHECKED
                String sql3 ="SELECT P.* FROM PHONG P FULL OUTER JOIN PhieuDangKy Dk on P.MaPhong = Dk.MaPhong \n" +
                "WHERE P.Tang = ? AND P.TrangThai=0 AND ORDER BY TenPhong ASC";
                list = select(sql3,tang);
                if(list.size()==0){list=null;}
                break;
            case 3://NGAY CHECKED
                String sql4 ="SELECT P.* FROM PHONG P FULL OUTER JOIN PhieuDangKy Dk on P.MaPhong = Dk.MaPhong \n" +
                "WHERE NgayTraPhongDuKien=? AND (P.TrangThai=1 OR P.TrangThai=3 OR P.TrangThai=5) ORDER BY TenPhong ASC";
                list = select(sql4,ngay);
                if(list.size()==0){list=null;}
                break;
            case 4:// NGAY & FINDER CHECKED
                String sql5 ="SELECT P.* FROM PHONG P FULL OUTER JOIN PhieuDangKy Dk on P.MaPhong = Dk.MaPhong \n" +
                "WHERE NgayTraPhongDuKien=? AND P.TrangThai=0 ORDER BY TenPhong ASC";
                list = select(sql5,ngay);
                if(list.size()==0){list=null;}
                break;
            case 5:// NGAY & TANG CHECKED
               String sql6 ="SELECT P.* FROM PHONG P FULL OUTER JOIN PhieuDangKy Dk on P.MaPhong = Dk.MaPhong \n" +
                "WHERE NgayTraPhongDuKien=? AND P.Tang =? AND  AND (P.TrangThai=1 OR P.TrangThai=3 OR P.TrangThai=5) ORDER BY TenPhong ASC";
                list = select(sql6,ngay,tang);
                if(list.size()==0){list=null;}
                break;
            case 6:// ALL ARE CHECKED
               String sql7 ="SELECT P.* FROM PHONG P FULL OUTER JOIN PhieuDangKy Dk on P.MaPhong = Dk.MaPhong \n" +
                "WHERE NgayTraPhongDuKien=? AND P.Tang =? AND P.TrangThai=0 ORDER BY TenPhong ASC";
                list = select(sql7,maLoaiPhong,ngay,tang);
                if(list.size()==0){list=null;}
                break;
            case 7:// TYPE AND FIND BLANK
               String sql8 ="SELECT P.* FROM PHONG P FULL OUTER JOIN PhieuDangKy Dk on P.MaPhong = Dk.MaPhong \n" +
                "WHERE P.MaLoaiPhong =? AND P.TrangThai=0 ORDER BY TenPhong ASC";
                list = select(sql8,maLoaiPhong);
                if(list.size()==0){list=null;}
                break;
            case 8://KEYWORD FILLED AND TIM PHONG CHECKED
                String sql9 ="SELECT P.* FROM PHONG P FULL OUTER JOIN PhieuDangKy Dk on P.MaPhong = Dk.MaPhong \n" +
                "WHERE P.TenPhong =? ORDER BY TenPhong ASC";
                list = select(sql9,keyword);
                if(list.size()==0){list=null;}
                break;
            case 9://KEYWORD FILLED AND CMND CHECKED
                String sql10 ="SELECT P.* FROM PHONG P FULL OUTER JOIN PhieuDangKy Dk on P.MaPhong = Dk.MaPhong JOIN KhachHang kh ON kh.MaKhachHang = Dk.MaKhachHang WHERE kh.CMND =? ORDER BY TenPhong ASC";
                list = select(sql10,keyword);
                if(list.size()==0){list=null;}
                break;
            case 10://(ANOTHER FORM) 
                String sql11 ="SELECT * FROM PHONG WHERE TrangThai = 0 ORDER BY TenPhong ASC";
                list = select(sql11);
                if(list.size()==0){list=null;}
                break;      
    }
        return list;
    }
    
    
    public List<Model_Phong> selectTang() {
        String sql = "SELECT DISTINCT Tang FROM Phong ORDER BY Tang ASC";
        return selectTang(sql);
    }

    public Model_Phong findById(String MaPhong) {
        String sql = "SELECT * FROM Phong WHERE MaPhong=?";
        List<Model_Phong> list = select(sql, MaPhong);
        return list.size() > 0 ? list.get(0) : null;
    }
    public Model_Phong findByName(String TenPhong) {
        String sql = "SELECT * FROM Phong WHERE TenPhong=?";
        List<Model_Phong> list = select(sql, TenPhong);
        return list.size() > 0 ? list.get(0) : null;
    }
    

    private List<Model_Phong> select(String sql, Object... args) {
        List<Model_Phong> list = new ArrayList<Model_Phong>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectorJDBC.executeQuery(sql, args);
                while (rs.next()) {
                    Model_Phong model = readFromResultSet(rs);
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
     private List selectTang(String sql) {
        List list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectorJDBC.executeQuery(sql);
                while (rs.next()) {
                    list.add(String.valueOf(rs.getInt("Tang")));
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private Model_Phong readFromResultSet(ResultSet rs) throws SQLException {
       Model_Phong model = new Model_Phong();
       model.setMaPhong(rs.getString("MaPhong"));
       model.setTenPhong(rs.getString("TenPhong"));
       model.setTrangThai(rs.getInt("TrangThai"));
       model.setGhiChu(rs.getString("GhiChu"));
       model.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
       model.setTang(String.valueOf(rs.getInt("Tang")));
       return model;
    }
}
