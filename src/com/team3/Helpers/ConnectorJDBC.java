package com.team3.Helpers;

import com.team3.UI.HoaDonThanhToan;
import java.awt.Dialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ConnectorJDBC {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost:1433;database=Quanlykhachsan";
    private static String username = "sa";
    private static String password = "songlong";

    public static PreparedStatement prepareStatement(String sql, Object... args) throws SQLException {
        Connection connection = DriverManager.getConnection(dburl, username, password);
        PreparedStatement pstmt = null;
        pstmt = sql.trim().startsWith("{") ? connection.prepareCall(sql) : connection.prepareStatement(sql);
        for (int i = 0; i < args.length; ++i) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    public static void executeUpdate(String sql, Object... args) {
        try {
            PreparedStatement stmt = ConnectorJDBC.prepareStatement(sql, args);
            try {
                stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet executeQuery(String sql, Object... args) {
        try {
            PreparedStatement stmt = ConnectorJDBC.prepareStatement(sql, args);
            return stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void inHoaDon(int mapdk) {
        try {
            Connection con = DriverManager.getConnection(dburl, username, password);
            Hashtable map = new Hashtable();
            JasperReport file = JasperCompileManager.compileReport("src\\com\\team3\\UI\\report1.jrxml");
            map.put("PhieuDangKy.MaPhieuDK", mapdk);
            JasperPrint print = JasperFillManager.fillReport(file, map, con);
            if (print != null) {
                JasperViewer jasperViewer = new JasperViewer(print, false);
                JDialog dialog = new JDialog(new javax.swing.JFrame(), true);
                dialog.setContentPane(jasperViewer.getContentPane());
                dialog.setSize(jasperViewer.getSize());
                dialog.setTitle("Hóa Đơn Tạm Tính");
                dialog.setModal(true);
                dialog.setAlwaysOnTop(true);
                dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                dialog.setIconImage(ShareHelper.APP_ICON);
                dialog.setVisible(true);
            }
        } catch (Exception e) {

        }
    }

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
