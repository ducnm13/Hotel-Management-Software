/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.Helpers;

import com.team3.Model.Model_NhanVien;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

public class ShareHelper {
    public static final Image APP_ICON;
    public static Model_NhanVien user;
    public static int role;    
    public static String verify;
    public static String email;
    public static boolean savelogo(File file) {
        File dir = new File("hinhanh");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File newFile = new File(dir, file.getName());
        try {
            Path source = Paths.get(file.getAbsolutePath(), new String[0]);
            Path destination = Paths.get(newFile.getAbsolutePath(), new String[0]);
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    public static ImageIcon readLogo(String fileName) {
        File path = new File("hinhanh", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    public static void logoff() {
        user = null;
        role = -1;
    }

    public static boolean authenticated() {
        return user != null;
    }

    static {
        String file = "/com/team3/Images/icons/iconApp.png";
        APP_ICON = new ImageIcon(ShareHelper.class.getResource(file)).getImage();
        user = null;
        role = -1;
    }
}
