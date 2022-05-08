/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.entity;

/**
 *
 * @author vt1
 */
public class HangHoa {

    private String maMatHang;
    private String tenMatHang;
    private LoaiHang loaiHangHoa;
    private float donGia;
    private int soLuong;
    private NhaCungCap nhaCungCap;
    private boolean trangThai;

    public HangHoa() {
    }

    public HangHoa(String maMatHang, String tenMatHang, LoaiHang loaiHangHoa, float donGia, int soLuong, NhaCungCap nhaCungCap, boolean trangThai) {
        this.maMatHang = maMatHang;
        this.tenMatHang = tenMatHang;
        this.loaiHangHoa = loaiHangHoa;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaCungCap = nhaCungCap;
        this.trangThai = trangThai;
    }



    public String getMaMatHang() {
        return maMatHang;
    }

    public void setMaMatHang(String maMatHang) {
        this.maMatHang = maMatHang;
    }

    public String getTenMatHang() {
        return tenMatHang;
    }

    public void setTenMatHang(String tenMatHang) {
        this.tenMatHang = tenMatHang;
    }

    public LoaiHang getLoaiHangHoa() {
        return loaiHangHoa;
    }

    public void setLoaiHangHoa(LoaiHang loaiHangHoa) {
        this.loaiHangHoa = loaiHangHoa;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    

    @Override
    public String toString() {
        return "( "+maMatHang+" ) - "+"( "+tenMatHang+" )";
    }

    

}
