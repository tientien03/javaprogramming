/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

import java.util.List;
import main.FileReaderUtil;
import financeManager.FinanceManagerMenu;
import inventoryManager.Dashboard;
import PurchaseManager.Menu;
import salesManager.SalesManagerMenu;
import javax.swing.JOptionPane;

public class UserClassification{
    
    private static Loginable currentUser;
    private static final String USER_FILE = "user.txt";

    public static Loginable getCurrentUser() {
        return currentUser;
    }
    
    public static String getRoleByCredentials(String username, String password) {
        List<String[]> users = FileReaderUtil.readFileAsArrays("user.txt");
        if (users == null || users.isEmpty()) return null;

        for (String[] user : users) {
            if (user.length == 8) {
                String fileUsername = user[1].trim();
                String filePassword = user[2].trim();
                String role = user[3].trim();
                String status = user[7].trim();

                if (fileUsername.equalsIgnoreCase(username) &&
                    filePassword.equals(password) &&
                    status.equalsIgnoreCase("Active")) {
                    return role;
                }
            }
        }
    return null;
}
    
    public static boolean authenticate(String username, String password) {
        System.out.println("🔍 Authenticating ->  Username: " + username + ", Password: " + password);

        // Read the file
        List<String[]> users = FileReaderUtil.readFileAsArrays(USER_FILE);

        if (users == null || users.isEmpty()) {
            System.out.println("⚠️ User data file not found or is empty.");
            JOptionPane.showMessageDialog(null, "⚠️ User data file not found or is empty.");
            return false;
        }
        
        for (String[] user : users) {
            if (user.length == 8) { 
                String userID= user[0].trim(); // A001
                String fileUsername = user[1].trim(); // admin01
                String filePassword = user[2].trim(); // password123
                String fileRole = user[3].trim(); // John Tan
                String fullName = user[4].trim(); // johntan@owsb.com
                String email = user[5].trim(); // 012-3456789
                String phone= user[6].trim(); // Administrator
                String status = user[7].trim(); // Active
                System.out.println("📝 Checking -> Role: " + fileRole + ", Username: " + fileUsername + ", Status: " + status);

                if (fileUsername.equalsIgnoreCase(username) && filePassword.equals(password) && status.equalsIgnoreCase("Active")) {
                    System.out.println("✅ Authentication successful for: " + username);
                    currentUser = new User(userID, fileUsername, filePassword, fileRole,fullName, email, phone, status);
                    System.out.println(currentUser.getUserName());     // Interface method
                    System.out.println(currentUser.getRole());         // Interface method
                    return currentUser.login(username, password);
                }
            } else {
                System.out.println("⚠️ Invalid user data format in users.txt.");
            }
        }

        System.out.println("❌ Authentication failed for: " + username);
        return false;
    }


 public static void routeToMenu() {
        switch (currentUser.getRole()) {
            case "Administrator":
                new AdminMenuGUI().setVisible(true);
                break;
            case "Finance Manager":
                new FinanceManagerMenu().setVisible(true);
                break;
            case "Inventory Manager":
                new Dashboard().setVisible(true);
                break;
            case "Purchase Manager":
                new Menu().setVisible(true);
                break;
            case "Sales Manager":
                new SalesManagerMenu().setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "❌ Invalid role: " + currentUser.getRole());
        }
    }
}
