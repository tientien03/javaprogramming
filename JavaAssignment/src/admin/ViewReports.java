/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import main.FileReaderUtil;
import main.FileWriterUtil;
import financeManager.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.nio.file.*;

public class ViewReports extends javax.swing.JFrame {

    public ViewReports() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(0xc5e1ef));
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        financereport = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        stockreport = new javax.swing.JTextArea();
        viewinventoryreportbutton = new javax.swing.JButton();
        viewfinancereportbutton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 40)); // NOI18N
        jLabel1.setText("Current Report");

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("MENU");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setText("FINANCE REPORT");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setText("INVENTORY REPORT");

        financereport.setBackground(new java.awt.Color(255, 255, 204));
        financereport.setColumns(20);
        financereport.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        financereport.setRows(5);
        jScrollPane1.setViewportView(financereport);

        stockreport.setBackground(new java.awt.Color(255, 255, 204));
        stockreport.setColumns(20);
        stockreport.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        stockreport.setRows(5);
        jScrollPane2.setViewportView(stockreport);

        viewinventoryreportbutton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        viewinventoryreportbutton.setText("VIEW");
        viewinventoryreportbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewinventoryreportbuttonActionPerformed(evt);
            }
        });

        viewfinancereportbutton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        viewfinancereportbutton.setText("VIEW");
        viewfinancereportbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewfinancereportbuttonActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setText("REFRESH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewinventoryreportbutton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(viewfinancereportbutton)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(viewfinancereportbutton)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(viewinventoryreportbutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewfinancereportbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewfinancereportbuttonActionPerformed
        // TODO add your handling code here:
        try {
            List<String> lines = Files.readAllLines(Paths.get("finance_report.txt"));
            financereport.setText(""); 
            
            for (String line : lines){
                financereport.append(line + "\n");
            }    
        } catch (IOException e){
            JOptionPane.showMessageDialog(this,"Load Failed");
            e.printStackTrace();
        }
    }//GEN-LAST:event_viewfinancereportbuttonActionPerformed

    private void viewinventoryreportbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewinventoryreportbuttonActionPerformed
        // TODO add your handling code here:
        try {
            List<String> lines = Files.readAllLines(Paths.get("stock_report.txt"));
            stockreport.setText("");
        
            for (String line : lines){
                stockreport.append(line + "\n");
            }
        } catch (IOException e){
            JOptionPane.showMessageDialog(this,"Load Failed");
            e.printStackTrace();
        }
    }//GEN-LAST:event_viewinventoryreportbuttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AdminMenuGUI menu = new AdminMenuGUI();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        refreshReports();
        clearInput();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void clearInput() {
        financereport.setText("");
        stockreport.setText("");
        }
    
    private void refreshReports() {
    
    financereport.setText("");
    stockreport.setText("");

    
    List<String[]> financeData = FileReaderUtil.readFileAsArrays("finance_report.txt");
    List<String[]> inventoryData = FileReaderUtil.readFileAsArrays("inventory_report.txt");

   
    for (String[] row : financeData) {
        financereport.append(String.join(", ", row) + "\n");
        }
    for (String[] row : inventoryData) {
        stockreport.append(String.join(", ", row) + "\n");
        }

   
    JOptionPane.showMessageDialog(this, "Reports refreshed successfully!");
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewReports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea financereport;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea stockreport;
    private javax.swing.JButton viewfinancereportbutton;
    private javax.swing.JButton viewinventoryreportbutton;
    // End of variables declaration//GEN-END:variables
}
