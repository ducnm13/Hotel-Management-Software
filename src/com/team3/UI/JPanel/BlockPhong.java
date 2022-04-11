/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.UI.JPanel;

import com.team3.DAO.DAO_KhachHang;
import com.team3.DAO.DAO_PhieuDangKy;
import com.team3.Helpers.DialogHelper;
import com.team3.Model.Model_KhachHang;
import com.team3.Model.Model_PhieuDangKy;
import com.team3.UI.ChinhSuaPhong;
import com.team3.UI.ChuyenPhong;
import com.team3.UI.ChuyenTrangThai;
import com.team3.UI.HoaDonThanhToan;
import com.team3.UI.PhieuDangKy_Form;
import com.team3.UI.PopupHuyPhong;
import com.team3.UI.PopupXacNhan;
import com.team3.UI.TheoDoiDichVu;
import com.team3.UI.WizardProgress;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 *
 * @author Dell Vostro
 */
public class BlockPhong extends javax.swing.JPanel {

    String masoPhong;
    String tensubPhong;
    String tenKhach;
    int trangThai;
    String maLoaiPhong;
    DAO_PhieuDangKy dkdao = new DAO_PhieuDangKy();
    DAO_KhachHang khdao = new DAO_KhachHang();

    /**
     * Creates new form BlockPhong
     */
//    public BlockPhong() {
//        initComponents();
//        this.setBackground(new Color(0,0,0,0));
//        showPopupMenu();
//    }
    public BlockPhong(String maPhong, String tenPhong, int trangthai, int maLoaiPhong, String ten, String ngayDen, String ngayDi) {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        tensubPhong = tenPhong;
        tenKhach = ten;
        masoPhong = maPhong;
        trangThai = trangthai;
        Dimension dm = new Dimension();
                dm.setSize(44, 16);
                lblTenKh.setPreferredSize(dm);
        if (maLoaiPhong == 5 || maLoaiPhong == 6) {
            lblVIP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/VIP.png")));
        } else {
            lblVIP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/thuong.png")));
        }

        switch (trangThai) {
            case 0:
                jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/trong.png")));
                lblTrangThai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/macdinh.png")));
                lblTenKh.setText("Không có");
                lblNgayVao.setText("Không có");
                lblNgayRaDK.setText("Không có");
                break;
            case 1:
                jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/khach.png")));
                lblTrangThai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/dango.png")));
                lblTenKh.setText(ten);
                lblNgayVao.setText(ngayDen);
                lblNgayRaDK.setText(ngayDi);
                break;
            case 2:
                jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/khongsansang.png")));
                lblTrangThai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/ban.png")));
                lblTenKh.setText("Không có");
                lblNgayVao.setText("Không có");
                lblNgayRaDK.setText("Không có");
                break;
            case 3:
                jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/khach.png")));
                lblTrangThai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/sapdi.png")));
                lblTenKh.setText(ten);
                lblNgayVao.setText(ngayDen);
                lblNgayRaDK.setText(ngayDi);
                break;
            case 4:
                jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/khongsansang.png")));
                lblTrangThai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/dangsua.png")));
                lblTenKh.setText("Không có");
                lblNgayVao.setText("Không có");
                lblNgayRaDK.setText("Không có");
                break;
            case 5:
                jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/khongsansang.png")));
                lblTrangThai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/dattruoc.png")));
                lblTenKh.setText(ten);
                lblNgayVao.setText(ngayDen);
                lblNgayRaDK.setText(ngayDi);
                break;
        }
        lblSoPhong.setText(tenPhong);

        showPopupMenu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pmnuFunction = new javax.swing.JPopupMenu();
        lblTenKH = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTenKh = new javax.swing.JLabel();
        lblNgayVao = new javax.swing.JLabel();
        lblNgayRaDK = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblSoPhong = new javax.swing.JLabel();
        lblVIP = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        lblBG = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        lblTenKH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenKH.setForeground(new java.awt.Color(255, 255, 255));
        lblTenKH.setText("Tên Ở Đây");

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ngày vào:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 56, -1, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ngày ra DK:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 76, -1, 20));

        lblTenKh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenKh.setForeground(new java.awt.Color(255, 255, 255));
        lblTenKh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenKh.setText(" Tên KH");
        jPanel1.add(lblTenKh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, 30));

        lblNgayVao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNgayVao.setForeground(new java.awt.Color(255, 255, 255));
        lblNgayVao.setText("Ngày Vào");
        jPanel1.add(lblNgayVao, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 56, -1, 20));

        lblNgayRaDK.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNgayRaDK.setForeground(new java.awt.Color(255, 255, 255));
        lblNgayRaDK.setText("Ngày Ra Dự Kiến");
        jPanel1.add(lblNgayRaDK, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 76, -1, 20));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/khach.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 5, 30, 30));

        lblSoPhong.setBackground(new java.awt.Color(0, 108, 176));
        lblSoPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSoPhong.setForeground(new java.awt.Color(255, 255, 255));
        lblSoPhong.setText("P101");
        jPanel1.add(lblSoPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 96, 40, 20));

        lblVIP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVIP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/VIP.png"))); // NOI18N
        jPanel1.add(lblVIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 97, 20, 20));

        lblTrangThai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/macdinh.png"))); // NOI18N
        lblTrangThai.setText("jLabel2");
        jPanel1.add(lblTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 95, 170, 25));

        lblBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/phong.png"))); // NOI18N
        jPanel1.add(lblBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formMousePressed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered

    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited

    }//GEN-LAST:event_formMouseExited

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        lblBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/phong2.png")));
        jPanel1.setToolTipText(lblTenKh.getText());
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        lblBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/phong.png")));
    }//GEN-LAST:event_jPanel1MouseExited

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        lblBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/phong2.png")));
    }//GEN-LAST:event_jPanel1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBG;
    private javax.swing.JLabel lblNgayRaDK;
    private javax.swing.JLabel lblNgayVao;
    private javax.swing.JLabel lblSoPhong;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTenKh;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JLabel lblVIP;
    private javax.swing.JPopupMenu pmnuFunction;
    // End of variables declaration//GEN-END:variables
    private void showPopupMenu() {
        final JPopupMenu editMenu = new JPopupMenu("Tùy Chỉnh");
        JSeparator sep = new JSeparator();
        sep.setOrientation(SwingConstants.HORIZONTAL);
        JMenuItem pmnu0 = new JMenuItem("PHÒNG ĐANG XEM: " + tensubPhong);
        JMenuItem pmnu0s = new JMenuItem("KHÁCH HÀNG ĐANG THUÊ: " + tenKhach);
        pmnu0.setOpaque(true);
        pmnu0.setBackground(Color.decode("#1D5995"));
        pmnu0.setForeground(Color.white);
        pmnu0s.setOpaque(true);
        pmnu0s.setBackground(Color.decode("#006CB0"));
        pmnu0s.setForeground(Color.white);
        JMenuItem pmnu1 = new JMenuItem("Thêm/Sửa Thông Tin Phòng");
        pmnu1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                ChinhSuaPhong jd = new ChinhSuaPhong(new javax.swing.JFrame(), true, masoPhong, tensubPhong);
                jd.setVisible(true);
                jd.setModal(true);
                jd.setAlwaysOnTop(true);
                jd.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            }
        });

        JMenuItem pmnu2 = new JMenuItem("Đặt Trước Phòng/Xác Nhận Lấy Phòng");
        pmnu2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                if (trangThai == 0) {
                    PopupXacNhan jd = new PopupXacNhan(new javax.swing.JFrame(), true, masoPhong, tensubPhong, 0);
                    jd.setVisible(true);
                    jd.setModal(true);
                    jd.setAlwaysOnTop(true);
                    jd.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                } else if (trangThai == 5) {
                    WizardProgress jd = new WizardProgress(new javax.swing.JFrame(), true, masoPhong, tensubPhong, 1);
                    jd.setVisible(true);
                    jd.setModal(true);
                    jd.setAlwaysOnTop(true);
                    jd.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                } else {
                    DialogHelper.alert(jPanel1, "Bạn không thể thao tác với phòng có khách");
                }
            }
        });
        JMenuItem pmnu3 = new JMenuItem("Tiến Hành Đổi Phòng");
        pmnu3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                if (trangThai == 1 || trangThai == 5 || trangThai == 3) {
                    ChuyenPhong jd = new ChuyenPhong(new javax.swing.JFrame(), true, masoPhong, trangThai);
                    jd.setVisible(true);
                    jd.setModal(true);
                    jd.setAlwaysOnTop(true);
                    jd.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                } else {
                    DialogHelper.alert(jPanel1, "Không thể thao tác với phòng không có khách!.");
                }
            }
        });
        JMenuItem pmnu4 = new JMenuItem("Chuyển Đổi Trạng Thái Phòng");
        pmnu4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                if (trangThai == 0 || trangThai == 2 || trangThai == 4) {
                    ChuyenTrangThai jd = new ChuyenTrangThai(new javax.swing.JFrame(), true, masoPhong, tensubPhong, trangThai);
                    jd.setVisible(true);
                    jd.setModal(true);
                    jd.setAlwaysOnTop(true);
                    jd.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                } else {
                    DialogHelper.alert(jPanel1, "Không thể chuyển trạng thái phòng có khách.");
                }
            }
        });
        JMenuItem pmnu6 = new JMenuItem("Hủy Đặt Phòng/Trả Phòng & Thanh Toán");
        pmnu6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (trangThai == 1 || trangThai == 3) {
                    Model_PhieuDangKy mdlpdk = dkdao.findByMaPhongActive(masoPhong);
                    System.out.println(masoPhong);
                    System.out.println(mdlpdk.getMaPhieuDK());
                    if (mdlpdk != null) {
                        HoaDonThanhToan jd = new HoaDonThanhToan(new javax.swing.JFrame(), true, mdlpdk.getMaPhieuDK());
                        jd.setVisible(true);
                        jd.setAlwaysOnTop(true);
                        jd.setModal(false);
                        jd.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    }
                } else if (trangThai == 5) {
                    Model_PhieuDangKy mdlpdk = dkdao.findByMaPhongActive(masoPhong);
                    
                    PopupHuyPhong jd = new PopupHuyPhong(new javax.swing.JFrame(), true, mdlpdk.getMaPhieuDK());               
                    jd.setVisible(true);
                    jd.setModal(true);
                    jd.setAlwaysOnTop(true);
                    jd.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                } else {
                    DialogHelper.alert(jPanel1, "Phòng trống không thể thanh toán");
                }
            }
        });
        JMenuItem pmnu7 = new JMenuItem("Xem/Sửa Phiếu Đăng Kí Phòng");
        pmnu7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                if (trangThai == 1 || trangThai == 5 || trangThai == 3) {
                    PhieuDangKy_Form jd = new PhieuDangKy_Form(new javax.swing.JFrame(), true, masoPhong, tensubPhong, trangThai);
                    jd.setVisible(true);
                    jd.setModal(true);
                    jd.setAlwaysOnTop(true);
                    jd.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                } else {
                    DialogHelper.alert(jPanel1, "Phòng không có phiếu đăng kí.");
                }
            }
        });
        JMenuItem pmnu8 = new JMenuItem("Theo Dõi Dịch Vụ");
        pmnu8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                if (trangThai == 1 || trangThai == 5 || trangThai == 3) {
                    Model_PhieuDangKy mdl = dkdao.findByMaPhongActive(masoPhong);
                    TheoDoiDichVu jd = new TheoDoiDichVu(new javax.swing.JFrame(), true, Integer.valueOf(masoPhong), tensubPhong, mdl.getMaPhieuDK());
                    jd.setVisible(true);
                    jd.setModal(true);
                    jd.setAlwaysOnTop(true);
                    jd.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                } else {
                    DialogHelper.alert(jPanel1, "Phòng không có khách!.");
                }
            }
        });
        editMenu.add(pmnu0);
        if (!tenKhach.isEmpty()) {
            editMenu.add(pmnu0s);
        }
        editMenu.add(sep);
        editMenu.add(pmnu1);
        editMenu.add(pmnu2);
        editMenu.add(pmnu3);
        editMenu.add(pmnu4);
        editMenu.add(pmnu6);
        editMenu.add(sep);
        editMenu.add(pmnu7);
        editMenu.add(pmnu8);
        jPanel1.setComponentPopupMenu(editMenu);

    }
}
