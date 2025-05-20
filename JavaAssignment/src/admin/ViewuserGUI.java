/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import main.FileReaderUtil;
import main.FileWriterUtil;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;



public class ViewuserGUI extends javax.swing.JFrame {
    private Viewuser selectedUser = null;
    List<Viewuser> userList = new ArrayList<>();
    private DefaultTableModel tableModel;
    private int adminCounter = 1, pmCounter = 1, smCounter = 1, imCounter = 1, fmCounter = 1;
    
    public ViewuserGUI() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(0xC5E1EF));
        this.setLocationRelativeTo(null);
        
        TableFormat();
        loadUserData(); 
        }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        menubutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        gmailfield = new javax.swing.JTextField();
        fullnamefield = new javax.swing.JTextField();
        idfield = new javax.swing.JTextField();
        namefield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        searchbutton = new javax.swing.JButton();
        createbutton = new javax.swing.JButton();
        editbutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();
        savebutton = new javax.swing.JButton();
        resetbutton1 = new javax.swing.JButton();
        rolebox = new javax.swing.JComboBox<>();
        statusbox = new javax.swing.JComboBox<>();
        phonefield = new javax.swing.JFormattedTextField();
        passwordfield = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Role:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jScrollPane1.setRowHeaderView(null);
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        userTable.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "UserID", "Username", "Password", "FullName", "Gmail", "Phone", "Role", "Status"
            }
        ));
        jScrollPane1.setViewportView(userTable);

        menubutton.setBackground(new java.awt.Color(255, 102, 102));
        menubutton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        menubutton.setText("MENU");
        menubutton.setBorder(new javax.swing.border.MatteBorder(null));
        menubutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubuttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("User ID:");

        gmailfield.setBackground(new java.awt.Color(255, 255, 204));
        gmailfield.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        gmailfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gmailfieldActionPerformed(evt);
            }
        });

        fullnamefield.setBackground(new java.awt.Color(255, 255, 204));
        fullnamefield.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        idfield.setBackground(new java.awt.Color(255, 255, 204));
        idfield.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        idfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idfieldActionPerformed(evt);
            }
        });

        namefield.setBackground(new java.awt.Color(255, 255, 204));
        namefield.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel2.setText("USER MANAGEMENT");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Full Name:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Username:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Gmail:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Status:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Password:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Phone Number:");

        searchbutton.setBackground(new java.awt.Color(204, 204, 204));
        searchbutton.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        searchbutton.setText("Search");
        searchbutton.setBorder(new javax.swing.border.MatteBorder(null));
        searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbuttonActionPerformed(evt);
            }
        });

        createbutton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        createbutton.setText("CREATE");
        createbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createbuttonActionPerformed(evt);
            }
        });

        editbutton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        editbutton.setText("EDIT");
        editbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbuttonActionPerformed(evt);
            }
        });

        deletebutton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        deletebutton.setText("DELETE");
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });

        savebutton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        savebutton.setText("SAVE");
        savebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebuttonActionPerformed(evt);
            }
        });

        resetbutton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        resetbutton1.setText("RESET");
        resetbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbutton1ActionPerformed(evt);
            }
        });

        rolebox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rolebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Role", "Administrator", "Finance Manager", "Inventory Manager", "Purchase Manager", "Sales Manager", " ", " ", " " }));
        rolebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleboxActionPerformed(evt);
            }
        });

        statusbox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        statusbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive", " ", " " }));
        statusbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusboxActionPerformed(evt);
            }
        });

        phonefield.setBackground(new java.awt.Color(255, 255, 204));
        try {
            phonefield.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        phonefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonefieldActionPerformed(evt);
            }
        });

        passwordfield.setBackground(new java.awt.Color(255, 255, 204));
        passwordfield.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        passwordfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordfieldActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Role:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(gmailfield, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fullnamefield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namefield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idfield, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addComponent(searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(createbutton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(savebutton)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel7))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(104, 104, 104)
                                        .addComponent(deletebutton)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(passwordfield)
                                                .addComponent(phonefield, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                                            .addComponent(rolebox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(statusbox, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(menubutton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(resetbutton1)))
                .addGap(0, 27, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(resetbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(menubutton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(phonefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rolebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(idfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fullnamefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gmailfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(savebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menubuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubuttonActionPerformed
        admin.AdminMenuGUI menu = new admin.AdminMenuGUI();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menubuttonActionPerformed


    private void searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbuttonActionPerformed
        String searchID = idfield.getText().trim();
        
        if (searchID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter User ID to search.");
            return;
        }
        
        boolean found = false;

        for (Viewuser user : userList) {
            if (user.getUserID().equalsIgnoreCase(searchID)) {
                idfield.setText(user.getUserID());
                namefield.setText(user.getUserName());           
                passwordfield.setText(user.getPassword());            
                fullnamefield.setText(user.getFullName());            
                gmailfield.setText(user.getEmail());               
                phonefield.setText(user.getPhoneNumber());
                rolebox.setSelectedItem(user.getRole());            
                statusbox.setSelectedItem(user.getStatus());

                idfield.setEditable(false); 
                selectedUser = user;

                JOptionPane.showMessageDialog(this, "✅ User found and loaded."); 
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "❌ User not found.");
        }
    }//GEN-LAST:event_searchbuttonActionPerformed

    private void createbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createbuttonActionPerformed
    String selectedRole = (String) rolebox.getSelectedItem();
    if (selectedRole.equals("Select Role")) {
        JOptionPane.showMessageDialog(this, "❗ Please select a role before creating User ID.");
        return;
    }
    
    String rolePrefix ;
        switch (selectedRole) {
            case "Administrator":
                rolePrefix = "A";
                break;
            case "Purchase Manager":
                rolePrefix = "PM";
                break;
            case "Sales Manager":
                rolePrefix = "SM";
                break;
            case "Inventory Manager":
                rolePrefix = "IM";
                break;
            case "Finance Manager":
                rolePrefix = "FM";
                break;
            default:
                 JOptionPane.showMessageDialog(this, "⚠️ Role not defined.");
                return ;
        }
        List<String[]> DataList = FileReaderUtil.readFileAsArrays("user.txt");
        
        int maxId = 0;
        for (String[] userData : DataList) {
            String id = userData[0];  
            if (id.startsWith(rolePrefix)) {
                try {
                    int num = Integer.parseInt(id.substring(rolePrefix.length()));
                    if (num > maxId) {
                        maxId = num;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ID not found：" + id);
                }
            }
        }    
        String nextID = String.format("%s%03d", rolePrefix, maxId + 1);
        idfield.setText(nextID);
        idfield.setEditable(false);
    
        JOptionPane.showMessageDialog(this, "✅ New User ID Generated: " + nextID);
        
        
    }//GEN-LAST:event_createbuttonActionPerformed

    private void editbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbuttonActionPerformed
        int selectedRow = userTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user row to edit.");
            return;
        }
        
        namefield.setEditable(true);
        passwordfield.setEditable(true);
        fullnamefield.setEditable(true);
        gmailfield.setEditable(true);
        phonefield.setEditable(true);
        rolebox.setEnabled(true);
        statusbox.setEnabled(true);

        DefaultTableModel model = (DefaultTableModel) userTable.getModel();
        String userID = model.getValueAt(selectedRow, 0).toString();
    
        System.out.println("🔎 Selected UserID: " + userID);

        boolean userFound = false;
  
        for (Viewuser user : userList) {
            if (user.getUserID().equals(userID)) {
               
                idfield.setText(user.getUserID());
                namefield.setText(user.getUserName());
                passwordfield.setText(user.getPassword());
                fullnamefield.setText(user.getFullName());
                gmailfield.setText(user.getEmail());
                phonefield.setText(user.getPhoneNumber());
                rolebox.setSelectedItem(user.getRole());
                statusbox.setSelectedItem(user.getStatus());
             
                idfield.setEditable(false);
                
                JOptionPane.showMessageDialog(this, "✏️You can now edit the user details now.");
                userFound = true;
                break;
            }
        }
         if (!userFound) {
        JOptionPane.showMessageDialog(this, "❌ User not found in list. Please refresh the table.");
        }
    }//GEN-LAST:event_editbuttonActionPerformed

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        if (selectedUser == null) {
        JOptionPane.showMessageDialog(this, "No user selected. Please search first.");
        return;
    }

    // Confirmation dialog
    int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
    if (option == JOptionPane.YES_OPTION) {
        userList.remove(selectedUser);
        Viewuser.saveToFile(userList, "user.txt");
        JOptionPane.showMessageDialog(this, "User deleted successfully.");
    }
        clearInput();
        loadUserData();
        idfield.setEditable(true);
    
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void savebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebuttonActionPerformed
                                             
    if (idfield.getText().isEmpty() || namefield.getText().isEmpty() || 
        fullnamefield.getText().isEmpty() || 
        gmailfield.getText().isEmpty() || phonefield.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(this, "❗ Please fill in all fields.");
        return;
    }
    if(passwordfield.getText().isEmpty()){
        String generatedPassword = generateRandomPassword(8);
        passwordfield.setText(generatedPassword);
        JOptionPane.showMessageDialog(this, "Generated a random password: " + generatedPassword);
    }

    boolean isNewUser = true;
    for (Viewuser user : userList) {
        if (user.getUserID().equals(idfield.getText())) {
            isNewUser = false;
            
            user.setUserName(namefield.getText());
            user.setPassword(passwordfield.getText());
            user.setFullName(fullnamefield.getText());
            user.setEmail(gmailfield.getText());
            user.setPhoneNumber(phonefield.getText());
            user.setRole(rolebox.getSelectedItem().toString());
            user.setStatus(statusbox.getSelectedItem().toString());

            JOptionPane.showMessageDialog(this, " User information updated successfully!");
            break;
        }
    }

    if(isNewUser){
        Viewuser newUser = new Viewuser(
            idfield.getText(),              // User ID
            namefield.getText(),            // Username
            passwordfield.getText(),        // Password
            fullnamefield.getText(),        // Full Name
            gmailfield.getText(),           // Email
            phonefield.getText(),           // Phone Number
            rolebox.getSelectedItem().toString(),  // Role
            statusbox.getSelectedItem().toString() // Status
        );

        userList.add(newUser);
        JOptionPane.showMessageDialog(this, "✅ New user added successfully!");
    } 

    Viewuser.saveToFile(userList, "user.txt");
    loadUserData();
    clearInput();
    idfield.setEditable(true); 


    }//GEN-LAST:event_savebuttonActionPerformed

    private void idfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idfieldActionPerformed

    private void resetbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbutton1ActionPerformed
        // TODO add your handling code here:
        clearInput();
        idfield.setEditable(true);
        loadUserData();
        JOptionPane.showMessageDialog(userTable, "User Management Reset Successfully!");
    }//GEN-LAST:event_resetbutton1ActionPerformed

    private void roleboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleboxActionPerformed

    private void statusboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusboxActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void passwordfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordfieldActionPerformed

    private void phonefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonefieldActionPerformed

    private void gmailfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gmailfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gmailfieldActionPerformed
    private void TableFormat() {
    DefaultTableModel model = new DefaultTableModel(
        new String[]{"UserID", "Username", "Password", "FullName", "Gmail", "PhoneNumber", "Role", "Status"}, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; 
        }
    };
    userTable.setModel(model);
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);

    for (int i = 0; i < userTable.getColumnCount(); i++) {
        userTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }

    userTable.setRowHeight(23);
    
    userTable.getColumnModel().getColumn(4).setPreferredWidth(125);
    userTable.getColumnModel().getColumn(5).setPreferredWidth(90);
    userTable.getColumnModel().getColumn(6).setPreferredWidth(95);
    userTable.getColumnModel().getColumn(7).setPreferredWidth(55);

    userTable.getTableHeader().setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 14));
    }

    private void clearInput() {
        idfield.setText("");
        passwordfield.setText("");
        namefield.setText("");
        fullnamefield.setText("");
        gmailfield.setText("");
        phonefield.setText("");
        rolebox.setSelectedIndex(0);
        statusbox.setSelectedIndex(0);
    }

    private String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }
    
 


    private void loadUserData() {
        userList.clear();
        List<String[]> dataList = FileReaderUtil.readFileAsArrays("user.txt");

        DefaultTableModel model = (DefaultTableModel) userTable.getModel();
        model.setRowCount(0);

        for (String[] user : dataList) {
            if (user.length == 8) {
                Viewuser newUser = new Viewuser(
                    user[0],
                    user[1],
                    user[2],
                    user[3],
                    user[4],
                    user[5],
                    user[6],
                    user[7]
                );
                userList.add(newUser);
                Object[] rowData = {
                    user[0], // UserID
                    user[1], // Username
                    user[2], // Password
                    user[3], // Role (INCORRECT)
                    user[4], // Full Name (INCORRECT)
                    user[5], // Email (INCORRECT)
                    user[6], // Phone Number (INCORRECT)
                    user[7]  // Status
                };
                model.addRow(rowData);
            }
        }
        
        System.out.println("-----userList Content-----");
        for(Viewuser user : userList){
            System.out.println(user.getUserID() + " - " + user.getUserName());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ViewuserGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createbutton;
    private javax.swing.JButton deletebutton;
    private javax.swing.JButton editbutton;
    private javax.swing.JTextField fullnamefield;
    private javax.swing.JTextField gmailfield;
    private javax.swing.JTextField idfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton menubutton;
    private javax.swing.JTextField namefield;
    private javax.swing.JTextField passwordfield;
    private javax.swing.JFormattedTextField phonefield;
    private javax.swing.JButton resetbutton1;
    private javax.swing.JComboBox<String> rolebox;
    private javax.swing.JButton savebutton;
    private javax.swing.JButton searchbutton;
    private javax.swing.JComboBox<String> statusbox;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}