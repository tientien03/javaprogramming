package javaassignment;

import java.util.ArrayList;

public class Login {

    public static Viewuser authenticate(String role, String username, String password) {
        ArrayList<Viewuser> users = Viewuser.loadUsersFromFile("user.txt");
        System.out.println("📂 Current working directory: " + new java.io.File(".").getAbsolutePath());
        System.out.println("🔍 Trying to load: user.txt");


        for (Viewuser user : users) {
            if (user.getUsername().equalsIgnoreCase(username) &&
                user.getPassword().equals(password) &&
                user.getRole().equalsIgnoreCase(role) &&
                user.getStatus().equalsIgnoreCase("Active")) {
                return user;  // 三個條件都對才成功
            }
        }

        return null; // 驗證失敗
    }
    
}