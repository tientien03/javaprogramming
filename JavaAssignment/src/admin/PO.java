/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import PurchaseManager.*;
import admin.UserClassification;
import main.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import salesManager.*;

public class PO extends javax.swing.JFrame {
    private String userID;
    private javax.swing.table.DefaultTableModel requisitionTableModel; 
    private javax.swing.table.DefaultTableModel tableModel;
    
    public PO() {
        String userID = UserClassification.getCurrentUser().getUserID();
        initComponents();
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(0xc5e1ef));
        
        //PR table
        requisitionTableModel = new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] { "PR ID", "ITEM CODE", "SUPPLIER ID", "QUANTITY", "DATE", "SALES MANAGER ID", "STATUS" }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 🔒 disable editing
            }
        };
        jTable2.setModel(requisitionTableModel);
        jTable2.setRowHeight(30);
        loadRequisitionsIntoTable();
        
        //PO table
        tableModel = new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[] { "PO ID", "PR ID", "ITEM CODE", "QUANTITY", "SUPPLIER ID", "PM ID", "DATE", "STATUS" }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 🔒 disable editing
            }
        };
        jTable1.setModel(tableModel);
        jTable1.setRowHeight(30);
        loadPurchaseOrders();
        
        java.awt.Color customBg = new java.awt.Color(0xc5e1ef);

        textFieldPOID.setBackground(customBg);
        textFieldPRID.setBackground(customBg);
        textFieldItemCode.setBackground(customBg);
        textFieldPurchaseManagerID.setBackground(customBg);
        textFieldDate.setBackground(customBg);
        textFieldStatus.setBackground(customBg);
        
        // Disable editing for fields except Quantity and Supplier ID
        textFieldPOID.setEditable(false);
        textFieldPRID.setEditable(false);
        textFieldItemCode.setEditable(false);
        textFieldPurchaseManagerID.setEditable(false);
        textFieldDate.setEditable(false);
        textFieldStatus.setEditable(false);

        textFieldSupplierID.setEditable(true);  // Allow editing
        textFieldQuantity.setEditable(true);    // Allow editing
        
        java.awt.Color customBt = new java.awt.Color(0x66a3c9);

        jButtonGenerate.setBackground(customBt);
        jButtonEdit.setBackground(customBt);
        jButtonDelete.setBackground(customBt);
        jButtonSearch.setBackground(customBt);
        
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String inputID = textField1.getText().trim();  // PR code input
                if (inputID.isEmpty()) {
                    JOptionPane.showMessageDialog(PO.this, "Please enter a PR code.");
                    return;
                }

                List<Supplier> supplierList = Supplier.loadSupplierFromFile("supplier.txt");
                List<Item> itemList = Item.loadItemFromFile("item.txt", supplierList);
                List<PurchaseRequisition> prList = PurchaseRequisition.loadPRFromFile("purchase_requisition.txt", itemList, supplierList);

                PurchaseRequisition selectedPR = null;
                for (PurchaseRequisition pr : prList) {
                    if (pr.getPrId().equalsIgnoreCase(inputID)) {
                        selectedPR = pr;
                        break;
                    }
                }

                if (selectedPR == null) {
                    JOptionPane.showMessageDialog(PO.this, "❌ Requisition not found.");
                    return;
                }

                if ("Updated".equalsIgnoreCase(selectedPR.getStatus())) { 
                    JOptionPane.showMessageDialog(PO.this, "This requisition has already been updated to a Purchase Order.");
                    return;
                }

                // Generate PO ID
                String poID = "PO" + (System.currentTimeMillis() % 100000);
                
                if (selectedPR.getSupplier().isEmpty()) {
                    JOptionPane.showMessageDialog(PO.this, "No suppliers available for this requisition.");
                    return;
                }

