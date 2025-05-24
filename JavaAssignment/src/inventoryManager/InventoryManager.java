/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventoryManager;

import admin.User;

/**
 *
 * @author limsh
 */
public class InventoryManager extends User{

    public InventoryManager(String userID, String userName, String Password, String Role, String FullName, String Email, String PhoneNumber, String Status) {
        super(userID, userName, Password, Role, FullName, Email, PhoneNumber, Status);
    }
      
    @Override
    public void routeMenu(){
        new Dashboard().setVisible(true);
    }
}
