/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao;

import com.project.database.DatabaseJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vt1
 */
public class ThongKeDAO {

    public List<Object[]> getHangHoaTheoNgay(String date) {
        List<Object[]> listHHTK = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_TKSanPhamTrongNgay(?)}";
                rs = DatabaseJdbc.query(sql, date);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaHangHoa"),
                        rs.getString("TenMatHang"),
                        rs.getInt("SoLuong"),
                        rs.getFloat("ThanhTien")
                    };
                    listHHTK.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return listHHTK;
    }

    public List<Object[]> getSoNgayLamNhanVienTheoThang(String thang, String nam) {
        List<Object[]> listHHTK = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_TKNgayDiLam(?,?)}";
                rs = DatabaseJdbc.query(sql, thang, nam);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaNhanVien"),
                        rs.getString("TenNhanVien"),
                        rs.getBoolean("VaiTro") ? "Quản Lý" : "Nhân Viên",
                        rs.getInt("SoNgayDiLam")
                    };
                    listHHTK.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return listHHTK;
    }

    //

    public List<Object[]> getDoanhThuTheoThang(String thang,String nam) {
        List<Object[]> listHHTK = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_DoanhThuTheoThang(?,?)}";
                rs = DatabaseJdbc.query(sql, thang, nam);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("NgayMuaHang"),
                        rs.getString("SoHoaDonDaBan"),
                        rs.getFloat("DoanhThuNgay"),};
                    listHHTK.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return listHHTK;
    }

    //

    public List<Object[]> getTop10(String ngayBD, String ngayKT, String cauLenh) {
        List<Object[]> listHHTK = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_ThongKeTop10NhieuNhat(?,?)}";
                rs = DatabaseJdbc.query(sql, ngayBD, ngayKT);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaMatHang"),
                        rs.getString("TenMatHang"),
                        rs.getInt("SoLuongDaBan"),};
                    listHHTK.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return listHHTK;
    }
// getThangNamThongKeDiLam
    public HashSet<String> getThangNamThongKeDiLam() {
        HashSet<String> hs = new HashSet<>();
        String sQL = "select convert(varchar,MONTH(NgayDiLam)) +'-'+Convert(varchar,YEAR(NgayDiLam)) as'ThangNam' from [dbo].[ChamCong]";
        try {
            ResultSet rs = DatabaseJdbc.query(sQL);
            while (rs.next()) {
                String str = rs.getString("ThangNam");
                hs.add(str);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hs;
    }
    // getThangNamThongKeDiLam
       public HashSet<String> getThangNamThongKeThangHangHoa() {
        HashSet<String> hs = new HashSet<>();
        String sQL = "select convert(varchar,MONTH(NgayMuaHang)) +'-'+Convert(varchar,YEAR(NgayMuaHang)) as'ThangNam' from Hoa_Don";
        try {
            ResultSet rs = DatabaseJdbc.query(sQL);
            while (rs.next()) {
                String str = rs.getString("ThangNam");
                hs.add(str);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hs;
    }
}
