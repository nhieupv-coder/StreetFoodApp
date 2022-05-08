/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao;

import static com.project.dao.NhanVienDAO.sql_SelectAll;
import com.project.database.DatabaseJdbc;
import com.project.entity.HoaDon;
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
public class HoaDonDAO {

    public static String sql_SelectHoaDon = "Select Hoa_Don.MaHoaDon,MaNhanVien,NgayMuaHang, Sum(HangHoa.DonGia*HoaDonChiTiet.Soluong) as'TongTien' From Hoa_Don inner join HoaDonChiTiet on Hoa_Don.MaHoaDon = HoaDonChiTiet.MaHoaDon inner join HangHoa on HoaDonChiTiet.MaHangHoa = HangHoa.MaMatHang Group By Hoa_Don.MaHoaDon,Hoa_Don.MaNhanVien,Hoa_Don.NgayMuaHang ORDER BY Hoa_Don.MaHoaDon";
    public static String sql_SelectHoaDonByID = "Select Hoa_Don.MaHoaDon,MaNhanVien,NgayMuaHang, Sum(HoaDonChiTiet.DonGia*HoaDonChiTiet.Soluong) as'TongTien' From Hoa_Don inner join HoaDonChiTiet on Hoa_Don.MaHoaDon = HoaDonChiTiet.MaHoaDon inner join HangHoa on HoaDonChiTiet.MaHangHoa = HangHoa.MaMatHang where Hoa_Don.MaHoaDon = ? Group By Hoa_Don.MaHoaDon,Hoa_Don.MaNhanVien,Hoa_Don.NgayMuaHang";
    public static String sql_InsertHoaDon = "INSERT INTO Hoa_Don (MaHoaDon, MaNhanVien, NgayMuaHang)\n"
            + "VALUES  (?,?,?)";
    public static String sql_DeleteHoaDon = "Delete From Hoa_don where MaHoaDon = ?";
    public static String sql_SelectHoaDonByDay = "Select Hoa_Don.MaHoaDon,MaNhanVien,NgayMuaHang, Sum(HoaDonChiTiet.DonGia*HoaDonChiTiet.Soluong) as'TongTien' From Hoa_Don inner join HoaDonChiTiet on Hoa_Don.MaHoaDon = HoaDonChiTiet.MaHoaDon inner join HangHoa on HoaDonChiTiet.MaHangHoa = HangHoa.MaMatHang where Hoa_Don.NgayMuaHang like ? Group By Hoa_Don.MaHoaDon,Hoa_Don.MaNhanVien,Hoa_Don.NgayMuaHang";
    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> listHoaDon = new ArrayList<>();
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectHoaDon);
            while (rs.next()) {
                HoaDon nv = new HoaDon();
                nv = this.readFromResultSet(rs);
                listHoaDon.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHoaDon;
    }

    private HoaDon readFromResultSet(ResultSet rs) throws SQLException {
        HoaDon model = new HoaDon();
        model.setMaHoaDon(rs.getString("MaHoaDon"));
        model.setMaNhanVien(rs.getString("MaNhanVien"));
        model.setNgayMuaHang(rs.getDate("NgayMuaHang"));
        model.setTongTien(rs.getFloat("TongTien"));
        return model;
    }

    public void insert(HoaDon hD) {
        DatabaseJdbc.update(sql_InsertHoaDon, hD.getMaHoaDon(),hD.getMaNhanVien(),hD.getNgayMuaHang());
    }
    public HoaDon getHoaDonByID(String ID){
         try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectHoaDonByID,ID);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd = this.readFromResultSet(rs);
                return hd;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void delete(String maHoaDon){
        DatabaseJdbc.update(sql_DeleteHoaDon, maHoaDon);
    }
    public List<HoaDon> getAllHoaDonByDay(String ngay) {
        List<HoaDon> listHoaDon = new ArrayList<>();
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectHoaDonByDay,"%"+ngay+"%");
            while (rs.next()) {
                HoaDon nv = new HoaDon();
                nv = this.readFromResultSet(rs);
                listHoaDon.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHoaDon;
    }
}
