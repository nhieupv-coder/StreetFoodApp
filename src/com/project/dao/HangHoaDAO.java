/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao;

import com.project.database.DatabaseJdbc;
import com.project.entity.HangHoa;
import com.project.entity.HangHoaTrongHoaDon;
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
public class HangHoaDAO {

    LoaiHangDAO lhdao = new LoaiHangDAO();
    NhaCungCapDAO nccdao = new NhaCungCapDAO();

    public static String sql_SelectALLWhitHangHoaDangBan = "SELECT MaMatHang, TenMatHang, MaLoaiHang, DonGia, MaNhaCungCap, SoLuong, TrangThai\n"
            + "FROM HangHoa where TrangThai = 1";
    public static String sql_SelectHangHoaAll = "SELECT  MaMatHang, TenMatHang, MaLoaiHang, DonGia, MaNhaCungCap, SoLuong, TrangThai\n"
            + "FROM  HangHoa";
    public static String sql_SelectHangHoaID = "SELECT MaMatHang, TenMatHang, MaLoaiHang, DonGia, SoLuong, MaNhaCungCap, TrangThai\n"
            + "FROM   HangHoa\n"
            + "WHERE (MaMatHang = ?)";
    public static String sql_SelectHoaDonChiTiet = "SELECT  MaHoaDon, MaHangHoa, Soluong\n"
            + "FROM HoaDonChiTiet where MaHoaDon = ?";
    public static String sql_Insert = "INSERT INTO HangHoa (MaMatHang, TenMatHang, MaLoaiHang, DonGia, SoLuong, MaNhaCungCap, TrangThai)\n"
            + "VALUES (?,?,?,?,?,?,?)";
    public static String sql_Delete = "DELETE FROM HangHoa where MaMatHang = ?";
    public static String sql_Update = "UPDATE  HangHoa\n"
            + "SET    TenMatHang = ?, MaLoaiHang = ?, DonGia = ?, SoLuong = ?, MaNhaCungCap = ?, TrangThai = ?\n"
            + "WHERE MaMatHang = ?";
    public static String sql_SearchByName = "SELECT  MaMatHang, TenMatHang, MaLoaiHang, DonGia, SoLuong, MaNhaCungCap, TrangThai\n"
            + "FROM  HangHoa\n"
            + "WHERE (TenMatHang like ?)";
    public static String sql_UpdateTruHangHoa = "update HangHoa set SoLuong = SoLuong - ? where MaMatHang = ?";
    private HangHoa readFromResultSet(ResultSet rs) throws SQLException {
        HangHoa model = new HangHoa();
        model.setMaMatHang(rs.getString("MaMatHang"));
        model.setTenMatHang(rs.getString("TenMatHang"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setDonGia(rs.getFloat("DonGia"));
        model.setLoaiHangHoa(lhdao.getLoaiHangByID(rs.getString("MaLoaiHang").trim()));
        model.setNhaCungCap(nccdao.getNCCByID(rs.getString("MaNhaCungCap").trim()));
        model.setTrangThai(rs.getBoolean("TrangThai"));
        return model;
    }

    public List<HangHoa> getAllHangHoa_DangBan() {
        List<HangHoa> list = new ArrayList<>();
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectALLWhitHangHoaDangBan);
            while (rs.next()) {
                HangHoa hh = this.readFromResultSet(rs);
                list.add(hh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<HangHoa> getAllHangHoa() {
        List<HangHoa> list = new ArrayList<>();
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectHangHoaAll);
            while (rs.next()) {
                HangHoa hh = this.readFromResultSet(rs);
                list.add(hh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public HangHoa getHangHoaByID(String ID) {
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectHangHoaID, ID);
            while (rs.next()) {
                HangHoa hh = this.readFromResultSet(rs);
                return hh;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<HangHoaTrongHoaDon> getListHangHoaTrongHoaDon(String maHoaDon) {
        List<HangHoaTrongHoaDon> hHTHD = new ArrayList<>();
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectHoaDonChiTiet, maHoaDon);
            while (rs.next()) {
                HangHoaTrongHoaDon hhHD = new HangHoaTrongHoaDon();
                HangHoa hh = this.getHangHoaByID(rs.getString("MaHangHoa"));
                hhHD.setHangHoa(hh);
                hhHD.setSoLuong(rs.getInt("SoLuong"));
                hHTHD.add(hhHD);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hHTHD;
    }

    public void insert(HangHoa hh) {
        DatabaseJdbc.update(sql_Insert, hh.getMaMatHang(), hh.getTenMatHang(), hh.getLoaiHangHoa().getMaLoaiHang(), hh.getDonGia(), hh.getSoLuong(), hh.getNhaCungCap().getMaNhaCungCap(), hh.isTrangThai());
    }

    public void update(HangHoa hh) {
        DatabaseJdbc.update(sql_Update, hh.getTenMatHang(), hh.getLoaiHangHoa().getMaLoaiHang(), hh.getDonGia(), hh.getSoLuong(), hh.getNhaCungCap().getMaNhaCungCap(), hh.isTrangThai(), hh.getMaMatHang());
    }
    public void deleteHangHoa(String maHangHoa){
        DatabaseJdbc.update(sql_Delete, maHangHoa);
    }
    public List<HangHoa> getAllHangHoaByName(String name) {
        List<HangHoa> list = new ArrayList<>();
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SearchByName, "%" + name + "%");
            while (rs.next()) {
                HangHoa hh = this.readFromResultSet(rs);
                list.add(hh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //phương thức update trừ đi số lượng hàng hóa đã bán
    public void updateHangHoaTuHoaDon(int soLuongBan, String MaMatHang){
        DatabaseJdbc.update(sql_UpdateTruHangHoa, soLuongBan,MaMatHang);
    }
}
