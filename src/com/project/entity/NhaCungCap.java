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
public class NhaCungCap {
    private String  maNhaCungCap;
    private String tenNhaCungCap;
    private String diaChi;

    public NhaCungCap() {
    }

    public NhaCungCap(String MaNhaCungCap, String TenNhaCungCap, String DiaChi) {
        this.maNhaCungCap = MaNhaCungCap;
        this.tenNhaCungCap = TenNhaCungCap;
        this.diaChi = DiaChi;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String MaNhaCungCap) {
        this.maNhaCungCap = MaNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String TenNhaCungCap) {
        this.tenNhaCungCap = TenNhaCungCap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.diaChi = DiaChi;
    }
    @Override
    public String toString(){
        return this.tenNhaCungCap;
    }
}
