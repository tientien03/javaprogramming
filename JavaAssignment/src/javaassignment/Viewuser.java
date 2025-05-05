/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import main.FileReaderUtil;
import main.FileWriterUtil;
import java.util.List;
import java.util.ArrayList;

public class Viewuser {
    private String userID;
    private String username;
    private String password;
    private String role;       
    private String fullName;
    private String email;
    private String phoneNumber;
    private String status; 

    public Viewuser(String userID, String username, String password, String role, String fullName, String email, String phoneNumber, String status) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public String getUserID() {return userID;}
    public void setUserID(String userID) { this.userID = userID; }
    
    public String getUsername() {return username;}
    public void setUsername(String username) { this.username = username; }

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    // Format data for saving to file
    public String toFileString() {
        return String.join(",", userID, username, password, role, fullName, email, phoneNumber, status);
    }
    
    // Load all users from user.txt
    public static ArrayList<Viewuser> loadUsersFromFile(String filename) {
            List<String[]> rawData = FileReaderUtil.readFileAsArrays(filename);
            ArrayList<Viewuser> userList = new ArrayList<>();

            for (String[] parts : rawData) {
                if (parts.length == 8) {
                    Viewuser user = new Viewuser(
                        parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim(),
                        parts[4].trim(), parts[5].trim(), parts[6].trim(), parts[7].trim()
                    );
                    userList.add(user);
                }
            }
            return userList;
        }
    // Append single user to file
    public static void appendUserToFile(Viewuser user, String filename) {
        FileWriterUtil.appendToFile(filename, user.toFileString());
    }

    // Save all users to file (overwrite)
    public static void saveUsersToFile(ArrayList<Viewuser> userList, String filename) {
        List<String[]> data = new ArrayList<>();
        for (Viewuser user : userList) {
            String[] row = {
                user.getUserID(), user.getUsername(), user.getPassword(), user.getRole(),
                user.getFullName(), user.getEmail(), user.getPhoneNumber(), user.getStatus()
            };
            data.add(row);
        }
        FileWriterUtil.writeFile(filename, data);
    }
    
    // Add new user
    public static boolean addUser(ArrayList<Viewuser> userList, Viewuser newUser) {
        for (Viewuser user : userList) {
            if (user.getUserID().equalsIgnoreCase(newUser.getUserID())) {
                System.out.println("User ID already exists!");
                return false;
            }
        }
        userList.add(newUser);
        System.out.println("User added successfully.");
        return true;
    }
    
    // Edit user
    public static boolean editUser(ArrayList<Viewuser> userList, String userID, Viewuser updatedUser) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserID().equalsIgnoreCase(userID)) {
                userList.set(i, updatedUser);
                System.out.println("User updated successfully.");
                return true;
            }
        }
        System.out.println("User ID not found.");
        return false;
    }
    
    // Delete user
    public static boolean deleteUser(ArrayList<Viewuser> userList, String userID) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserID().equalsIgnoreCase(userID)) {
                userList.remove(i);
                System.out.println("User deleted successfully.");
                return true;
            }
        }
        System.out.println("User ID not found.");
        return false;
    }
}
    

