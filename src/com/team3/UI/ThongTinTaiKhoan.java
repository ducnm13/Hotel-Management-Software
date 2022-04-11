/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.UI;

import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import com.team3.DAO.DAO_NhanVien;
import com.team3.Helpers.DialogHelper;
import com.team3.Helpers.ShareHelper;
import com.team3.Model.Model_NhanVien;
import java.awt.Color;

/**
 *
 * @author MyPC
 */
public class ThongTinTaiKhoan extends javax.swing.JDialog {

    DAO_NhanVien dao = new DAO_NhanVien();
    JFileChooser fileChooser = new JFileChooser();

    /**
     * Creates new form ChangePasswordJFrame
     */
    public ThongTinTaiKhoan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    void init() {
        setIconImage(ShareHelper.APP_ICON);
    }

    void clear() {
        txtOldPass.setText("");
        txtNewPass.setText("");
        txtConfirm.setText("");
        chkShowPassword.setSelected(false);
        chkEditInfo.setSelected(false);
    }

    void update() {
        Model_NhanVien model = new Model_NhanVien();
        Model_NhanVien model2 = new Model_NhanVien();
        model = dao.findById(ShareHelper.user.getMaNV());
        model2 = dao.findByEmail(txtEmail.getText());
        String oldPass = model.getMatKhau();
        String regex = "^[\\w-_\\.[^0-9]]+\\@[\\w&&[a-z][^0-9]]+\\.[\\w&&[a-z][^0-9]]+[\\.[a-z]]+$";
        String txtoldPass = new String(txtOldPass.getPassword());
        String newPass = new String(txtNewPass.getPassword());
        String confirm = new String(txtConfirm.getPassword());
        String oldMail = model.getEmail();
        String email = txtEmail.getText();
        String hoten = txtHoTen.getText();
        if (!oldPass.equals(txtoldPass)) {
            DialogHelper.alert(this, "Mật khẩu cũ không đúng, hãy kiểm tra lại.");
            txtOldPass.requestFocus();
        } else if (newPass.length() < 6) {
            DialogHelper.alert(this, "Mật khẩu mới phải lớn hơn 6 kí tự");
            txtNewPass.requestFocus();
        } else if (!confirm.equals(newPass)) {
            DialogHelper.alert(this, "Xác nhận mật khẩu không đúng!");
            txtConfirm.requestFocus();
        } else if (chkEditInfo.isSelected() == true) {
            if (hoten.chars().allMatch(Character::isDigit) == true && hoten.length() == 0) {
                DialogHelper.alert(this, "Họ Tên phải là chữ cái và không được bỏ trống!");
                txtHoTen.requestFocus();
            } else if (!email.matches(regex) || email.length() == 0) {
                DialogHelper.alert(this, "Email không đúng!");
                txtEmail.requestFocus();
            } else if (model2 != null && !oldMail.equalsIgnoreCase(email)) {
                DialogHelper.alert(this, "Email đã có người đăng kí!");
                txtEmail.requestFocus();
            } else {
                try {
                    model.setMatKhau(confirm);
                    model.setEmail(email);
                    model.setTen(hoten);
                    model.setHinh(lblLogoPlace.getToolTipText());
                    dao.update(model);
                    this.clear();
                    this.load();
                    DialogHelper.alert(this, "Cập nhật thành công!");
                } catch (Exception e) {
                    DialogHelper.alert(this, "Cập nhật thất bại!");
                    e.printStackTrace();
                }
            }

        } else {
            try {
                model.setMatKhau(confirm);
                model.setEmail(email);
                model.setTen(hoten);
                model.setHinh(lblLogoPlace.getToolTipText());
                dao.update(model);
                this.clear();
                this.load();
                DialogHelper.alert(this, "Cập nhật thành công!");
            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thất bại!");
                e.printStackTrace();
            }
        }
    }

