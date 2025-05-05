/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PurchaseManager;

public abstract class User {
    protected String userID;
    protected String name;
    protected String role;

    public User(String userID, String name, String role) {
        this.userID = userID;
        this.name = name;
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public abstract void showMenu(); // Each role has a different menu
}

