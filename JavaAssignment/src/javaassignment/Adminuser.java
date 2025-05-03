/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import javax.swing.*;

public class Adminuser extends User {

    public Adminuser(String fullName) {
        super(fullName);
    }

    @Override
    public void showDashboard() {

        Viewuser dummyUser = new Viewuser(
            "", "", "", "Administrator", fullName, "", "", "Active"
        );
        new AdminMenuGUI(dummyUser).setVisible(true);
    }
}