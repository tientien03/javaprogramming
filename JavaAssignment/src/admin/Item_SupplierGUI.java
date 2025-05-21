/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import main.FileReaderUtil;
import javax.swing.*;
import javax.swing.table.*;
import java.util.List;

public class Item_SupplierGUI extends javax.swing.JFrame {

    public Item_SupplierGUI() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(0xc5e1ef));
        this.setLocationRelativeTo(null);
        
        inventoryTable.setRowHeight(25);
        supplierTable.setRowHeight(25);
        
        inventoryTableFormat();
        supplierTableFormat();
        loadItems();
        loadSuppliers();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        itembutton = new javax.swing.JButton();
        supplierbutton = new javax.swing.JButton();
        ItemTable = new javax.swing.JScrollPane();
        inventoryTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        searchSupplierField = new javax.swing.JTextField();
        searchItemField = new javax.swing.JTextField();
        suppliersearchbutton = new javax.swing.JButton();
        itemsearchbutton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        supplierTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel1.setText("SUPPLIER");

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Menu");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        itembutton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        itembutton.setText("Edit");
        itembutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itembuttonActionPerformed(evt);
            }
        });

        supplierbutton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        supplierbutton.setText("Edit");
        supplierbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierbuttonActionPerformed(evt);
            }
        });

        ItemTable.setRowHeaderView(null);

        inventoryTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        inventoryTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        inventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Item ID", "Item Name", "Supplier ID", "Net Price", "Sales Price", "Stock", "Status"
            }
        ));
        ItemTable.setViewportView(inventoryTable);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setText("Inventory & Supplier");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel3.setText("INVENTORY");

        searchSupplierField.setBackground(new java.awt.Color(255, 255, 204));
        searchSupplierField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSupplierFieldActionPerformed(evt);
            }
        });

        searchItemField.setBackground(new java.awt.Color(255, 255, 204));
        searchItemField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchItemFieldActionPerformed(evt);
            }
        });

        suppliersearchbutton.setBackground(new java.awt.Color(204, 204, 204));
        suppliersearchbutton.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        suppliersearchbutton.setText("Search");
        suppliersearchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliersearchbuttonActionPerformed(evt);
            }
        });

        itemsearchbutton.setBackground(new java.awt.Color(204, 204, 204));
        itemsearchbutton.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        itemsearchbutton.setText("Search");
        itemsearchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemsearchbuttonActionPerformed(evt);
            }
        });

        supplierTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        supplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "SupplierID", "SuppllierName", "Contact Number", "Email"
            }
        ));
        jScrollPane1.setViewportView(supplierTable);

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setText("Refresh");
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
                    .addComponent(ItemTable)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(searchItemField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemsearchbutton)
                        .addGap(118, 118, 118)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(itembutton)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchSupplierField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(suppliersearchbutton)
                        .addGap(134, 134, 134)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addComponent(supplierbutton)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(itembutton)
                        .addComponent(jButton2)
                        .addComponent(itemsearchbutton)
                        .addComponent(searchItemField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ItemTable, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchSupplierField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(suppliersearchbutton)
                        .addComponent(supplierbutton)
                        .addComponent(jButton3))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AdminMenuGUI menu = new AdminMenuGUI();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void itembuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itembuttonActionPerformed
        // TODO add your handling code here:
        new ItemGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itembuttonActionPerformed

    private void supplierbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierbuttonActionPerformed
        // TODO add your handling code here:
        new SupplierGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_supplierbuttonActionPerformed

    private void searchItemFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchItemFieldActionPerformed
        // TODO add your handling code here:
        searchItems();
    }//GEN-LAST:event_searchItemFieldActionPerformed

    private void itemsearchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemsearchbuttonActionPerformed
        // TODO add your handling code here:
        searchItems();
    }//GEN-LAST:event_itemsearchbuttonActionPerformed

    private void suppliersearchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliersearchbuttonActionPerformed
        // TODO add your handling code here:
        searchSuppliers();
    }//GEN-LAST:event_suppliersearchbuttonActionPerformed

    private void searchSupplierFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSupplierFieldActionPerformed
        // TODO add your handling code here:
        searchSuppliers();
    }//GEN-LAST:event_searchSupplierFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        loadItems();
        JOptionPane.showMessageDialog(this, "Item list refreshed successfully!");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        loadSuppliers();
        JOptionPane.showMessageDialog(this, "Supplier list refreshed successfully!");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void inventoryTableFormat() {
    DefaultTableModel model = new DefaultTableModel(
        new String[]{"Item ID", "Item Name", "Supplier ID", "Net Price", "Sales Price", "Stock", "Status"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; 
        }
    };
    inventoryTable.setModel(model);
    
    inventoryTable.setRowHeight(23);
    
    inventoryTable.getTableHeader().setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 14));
    } 
    
    private void supplierTableFormat() {
    DefaultTableModel model = new DefaultTableModel(
        new String[]{"Supplier ID", "Supplier Name", "Contact Number", "Email"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; 
        }
    };
    supplierTable.setModel(model);
    
    supplierTable.setRowHeight(23);
    
    supplierTable.getTableHeader().setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 14));
    } 
    
    private void loadItems() {
        try {
            List<String[]> itemList = FileReaderUtil.readFileAsArrays("item.txt");

            if (itemList == null || itemList.isEmpty()) {
                System.out.println("Items list is empty or file not found.");
                return;
            }

            DefaultTableModel model = (DefaultTableModel) inventoryTable.getModel();
            model.setRowCount(0);

            for (String[] item : itemList) {
                if (item.length == 6) {
                     int stock = Integer.parseInt(item[5]);
                String status;

                // Apply status logic
                if (stock < 25) {
                    status = "Low Stock";
                } else if (stock <= 75) {
                    status = "In Stock";
                } else {
                    status = "Overstocked";
                }
                    model.addRow(new Object[]{item[0], item[1], item[2], item[3], item[4], stock, status
                    });
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading items: " + e.getMessage());
        }
    }
     
      private void loadSuppliers() {
        try {
            List<String[]> supplierList = FileReaderUtil.readFileAsArrays("supplier.txt");

            if (supplierList == null || supplierList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Supplier list is empty or file not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DefaultTableModel model = (DefaultTableModel) supplierTable.getModel();
            model.setRowCount(0);  // Clear existing rows in the table

            for (String[] supplier : supplierList) {
                if (supplier.length == 4) {
                    model.addRow(new Object[]{
                        supplier[0], supplier[1], supplier[2], supplier[3]
                    });
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading suppliers: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

      
      private void searchItems() {
        String keyword = searchItemField.getText().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) inventoryTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        inventoryTable.setRowSorter(sorter);

        if (keyword.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
        }
    }

    private void searchSuppliers() {
        if (supplierTable == null) {
        JOptionPane.showMessageDialog(this, "Supplier Table not initialized.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
        
        String keyword = searchSupplierField.getText().toLowerCase();
        DefaultTableModel model = (DefaultTableModel) supplierTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        supplierTable.setRowSorter(sorter);

        if (keyword.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));
        }
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
            java.util.logging.Logger.getLogger(Item_SupplierGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Item_SupplierGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Item_SupplierGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Item_SupplierGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Item_SupplierGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ItemTable;
    private javax.swing.JTable inventoryTable;
    private javax.swing.JButton itembutton;
    private javax.swing.JButton itemsearchbutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchItemField;
    private javax.swing.JTextField searchSupplierField;
    private javax.swing.JTable supplierTable;
    private javax.swing.JButton supplierbutton;
    private javax.swing.JButton suppliersearchbutton;
    // End of variables declaration//GEN-END:variables
}
