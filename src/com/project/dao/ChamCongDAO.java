/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao;

import com.project.database.DatabaseJdbc;
import com.project.entity.ChamCong;
import com.project.utils.AuthenicatedHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vt1
 */
public class ChamCongDAO {

    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    NhanVienDAO nvdao = new NhanVienDAO();
    public static String sql_Insert = "INSERT INTO ChamCong (MaNhanVien, NgayDiLam, TrangThai, CaLam, MaNguoiChamCong) VALUES (?,?,?,?,?)";
    public static String sql_SelectAllChamCongByNgay = "SELECT MaDiemDanh, MaNhanVien, NgayDiLam, TrangThai, CaLam, MaNguoiChamCong FROM  ChamCong where NgayDiLam like ?";
    public static String sql_SelectNgayChamCong = "select Distinct NgayDiLam From ChamCong";
    public static String sql_DeleteNhanVienChamCong = "delete from ChamCong where MaNhanVien = ?";

    public ChamCong readResultSet(ResultSet rs) throws SQLException {
        ChamCong chamCong = new ChamCong();
        chamCong.setMaNguoiChamCong(AuthenicatedHelper.nvDangNhap.getMaNhanVien());
        chamCong.setNgayDiLam(rs.getDate("NgayDiLam"));
        chamCong.setNhanVien(nvdao.getNhanVienByID(rs.getString("MaNhanVien")));
        chamCong.setCaLam(rs.getInt("CaLam"));
        chamCong.setTrangThai(rs.getBoolean("TrangThai"));
        return chamCong;

    }

    public void insert(ChamCong cc) {
        DatabaseJdbc.update(sql_Insert, cc.getNhanVien().getMaNhanVien(), formater.format(cc.getNgayDiLam()), cc.isTrangThai(), cc.getCaLam(), cc.getMaNguoiChamCong());
    }

    
    public List<ChamCong> getAllChamCongByNgay(Date ngay) {
        List<ChamCong> list = new ArrayList<>();
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectAllChamCongByNgay,ngay);
            while (rs.next()) {
                ChamCong cc = this.readResultSet(rs);
                list.add(cc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public List<Date> getNgayChamCong(){
        List<Date> listNgay = new ArrayList<>();
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectNgayChamCong);
            while(rs.next()){
                Date date = new Date();
                date = rs.getDate("NgayDiLam");
                listNgay.add(date);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChamCongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNgay;
    }
    public void deleteNVDiemDanh(String maNV){
        DatabaseJdbc.update(sql_DeleteNhanVienChamCong, maNV);
    }
}
