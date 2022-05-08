/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.entity;

import java.io.Serializable;

/**
 *
 * @author vt1
 */
public class NhanVien implements Serializable{

    private String maNhanVien;
    private String tenNhanVien;
    private int tuoi;
    private String email;
    private boolean gioiTinh;
    private String matKhau;
    private boolean vaiTro;
    private String hinhAnh;
    private boolean trangThai;

    public NhanVien() {
    }

    public NhanVien(String MaNhanVien, String TenNhanVien, int Tuoi, String Email, boolean GioiTinh, String MatKhau, boolean VaiTro, String HinhAnh, boolean TrangThai) {
        this.maNhanVien = MaNhanVien;
        this.tenNhanVien = TenNhanVien;
        this.tuoi = Tuoi;
        this.email = Email;
        this.gioiTinh = GioiTinh;
        this.matKhau = MatKhau;
        this.vaiTro = VaiTro;
        this.hinhAnh = HinhAnh;
        this.trangThai = TrangThai;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.maNhanVien = MaNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.tenNhanVien = TenNhanVien;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int Tuoi) {
        this.tuoi = Tuoi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.gioiTinh = GioiTinh;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.matKhau = MatKhau;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean VaiTro) {
        this.vaiTro = VaiTro;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.hinhAnh = HinhAnh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.trangThai = TrangThai;
    }

}
