/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory;

/**
 *
 * @author limsh
 */
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import main.FileReaderUtil;
import main.FileWriterUtil;

public class InventoryUpdateStock {
    public List<String[]> loadApprovedPOs() {
        List<String[]> allPOs = FileReaderUtil.readFile("purchase_orders.txt");
        List<String[]> approvedPOs = new ArrayList<>();

        for (String[] parts : allPOs) {
            if (parts.length == 8 && parts[7].trim().equalsIgnoreCase("Approved")) {
                approvedPOs.add(parts);
            }
        }
        return approvedPOs;
    }
    
    public void updateItemStock(String itemID, int quantityToAdd){
        List<String[]> itemList = FileReaderUtil.readFile("item.txt");

        for (String[] parts : itemList) {
            if (parts.length >= 6 && parts[0].trim().equals(itemID)) {
                try {
                    int currentQty = Integer.parseInt(parts[5].trim());
                    int newQty = currentQty + quantityToAdd;
                    parts[5] = String.valueOf(newQty);
                    break; // Optional: Exit loop after updating
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid quantity format for item " + itemID, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        FileWriterUtil.writeFile("item.txt", itemList);
    }
    
    public void updatePurchaseOrderStatus(String poID) {
        List<String[]> rawData = FileReaderUtil.readFile("purchase_orders.txt");

        for (String[] parts : rawData) {
            if (parts.length == 8 && parts[0].equals(poID)) {
                parts[7] = "Updated";
                break;
            }
        }

        FileWriterUtil.writeFile("purchase_orders.txt", rawData);
    }
}
