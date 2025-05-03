/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

public abstract class User {
    protected String fullName;

    public User(String fullName) {
        this.fullName = fullName;
    }

    public abstract void showDashboard(); // 子類實作自己的行為
}