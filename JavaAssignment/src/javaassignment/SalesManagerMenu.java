/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaassignment;

/**
 *
 * @author User
 */
public class SalesManagerMenu extends javax.swing.JFrame {
    public SalesManagerMenu() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("SALES MANAGER MENU");

        supplierbtn.setText("SUPPLIER MANAGEMENT");
        supplierbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierbtnActionPerformed(evt);
            }
        });

        itemBtn.setText("ITEM MANAGEMENT");
        itemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBtnActionPerformed(evt);
            }
        });

        salesEntryBtn.setText("DAILY SALES ENTRY");
        salesEntryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesEntryBtnActionPerformed(evt);
            }
        });

        prBtn.setText("PURCHASE REQUISITION");
        prBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prBtnActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(supplierbtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(itemBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(salesEntryBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(prBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(227, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(316, 316, 316))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(itemBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salesEntryBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supplierbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addComponent(prBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(itemBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(salesEntryBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(supplierbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prBtn)
                .addContainerGap(176, Short.MAX_VALUE))
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesManagerMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton itemBtn;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton prBtn;
    private javax.swing.JButton salesEntryBtn;
    private javax.swing.JButton supplierbtn;
    // End of variables declaration//GEN-END:variables
}
