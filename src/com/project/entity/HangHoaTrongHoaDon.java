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
public class HangHoaTrongHoaDon {
    private HangHoa hangHoa;
    private int soLuong;

    public HangHoaTrongHoaDon() {
    }

    public HangHoaTrongHoaDon(HangHoa hangHoa, int soLuong) {
        this.hangHoa = hangHoa;
        this.soLuong = soLuong;
    }

    public HangHoa getHangHoa() {
        return hangHoa;
    }

    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
}
