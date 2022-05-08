/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao;

import com.project.database.DatabaseJdbc;
import com.project.entity.LoaiHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vt1
 */
public class LoaiHangDAO {

    public static String sql_SelectLoaiHangHoaByID = "SELECT  MaLoaiHang, TenLoaiHang\n"
            + "FROM            LoaiHang\n"
            + "WHERE        (MaLoaiHang = ?)";
    public static String sql_SelectAll = "SELECT MaLoaiHang, TenLoaiHang\n"
            + "FROM LoaiHang";
    public static String sql_Insert = "INSERT INTO LoaiHang(MaLoaiHang, TenLoaiHang)\n"
            + "VALUES (?,?)";
    public static String sqlUpdate = "Update LoaiHang\n"
            + "set TenLoaiHang = ? \n"
            + "where MaLoaiHang = ?";

    public LoaiHang readResultSet(ResultSet rs) throws SQLException {
        LoaiHang lH = new LoaiHang();
        lH.setMaLoaiHang(rs.getString("MaLoaihang"));
        lH.setTenLoaihang(rs.getString("TenLoaiHang"));
        return lH;
    }

    public LoaiHang getLoaiHangByID(String ID) {
        LoaiHang lH = new LoaiHang();
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectLoaiHangHoaByID, ID);
            while (rs.next()) {
                lH = this.readResultSet(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lH;
    }

    public List<LoaiHang> getAllLoaiHang() {
        List<LoaiHang> listLoaiHang = new ArrayList<>();
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectAll);
            while (rs.next()) {
                LoaiHang lH = new LoaiHang();
                lH = this.readResultSet(rs);
                listLoaiHang.add(lH);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLoaiHang;
    }

    public void insert(LoaiHang lh) {
        DatabaseJdbc.update(sql_Insert, lh.getMaLoaiHang(), lh.getTenLoaihang());
    }

    public void update(LoaiHang lh) {
      DatabaseJdbc.update(sqlUpdate, lh.getTenLoaihang(),lh.getMaLoaiHang());
    }
}
