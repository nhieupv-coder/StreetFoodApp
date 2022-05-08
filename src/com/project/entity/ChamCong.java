/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vt1
 */
public class ChamCong {
    private NhanVien nhanVien;
    private Date ngayDiLam;
    private int caLam;
    private boolean TrangThai;
    private String maNguoiChamCong;

    public ChamCong() {
    }

    public ChamCong(NhanVien nhanVien, Date ngayDiLam, int caLam, boolean TrangThai, String maNguoiChamCong) {
        this.nhanVien = nhanVien;
        this.ngayDiLam = ngayDiLam;
        this.caLam = caLam;
        this.TrangThai = TrangThai;
        this.maNguoiChamCong = maNguoiChamCong;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Date getNgayDiLam() {
        return ngayDiLam;
    }

    public void setNgayDiLam(Date ngayDiLam) {
        this.ngayDiLam = ngayDiLam;
    }

    public int getCaLam() {
        return caLam;
    }

    public void setCaLam(int caLam) {
        this.caLam = caLam;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMaNguoiChamCong() {
        return maNguoiChamCong;
    }

    public void setMaNguoiChamCong(String maNguoiChamCong) {
        this.maNguoiChamCong = maNguoiChamCong;
    }
    
}
