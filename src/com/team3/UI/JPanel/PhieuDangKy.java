/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.UI.JPanel;

import com.team3.DAO.DAO_PhieuDangKy;
import com.team3.Helpers.DateHelper;
import com.team3.Helpers.DialogHelper;
import com.team3.Helpers.ShareHelper;
import com.team3.Helpers.StringParseHelper;
import com.team3.Model.Model_PhieuDangKy;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell Vostro
 */
public class PhieuDangKy extends javax.swing.JPanel {

    DAO_PhieuDangKy phieuDkDAO = new DAO_PhieuDangKy();

    int index = 0;

    public PhieuDangKy() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Gioitinh = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        pnlDSLP = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPDK = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        pnlChiTiet = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        chitiet = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dccNgayNhan = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        dccNgayTraDK = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        dccNgayTraTT = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        dccNgayLap = new com.toedter.calendar.JDateChooser();
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cboTrangthai = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1250, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("PHI???U ????NG K??");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(938, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.X_AXIS));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(15, 610));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5);

        pnlDSLP.setBackground(new java.awt.Color(255, 255, 255));
        pnlDSLP.setPreferredSize(new java.awt.Dimension(730, 570));
        pnlDSLP.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tblPDK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblPDK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "M?? phi???u", "M?? kh??ch h??ng", "M?? ph??ng", "Ng??y nh???n ph??ng", "Ng??y tr??? d??? ki???n", "Ng??y tr??? th???c t???", "Ng?????i l???p", "Ng?????i l???p", "Tr???ng th??i"
            }
        ));
        tblPDK.setRowHeight(22);
        tblPDK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPDKMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPDK);

        pnlDSLP.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("      Danh s??ch phi???u ????ng k??");
        jLabel2.setPreferredSize(new java.awt.Dimension(132, 25));
        pnlDSLP.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(pnlDSLP);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(20, 610));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);

        pnlChiTiet.setBackground(new java.awt.Color(255, 255, 255));
        pnlChiTiet.setPreferredSize(new java.awt.Dimension(500, 570));
        pnlChiTiet.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("      Chi ti???t");
        jLabel3.setPreferredSize(new java.awt.Dimension(42, 25));
        pnlChiTiet.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        chitiet.setBackground(new java.awt.Color(255, 255, 255));
        chitiet.setLayout(new java.awt.GridLayout(3, 0));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.GridLayout(6, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("M?? kh??ch h??ng");
        jPanel3.add(jLabel4);

        txtMaKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtMaKH);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("M?? Ph??ng");
        jPanel3.add(jLabel5);

        txtMP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtMP);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Ng??y nh???n ph??ng");
        jPanel3.add(jLabel6);
        jPanel3.add(dccNgayNhan);

        chitiet.add(jPanel3);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.GridLayout(6, 0));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Ng??y tr??? d??? ki???n");
        jPanel8.add(jLabel7);
        jPanel8.add(dccNgayTraDK);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Ng??y tr??? th???c t???");
        jPanel8.add(jLabel8);
        jPanel8.add(dccNgayTraTT);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Ng??y l???p");
        jPanel8.add(jLabel9);
        jPanel8.add(dccNgayLap);

        chitiet.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.GridLayout(2, 0));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.GridLayout(3, 0));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Tr???ng th??i");
        jPanel7.add(jLabel10);

        cboTrangthai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboTrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "??ang x??? l??", "Ho??n th??nh", "H???y" }));
        jPanel7.add(cboTrangthai);

        jPanel9.add(jPanel7);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setText("X??a");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel11.add(btnXoa);

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setText("L??m m???i");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        jPanel11.add(btnLamMoi);

        btnExport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExport.setText("Xu???t Excel P??K");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        jPanel11.add(btnExport);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel10);

        chitiet.add(jPanel9);

        pnlChiTiet.add(chitiet, java.awt.BorderLayout.CENTER);

        jPanel2.add(pnlChiTiet);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(15, 610));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (checkRole()) {
            deletePhieuDK();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        ClearPhieuDK();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblPDKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPDKMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            editPhieuDK();
        }
    }//GEN-LAST:event_tblPDKMouseClicked

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        if (DialogHelper.confirm(this, "H??y ch???c ch???n b???n mu???n tr??ch xu???t d??? li???u!")) {
            this.exportExcel(tblPDK);
        }
    }//GEN-LAST:event_btnExportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Gioitinh;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboTrangthai;
    private javax.swing.JPanel chitiet;
    private com.toedter.calendar.JDateChooser dccNgayLap;
    private com.toedter.calendar.JDateChooser dccNgayNhan;
    private com.toedter.calendar.JDateChooser dccNgayTraDK;
    private com.toedter.calendar.JDateChooser dccNgayTraTT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlChiTiet;
    private javax.swing.JPanel pnlDSLP;
    private javax.swing.JTable tblPDK;
    private javax.swing.JTextField txtMP;
    private javax.swing.JTextField txtMaKH;
    // End of variables declaration//GEN-END:variables

    void init() {
        loadPhieuDK();
        dccNgayLap.setDateFormatString("dd/MM/yyyy");
        dccNgayLap.setDate(new Date());
        dccNgayNhan.setDateFormatString("dd/MM/yyyy");
        dccNgayNhan.setDate(new Date());
        dccNgayTraDK.setDateFormatString("dd/MM/yyyy");
        dccNgayTraDK.setDate(new Date());
        dccNgayTraTT.setDateFormatString("dd/MM/yyyy");
        dccNgayTraTT.setDate(new Date());
    }

    void loadPhieuDK() {
        DefaultTableModel model = (DefaultTableModel) tblPDK.getModel();
        model.setRowCount(0);
        try {
            List<Model_PhieuDangKy> list = phieuDkDAO.select();
            for (Model_PhieuDangKy pdk : list) {
                Object[] row = {
                    pdk.getMaPhieuDK(),
                    pdk.getMaKH(),
                    pdk.getMaPhong(),
                    DateHelper.toString(pdk.getNgayNhanPhong()),
                    DateHelper.toString(pdk.getNgayTraPhongDuKien()),
                    DateHelper.toString(pdk.getNgayTraPhongThucTe()),
                    DateHelper.toString(pdk.getNgayLap()),
                    pdk.getMaNV(),
                    StringParseHelper.TrangThaitoString(pdk.getTrangThai())
                };
                model.addRow(row);
                if (list.size() > 0) {
                    tblPDK.setRowSelectionInterval(index, index);
                }
            }
        } catch (Exception e) {

        }
    }

    void ClearPhieuDK() {
        txtMaKH.setText(null);
        txtMP.setText(null);
        dccNgayNhan.setDate(new Date());
        dccNgayTraDK.setDate(new Date());
        dccNgayTraTT.setDate(new Date());
        dccNgayLap.setDate(new Date());
        cboTrangthai.setSelectedIndex(0);
        tblPDK.clearSelection();
        index = 0;
        setButton(true);
    }

    void setModelPhieuDK(Model_PhieuDangKy model) {
        txtMaKH.setText(String.valueOf(model.getMaKH()));
        txtMP.setText(String.valueOf(model.getMaPhong()));
        dccNgayNhan.setDate(model.getNgayNhanPhong());
        dccNgayTraDK.setDate(model.getNgayTraPhongDuKien());
        dccNgayTraTT.setDate(model.getNgayTraPhongThucTe());
        dccNgayLap.setDate(model.getNgayLap());
        cboTrangthai.setSelectedItem(StringParseHelper.TrangThaitoString(model.getTrangThai()));

    }

    void deletePhieuDK() {
        if (DialogHelper.confirm(this, "B???n th???c s??? mu???n x??a n??y?")) {
            int MP = (int) tblPDK.getValueAt(tblPDK.getSelectedRow(), 0);
            try {
                phieuDkDAO.delete(MP);
                loadPhieuDK();
                ClearPhieuDK();
                DialogHelper.alert(this, "X??a th??nh c??ng!");
            } catch (Exception e) {
                DialogHelper.alert(this, "X??a th???t b???i!");
            }
        }
    }

    void setButton(boolean value) {
        btnXoa.setEnabled(!value);
    }

    void editPhieuDK() {
        try {
            String MaPhieuDK = String.valueOf(tblPDK.getValueAt(tblPDK.getSelectedRow(), 0));
            Model_PhieuDangKy model = phieuDkDAO.findById(MaPhieuDK);
            if (model != null) {
                this.setModelPhieuDK(model);
                setButton(false);
            }
        } catch (Exception e) {

        }
    }

    boolean checkRole() {
        if (ShareHelper.role == 2) {
            return true;
        } else {
            DialogHelper.alert(this, "Ch??? c?? qu???n l?? m???i ???????c thao t??c");
            return false;
        }
    }

    public void exportExcel(JTable table) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Microsoft 97/2003 Worksheet Book - *.xls ","xls"));
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                FileWriter out = new FileWriter(file+".xls");
                BufferedWriter bwrite = new BufferedWriter(out);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                // ten Cot
                for (int j = 0; j < table.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < table.getRowCount(); j++) {
                    for (int k = 0; k < table.getColumnCount(); k++) {
                        bwrite.write(model.getValueAt(j, k) + "\t");
                    }
                    bwrite.write("\n");
                }
                bwrite.close();
                DialogHelper.alert(this, "Tr??ch xu???t th??nh c??ng!");
            } catch (Exception e) {
                DialogHelper.alert(this, "L???i tr??ch xu???t b???ng!");
            }
        }
    }
}
