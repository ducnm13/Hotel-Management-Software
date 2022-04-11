/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.UI;

import com.team3.DAO.DAO_NhanVien;
import com.team3.Helpers.DialogHelper;
import com.team3.Helpers.ShareHelper;
import com.team3.Model.Model_NhanVien;
import java.awt.Color;
import java.awt.Dialog;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Dell Vostro
 */
public class ForgetPass_Form extends javax.swing.JDialog {

    static int xx, yy;

    DAO_NhanVien dao = new DAO_NhanVien();

    /**
     * Creates new form SignUp_Form
     */
    public ForgetPass_Form(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    void init() {
        this.setLocationRelativeTo(null);
        txtEmail.setText(ShareHelper.email);
    }

    void EmailConfirm() {
        try {
            if (txtEmail.getText().length() > 0 && txtVerify.getText().length() > 0) {
                if (txtEmail.getText().trim().equalsIgnoreCase(String.valueOf(ShareHelper.email))) {
                    if (txtVerify.getText().trim().equals(String.valueOf(ShareHelper.verify))) {
                        openReset();
                        this.dispose();
                    } else {
                        DialogHelper.alert(this, "Mã xác nhận đã quá hạn hoặc không tòn tại");
                        txtVerify.requestFocus();
                    }
                } else {
                    DialogHelper.alert(this, "Email nhập không đúng");
                    txtEmail.requestFocus();
                }
            } else {
                DialogHelper.alert(this, "Email hoặc mã xác nhận không được đê trống");
            }
        } catch (Exception e) {

        }
    }

    void openReset() {
        this.setVisible(false);
        ResetPass_Form jd = new ResetPass_Form(new javax.swing.JFrame(), true);
        jd.setVisible(true);
        jd.setAlwaysOnTop(true);
    }
    
    static String random(){
        char[] chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder(6);
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
            }
        String output = sb.toString();
        return output;
    }
    
