/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package financeManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import main.FileReaderUtil;
import main.FileWriterUtil;
import PurchaseManager.PurchaseOrder;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author HP
 */
public class PurchaseOrderApproval extends javax.swing.JFrame {
    
    private ArrayList<PurchaseOrder> poList;
    private DefaultTableModel tableModel;
    /**
     * Creates new form PurchaseOrderApproval
     */
    public PurchaseOrderApproval() {
        initComponents();
        setLocationRelativeTo(null);
        loadTableData();
        setupListeners();
        setVisible(true);
        jPanel1.setBackground(new java.awt.Color(0xc5e1ef));
    }
    

    private void loadTableData() {
        poList = new ArrayList<>();
        tableModel = new DefaultTableModel(
            new String[]{"PO ID", "PR ID", "Item Code", "Quantity", "Supplier ID", "PM ID", "Date", "Status"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable2.setModel(tableModel);

        try {
            List<String[]> rawData = FileReaderUtil.readFile("purchase_orders.txt");
            for (String[] parts : rawData) {
                if (parts.length == 8) {
                    PurchaseOrder po = new PurchaseOrder(
                        parts[0], parts[1], parts[2],
                        Integer.parseInt(parts[3]), parts[4],
                        parts[5], parts[6], parts[7]
                    );
                    poList.add(po);

                    tableModel.addRow(new Object[]{
                        po.getPoID(), po.getPrID(), po.getItemCode(),
                        po.getQuantity(), po.getSupplierID(),
                        po.getPurchaseManagerID(), po.getDate(),
                        po.getStatus()
                    });
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error reading purchase orders: " + e.getMessage(), "Read Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void setupListeners() {
        jTable2.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = jTable2.getSelectedRow();
            if (selectedRow >= 0) {
                PurchaseOrder po = poList.get(selectedRow);
                PO_ID_TextField.setText(po.getPoID());
                PR_ID_TextField.setText(po.getPrID());
                Item_Code_TextField.setText(po.getItemCode());
                Quantity_TextField.setText(String.valueOf(po.getQuantity()));
                PM_ID_TextField.setText(po.getPurchaseManagerID());
                Date_TextField.setText(po.getDate());
                Status_TextField.setText(po.getStatus());

                jComboBox1.removeAllItems();
                List<String> suppliers = getSuppliersFromPR(po.getPrID());
                for (String supplier : suppliers) {
                    jComboBox1.addItem(supplier);
                }

                if (suppliers.contains(po.getSupplierID())) {
                    jComboBox1.setSelectedItem(po.getSupplierID());
                } else {
                    jComboBox1.setSelectedIndex(0);
                }

                if (po.getStatus().equalsIgnoreCase("Approved") || po.getStatus().equalsIgnoreCase("Paid")) {
                    Approve.setEnabled(false);
                    Quantity_TextField.setEnabled(false);
                    jComboBox1.setEnabled(false);
                    Modify_Quantity.setEnabled(false);
                    SupplierID_edit.setEnabled(false);
                } else {
                    Approve.setEnabled(true);
                    Quantity_TextField.setEnabled(false);
                    jComboBox1.setEnabled(false);
                    Modify_Quantity.setEnabled(true);
                    SupplierID_edit.setEnabled(true);
                }
            }
        });
    }




    
    private void savePurchaseOrders() {
        List<String[]> data = new ArrayList<>();
        for (PurchaseOrder po : poList) {
            String[] lineData = new String[]{
                po.getPoID(), po.getPrID(), po.getItemCode(),
                String.valueOf(po.getQuantity()), po.getSupplierID(),
                po.getPurchaseManagerID(), po.getDate(), po.getStatus()
            };
            data.add(lineData);
        }
        try {
            FileWriterUtil.writeFile("purchase_orders.txt", data);
            JOptionPane.showMessageDialog(this, "Data saved successfully.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + e.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private List<String> getSuppliersFromPR(String prId) {
        List<String> suppliers = new ArrayList<>();

        List<String[]> rawData = FileReaderUtil.readFile("purchase_requisition.txt");
        List<String> lines = new ArrayList<>();
        for (String[] parts : rawData) {
            lines.add(String.join(",", parts));
        }

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts[0].equals(prId)) {
                suppliers = Arrays.asList(parts[2].split(";"));
            }
        }
        return suppliers;
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
        jButton4 = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();
        PO_name1 = new javax.swing.JLabel();
        Search_TextField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        PO_ID = new javax.swing.JLabel();
        PR_ID = new javax.swing.JLabel();
        ItemCode_Label = new javax.swing.JLabel();
        Quantity = new javax.swing.JLabel();
        Supplier = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        Quantity_TextField = new javax.swing.JTextField();
        Item_Code_TextField = new javax.swing.JTextField();
        PR_ID_TextField = new javax.swing.JTextField();
        PO_ID_TextField = new javax.swing.JTextField();
        Modify_Quantity = new javax.swing.JButton();
        SupplierID_edit = new javax.swing.JButton();
        Date_TextField = new javax.swing.JTextField();
        Status_TextField = new javax.swing.JTextField();
        PM_ID_TextField = new javax.swing.JTextField();
        Approve = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton4.setText("Menu");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        RefreshButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        PO_name1.setBackground(new java.awt.Color(204, 204, 255));
        PO_name1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        PO_name1.setText("Purchase Order Approval");

        Search_TextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        SearchButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        PO_ID.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        PO_ID.setText("PO ID:");

        PR_ID.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        PR_ID.setText("PR ID:");

        ItemCode_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ItemCode_Label.setText("Item Code:");

        Quantity.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Quantity.setText("Quantity:");

        Supplier.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Supplier.setText("Supplier ID:");

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBox1.setEnabled(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        Quantity_TextField.setColumns(15);
        Quantity_TextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Quantity_TextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Quantity_TextField.setEnabled(false);
        Quantity_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Quantity_TextFieldActionPerformed(evt);
            }
        });

        Item_Code_TextField.setColumns(15);
        Item_Code_TextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Item_Code_TextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Item_Code_TextField.setEnabled(false);
        Item_Code_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_Code_TextFieldActionPerformed(evt);
            }
        });

