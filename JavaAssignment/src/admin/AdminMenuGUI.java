/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author USER
 */
public class AdminMenuGUI extends javax.swing.JFrame {
    
    public AdminMenuGUI() {
        initComponents();
        setCurrentTime();
        getContentPane().setBackground(new java.awt.Color(0xc5e1ef));
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userbutton = new javax.swing.JButton();
        inventory_supplierbutton = new javax.swing.JButton();
        viewreport = new javax.swing.JButton();
        po_prbutton = new javax.swing.JButton();
        logoutbutton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("Administrator Main Menu");

        userbutton.setBackground(new java.awt.Color(255, 255, 204));
        userbutton.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        userbutton.setText("USER MANAGEMENT");
        userbutton.setBorder(new javax.swing.border.MatteBorder(null));
        userbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbuttonActionPerformed(evt);
            }
        });

        inventory_supplierbutton.setBackground(new java.awt.Color(255, 255, 204));
        inventory_supplierbutton.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        inventory_supplierbutton.setText("INVENTORY & SUPPLIER ");
        inventory_supplierbutton.setBorder(new javax.swing.border.MatteBorder(null));
        inventory_supplierbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventory_supplierbuttonActionPerformed(evt);
            }
        });

        viewreport.setBackground(new java.awt.Color(255, 255, 204));
        viewreport.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        viewreport.setText("VIEW CURRENT REPORT");
        viewreport.setBorder(new javax.swing.border.MatteBorder(null));
        viewreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewreportActionPerformed(evt);
            }
        });

        po_prbutton.setBackground(new java.awt.Color(255, 255, 204));
        po_prbutton.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        po_prbutton.setText("REQUISITION & ORDER");
        po_prbutton.setBorder(new javax.swing.border.MatteBorder(null));
        po_prbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                po_prbuttonActionPerformed(evt);
            }
        });

        logoutbutton.setBackground(new java.awt.Color(255, 102, 102));
        logoutbutton.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        logoutbutton.setText("LOG OUT");
        logoutbutton.setBorder(new javax.swing.border.MatteBorder(null));
        logoutbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbuttonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("yyyy-MM-dd HH:mm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logoutbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(po_prbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(viewreport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inventory_supplierbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(userbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inventory_supplierbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewreport, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(po_prbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logoutbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbuttonActionPerformed
        new ViewuserGUI().setVisible(true);
    }//GEN-LAST:event_userbuttonActionPerformed

    private void inventory_supplierbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventory_supplierbuttonActionPerformed
        new admin.Item_SupplierGUI().setVisible(true); 
    }//GEN-LAST:event_inventory_supplierbuttonActionPerformed

    private void po_prbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_po_prbuttonActionPerformed
        new requisition_ordersGUI().setVisible(true);
    }//GEN-LAST:event_po_prbuttonActionPerformed

    private void viewreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewreportActionPerformed
        new admin.ViewReports().setVisible(true);
    }//GEN-LAST:event_viewreportActionPerformed

    private void logoutbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbuttonActionPerformed
        dispose(); 
        new LoginGUI().setVisible(true);
    }//GEN-LAST:event_logoutbuttonActionPerformed

    private void setCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        jLabel2.setText(formatter.format(date));
    }
     public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMenuGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inventory_supplierbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logoutbutton;
    private javax.swing.JButton po_prbutton;
    private javax.swing.JButton userbutton;
    private javax.swing.JButton viewreport;
    // End of variables declaration//GEN-END:variables
}
