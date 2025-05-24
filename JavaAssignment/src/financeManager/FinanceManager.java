/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financeManager;

import admin.User;

/**
 *
 * @author User
 */
public class FinanceManager extends User {

    public FinanceManager(String userID, String userName, String Password, String Role, String FullName, String Email, String PhoneNumber, String Status) {
        super(userID, userName, Password, Role, FullName, Email, PhoneNumber, Status);
    }
    
    @Override
    public void routeMenu(){
        new FinanceManagerMenu().setVisible(true);
    }
}