        PR_ID_TextField.setColumns(15);
        PR_ID_TextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        PR_ID_TextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        PR_ID_TextField.setEnabled(false);
        PR_ID_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PR_ID_TextFieldActionPerformed(evt);
            }
        });

        PO_ID_TextField.setColumns(15);
        PO_ID_TextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        PO_ID_TextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        PO_ID_TextField.setEnabled(false);
        PO_ID_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PO_ID_TextFieldActionPerformed(evt);
            }
        });

        Modify_Quantity.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Modify_Quantity.setText("Edit");
        Modify_Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Modify_QuantityActionPerformed(evt);
            }
        });

        SupplierID_edit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        SupplierID_edit.setText("Edit");
        SupplierID_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupplierID_editActionPerformed(evt);
            }
        });

        Date_TextField.setColumns(15);
        Date_TextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Date_TextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Date_TextField.setEnabled(false);
        Date_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Date_TextFieldActionPerformed(evt);
            }
        });

        Status_TextField.setColumns(15);
        Status_TextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Status_TextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Status_TextField.setEnabled(false);
        Status_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Status_TextFieldActionPerformed(evt);
            }
        });

        PM_ID_TextField.setColumns(15);
        PM_ID_TextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        PM_ID_TextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        PM_ID_TextField.setEnabled(false);
        PM_ID_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PM_ID_TextFieldActionPerformed(evt);
            }
        });

        Approve.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Approve.setText("Approve");
        Approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApproveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(598, Short.MAX_VALUE)
                .addComponent(Approve, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(RefreshButton)
                                    .addGap(301, 301, 301)
                                    .addComponent(Search_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton4)
                                    .addGap(55, 55, 55)
                                    .addComponent(PO_name1)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Quantity)
                                .addComponent(Supplier)
                                .addComponent(PR_ID)
                                .addComponent(PO_ID)
                                .addComponent(ItemCode_Label))
                            .addGap(41, 41, 41)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Quantity_TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Item_Code_TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PR_ID_TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PO_ID_TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(134, 134, 134)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PM_ID_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Status_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Date_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Modify_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SupplierID_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                            .addGap(15, 15, 15)))
                    .addGap(37, 37, 37)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(427, Short.MAX_VALUE)
                .addComponent(Approve)
                .addGap(45, 45, 45))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jButton4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(PO_name1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RefreshButton)
                        .addComponent(Search_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SearchButton))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(PO_ID_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PO_ID))
                            .addGap(16, 16, 16)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(PR_ID_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PR_ID))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Item_Code_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ItemCode_Label)
                                .addComponent(Date_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(PM_ID_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Status_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Modify_Quantity)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Quantity_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Quantity)))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Supplier)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SupplierID_edit))
                    .addGap(21, 21, 21)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        FinanceManagerMenu menu = new FinanceManagerMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        loadTableData();
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        String searchText = Search_TextField.getText().trim();
        tableModel.setRowCount(0);
        boolean found = false;

        for (PurchaseOrder po : poList) {
            if (po.getPoID().contains(searchText)) {
                tableModel.addRow(new Object[]{
                    po.getPoID(),
                    po.getPrID(),
                    po.getItemCode(),
                    po.getQuantity(),
                    po.getSupplierID(),
                    po.getPurchaseManagerID(),
                    po.getDate(),
                    po.getStatus()
                });
                found = true;
            }
        }
        if (!found){
            JOptionPane.showMessageDialog(this, "No records found for ID: " + searchText, "Search Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow >= 0) {
            String supplierID = jTable2.getValueAt(selectedRow, 4).toString();
            jComboBox1.setSelectedItem(supplierID);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void Quantity_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Quantity_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Quantity_TextFieldActionPerformed

    private void Item_Code_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_Code_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Item_Code_TextFieldActionPerformed

    private void PR_ID_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PR_ID_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PR_ID_TextFieldActionPerformed

    private void PO_ID_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PO_ID_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PO_ID_TextFieldActionPerformed

    private void Modify_QuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modify_QuantityActionPerformed
        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to edit the quantity.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String newQuantity = JOptionPane.showInputDialog(this, "Enter new quantity:", "Edit Quantity", JOptionPane.PLAIN_MESSAGE);

        if (newQuantity == null || newQuantity.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Quantity cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int quantity = Integer.parseInt(newQuantity.trim());

            if (quantity < 0) {
                JOptionPane.showMessageDialog(this, "Quantity cannot be negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 📝 更新到 JTable 和 内存对象
            tableModel.setValueAt(quantity, selectedRow, 3); // 🔄 更新到列 3 (Quantity)
            PurchaseOrder selectedPO = poList.get(selectedRow);
            selectedPO.setQuantity(quantity);

            // 🔄 更新 TextField 的显示
            Quantity_TextField.setText(String.valueOf(quantity));

            // 🔄 修复 Supplier ID ComboBox 显示问题
            jComboBox1.removeAllItems();
            jComboBox1.addItem(selectedPO.getSupplierID());
            jComboBox1.setSelectedItem(selectedPO.getSupplierID());

            // 🔄 把数据转换成 List<String[]> 格式
            List<String[]> lines = new ArrayList<>();
            for (PurchaseOrder po : poList) {
                lines.add(new String[]{
                    po.getPoID(),
                    po.getPrID(),
                    po.getItemCode(),
                    String.valueOf(po.getQuantity()),
                    po.getSupplierID(),
                    po.getPurchaseManagerID(),
                    po.getDate(),
                    po.getStatus()
                });
            }

            // ✍️ 使用 FileWriterUtil 写入文件
            FileWriterUtil.writeFile("purchase_orders.txt", lines);

            JOptionPane.showMessageDialog(this, "Quantity updated successfully.", "Update Successful", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format. Please enter a valid quantity.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Modify_QuantityActionPerformed

    private void SupplierID_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierID_editActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to edit the supplier.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        PurchaseOrder po = poList.get(selectedRow);
        List<String> suppliers = getSuppliersFromPR(po.getPrID());
        if (suppliers.size() > 1) {
            String selectedSupplier = (String) JOptionPane.showInputDialog(this, "Select a supplier:", "Edit Supplier",
                    JOptionPane.QUESTION_MESSAGE, null, suppliers.toArray(), suppliers.get(0));
            if (selectedSupplier != null) {
                // ✅ 更新对象和表格数据
                po.setSupplierID(selectedSupplier);
                tableModel.setValueAt(selectedSupplier, selectedRow, 4);
                savePurchaseOrders();

                // 🔄 **同步更新到 ComboBox**
                jComboBox1.removeAllItems();
                for (String supplier : suppliers) {
                    jComboBox1.addItem(supplier);
                }
                jComboBox1.setSelectedItem(selectedSupplier); // 设置默认选中项

                // ✅ 提示成功
                JOptionPane.showMessageDialog(this, "Supplier updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Only one supplier available. Cannot edit.", "Edit Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SupplierID_editActionPerformed

    private void Date_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Date_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Date_TextFieldActionPerformed

    private void Status_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Status_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Status_TextFieldActionPerformed

    private void PM_ID_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PM_ID_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PM_ID_TextFieldActionPerformed

    private void ApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApproveActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to approve.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        PurchaseOrder po = poList.get(selectedRow);
        if (!po.getStatus().equalsIgnoreCase("Pending")) {
            JOptionPane.showMessageDialog(this, "Only Pending orders can be approved.", "Approve Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        po.setStatus("Approved");
        tableModel.setValueAt("Approved", selectedRow, 7);
        savePurchaseOrders();
        JOptionPane.showMessageDialog(this, "Purchase Order approved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ApproveActionPerformed

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
            java.util.logging.Logger.getLogger(PurchaseOrderApproval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrderApproval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrderApproval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrderApproval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseOrderApproval().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Approve;
    private javax.swing.JTextField Date_TextField;
    private javax.swing.JLabel ItemCode_Label;
    private javax.swing.JTextField Item_Code_TextField;
    private javax.swing.JButton Modify_Quantity;
    private javax.swing.JTextField PM_ID_TextField;
    private javax.swing.JLabel PO_ID;
    private javax.swing.JTextField PO_ID_TextField;
    private javax.swing.JLabel PO_name1;
    private javax.swing.JLabel PR_ID;
    private javax.swing.JTextField PR_ID_TextField;
    private javax.swing.JLabel Quantity;
    private javax.swing.JTextField Quantity_TextField;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField Search_TextField;
    private javax.swing.JTextField Status_TextField;
    private javax.swing.JLabel Supplier;
    private javax.swing.JButton SupplierID_edit;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
