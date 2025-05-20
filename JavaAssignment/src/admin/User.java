/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  admin;


public class User{
    private String userID;
    private String userName;
    private String Password;
    private String Role;
    private String FullName;
    private String Email;
    private String PhoneNumber;
    private String Status;

    public User(String userID, String userName, String Password, String Role, String FullName, String Email, String PhoneNumber, String Status) {
        this.userID = userID;
        this.userName = userName;
        this.Password = Password;
        this.Role = Role;
        this.FullName = FullName;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Status = Status;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return Password;
    }

    public String getRole() {
        return Role;
    }

    public String getFullName() {
        return FullName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getStatus() {
        return Status;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

   
    public String toFileString() {
        return userID + "," + userName + "," + Password + "," + Role + "," + FullName + "," + Email + "," + PhoneNumber + "," + Status;
        }
    
     @Override
    public String toString() {
        return userID + "," + userName + "," + Password + "," + Role + "," + 
               FullName + "," + Email + "," + PhoneNumber + "," + Status;
    }
    }