    void selectImage() {
        File file;
        if (this.fileChooser.showOpenDialog(this) == 0 && ShareHelper.savelogo(file = this.fileChooser.getSelectedFile())) {
            Image img = ShareHelper.readLogo(file.getName()).getImage();
            Image img1 = img.getScaledInstance(lblLogoPlace.getWidth(), lblLogoPlace.getHeight(), img.SCALE_SMOOTH);
            ImageIcon icon1 = new ImageIcon(img1);
            this.lblLogoPlace.setIcon(icon1);
            this.lblLogoPlace.setToolTipText(file.getName());
        }
    }

    void load() {
        lblTitle.setText("XIN CHÀO NHÂN VIÊN: " + ShareHelper.user.getTen());
        Model_NhanVien model = new Model_NhanVien();
        model = dao.findById(ShareHelper.user.getMaNV());
        Image img = ShareHelper.readLogo(model.getHinh()).getImage();
        ImageIcon icon1 = new ImageIcon(img.getScaledInstance(lblLogoPlace.getWidth(), lblLogoPlace.getHeight(), img.SCALE_SMOOTH));
        this.lblLogoPlace.setIcon(icon1);
        this.lblLogoPlace.setToolTipText(model.getHinh());
        txtEmail.setText(model.getEmail());
        txtHoTen.setText(model.getTen());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        btnSubmit = new keeptoo.KButton();
        btnReset = new keeptoo.KButton();
        lblLogoPlace = new javax.swing.JLabel();
        lblLogoTitle = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        chkEditInfo = new javax.swing.JCheckBox();
        chkShowPassword = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        txtConfirm = new javax.swing.JPasswordField();
        txtNewPass = new javax.swing.JPasswordField();
        txtOldPass = new javax.swing.JPasswordField();
        lblIconApp = new javax.swing.JLabel();
        lblGetQR = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel2.setText("Mật khẩu cũ:");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 78, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel1.setText("Mật khẩu mới:");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel3.setText("Email:");
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 41, -1));

        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/Cross-white.png"))); // NOI18N
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        kGradientPanel1.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 6, -1, -1));

        btnSubmit.setText("SUBMIT");
        btnSubmit.setBorderPainted(false);
        btnSubmit.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 163, -1));

        btnReset.setText("RESET FIELD");
        btnReset.setBorderPainted(false);
        btnReset.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, -1));

        lblLogoPlace.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        lblLogoPlace.setMaximumSize(new java.awt.Dimension(151, 190));
        lblLogoPlace.setMinimumSize(new java.awt.Dimension(151, 190));
        lblLogoPlace.setPreferredSize(new java.awt.Dimension(151, 190));
        lblLogoPlace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoPlaceMouseClicked(evt);
            }
        });
        kGradientPanel1.add(lblLogoPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 109, -1, -1));

        lblLogoTitle.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblLogoTitle.setForeground(new java.awt.Color(0, 0, 153));
        lblLogoTitle.setText("Ảnh đại diện");
        kGradientPanel1.add(lblLogoTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 87, -1, -1));
        kGradientPanel1.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 317, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel5.setText("Họ tên:");
        kGradientPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 41, -1));
        kGradientPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 317, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel6.setText("Xác nhận mật khẩu mới:");
        kGradientPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, -1, -1));

        lblTitle.setBackground(new java.awt.Color(0, 0, 153));
        lblTitle.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 153));
        lblTitle.setText("XIN CHÀO NHÂN VIÊN:");
        kGradientPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 258, -1));

        chkEditInfo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        chkEditInfo.setText("Bật tắt đổi họ tên và Email");
        chkEditInfo.setOpaque(false);
        chkEditInfo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkEditInfoStateChanged(evt);
            }
        });
        kGradientPanel1.add(chkEditInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 296, -1, -1));

        chkShowPassword.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        chkShowPassword.setText("Show Password");
        chkShowPassword.setOpaque(false);
        chkShowPassword.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkShowPasswordStateChanged(evt);
            }
        });
        kGradientPanel1.add(chkShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 296, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("TRANG TÀI KHOẢN CÁ NHÂN");
        kGradientPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 50, 252, -1));
        kGradientPanel1.add(txtConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 317, -1));
        kGradientPanel1.add(txtNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 317, -1));
        kGradientPanel1.add(txtOldPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 317, -1));

        lblIconApp.setBackground(new java.awt.Color(153, 255, 102));
        lblIconApp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconApp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/iconApp.png"))); // NOI18N
        lblIconApp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kGradientPanel1.add(lblIconApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        lblGetQR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGetQR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/qrico.png"))); // NOI18N
        lblGetQR.setText("Get QR Code");
        lblGetQR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGetQRMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGetQRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGetQRMouseExited(evt);
            }
        });
        kGradientPanel1.add(lblGetQR, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblLogoPlaceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoPlaceMouseClicked
        this.selectImage();
    }//GEN-LAST:event_lblLogoPlaceMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtHoTen.setEditable(false);
        txtEmail.setEditable(false);
        this.load();

    }//GEN-LAST:event_formWindowOpened

    private void chkEditInfoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkEditInfoStateChanged
        if (chkEditInfo.isSelected()) {
            txtHoTen.setEditable(true);
            txtEmail.setEditable(true);
            String matKhau = new String(txtOldPass.getPassword());
            if (matKhau.length() == 0) {
                DialogHelper.alert(this, "Bạn chưa nhập mật khẩu cũ");
            } else {
                txtNewPass.setText(matKhau);
                txtConfirm.setText(matKhau);
            }
        } else {
            txtHoTen.setEditable(false);
            txtEmail.setEditable(false);
            txtNewPass.setText(null);
            txtConfirm.setText(null);
        }
    }//GEN-LAST:event_chkEditInfoStateChanged

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        this.update();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        this.clear();
        this.load();
    }//GEN-LAST:event_btnResetActionPerformed

    private void chkShowPasswordStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkShowPasswordStateChanged
        if (chkShowPassword.isSelected()) {
            txtOldPass.setEchoChar((char) 0);
            txtNewPass.setEchoChar((char) 0);
            txtConfirm.setEchoChar((char) 0);
        } else {
            txtOldPass.setEchoChar('•');
            txtNewPass.setEchoChar('•');
            txtConfirm.setEchoChar('•');
        }
    }//GEN-LAST:event_chkShowPasswordStateChanged

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblExitMouseClicked

    private void lblGetQRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGetQRMouseEntered
        lblGetQR.setForeground(Color.red);
    }//GEN-LAST:event_lblGetQRMouseEntered

    private void lblGetQRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGetQRMouseExited
        lblGetQR.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblGetQRMouseExited

    private void lblGetQRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGetQRMouseClicked
        if (DialogHelper.confirm(this, "Make sure you want to generate it !")) {
            this.openQRGenerator();
        }
    }//GEN-LAST:event_lblGetQRMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongTinTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new ThongTinTaiKhoan().setVisible(true);
                ThongTinTaiKhoan dialog = new ThongTinTaiKhoan(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton btnReset;
    private keeptoo.KButton btnSubmit;
    private javax.swing.JCheckBox chkEditInfo;
    private javax.swing.JCheckBox chkShowPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblGetQR;
    private javax.swing.JLabel lblIconApp;
    private javax.swing.JLabel lblLogoPlace;
    private javax.swing.JLabel lblLogoTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPasswordField txtConfirm;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JPasswordField txtNewPass;
    private javax.swing.JPasswordField txtOldPass;
    // End of variables declaration//GEN-END:variables
    void openQRGenerator() {
        String user = ShareHelper.user.getMaNV();
        String matkhau = ShareHelper.user.getMatKhau();
        String keycode = user+"--"+matkhau;
        GeneratedCode jd = new GeneratedCode(new javax.swing.JFrame(), true, keycode);
        jd.setModal(true);
        jd.setVisible(true);
    }
}
