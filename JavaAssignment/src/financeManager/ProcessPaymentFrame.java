/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package financeManager;

import main.FileReaderUtil;
import main.FileWriterUtil;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
/**
 *
 * @author HP
 */
public class ProcessPaymentFrame extends javax.swing.JFrame {


    public ProcessPaymentFrame() {
        initComponents();
        loadUpdatedPurchaseOrders();
        loadProcessPaymentTable();
        setupListeners();
        setLocationRelativeTo(null);
        jPanel1.setBackground(new java.awt.Color(0xc5e1ef));
    }


    private void loadUpdatedPurchaseOrders() {
        DefaultTableModel model = new DefaultTableModel(
            new String[]{
                "PO ID", "PR ID", "Item Code", "Quantity", "Supplier ID", "PM ID", "Date", "Status"},0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        List<String[]> data = FileReaderUtil.readFile("purchase_orders.txt");
        for (String[] po : data) {
            if (po.length >= 8) {
                model.addRow(po);
            }
        }

        jTable1.setModel(model);
    }


    private void loadProcessPaymentTable() {
        DefaultTableModel model = new DefaultTableModel(
            new String[]{
                "PO ID", "PR ID", "Item Code", "Quantity", "Unit Price", "Total Price", "Supplier ID", "PM ID", "Date", "Status"},0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        List<String[]> data = FileReaderUtil.readFile("purchase_orders.txt");

        for (String[] po : data) {
            if (po.length >= 8 && po[7].trim().equalsIgnoreCase("Updated")) {
                String itemCode = po[2];
                String supplierID = po[4];
                String unitPrice = getUnitPrice(itemCode, supplierID);
                int qty = Integer.parseInt(po[3]);
                double totalPrice = qty * Double.parseDouble(unitPrice);

                model.addRow(new Object[]{
                    po[0], // PO ID
                    po[1], // PR ID
                    itemCode, // Item Code
                    po[3], // Quantity
                    unitPrice,
                    String.format("%.2f", totalPrice),
                    supplierID,
                    po[5], // PM ID
                    po[6], // Date
                    po[7]  // Status
                });
            }
        }

        paymentTable.setModel(model);
    }




    private String getUnitPrice(String itemCode, String supplierID) {
        List<String[]> items = FileReaderUtil.readFile("item.txt");
        for (String[] item : items) {
            if (item.length >= 4 &&
                item[0].equalsIgnoreCase(itemCode) &&
                item[2].contains(supplierID)) {
                return item[3]; // supplier price
            }
        }
        return "0.00"; 
    }

    private void setupListeners() {
        jTable1.getSelectionModel().addListSelectionListener(e -> {
            int row = jTable1.getSelectedRow();
            if (row >= 0) {
            }
        });
    }
    
    private void processSelectedPayment() {
        int selectedRow = paymentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a PO to process.");
            return;
        }

        String selectedPOID = paymentTable.getValueAt(selectedRow, 0).toString();

        List<String[]> poData = FileReaderUtil.readFile("purchase_orders.txt");
        List<String[]> updatedPOData = new java.util.ArrayList<>();
        String[] paymentEntry = null;

        for (String[] po : poData) {
            if (po.length >= 8 && po[0].equalsIgnoreCase(selectedPOID) && po[7].equalsIgnoreCase("Updated")) {
                String unitPrice = getUnitPrice(po[2], po[4]);
                int qty = Integer.parseInt(po[3]);
                double totalPrice = qty * Double.parseDouble(unitPrice);

                paymentEntry = new String[] {
                    po[0], po[1], po[2], po[3], unitPrice,
                    String.format("%.2f", totalPrice), po[4], po[5], po[6], "Paid"
                };

                po[7] = "Paid";
            }
            updatedPOData.add(po);
        }

        if (paymentEntry != null) {
            FileWriterUtil.appendToFile("payments.txt", String.join(",", paymentEntry));
            FileWriterUtil.writeFile("purchase_orders.txt", updatedPOData);

            JOptionPane.showMessageDialog(this, "Payment processed successfully for " + selectedPOID);
            loadUpdatedPurchaseOrders();
            loadProcessPaymentTable();
        } else {
            JOptionPane.showMessageDialog(this, "No matching PO found to process.");
        }
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
        jLabel1 = new javax.swing.JLabel();
        menuButton = new javax.swing.JButton();
        Refresh_Button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        statusComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Search_Button = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        paymentTable = new javax.swing.JTable();
        ProcessPayment_Button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel1.setText("Process Payment");

        menuButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        menuButton.setText("Menu");
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });

