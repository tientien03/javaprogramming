/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

public class AdminMenu  {

    private Viewuser currentUser;

    public AdminMenu(Viewuser user) {
        this.currentUser = user;
    }

    public void openUserManagement() {
        System.out.println(">>> User Management opened for " + currentUser.getFullName());
        // 之後可以開啟 UserManagementGUI()
    }

    public void openItemSupplierModule() {
        System.out.println(">>> Item & Supplier module");
    }

    public void openSalesInventoryModule() {
        System.out.println(">>> Sales & Inventory module");
    }

    public void openRequisitionOrders() {
        System.out.println(">>> Requisition & Orders");
    }

    public void openFinance() {
        System.out.println(">>> Finance module");
    }

    public void logout() {
        System.out.println(">>> Logging out...");
    }
}

