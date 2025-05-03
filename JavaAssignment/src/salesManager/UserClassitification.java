/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

public class UserClassitification {

    public static User createUser(String role, String fullName) {
        switch (role.toLowerCase()) {
            case "Administrator":
                return new Adminuser(fullName);
            case "Sales manager":
                return new SalesManageruser(fullName);
//            case "Purchase Manager":
//                return new PurchaseManagerUser(fullName);
//            case "Inventory Manager":
//                return new InventoryManagerUser(fullName);
//            case "Finance Manager":
//                return new FinanceManagerUser(fullName);
            default:
                throw new IllegalArgumentException("❌ Unknown role: " + role);
        }
    }
}