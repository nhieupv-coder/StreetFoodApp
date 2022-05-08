/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.utils;

import com.project.entity.NhanVien;

/**
 *
 * @author vt1
 */
public class AuthenicatedHelper {

    public static NhanVien nvDangNhap = null;
    //sử dụng trong phần hiển thị chi tiết hóa đơn
    public static String maHoaDon;

    public static boolean isManager() {
        if (nvDangNhap.isVaiTro()) {
            return true;
        }
        return false;
    }

}
