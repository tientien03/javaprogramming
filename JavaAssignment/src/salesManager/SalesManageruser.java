/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

/**
 * 銷售經理角色類別，登入後顯示 SalesManagerMenu。
 */
public class SalesManageruser extends User {

    public SalesManageruser(String fullName) {
        super(fullName);
    }

    @Override
    public void showDashboard() {
        // 如果 SalesManagerMenu 不需要 Viewuser，可直接打開
        new SalesManagerMenu().setVisible(true);
    }
}