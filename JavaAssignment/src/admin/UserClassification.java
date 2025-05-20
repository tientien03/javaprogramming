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

public class UserClassification {
    
    private static String currentRole;
    private static String currentUsername;

    public static String getCurrentUsername() {
        return currentUsername;
    }

    public static void setCurrentUsername(String currentUsername) {
        UserClassification.currentUsername = currentUsername;
    }

    public static void setCurrentRole(String Role){
        currentRole = Role;
    }

    public static String getCurrentRole() {
        return currentRole;
    }

    private static final String USER_FILE = "user.txt";

 public static boolean authenticate(String role, String username, String password) {
        System.out.println("🔍 Authenticating -> Role: " + role + ", Username: " + username + ", Password: " + password);

        // Read the file
        List<String[]> users = FileReaderUtil.readFileAsArrays(USER_FILE);

        if (users == null || users.isEmpty()) {
            System.out.println("⚠️ User data file not found or is empty.");
            JOptionPane.showMessageDialog(null, "⚠️ User data file not found or is empty.");
            return false;
        }
        
        for (String[] user : users) {
            if (user.length >= 8) { 
                String fileUsername = user[1].trim();
                String filePassword = user[2].trim();
                String fileRole = user[6].trim();
                String status = user[7].trim();

                System.out.println("📝 Checking -> Role: " + fileRole + ", Username: " + fileUsername + ", Status: " + status);

                if (fileRole.equalsIgnoreCase(role) && 
                    fileUsername.equalsIgnoreCase(username) && 
                    filePassword.equals(password) &&
                    status.equalsIgnoreCase("Active")) {
                    
                    System.out.println("✅ Authentication successful for: " + username);
                    setCurrentRole(fileRole);
                    setCurrentUsername(fileUsername);
                    return true;
                }
            } else {
                System.out.println("⚠️ Invalid user data format in users.txt.");
            }
        }

        System.out.println("❌ Authentication failed for: " + username);
        return false;
    }


 public static void routeToMenu() {
        switch (currentRole) {
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
                new SalesManagerMenu(getCurrentUsername()).setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "❌ Invalid role: " + currentRole);
    }
}
}