    void sendVerify() {
        String email = txtEmail.getText();
        try {
            if (email.length() > 0) {
                if (email != null) {
                    Model_NhanVien model = dao.findByEmail(email);
                    if (model != null) {
                        String code = random();
                        ShareHelper.verify = code;
                        ShareHelper.email = model.getEmail().trim();
                        Properties pp = new Properties();
                        pp.put("mail.smtp.auth", "true");
                        pp.put("mail.smtp.starttls.enable", "true");
                        pp.put("mail.smtp.host", "smtp.gmail.com");
                        pp.put("mail.smtp.port", 587);
                        Session ss = Session.getInstance(pp, new javax.mail.Authenticator() {
                            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                                return new javax.mail.PasswordAuthentication("poly3duan@gmail.com", "Poly123456789");
                            }
                        });
                        String from = "poly3duan@gmail.com";
                        String to = ShareHelper.email;
                        Message msg = new MimeMessage(ss);
                        msg.setFrom(new InternetAddress(from));
                        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                        msg.setSubject("Verify Code - Phần Mềm Quản Lý Khách Sạn PhucCO.LTD");
//                        msg.setText("Xin Chào " + to + "!\n" + "Chúng tôi vừa nhận được yêu cầu khôi phục mật khẩu. Để tiếp tục, vui lòng nhập mã xác minh: " + code
//                                + "\nEmail này được gửi tự động. Vui lòng không trả lời Email này. \n\n\n"
//                                + "Trân trọng, \nPhần Mềm Quản Lý Khách Sạn PhucCO.LTD");
                        msg.setContent("<head>\n"
                                + "  <style type=\"text/css\" title=\"x-apple-mail-formatting\"></style>\n"
                                + "  <meta name=\"viewport\" content=\"width = 375, initial-scale = -1\">\n"
                                + "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                                + "  <meta charset=\"UTF-8\">\n"
                                + "  <title></title>\n"
                                + "  <style>\n"
                                + "  @media only screen and (max-device-width: 700px) {\n"
                                + "  .table-wrapper {\n"
                                + "  margin-top: 0px !important;\n"
                                + "  border-radius: 0px !important;\n"
                                + "  }\n"
                                + "  .header {\n"
                                + "  border-radius: 0px !important;\n"
                                + "  }\n"
                                + "  }\n"
                                + "  </style>\n"
                                + "</head>\n"
                                + "<body style=\"-webkit-font-smoothing:antialiased;\n"
                                + "  -webkit-text-size-adjust:none;\n"
                                + "  margin:0;\n"
                                + "  padding:0;\n"
                                + "  font-family:&quot; Arial&quot;, sans-serif;\n"
                                + "  font-size:100%;\n"
                                + "  line-height:1.6\">\n"
                                + "  <table style=\"background: #F5F6F7;\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\n"
                                + "    <tbody>\n"
                                + "      <tr>\n"
                                + "        <td>\n"
                                + "          <table  cellpadding=\"0\" cellspacing=\"0\" class=\"table-wrapper\" style=\" margin:auto;\n"
                                + "            margin-top:50px;\n"
                                + "            border-radius:7px;\n"
                                + "            -webkit-border-radius:7px;\n"
                                + "            -moz-border-radius:7px;\n"
                                + "            max-width:700px !important;\n"
                                + "            box-shadow:0 8px 20px #e3e7ea !important;\n"
                                + "            -webkit-box-shadow:0 8px 20px #e3e7ea !important;\n"
                                + "            -moz-box-shadow:0 8px 20px #e3e7ea !important;\n"
                                + "            box-shadow: 0 8px 20px #e3e7ea !important;\n"
                                + "            -webkit-box-shadow: 0 8px 20px #e3e7ea !important;\n"
                                + "            -moz-box-shadow: 0 8px 20px #e3e7ea !important;\">\n"
                                + "            <tbody><tr>\n"
                                + "              <td class=\"container\" bgcolor=\"#FFFFFF\" style=\"display:block !important;margin:0 auto !important;clear:both !important\">\n"
                                + "                <img src=\"https://cdn.discordapp.com/attachments/667070284305793065/700728663171137606/email-header.png\" style=\"max-width:100%\">\n"
                                + "              </td>\n"
                                + "            </tr>\n"
                                + "            <tr>\n"
                                + "              <td class=\"container content\" bgcolor=\"#FFFFFF\" style=\"padding:35px 40px;border-bottom-left-radius:6px;\n"
                                + "              border-bottom-right-radius:6px;display:block !important;margin:0 auto !important;clear:both !important\">\n"
                                + "                <div class=\"content-box\" style=\"max-width:600px;margin:0 auto;display:block\">\n"
                                + "                  <h1 style=\"font-family:&quot; Arial&quot;, sans-serif;margin-bottom:15px;color:#47505E;\n"
                                + "                  margin:0px 0 10px;line-height:1.2;font-weight:200;font-size:28px;font-weight:bold;margin-bottom:30px\">\n"
                                + "                Xác thực khôi phục tài khoản</h1>\n"
                                + "                  <p style=\"font-weight:normal;padding:0;font-family:&quot; Arial&quot;, sans-serif;line-height:1.7;margin-bottom:1.3em;\n"
                                + "                  font-size:15px;color:#47505E\">Xin chào " + to + "! Chúng tôi vừa nhận được yêu cầu khôi phục tài khoản của bạn. <br>\n"
                                + "                  Mã khôi phục của bạn là:</p>\n"
                                + "                  <center><a href=\"#\" class=\"confirmation-url btn-primary\" style=\"color:#1EA69A;word-wrap:break-word;\n"
                                + "                  font-family:&quot; Arial&quot;, sans-serif;text-decoration:none;background-color:#30374F;border:solid #30374F;\n"
                                + "                  line-height:2;max-width:100%;font-size:22px;padding:8px 40px 8px 40px;margin-top:30px;margin-bottom:30px;font-weight:bold;cursor:pointer;\n"
                                + "                  display:inline-block;border-radius:30px;margin-left:auto;margin-right:auto;text-align:center;color:#FFF !important\">" + code + "</a></center>\n"
                                + "                  <p style=\"font-weight:normal;padding:0;font-family:&quot; Arial&quot;, sans-serif;line-height:1.7;margin-bottom:1.3em;\n"
                                + "                  font-size:15px;color:#47505E\">Đây là thư được gửi tự động. Vui lòng không trả lời thư này.</p>\n"
                                + "                  <p style=\"font-weight:normal;padding:0;font-family:&quot; Arial&quot;, sans-serif;line-height:1.7;margin-bottom:1.3em;\n"
                                + "                  font-size:15px;color:#47505E\">Trân trọng,<br>\n"
                                + "                  Phần mềm Quản Lý Khách Sạn Team2.Ltd</p>\n"
                                + "                  <script type=\"application/ld+json\">{\"@context\":\"http://schema.org\",\"@type\":\"EmailMessage\",\"potentialAction\":{\"@type\":\"ConfirmAction\",\"name\":\"Confirm Email\",\"handler\":{\"@type\":\"HttpActionHandler\",\"url\":\"http://sso.teachable.com/secure/teachable_accounts/confirmation?confirmation_token=4dNuyAZNQin-Sfq48uB4\"}}}</script>\n"
                                + "                </div>\n"
                                + "              </td>\n"
                                + "              <td>\n"
                                + "              </td>\n"
                                + "            </tr>\n"
                                + "          </tbody></table>\n"
                                + "          <!-- /body -->\n"
                                + "          <div class=\"footer\" style=\"padding-top:30px;padding-bottom:55px;width:100%;text-align:center;clear:both !important\">\n"
                                + "            <p style=\"font-weight:normal;padding:0;font-family:&quot; Arial&quot;, sans-serif;line-height:1.7;margin-bottom:1.3em;font-size:15px;color:#47505E;font-size:12px;color:#666;margin-top:0px\">© 2020 Dự Án 1 - Team2™ - FPT Polytechnic</p>\n"
                                + "          </div>\n"
                                + "        </td>\n"
                                + "      </tr>\n"
                                + "    </tbody></table>\n"
                                + "    \n"
                                + "  </body>", "text/html; charset=utf-8");

                        Transport.send(msg);
                        DialogHelper.alert(this, "Mã xác thực đã được gửi. Vui lòng kiểm tra Email của bạn");
                    } else {
                        DialogHelper.alert(this, "Email không tồn tại trên hệ thống!");
                        txtEmail.requestFocus();
                    }
                }
            } else {
                DialogHelper.alert(this, "Vui lòng nhập Email!");
                txtEmail.requestFocus();
            }
        } catch (Exception e) {

        }
    }
    void openSignIn() {
        this.setVisible(false);
        SignIn_Form jd = new SignIn_Form(new javax.swing.JFrame(), true);
        jd.setVisible(true);
        jd.setModal(true);
        jd.setAlwaysOnTop(true);
        jd.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblVerify = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtVerify = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnAccept = new javax.swing.JButton();
        lblMinimize = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVerify.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblVerify.setForeground(new java.awt.Color(113, 113, 113));
        lblVerify.setText("Nhận mã xác thực?");
        lblVerify.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVerify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVerifyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblVerifyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblVerifyMouseExited(evt);
            }
        });
        jPanel1.add(lblVerify, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 130, -1));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtEmail.setText("admin@gmail.com");
        txtEmail.setBorder(null);
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 290, -1));

        txtVerify.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtVerify.setText("123456");
        txtVerify.setBorder(null);
        jPanel1.add(txtVerify, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 290, -1));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/back1.png"))); // NOI18N
        btnBack.setBorder(null);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, -1));

        btnAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/accept2.png"))); // NOI18N
        btnAccept.setBorder(null);
        btnAccept.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAccept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAcceptMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAcceptMouseExited(evt);
            }
        });
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });
        jPanel1.add(btnAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, -1, -1));

        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/minimize1.png"))); // NOI18N
        lblMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMinimizeMousePressed(evt);
            }
        });
        jPanel1.add(lblMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 5, -1, -1));

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/close1.png"))); // NOI18N
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCloseMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCloseMousePressed(evt);
            }
        });
        jPanel1.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 5, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/FogetPassword.png"))); // NOI18N
        bg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bgMouseDragged(evt);
            }
        });
        bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bgMousePressed(evt);
            }
        });
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMousePressed
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_bgMousePressed

    private void bgMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - yy);
    }//GEN-LAST:event_bgMouseDragged

    private void lblMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseEntered
        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/minimize2.png")));
    }//GEN-LAST:event_lblMinimizeMouseEntered

    private void lblMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseExited
        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/minimize1.png")));
    }//GEN-LAST:event_lblMinimizeMouseExited

    private void lblMinimizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMousePressed
