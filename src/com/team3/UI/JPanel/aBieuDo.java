/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.UI.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Dell Vostro
 */
public class aBieuDo extends javax.swing.JPanel {

    /**
     * Creates new form SoDoPhong
     */
    String userName = "sa";
    String password = "songlong";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=Quanlykhachsan";

    public aBieuDo() {
        initComponents();
        fillCbb();
        Jchart();

    }

    void fillCbb() {
        jComboBox1.removeAllItems();
        for (int i = 2018; i <= 2100; i++) {
            jComboBox1.addItem(String.valueOf(i));
        }
        jComboBox1.setSelectedItem(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
    }

    void Jchart() {
        int s1 = 0;
        int s2 = 0;
        int s3 = 0;
        int s4 = 0;
        int s5 = 0;
        int s6 = 0;
        int s7 = 0;
        int s8 = 0;
        int s9 = 0;
        int s10 = 0;
        int s11 = 0;
        int s12 = 0;
        Vector data = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            String sql = "SELECT SUM(TongTien) AS N'Tổng tiền', MONTH(NgayThanhToan) AS N'Tháng'\n"
                    + "FROM HoaDon\n"
                    + "WHERE TrangThai = 1 AND YEAR(NgayThanhToan) = " + "'" + Integer.parseInt((String) jComboBox1.getSelectedItem()) + "' "
                    + "GROUP BY MONTH(NgayThanhToan)";
            ResultSet rs = st.executeQuery(sql);

            DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
            tblModel.setRowCount(0);
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getInt(1));
                data.add(rs.getString(2));
                // Thêm một dòng vào table model
                tblModel.addRow(data);
            }
            rs.close();
            st.close();
            con.close();

            for (int i = 0; i <= (data.capacity() / 2) - 1; i++) {

                switch (Integer.parseInt((String) jTable1.getValueAt(i, 1))) {
                    case 1:
                        s1 = Integer.parseInt(jTable1.getValueAt(i, 0).toString());
                        break;
                    case 2:
                        s2 = Integer.parseInt(jTable1.getValueAt(i, 0).toString());
                        break;
                    case 3:
                        s3 = Integer.parseInt(jTable1.getValueAt(i, 0).toString());
                        break;
                    case 4:
                        s4 = Integer.parseInt(jTable1.getValueAt(i, 0).toString());
                        break;
                    case 5:
                        s5 = Integer.parseInt(jTable1.getValueAt(i, 0).toString());
                        break;
                    case 6:
                        s6 = Integer.parseInt(jTable1.getValueAt(i, 0).toString());
                        break;
                    case 7:
                        s7 = Integer.parseInt(jTable1.getValueAt(i, 0).toString());
                        break;
                    case 8:
                        s8 = Integer.parseInt(jTable1.getValueAt(i, 0).toString());
                        break;
                    case 9:
                        s9 = Integer.parseInt(jTable1.getValueAt(i, 0).toString());
                        break;
                    case 10:
                        s10 = Integer.parseInt(jTable1.getValueAt(i, 0).toString());
                        break;
                    case 11:
                        s11 = Integer.parseInt(jTable1.getValueAt(i, 0).toString());
                        break;
                    case 12:
                        s12 = Integer.parseInt(jTable1.getValueAt(i, 0).toString());
                        break;
                    default:
                }
            }
        } catch (Exception ex) {
            
        }

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.setValue(s1, "", "1");
        dataSet.setValue(s2, "", "2");
        dataSet.setValue(s3, "", "3");
        dataSet.setValue(s4, "", "4");
        dataSet.setValue(s5, "", "5");
        dataSet.setValue(s6, "", "6");
        dataSet.setValue(s7, "", "7");
        dataSet.setValue(s8, "", "8");
        dataSet.setValue(s9, "", "9");
        dataSet.setValue(s10, "", "10");
        dataSet.setValue(s11, "", "11");
        dataSet.setValue(s12, "", "12");

        JFreeChart chart = ChartFactory.createBarChart("Thống kê doanh thu hằng tháng năm " + jComboBox1.getSelectedItem(), "", "Thu nhập", dataSet, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot catPlot = chart.getCategoryPlot();
        catPlot.setRangeCrosshairPaint(Color.BLACK);
        ChartPanel chartPanel = new ChartPanel(chart);
        JPanelX.removeAll();
        JPanelX.add(chartPanel, BorderLayout.CENTER);
        JPanelX.validate();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        JPanelX = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1250, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("BIỂU ĐỒ THỐNG KÊ DOANH THU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(839, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(177, 20));
        jPanel3.setPreferredSize(new java.awt.Dimension(1280, 35));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("     Năm      ");
        jPanel3.add(jLabel2);

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setPreferredSize(new java.awt.Dimension(250, 35));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jPanel3.add(jComboBox1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 957, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(850, 605));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(850, 30));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(15, 575));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel12, java.awt.BorderLayout.WEST);

        JPanelX.setBackground(new java.awt.Color(204, 255, 51));
        JPanelX.setLayout(new java.awt.BorderLayout());
        jPanel6.add(JPanelX, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel7.setBackground(new java.awt.Color(153, 153, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(430, 605));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jTable1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tổng doang thu", "Tháng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowHeight(22);
        jScrollPane1.setViewportView(jTable1);

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(430, 30));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("      Chi tiết");
        jPanel8.add(jLabel3);

        jPanel7.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(15, 575));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel10, java.awt.BorderLayout.WEST);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(15, 575));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel11, java.awt.BorderLayout.EAST);

        jPanel4.add(jPanel7, java.awt.BorderLayout.LINE_END);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
       Jchart();
    }//GEN-LAST:event_jComboBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Gioitinh;
    private javax.swing.JPanel JPanelX;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
