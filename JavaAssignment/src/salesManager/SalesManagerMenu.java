
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package salesManager;

import admin.LoginGUI;
import admin.UserClassification;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author User
 */
public class SalesManagerMenu extends javax.swing.JFrame {
        public SalesManagerMenu() {
            initComponents();
            jDesktopPane1.setBackground(new java.awt.Color(0xc5e1ef));
            setLocationRelativeTo(null);
            userlabel.setText(UserClassification.getCurrentUser().getFullName().toUpperCase());
            setCurrentTime();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        supplierbtn = new javax.swing.JButton();
        itemBtn = new javax.swing.JButton();
        salesEntryBtn = new javax.swing.JButton();
        prBtn = new javax.swing.JButton();
        poBtn = new javax.swing.JButton();
        poBtn1 = new javax.swing.JButton();
        userlabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jDesktopPane1.setBackground(new java.awt.Color(242, 242, 242));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("SALES MANAGER MENU");

        supplierbtn.setBackground(new java.awt.Color(255, 255, 204));
        supplierbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        supplierbtn.setText("SUPPLIER MANAGEMENT");
        supplierbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierbtnActionPerformed(evt);
            }
        });

        itemBtn.setBackground(new java.awt.Color(255, 255, 204));
        itemBtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        itemBtn.setText("ITEM MANAGEMENT");
        itemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBtnActionPerformed(evt);
            }
        });

        salesEntryBtn.setBackground(new java.awt.Color(255, 255, 204));
        salesEntryBtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        salesEntryBtn.setText("DAILY SALES ENTRY");
        salesEntryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesEntryBtnActionPerformed(evt);
            }
        });

        prBtn.setBackground(new java.awt.Color(255, 255, 204));
        prBtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        prBtn.setText("PURCHASE REQUISITION");
        prBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prBtnActionPerformed(evt);
            }
        });

        poBtn.setBackground(new java.awt.Color(255, 255, 204));
        poBtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        poBtn.setText("VIEW PURCHASE ORDER");
        poBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poBtnActionPerformed(evt);
            }
        });

        poBtn1.setBackground(new java.awt.Color(255, 102, 102));
        poBtn1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        poBtn1.setText("LOG OUT");
        poBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poBtn1ActionPerformed(evt);
            }
        });

        userlabel.setBackground(new java.awt.Color(255, 255, 255));
        userlabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        userlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userlabel.setText("hhhh");

        dateLabel.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(102, 102, 102));
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("yyyy-MM-dd HH:mm");

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(supplierbtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(itemBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(salesEntryBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(prBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(poBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(poBtn1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(userlabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(dateLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(105, 105, 105))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salesEntryBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supplierbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prBtn)
                    .addComponent(poBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(poBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateLabel)
                .addGap(8, 8, 8)
                .addComponent(itemBtn)
                .addGap(18, 18, 18)
                .addComponent(salesEntryBtn)
                .addGap(18, 18, 18)
                .addComponent(supplierbtn)
                .addGap(18, 18, 18)
                .addComponent(prBtn)
                .addGap(18, 18, 18)
                .addComponent(poBtn)
                .addGap(18, 18, 18)
                .addComponent(poBtn1)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void supplierbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierbtnActionPerformed
        // TODO add your handling code here:
        SupplierManagementGUI supplierForm = new SupplierManagementGUI();
        supplierForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_supplierbtnActionPerformed

    private void itemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBtnActionPerformed
        // TODO add your handling code here:
        ItemManagement itemForm = new ItemManagement();
        itemForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemBtnActionPerformed

    private void salesEntryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesEntryBtnActionPerformed
        // TODO add your handling code here:
        SalesEntryGUI salesEntry = new SalesEntryGUI();
        salesEntry.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_salesEntryBtnActionPerformed

    private void prBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prBtnActionPerformed
        // TODO add your handling code here:
        PurchaseRequisitionGUI PRForm = new PurchaseRequisitionGUI();
        PRForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_prBtnActionPerformed

    private void poBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poBtnActionPerformed
        // TODO add your handling code here:
        ViewPOs VPO = new ViewPOs();
        VPO.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_poBtnActionPerformed

    private void poBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poBtn1ActionPerformed
        // TODO add your handling code here:
        dispose(); 
        new LoginGUI().setVisible(true);
    }//GEN-LAST:event_poBtn1ActionPerformed

    private void setCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        dateLabel.setText(formatter.format(date));
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                new SalesManagerMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton itemBtn;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton poBtn;
    private javax.swing.JButton poBtn1;
    private javax.swing.JButton prBtn;
    private javax.swing.JButton salesEntryBtn;
    private javax.swing.JButton supplierbtn;
    private javax.swing.JLabel userlabel;
    // End of variables declaration//GEN-END:variables
}
