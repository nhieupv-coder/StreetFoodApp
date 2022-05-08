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
public class HoaDonChiTiet {
    private HoaDon hoaDon;
    private HangHoaTrongHoaDon hangHoaTrongHoaDon;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(HoaDon hoaDon, HangHoaTrongHoaDon hangHoaTrongHoaDon) {
        this.hoaDon = hoaDon;
        this.hangHoaTrongHoaDon = hangHoaTrongHoaDon;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public HangHoaTrongHoaDon getHangHoaTrongHoaDon() {
        return hangHoaTrongHoaDon;
    }

    public void setHangHoaTrongHoaDon(HangHoaTrongHoaDon hangHoaTrongHoaDon) {
        this.hangHoaTrongHoaDon = hangHoaTrongHoaDon;
    }
    
    
}