        Refresh_Button.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Refresh_Button.setText("Refresh");
        Refresh_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Refresh_ButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Inventory Updated Table");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PO ID", "PR ID", "Item Code", "Quantity", "Supplier ID", "PM ID", "Status", "Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        statusComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Approved", "Updated", "Pending" }));
        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Status:");

        Search_Button.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Search_Button.setText("Search");
        Search_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_ButtonActionPerformed(evt);
            }
        });

        paymentTable.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        paymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PO ID", "PR ID", "Item Code", "Quantity", "Unit Price", "Total Price", "Supplier ID", "PM ID", "Date", "Status"
            }
        ));
        jScrollPane5.setViewportView(paymentTable);

        ProcessPayment_Button.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ProcessPayment_Button.setText("Process Payment");
        ProcessPayment_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessPayment_ButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Process Payment Table");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(menuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Refresh_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ProcessPayment_Button)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Search_Button))
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(menuButton)
                        .addComponent(Refresh_Button))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search_Button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ProcessPayment_Button)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        FinanceManagerMenu menu = new FinanceManagerMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuButtonActionPerformed

    private void ProcessPayment_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessPayment_ButtonActionPerformed
        processSelectedPayment();

    }//GEN-LAST:event_ProcessPayment_ButtonActionPerformed

    private void Refresh_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Refresh_ButtonActionPerformed
        loadUpdatedPurchaseOrders();
        loadProcessPaymentTable();
        JOptionPane.showMessageDialog(this, "Refresh successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_Refresh_ButtonActionPerformed

    private void Search_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_ButtonActionPerformed
        String keyword = searchField.getText().trim();
        DefaultTableModel model = (DefaultTableModel) paymentTable.getModel();
        model.setRowCount(0);

        List<String[]> data = FileReaderUtil.readFile("purchase_orders.txt");
        for (String[] po : data) {
            if (po.length >= 8 && po[7].trim().equalsIgnoreCase("Updated") && po[4].contains(keyword)) {
                String itemCode = po[2];
                String supplierID = po[4];
                String unitPrice = getUnitPrice(itemCode, supplierID);
                
                int qty = Integer.parseInt(po[3]);
                double totalPrice = qty * Double.parseDouble(unitPrice);

                model.addRow(new Object[]{
                    po[0], po[1], itemCode, po[3], unitPrice,
                    String.format("%.2f", totalPrice), supplierID, po[5], po[6], po[7]
                    
                });
            }
        }
    }//GEN-LAST:event_Search_ButtonActionPerformed

    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        String selectedStatus = statusComboBox.getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        List<String[]> data = FileReaderUtil.readFile("purchase_orders.txt");
        for(String[]po : data){
            if(po.length >= 8){
                String status = po[7].trim();
                if(selectedStatus.equals("All") || status.equalsIgnoreCase(selectedStatus)){
                    model.addRow(po);
                }
            }
        }
    }//GEN-LAST:event_statusComboBoxActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProcessPaymentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProcessPaymentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProcessPaymentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProcessPaymentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProcessPaymentFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ProcessPayment_Button;
    private javax.swing.JButton Refresh_Button;
    private javax.swing.JButton Search_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton menuButton;
    private javax.swing.JTable paymentTable;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> statusComboBox;
    // End of variables declaration//GEN-END:variables
}
