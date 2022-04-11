/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.DAO;

import com.team3.Helpers.ConnectorJDBC;
import com.team3.Model.Model_DichVu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DAO_DichVu {

    public void inset(Model_DichVu model) throws SQLException {
        String sql = "Insert into DichVu (Ten, DonGia) Values (?,?)";
        ConnectorJDBC.executeUpdate(sql, model.getTen(), model.getDongia());
    }

    public void update(Model_DichVu model) throws SQLException {
        String sql = "Update DichVu set Ten = ?, DonGia = ? Where MaDichVu = ?";
        ConnectorJDBC.executeUpdate(sql, model.getTen(), model.getDongia(), model.getMadv());
    }

    public void delete(int maDV) throws SQLException {
        String sql = "Delete From DichVu Where MaDichVu = ?";
        ConnectorJDBC.executeUpdate(sql, maDV);
    }
    
    public List<Model_DichVu> select(){
        String sql = "Select * From DichVu";
        return this.select(sql, new Object[0]);
    }
    
    
    public List<Model_DichVu> selectAvailableServices(int maHD) {
        List<Model_DichVu> list = new ArrayList<Model_DichVu>();
        String sql = "Select * From DichVu WHERE MaDichVu NOT IN (SELECT MaDichVu FROM HoaDonChiTiet WHERE MaHoaDon=?)";
        list = this.select(sql, maHD);
        if(list.size()==0){list=null;}
        return list;
    }
    
    public Model_DichVu findById(int maDV) {
        String sql = "Select * From DichVu Where MaDichVu = ?";
        List<Model_DichVu> list = this.select(sql, maDV);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public List<Model_DichVu> findByKeyword(String keyword) {
        String sql = "Select * From DichVu WHERE Ten = ?";
        return this.select(sql, "%" + keyword + "%");
    }

    private List<Model_DichVu> select(String sql, Object ... args) {
        ArrayList<Model_DichVu> list = new ArrayList<Model_DichVu>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectorJDBC.executeQuery(sql, args);
                while (rs.next()) {
                    Model_DichVu model = this.readfromresultset(rs);
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

    private Model_DichVu readfromresultset(ResultSet rs) throws SQLException {
        Model_DichVu model = new Model_DichVu();
        model.setMadv(rs.getInt("MaDichVu"));
        model.setTen(rs.getString("Ten"));
        model.setDongia(rs.getDouble("DonGia"));
        return model;
    }
}
