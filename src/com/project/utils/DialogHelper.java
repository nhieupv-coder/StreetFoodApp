/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author vt1
 */
public class DialogHelper {

    public static void alert(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Hệ thống bán hàng", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(Component parent, String message) {
        if (JOptionPane.showConfirmDialog(parent, message, "Hệ thống bán hàng", JOptionPane.YES_NO_OPTION) == 0) {
            return true;
        }
        return false;
    }
      public static void alertSucess(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Hệ thống bán hàng", JOptionPane.INFORMATION_MESSAGE);
    }
       public static void alertError(Component parent, String message){
            JOptionPane.showMessageDialog(parent, message, "Hệ thống bán hàng", JOptionPane.ERROR_MESSAGE);
       }
}