//        setState(this.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMousePressed

    private void lblCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseEntered
        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/close2.png")));
    }//GEN-LAST:event_lblCloseMouseEntered

    private void lblCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseExited
        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/icons/close1.png")));
    }//GEN-LAST:event_lblCloseMouseExited

    private void lblCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMousePressed
        System.exit(0);
    }//GEN-LAST:event_lblCloseMousePressed

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/back2.png")));
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/back1.png")));
    }//GEN-LAST:event_btnBackMouseExited

    private void btnAcceptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAcceptMouseEntered
        btnAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/accept1.png")));
    }//GEN-LAST:event_btnAcceptMouseEntered

    private void btnAcceptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAcceptMouseExited
        btnAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/team3/Images/UI/accept2.png")));
    }//GEN-LAST:event_btnAcceptMouseExited

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        // TODO add your handling code here:
        this.EmailConfirm();
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void txtVerifyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVerifyMouseClicked
        // TODO add your handling code here:
        txtVerify.setText("");
    }//GEN-LAST:event_txtVerifyMouseClicked

    private void lblVerifyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerifyMouseClicked
        this.sendVerify();
    }//GEN-LAST:event_lblVerifyMouseClicked

    private void lblVerifyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerifyMouseEntered
        lblVerify.setForeground(Color.decode("#FF374F"));
    }//GEN-LAST:event_lblVerifyMouseEntered

    private void lblVerifyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerifyMouseExited
        lblVerify.setForeground(Color.decode("#717171"));
    }//GEN-LAST:event_lblVerifyMouseExited

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.openSignIn();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(ForgetPass_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgetPass_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgetPass_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgetPass_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ForgetPass_Form dialog = new ForgetPass_Form(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel bg;
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnBack;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblVerify;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtVerify;
    // End of variables declaration//GEN-END:variables
}
