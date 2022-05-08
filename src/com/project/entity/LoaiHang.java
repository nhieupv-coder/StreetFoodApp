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
public class LoaiHang {
    private String maLoaiHang;
    private String tenLoaihang;

    public LoaiHang() {
    }

    public LoaiHang(String MaLoaiHang, String TenLoaihang) {
        this.maLoaiHang = MaLoaiHang;
        this.tenLoaihang = TenLoaihang;
    }

    public String getMaLoaiHang() {
        return maLoaiHang;
    }

    public void setMaLoaiHang(String MaLoaiHang) {
        this.maLoaiHang = MaLoaiHang;
    }

    public String getTenLoaihang() {
        return tenLoaihang;
    }

    public void setTenLoaihang(String TenLoaihang) {
        this.tenLoaihang = TenLoaihang;
    }

    @Override
    public String toString() {
        return  tenLoaihang ;
    }
    
}
