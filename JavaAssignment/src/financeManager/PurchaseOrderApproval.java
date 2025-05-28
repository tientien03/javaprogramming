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
import PurchaseManager.*;
import java.util.Arrays;
import salesManager.*;


/**
 *
 * @author HP
 */
public class PurchaseOrderApproval extends javax.swing.JFrame {
    
    private List<PurchaseOrder> poList = new ArrayList<>();
    private DefaultTableModel tableModel;

    public PurchaseOrderApproval() {
        initComponents(); 
        tableModel = (DefaultTableModel) POTable.getModel();
        setLocationRelativeTo(null);
        setVisible(true);
        loadPurchaseOrders();
        jPanel1.setBackground(new java.awt.Color(0xc5e1ef));
        POTable.setDefaultEditor(Object.class, null);        
        POTable.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = POTable.getSelectedRow();
            if (selectedRow != -1) {
                PurchaseOrder po = poList.get(selectedRow);

                PO_ID_TextField.setText(po.getPoID());
                PR_ID_TextField.setText(po.getPurchaseRequisition().getPrId());
                Item_Code_TextField.setText(po.getItem().getItemID());
                Quantity_TextField.setText(String.valueOf(po.getQuantity()));

                SupplierID_ComboBox.removeAllItems();
                for (String sid : po.getSupplierIds()) {
                    SupplierID_ComboBox.addItem(sid);
                }
                SupplierID_ComboBox.setSelectedItem(po.getSupplierIds().get(0));
                
                PM_ID_TextField.setText(po.getPurchaseManagerID());
                Status_TextField.setText(po.getStatus());
                Date_TextField.setText(po.getDate());

            }
        });
    }

    private void loadPurchaseOrders() {
        tableModel.setRowCount(0);  // Clear existing rows
        
        // Load the required lists for matching
        List<Supplier> supplierList = Supplier.loadSupplierFromFile("supplier.txt");
        List<Item> itemList = Item.loadItemFromFile("item.txt", supplierList);
        List<PurchaseRequisition> prList = PurchaseRequisition.loadPRFromFile("purchase_requisition.txt", itemList, supplierList);

        List<String []> lines = FileReaderUtil.readFileAsArrays("purchase_orders.txt");
        
        for (String[] parts : lines) {
            String line = String.join(",", parts);
            
            PurchaseOrder po = PurchaseOrder.fromString(line, prList, supplierList);
            if (po != null) {
                poList.add(po);
                List<String> suppliers = po.getSupplierIds();
                String supplierIDs = String.join(";", suppliers);

            
                tableModel.addRow(new Object[]{
                    po.getPoID(),
                    po.getPurchaseRequisition().getPrId(),
                    po.getItem().getItemID(),
                    po.getQuantity(),
                    String.join(";", po.getSupplierIds()),
                    po.getPurchaseManagerID(),
                    po.getDate(),
                    po.getStatus()
                });
            }
        }
    }

    public void savePurchaseOrders(List<PurchaseOrder> poList) {
        List<String[]> data = new ArrayList<>();

        for (PurchaseOrder po : poList) {
            String[] row = new String[]{
                po.getPoID(),
                po.getPurchaseRequisition().getPrId(),
                po.getItem().getItemID(),
                String.valueOf(po.getQuantity()),
                String.join(";", po.getSupplierIds()),
                po.getPurchaseManagerID(),
                po.getDate(),
                po.getStatus()
            };
            data.add(row);
        }

        FileWriterUtil.writeFile("purchase_orders.txt", data);
        JOptionPane.showMessageDialog(this, "Purchase orders saved successfully!");
    }
    
    private List<String> getSuppliersFromPR(String prId) {
        List<String> suppliers = new ArrayList<>();

        try {
            List<String[]> rawData = FileReaderUtil.readFileAsArrays("purchase_requisition.txt");
            for (String[] parts : rawData) {
                if (parts.length >= 3 && parts[0].equalsIgnoreCase(prId)) {
                    String[] supplierArray = parts[2].split(";");
                    suppliers.addAll(Arrays.asList(supplierArray));
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error reading purchase requisitions: " + e.getMessage(),
                    "File Error", JOptionPane.ERROR_MESSAGE);
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
        SearchTextField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        POTable = new javax.swing.JTable();
        PO_ID = new javax.swing.JLabel();
        PR_ID = new javax.swing.JLabel();
        ItemCode_Label = new javax.swing.JLabel();
        Quantity = new javax.swing.JLabel();
        SupplierLabel = new javax.swing.JLabel();
        SupplierID_ComboBox = new javax.swing.JComboBox<>();
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
        StatusBox = new javax.swing.JComboBox<>();
        PO_ID1 = new javax.swing.JLabel();
        StatusLabel = new javax.swing.JLabel();
        StatusLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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

        SearchTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        SearchButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        POTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PO ID", "PR ID", "Item", "Quantity", "Supplier ID", "PM ID", "Date", "Status"
            }
        ));
        jScrollPane4.setViewportView(POTable);

        PO_ID.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        PO_ID.setText("PO ID:");

        PR_ID.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        PR_ID.setText("PR ID:");

        ItemCode_Label.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ItemCode_Label.setText("Item Code:");

        Quantity.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Quantity.setText("Quantity:");

        SupplierLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        SupplierLabel.setText("Supplier ID:");

        SupplierID_ComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        SupplierID_ComboBox.setEnabled(false);
        SupplierID_ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupplierID_ComboBoxActionPerformed(evt);
            }
        });

        Quantity_TextField.setEditable(false);
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

        StatusBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        StatusBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Pending", "Paid", "Updated", "Approved" }));
        StatusBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusBoxActionPerformed(evt);
            }
        });

        PO_ID1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        PO_ID1.setText("PM ID:");

        StatusLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        StatusLabel.setText("Date:");

        StatusLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        StatusLabel1.setText("Status:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Approve, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(StatusBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PO_ID1)
                            .addComponent(StatusLabel)
                            .addComponent(StatusLabel1))
                        .addGap(300, 300, 300))))
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
                                    .addGap(664, 664, 664))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton4)
                                    .addGap(55, 55, 55)
                                    .addComponent(PO_name1)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Quantity)
                                .addComponent(SupplierLabel)
                                .addComponent(PR_ID)
                                .addComponent(PO_ID)
                                .addComponent(ItemCode_Label))
                            .addGap(41, 41, 41)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Quantity_TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Item_Code_TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PR_ID_TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PO_ID_TextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(SupplierID_ComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addGap(52, 52, 52)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton)
                    .addComponent(StatusBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(PO_ID1)
                .addGap(27, 27, 27)
                .addComponent(StatusLabel1)
                .addGap(18, 18, 18)
                .addComponent(StatusLabel)
                .addGap(44, 44, 44)
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
                    .addComponent(RefreshButton)
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
                        .addComponent(SupplierLabel)
                        .addComponent(SupplierID_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SupplierID_edit))
                    .addGap(21, 21, 21)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 801, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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
        loadPurchaseOrders();
        JOptionPane.showMessageDialog(this, "Refresh successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        String searchText = SearchTextField.getText().trim().toLowerCase();
        tableModel.setRowCount(0); // Clear table

        // ✅ Read from the text file
        List<String[]> rawList = FileReaderUtil.readFile("purchase_orders.txt");

        boolean found = false;

        for (String[] line : rawList) {
            // Search by PO ID, PR ID, Item Code, or Supplier ID
            if (line[0].toLowerCase().contains(searchText) || 
                line[1].toLowerCase().contains(searchText) || 
                line[2].toLowerCase().contains(searchText) || 
                line[4].toLowerCase().contains(searchText)) {

                tableModel.addRow(new Object[] {
                    line[0], // PO ID
                    line[1], // PR ID
                    line[2], // Item Code
                    line[3], // Quantity
                    line[4], // Supplier ID
                    line[5], // PM ID
                    line[6], // Date
                    line[7]  // Status
                });
                found = true;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "No matching record found for: " + searchText, "Search Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void SupplierID_ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierID_ComboBoxActionPerformed
        int selectedRow = POTable.getSelectedRow();
        if (selectedRow >= 0) {
            String supplierID = POTable.getValueAt(selectedRow, 4).toString();
            SupplierID_ComboBox.setSelectedItem(supplierID);
        }
    }//GEN-LAST:event_SupplierID_ComboBoxActionPerformed

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
         int selectedRow = POTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to edit the quantity.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String status = String.valueOf(POTable.getValueAt(selectedRow, 7)).trim();
        if (!status.equalsIgnoreCase("Pending")) {
            JOptionPane.showMessageDialog(this, "Quantity can only be edited when status is 'Pending'.", "Action Not Allowed", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String currentQuantity = String.valueOf(POTable.getValueAt(selectedRow, 3));
        String newQuantity = JOptionPane.showInputDialog(this, "Enter new quantity:", currentQuantity);

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
            
            POTable.setValueAt(String.valueOf(quantity), selectedRow, 3);
            Quantity_TextField.setText(String.valueOf(quantity));

            String[] po = new String[8];
            for (int i = 0; i < 8; i++) {
                po[i] = String.valueOf(POTable.getValueAt(selectedRow, i));
            }

            savePurchaseOrders(poList);


            JOptionPane.showMessageDialog(this, "Quantity updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Modify_QuantityActionPerformed

    private void SupplierID_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierID_editActionPerformed
        int selectedRow = POTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to edit the supplier.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String[] po = new String[8];
        for (int i = 0; i < 8; i++) {
            po[i] = String.valueOf(POTable.getValueAt(selectedRow, i));
        }

        List<String> suppliers = getSuppliersFromPR(po[1]);

        if (suppliers.size() <= 1) {
            JOptionPane.showMessageDialog(this, "Only one supplier available. Cannot edit.", "Edit Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SupplierID_ComboBox.setEnabled(true);

        String selectedSupplier = (String) JOptionPane.showInputDialog(
            this,
            "Select a supplier:",
            "Edit Supplier",
            JOptionPane.QUESTION_MESSAGE,
            null,
            suppliers.toArray(),
            po[4]
        );

        if (selectedSupplier != null) {
            po[4] = selectedSupplier;
            tableModel.setValueAt(selectedSupplier, selectedRow, 4);

            SupplierID_ComboBox.removeAllItems();
            for (String s : suppliers) {
                SupplierID_ComboBox.addItem(s);
            }
            SupplierID_ComboBox.setSelectedItem(selectedSupplier);
            SupplierID_ComboBox.setEnabled(false);

            savePurchaseOrders(poList);

            JOptionPane.showMessageDialog(this, "Supplier updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            SupplierID_ComboBox.setEnabled(false);
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

        int selectedRow = POTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to approve.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String selectedPOID = POTable.getValueAt(selectedRow, 0).toString().trim();

        PurchaseOrder po = poList.stream()
            .filter(p -> p.getPoID().equalsIgnoreCase(selectedPOID))
            .findFirst()
            .orElse(null);

        if (po == null) {
            JOptionPane.showMessageDialog(this, "PO not found in current list.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!po.getStatus().equalsIgnoreCase("Pending")) {
            JOptionPane.showMessageDialog(this, "Only Pending orders can be approved.", "Approve Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        po.setStatus("Approved");
        tableModel.setValueAt("Approved", selectedRow, 7); // Update table view
        savePurchaseOrders(poList); // Save to file

        JOptionPane.showMessageDialog(this, "Purchase Order approved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_ApproveActionPerformed

    private void StatusBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusBoxActionPerformed
        String selectedStatus = (String) StatusBox.getSelectedItem();
        tableModel.setRowCount(0); // Clear table

        List<String[]> rawList = FileReaderUtil.readFile("purchase_orders.txt");

        boolean found = false;

        for (String[] line : rawList) {
            String status = line[7];

            if (selectedStatus.equals("All") || status.equalsIgnoreCase(selectedStatus)) {
                tableModel.addRow(new Object[] {
                    line[0], // PO ID
                    line[1], // PR ID
                    line[2], // Item Code
                    line[3], // Quantity
                    line[4], // Supplier ID
                    line[5], // PM ID
                    line[6], // Date
                    line[7]  // Status
                });
                found = true;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this,
                "No purchase orders found with status: " + selectedStatus,
                "No Records Found",
                JOptionPane.INFORMATION_MESSAGE);

            tableModel.setRowCount(0);
            for (String[] line : rawList) {
                tableModel.addRow(new Object[] {
                    line[0], line[1], line[2], line[3],
                    line[4], line[5], line[6], line[7]
                });
            }
        }
    }//GEN-LAST:event_StatusBoxActionPerformed

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
    private javax.swing.JTable POTable;
    private javax.swing.JLabel PO_ID;
    private javax.swing.JLabel PO_ID1;
    private javax.swing.JTextField PO_ID_TextField;
    private javax.swing.JLabel PO_name1;
    private javax.swing.JLabel PR_ID;
    private javax.swing.JTextField PR_ID_TextField;
    private javax.swing.JLabel Quantity;
    private javax.swing.JTextField Quantity_TextField;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JComboBox<String> StatusBox;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JLabel StatusLabel1;
    private javax.swing.JTextField Status_TextField;
    private javax.swing.JComboBox<String> SupplierID_ComboBox;
    private javax.swing.JButton SupplierID_edit;
    private javax.swing.JLabel SupplierLabel;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
