/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesManager;

import admin.User;

/**
 *
 * @author User
 */
public class SalesManager extends User{

    public SalesManager(String userID, String userName, String Password, String Role, String FullName, String Email, String PhoneNumber, String Status) {
        super(userID, userName, Password, Role, FullName, Email, PhoneNumber, Status);
    }
    
    @Override
    public void routeMenu(){
        new SalesManagerMenu().setVisible(true);
    }
}
