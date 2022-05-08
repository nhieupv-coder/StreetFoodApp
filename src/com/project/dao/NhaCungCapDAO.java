/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao;

import com.project.database.DatabaseJdbc;
import com.project.entity.NhaCungCap;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vt1
 */
public class NhaCungCapDAO {

    public static String sql_SelectNCCByID = "SELECT        MaNhaCungCap, TenNhaCungCap, DiaChi\n"
            + "FROM            NhaCungCap\n"
            + "WHERE        (MaNhaCungCap = ?)";
    public static String sql_SelectALL = "SELECT MaNhaCungCap, TenNhaCungCap, DiaChi\n"
            + "FROM NhaCungCap";
    public static String sql_Insert = "INSERT INTO NhaCungCap\n"
            + "(MaNhaCungCap, TenNhaCungCap, DiaChi)\n"
            + "VALUES  (?,?,?)";
    public static String sql_Update = "UPDATE NhaCungCap SET   TenNhaCungCap =?, DiaChi =?\n"
            + "WHERE        (MaNhaCungCap = ?)";

    private NhaCungCap readResultSet(ResultSet rs) throws SQLException {
        NhaCungCap nCC = new NhaCungCap();
        nCC.setMaNhaCungCap(rs.getString("MaNhaCungCap"));
        nCC.setTenNhaCungCap(rs.getString("TenNhaCungCap"));
        nCC.setDiaChi(rs.getString("DiaChi"));
        return nCC;
    }

    public NhaCungCap getNCCByID(String iD) {
        NhaCungCap ncc = new NhaCungCap();
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectNCCByID, iD);
            while (rs.next()) {
                ncc = this.readResultSet(rs);
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ncc;
    }

    public List<NhaCungCap> getAllNCC() {
        List<NhaCungCap> listNCC = new ArrayList<>();
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectALL);
            while (rs.next()) {
                NhaCungCap nCC = this.readResultSet(rs);
                listNCC.add(nCC);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listNCC;
    }

    public void insert(NhaCungCap nCC) {
        DatabaseJdbc.update(sql_Insert, nCC.getMaNhaCungCap(), nCC.getTenNhaCungCap(), nCC.getDiaChi());
    }

    public void update(NhaCungCap nCC) {
     DatabaseJdbc.update(sql_Update, nCC.getTenNhaCungCap(),nCC.getDiaChi(),nCC.getMaNhaCungCap());
    }
}