//                Supplier selectedSupplier = selectedPR.getSupplierIds().get(0);
//                List<Supplier> selectedSuppliers = new ArrayList<>();
//                supplierList.add(selectedSupplier);

                // Get the list of supplier IDs from the PR
                List<String> supplierIDs = selectedPR.getSupplierIds();

                // Create a new list to hold the actual Supplier objects
                List<Supplier> selectedSuppliers = new ArrayList<>();

                // Iterate through the IDs and find the matching Suppliers
                List<Supplier> allSuppliers = Supplier.loadSupplierFromFile("supplier.txt");
                for (String id : supplierIDs) {
                    for (Supplier supplier : allSuppliers) {
                        if (supplier.getSupplierId().equalsIgnoreCase(id)) {
                            selectedSuppliers.add(supplier);
                            break;
                        }
                    }
                }

                // If no suppliers found, display a warning and return
                if (selectedSuppliers.isEmpty()) {
                    JOptionPane.showMessageDialog(PO.this, "No suppliers available for this requisition.");
                    return;
                }

                PurchaseOrder po = new PurchaseOrder(
                    poID,
                    selectedPR,
                    selectedPR.getItem(),
                    selectedPR.getQuantity(),
                    selectedSuppliers,
                    userID,
                    java.time.LocalDate.now().toString(),
                    "Pending"
                );
                
                FileWriterUtil.appendToFile("purchase_orders.txt", po.toString());

                // Update PR status to "Updated"
                for (PurchaseRequisition pr : prList) {
                    if (pr.getPrId().equalsIgnoreCase(inputID)) {
                        pr.setStatus("Updated");
                        break;
                    }
                }
                
                List<String[]> updatedPRStrings = new ArrayList<>();
                for (PurchaseRequisition pr : prList) {
                    updatedPRStrings.add(pr.toString().split(","));
                }
                FileWriterUtil.writeFile("purchase_requisition.txt", updatedPRStrings);
        
                String message = "✅ Purchase Order generated successfully!\n\n"
                    + "PO ID: " + poID + "\n"
                    + "PR ID: " + selectedPR.getPrId() + "\n"
                    + "Item Code: " + selectedPR.getItem().getItemID() + "\n"
                    + "Quantity: " + selectedPR.getQuantity() + "\n"
                    + "Supplier ID: " + String.join(";", selectedPR.getSupplierIds()) + "\n"
                    + "Purchase Manager ID: " + userID + "\n"
                    + "Date: " + java.time.LocalDate.now().toString() + "\n"
                    + "Status: Pending";
        
                JOptionPane.showMessageDialog(PO.this, message);
    
                // Refresh requisitions list
                loadRequisitionsIntoTable();
                loadPurchaseOrders();  
        
                textField1.setText("");
            }
        });

        // After initializing jTable1 and loading the data
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow != -1) {
                    textFieldPOID.setText(jTable1.getValueAt(selectedRow, 0).toString());
                    textFieldPRID.setText(jTable1.getValueAt(selectedRow, 1).toString());
                    textFieldItemCode.setText(jTable1.getValueAt(selectedRow, 2).toString());
                    textFieldQuantity.setText(jTable1.getValueAt(selectedRow, 3).toString());
                    textFieldSupplierID.setText(jTable1.getValueAt(selectedRow, 4).toString());
                    textFieldPurchaseManagerID.setText(jTable1.getValueAt(selectedRow, 5).toString());
                    textFieldDate.setText(jTable1.getValueAt(selectedRow, 6).toString());
                    textFieldStatus.setText(jTable1.getValueAt(selectedRow, 7).toString());
                }
            }
        });
        
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String searchPOID = jTextFieldSearch.getText().trim();  // black search box
                boolean found = false;

                for (int row = 0; row < jTable1.getRowCount(); row++) {
                    String poID = jTable1.getValueAt(row, 0).toString();  // Column 0 is PO ID
                    if (poID.equalsIgnoreCase(searchPOID)) {
                        // Highlight the row
                        jTable1.setRowSelectionInterval(row, row);
                
                        // Populate the text fields
                        textFieldPOID.setText(jTable1.getValueAt(row, 0).toString());
                        textFieldPRID.setText(jTable1.getValueAt(row, 1).toString());
                        textFieldItemCode.setText(jTable1.getValueAt(row, 2).toString());
                        textFieldQuantity.setText(jTable1.getValueAt(row, 3).toString());
                        textFieldSupplierID.setText(jTable1.getValueAt(row, 4).toString());
                        textFieldPurchaseManagerID.setText(jTable1.getValueAt(row, 5).toString());
                        textFieldDate.setText(jTable1.getValueAt(row, 6).toString());
                        textFieldStatus.setText(jTable1.getValueAt(row, 7).toString());
                
                        found = true;
                        break;  // Stop after finding the PO
                    }
                }

                if (!found) {
                    javax.swing.JOptionPane.showMessageDialog(null, "❌ PO ID not found.");
                }
                
                jTextFieldSearch.setText("");
            }
        });
        
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String poID = textFieldPOID.getText().trim();  // Get PO ID
                String newSupplierID = textFieldSupplierID.getText().trim();
                String newQuantity = textFieldQuantity.getText().trim();
        
                if (poID.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "⚠️ Please select a Purchase Order to edit.");
                    return;
                }

                // Load the supplier list from the file
                List<Supplier> supplierList = Supplier.loadSupplierFromFile("supplier.txt");

                // Split the newSupplierID string by semicolon
                String[] supplierIDs = newSupplierID.split(";");

                // Validate each supplier ID
                List<Supplier> newSupplierList = new ArrayList<>();
                for (String id : supplierIDs) {
                    String trimmedID = id.trim();
                    Supplier foundSupplier = supplierList.stream()
                            .filter(s -> s.getSupplierId().equalsIgnoreCase(trimmedID))
                            .findFirst()
                            .orElse(null);

                    if (foundSupplier == null) {
                        JOptionPane.showMessageDialog(null, "❌ Supplier ID not found: " + trimmedID);
                        return;
                    }

                    newSupplierList.add(foundSupplier);
                }

                // Load Suppliers, Items, and Requisitions
                List<Item> itemList = Item.loadItemFromFile("item.txt", supplierList);
                List<PurchaseRequisition> prList = PurchaseRequisition.loadPRFromFile("purchase_requisition.txt", itemList, supplierList);

                // Load all PO lines
                List<String[]> rawLines = FileReaderUtil.readFileAsArrays("purchase_orders.txt");
                List<PurchaseOrder> poList = new ArrayList<>();
                for (String[] parts : rawLines) {
                    PurchaseOrder po = PurchaseOrder.fromString(String.join(",", parts), prList, supplierList);
                    if (po != null) poList.add(po);
                }
                
                boolean found = false;

                for (PurchaseOrder po : poList) {
                    if (po.getPoID().equalsIgnoreCase(poID)) {
                        int updatedQty;
                        try {
                            updatedQty = Integer.parseInt(newQuantity);
                            if (updatedQty < 0) {
                                JOptionPane.showMessageDialog(null, "❌ Quantity cannot be negative.");
                                return;
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "❌ Please enter a valid number for quantity.");
                            return;
                        }
                        // Update PO
                        po.setQuantity(updatedQty);
                        po.setSuppliers(newSupplierList);   // ✅ Update suppliers in PO
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "❌ Purchase Order not found!");
                    return;
                }

                // Write back to file
                List<String[]> updatedLines = new ArrayList<>();
                for (PurchaseOrder po : poList) {
                    updatedLines.add(po.toString().split(","));
                }
                FileWriterUtil.writeFile("purchase_orders.txt", updatedLines);
             
                JOptionPane.showMessageDialog(null, "✅ Purchase Order updated successfully!\n\n" +
                    "PO ID: " + poID + "\n" +
                    "PR ID: " + textFieldPRID.getText() + "\n" +
                    "Item Code: " + textFieldItemCode.getText() + "\n" +
                    "Quantity: " + textFieldQuantity.getText() + "\n" +
                    "Supplier ID: " + textFieldSupplierID.getText() + "\n" +
                    "Purchase Manager ID: " + textFieldPurchaseManagerID.getText() + "\n" +
                    "Date: " + textFieldDate.getText() + "\n" +
                    "Status: " + textFieldStatus.getText()
                );
                    
                loadPurchaseOrders();  // Refresh table
                clearFields();  // Clears the 8 detail fields
                jTextFieldSearch.setText("");
            }
        });

        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String poID = textFieldPOID.getText().trim();  // Get PO ID
                

                if (poID.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "⚠️ Please select a Purchase Order to delete.");
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(null, 
                        "Are you sure you want to delete PO ID: " + poID + "?", 
                        "Confirm Deletion", 
                        JOptionPane.YES_NO_OPTION);
        
                if (confirm != JOptionPane.YES_OPTION) {
                    return;  // Cancelled
                }

                List<Supplier> supplierList = Supplier.loadSupplierFromFile("supplier.txt");
                List<Item> itemList = Item.loadItemFromFile("item.txt", supplierList);
                List<PurchaseRequisition> prList = PurchaseRequisition.loadPRFromFile("purchase_requisition.txt", itemList, supplierList);

                List<String[]> rawLines = FileReaderUtil.readFileAsArrays("purchase_orders.txt");
                List<PurchaseOrder> poList = new ArrayList<>();
                for (String[] parts : rawLines) {
                    PurchaseOrder po = PurchaseOrder.fromString(String.join(",", parts), prList, supplierList);
                    if (po != null) poList.add(po);
                }

                boolean found = false;
                String prIDToUpdate = "";

                List<PurchaseOrder> updatedList = new ArrayList<>();
                for (PurchaseOrder po : poList) {
                    if (po.getPoID().equalsIgnoreCase(poID)) {
                        found = true;
                        prIDToUpdate = po.getPurchaseRequisition().getPrId();
                    } else {
                        updatedList.add(po);
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "❌ Purchase Order not found.");
                    return;
                }

                // Save updated PO list
                List<String[]> updatedLines = new ArrayList<>();
                for (PurchaseOrder po : updatedList) {
                    updatedLines.add(po.toString().split(","));
                }
                FileWriterUtil.writeFile("purchase_orders.txt", updatedLines);
                    
                if (!prIDToUpdate.isEmpty()) {
                    for (PurchaseRequisition pr : prList) {
                        if (pr.getPrId().equalsIgnoreCase(prIDToUpdate)) {
                            pr.setStatus("Pending");
                            break;
                        }
                    }

                    // Write updated PRs to file
                    List<String[]> updatedPRLines = new ArrayList<>();
                    for (PurchaseRequisition pr : prList) {
                        updatedPRLines.add(pr.toString().split(","));
                    }
                    FileWriterUtil.writeFile("purchase_requisition.txt", updatedPRLines);
                }
                    
                JOptionPane.showMessageDialog(null, "Purchase Order deleted successfully!");

                loadPurchaseOrders();
                loadRequisitionsIntoTable();// Refresh the table
                clearFields();  // Clears the 8 detail fields
                jTextFieldSearch.setText("");
            }
        });
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    
//    private String getUserID() {
//        return userID;  // Hardcoded Purchase Manager ID
//    }
    
    private void clearFields() {
        textFieldPOID.setText("");
        textFieldPRID.setText("");
        textFieldItemCode.setText("");
        textFieldQuantity.setText("");
        textFieldSupplierID.setText("");
        textFieldPurchaseManagerID.setText("");
        textFieldDate.setText("");
        textFieldStatus.setText("");
    }
    
    private void loadRequisitionsIntoTable() {
        requisitionTableModel.setRowCount(0);  // Clear existing rows

        List<Supplier> supplierList = Supplier.loadSupplierFromFile("supplier.txt");
        List<Item> itemList = Item.loadItemFromFile("item.txt", supplierList);
        List<PurchaseRequisition> prList = PurchaseRequisition.loadPRFromFile("purchase_requisition.txt", itemList, supplierList);

        requisitionTableModel.setRowCount(0);  // Clear table
        for (PurchaseRequisition pr : prList) {
            if ("Pending".equalsIgnoreCase(pr.getStatus())) {
                requisitionTableModel.addRow(new Object[]{
                    pr.getPrId(),
                    pr.getItem().getItemID(),
                    String.join(";", pr.getSupplierIds()),
                    pr.getQuantity(),
                    pr.getRequiredDate(),
                    pr.getRaisedBy(),
                    pr.getStatus()
                });
            }
        }
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
                // Combine the supplier IDs
                List<String> suppliers = po.getSupplierIds();
                String supplierIDs = String.join(";", suppliers);
//                String supplierIDs = String.join(";", po.getSupplierIds());
            
//                // 🔄 Combine the supplier IDs
//                String supplierIDs = suppliers.stream()
//                                          .map(Supplier::getSupplierId)
//                                          .reduce((s1, s2) -> s1 + ";" + s2)
//                                          .orElse("");
            
                tableModel.addRow(new Object[]{
                    po.getPoID(),
                    po.getPurchaseRequisition().getPrId(),
                    po.getItem().getItemID(),
                    po.getQuantity(),
                    supplierIDs,
                    po.getPurchaseManagerID(),
                    po.getDate(),
                    po.getStatus()
                });
            }
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

        jButtonGenerate = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textField1 = new java.awt.TextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textFieldPOID = new javax.swing.JTextField();
        textFieldPRID = new javax.swing.JTextField();
        textFieldItemCode = new javax.swing.JTextField();
        textFieldQuantity = new javax.swing.JTextField();
        textFieldStatus = new javax.swing.JTextField();
        textFieldSupplierID = new javax.swing.JTextField();
        textFieldPurchaseManagerID = new javax.swing.JTextField();
        textFieldDate = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButtonGenerate.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButtonGenerate.setText("Generate");
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateActionPerformed(evt);
            }
        });

        jButtonEdit.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonDelete.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 51, 51));
        jButton5.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("EXIT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Purchase Orders");

        jTable1.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PO ID", "PR ID", "ITEM CODE", "QUANTITY", "SUPPLIER ID", "PM ID", "DATE", "STATUS"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "PR ID", "ITEM CODE", "SUPPLIER ID", "QUANTITY", "DATE", "SALES MANAGER ID", "STATUS"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel2.setText("AVAILABLE PURCHASE REQUISITIONS");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel3.setText("Type in PR ID to generate:");

        textField1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        textField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel4.setText("PO ID:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel5.setText("PR ID:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel6.setText("ITEM CODE:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel7.setText("QUANTITY:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel8.setText("SUPPLIER ID:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel9.setText("PURCHASE MANAGER ID:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel10.setText("DATE:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel11.setText("STATUS:");

        textFieldPOID.setBackground(new java.awt.Color(204, 204, 204));
        textFieldPOID.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        textFieldPOID.setForeground(new java.awt.Color(102, 102, 102));
        textFieldPOID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPOIDActionPerformed(evt);
            }
        });

        textFieldPRID.setBackground(new java.awt.Color(204, 204, 204));
        textFieldPRID.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        textFieldPRID.setForeground(new java.awt.Color(102, 102, 102));
        textFieldPRID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPRIDActionPerformed(evt);
            }
        });

        textFieldItemCode.setBackground(new java.awt.Color(204, 204, 204));
        textFieldItemCode.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        textFieldItemCode.setForeground(new java.awt.Color(102, 102, 102));

        textFieldQuantity.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        textFieldQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldQuantityActionPerformed(evt);
            }
        });

        textFieldStatus.setBackground(new java.awt.Color(204, 204, 204));
        textFieldStatus.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        textFieldStatus.setForeground(new java.awt.Color(102, 102, 102));
        textFieldStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldStatusActionPerformed(evt);
            }
        });

        textFieldSupplierID.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        textFieldSupplierID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSupplierIDActionPerformed(evt);
            }
        });

        textFieldPurchaseManagerID.setBackground(new java.awt.Color(204, 204, 204));
        textFieldPurchaseManagerID.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        textFieldPurchaseManagerID.setForeground(new java.awt.Color(102, 102, 102));

        textFieldDate.setBackground(new java.awt.Color(204, 204, 204));
        textFieldDate.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        textFieldDate.setForeground(new java.awt.Color(102, 102, 102));

        jButtonSearch.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButtonSearch.setText("SEARCH");

        jTextFieldSearch.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel12.setText("PURCHASE ORDERS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonGenerate))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                        .addComponent(jButtonSearch))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(58, 58, 58)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textFieldPRID, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                            .addComponent(textFieldPOID))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(textFieldItemCode, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                                    .addComponent(textFieldQuantity))
                                                .addGap(10, 10, 10))
                                            .addComponent(jLabel6))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(textFieldDate, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                                .addComponent(textFieldSupplierID)
                                                .addComponent(textFieldPurchaseManagerID))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonEdit)
                                        .addGap(31, 31, 31)
                                        .addComponent(jButtonDelete)))))
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGenerate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(textField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldPOID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(textFieldSupplierID)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldPRID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(textFieldPurchaseManagerID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(textFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addComponent(textFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new admin.requisition_ordersGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed

    }//GEN-LAST:event_jButtonGenerateActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed

    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed

    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void textFieldPRIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPRIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPRIDActionPerformed

    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField1ActionPerformed
        //generatePurchaseOrder();
    }//GEN-LAST:event_textField1ActionPerformed

    private void textFieldPOIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPOIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPOIDActionPerformed

    private void textFieldQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldQuantityActionPerformed

    private void textFieldSupplierIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSupplierIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldSupplierIDActionPerformed

    private void textFieldStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldStatusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextFieldSearch;
    private java.awt.TextField textField1;
    private javax.swing.JTextField textFieldDate;
    private javax.swing.JTextField textFieldItemCode;
    private javax.swing.JTextField textFieldPOID;
    private javax.swing.JTextField textFieldPRID;
    private javax.swing.JTextField textFieldPurchaseManagerID;
    private javax.swing.JTextField textFieldQuantity;
    private javax.swing.JTextField textFieldStatus;
    private javax.swing.JTextField textFieldSupplierID;
    // End of variables declaration//GEN-END:variables
}
