/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  admin;


import main.FileWriterUtil;
import java.util.*;



public class Viewuser extends User {

    public Viewuser(String userID, String username, String password, String fullName, String email, String phoneNumber, String role, String status) {
        super(userID, username, password, role, fullName, email, phoneNumber, status);
    }

    public String displayInfo() {
        return getUserID() + " - " + getFullName() + " - " + getRole();
        }      
    
    public static List<String[]> convertToStringArrayList(List<Viewuser> userList) {
    List<String[]> data = new ArrayList<>();

    for (Viewuser user : userList) {
        String[] parts = {
            user.getUserID(),
            user.getUserName(),
            user.getPassword(),
            user.getRole(),
            user.getFullName(),
            user.getEmail(),
            user.getPhoneNumber(),
            user.getStatus()
        };
        data.add(parts);
    }
    return data;
}

    public static void saveToFile(List<Viewuser> userList, String fileName) {
            try {
                List<String[]> dataList = new ArrayList<>();
                for (Viewuser user : userList) {
                    dataList.add(new String[]{
                        user.getUserID(),
                        user.getUserName(),
                        user.getPassword(),
                        user.getFullName(),
                        user.getEmail(),
                        user.getPhoneNumber(),
                        user.getRole(),
                        user.getStatus()
                    });
                }
                FileWriterUtil.writeFile(fileName, dataList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static void appendUserToFile(Viewuser user, String filePath) {
        try {
            String userLine = String.join(",",
                user.getUserID(),
                user.getUserName(),
                user.getPassword(),
                user.getRole(),
                user.getFullName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getStatus()
            );

            FileWriterUtil.appendToFile(filePath, userLine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    