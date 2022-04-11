/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.Helpers;

import com.team3.UI.FormHelper.JCustomOptionPane;
import java.awt.Component;
import javax.swing.JOptionPane;

public class DialogHelper {
    
    public static void alert(Component parent, String message) {
//        JOptionPane.showMessageDialog(parent, message, "Chú ý -- Hệ Thống Quản Lý Khách Sạn", 1);
          JCustomOptionPane msgBox = new JCustomOptionPane();
          msgBox.displayAlertPane("Chú ý -- Hệ Thống Quản Lý Khách Sạn PhucCo", message);
    }

    public static boolean confirm(Component parent, String message) {
        JCustomOptionPane msgBox = new JCustomOptionPane();
        msgBox.displayConfirmPane("Xác Nhận -- Hệ Thống Quản Lý Khách Sạn PhucCo", message);
        boolean result=false;
        if(msgBox.getState()==true){
        result =true;
        }
        return result;
    }

    public static String promt(Component parent, String message) {
        JCustomOptionPane msgBox = new JCustomOptionPane();
        msgBox.displayPromtPane("Nhập liệu -- Hệ Thống Quản Lý Khách Sạn PhucCo", message);
        String result=msgBox.getResult();
        return result;
    }
}
