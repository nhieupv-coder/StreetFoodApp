/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dao;

import com.project.database.DatabaseJdbc;
import com.project.entity.HangHoaTrongHoaDon;
import com.project.entity.HoaDonChiTiet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vt1
 */
public class HoaDonChiTietDAO {

    HoaDonDAO hDDAO = new HoaDonDAO();
    HangHoaDAO hHoaDAO = new HangHoaDAO();
    public static String sql_Insert = "INSERT INTO HoaDonChiTiet \n"
            + "VALUES   (?,?,?,?)";
    public static String sql_SelectByID = "SELECT        MaHoaDon, MaHangHoa, Soluong\n"
            + "FROM            HoaDonChiTiet\n"
            + "WHERE        (MaHoaDon = ?)";
    public static String sql_DeleteByID = "delete From HoaDonChiTiet where MaHoaDon = ?";

    public void insert(HoaDonChiTiet hDCT) {
        DatabaseJdbc.update(sql_Insert, hDCT.getHoaDon().getMaHoaDon(), hDCT.getHangHoaTrongHoaDon().getHangHoa().getMaMatHang(), hDCT.getHangHoaTrongHoaDon().getSoLuong(), hDCT.getHangHoaTrongHoaDon().getHangHoa().getDonGia());
        hHoaDAO.updateHangHoaTuHoaDon(hDCT.getHangHoaTrongHoaDon().getSoLuong(), hDCT.getHangHoaTrongHoaDon().getHangHoa().getMaMatHang());
    }

    public List<HoaDonChiTiet> getListHoaDonChiTietByMaHoaDon(String MaHoaDon) {
        List<HoaDonChiTiet> listHD = new ArrayList<>();
        try {
            ResultSet rs = DatabaseJdbc.query(sql_SelectByID, MaHoaDon);
            while (rs.next()) {
                HoaDonChiTiet hDCT = this.readResultSet(rs);
                listHD.add(hDCT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHD;
    }

    public HoaDonChiTiet readResultSet(ResultSet rs) throws SQLException {
        HoaDonChiTiet hDCT = new HoaDonChiTiet();
        hDCT.setHoaDon(hDDAO.getHoaDonByID(rs.getString("MaHoaDon")));
        HangHoaTrongHoaDon hHTHD = new HangHoaTrongHoaDon();
        hHTHD.setHangHoa(hHoaDAO.getHangHoaByID(rs.getString("MaHangHoa")));
        hHTHD.setSoLuong(rs.getInt("Soluong"));
        hDCT.setHangHoaTrongHoaDon(hHTHD);
        return hDCT;
    }

    public void deleteByID(String ID) {
        DatabaseJdbc.update(sql_DeleteByID, ID);
    }
}
