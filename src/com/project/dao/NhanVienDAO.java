package com.project.dao;

import com.project.database.DatabaseJdbc;
import com.project.entity.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vt1
 */
public class NhanVienDAO {

    public static String insert_SQL = "INSERT INTO NhanVien\n"
            + "(MaNhanVien, TenNhanVien, Tuoi, Email, GioiTinh, MatKhau, VaiTro, HinhAnh, TrangThai)\n"
            + "VALUES (?,?,?,?,?,?,?,?,?)";
    public static String sql_SelectAll = "SELECT  MaNhanVien, TenNhanVien, Tuoi, Email, GioiTinh, MatKhau, VaiTro, HinhAnh, TrangThai\n"
            + "FROM  NhanVien";
    public static String sql_Update = "UPDATE  NhanVien\n"
            + "SET  TenNhanVien = ? , Tuoi = ?, Email = ?, GioiTinh = ?, MatKhau = ?, VaiTro = ?, HinhAnh = ?, TrangThai = ?\n"
            + "WHERE   (MaNhanVien = ?)";
    public static String sql_SelectByMaNhanVien = "SELECT MaNhanVien, TenNhanVien, Tuoi, Email, GioiTinh, MatKhau, VaiTro, HinhAnh, TrangThai\n"
            + "FROM   NhanVien\n"
            + "WHERE   (MaNhanVien = ?)";
    public static String sql_Delete = "Delete From NhanVien where MaNhanVien = ?";
    public static String sql_SelectNVByName = "SELECT MaNhanVien, TenNhanVien, Tuoi, Email, GioiTinh, MatKhau, HinhAnh, TrangThai, VaiTro\n"
            + "FROM   NhanVien\n"
            + "WHERE  (TenNhanVien like ?)";
    public static String sql_SelectNhanVienForChamCong_Not_NV_Login = "SELECT TenNhanVien, MaNhanVien, Tuoi, Email, GioiTinh, MatKhau, VaiTro, HinhAnh, TrangThai FROM  NhanVien WHERE (TrangThai = 1) and MaNhanVien != ? and MaNhanVien not in(Select MaNhanVien From ChamCong where NgayDiLam like ?)";
    public void insert(NhanVien nv) {
        DatabaseJdbc.update(insert_SQL, nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getTuoi(), nv.getEmail(), nv.isGioiTinh(), nv.getMatKhau(), nv.isVaiTro(), nv.getHinhAnh(), nv.isTrangThai());
    }

    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> listNhanVien = new ArrayList<>();
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectAll);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv = this.readFromResultSet(rs);
                listNhanVien.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNhanVien;
    }

    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNhanVien(rs.getString("MaNhanVien"));
        model.setEmail(rs.getString("Email"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setHinhAnh(rs.getString("HinhAnh"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setTenNhanVien(rs.getString("TenNhanVien"));
        model.setTrangThai(rs.getBoolean("TrangThai"));
        model.setTuoi(rs.getInt("Tuoi"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        return model;
    }

    public void update(NhanVien nv) {
        DatabaseJdbc.update(sql_Update, nv.getTenNhanVien(), nv.getTuoi(), nv.getEmail(), nv.isGioiTinh(), nv.getMatKhau(), nv.isVaiTro(), nv.getHinhAnh(), nv.isTrangThai(), nv.getMaNhanVien());
    }

    public NhanVien getNhanVienByID(String MaNhanVien) {
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectByMaNhanVien, MaNhanVien);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv = this.readFromResultSet(rs);
                return nv;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void deleteNhanVien(String maNhanVien) {
        DatabaseJdbc.update(sql_Delete, maNhanVien);
    }

    public List<NhanVien> getAllNhanVienByName(String name) {
        List<NhanVien> listNhanVien = new ArrayList<>();
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectNVByName, "%" + name + "%");
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv = this.readFromResultSet(rs);
                listNhanVien.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNhanVien;
    }
     public List<NhanVien> getAllNhanVien_DangLam_Not_NV_Login_ChuaChamCong(String notInMaNhanVien,String date) {
        List<NhanVien> listNhanVien = new ArrayList<>();
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectNhanVienForChamCong_Not_NV_Login,notInMaNhanVien,date);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv = this.readFromResultSet(rs);
                listNhanVien.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNhanVien;
    }

}
