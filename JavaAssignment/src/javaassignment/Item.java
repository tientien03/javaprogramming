/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Item{
    private String ItemID;
    private String ItemName;
    private double price;
    private int stock;
    private ArrayList<String> supplierIds = new ArrayList<>();

    public Item(String ItemID, String ItemName, double price, int stock) {
        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.price = price;
        this.stock = stock;
    }

    public String getItemID() {return ItemID;}
    public void setItemID(String ItemID) {this.ItemID = ItemID;}

    public String getItemName() {return ItemName;}
    public void setItemName(String ItemName) {this.ItemName = ItemName;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}
    
    public void addSupplierId(String supplierId){
        if(!supplierIds.contains(supplierId)){
            supplierIds.add(supplierId);
        }
    }
    
    public ArrayList<String> getSupplierIds(){ return supplierIds;}

    public String toFileString() {
        String supplierJoined = String.join(";", supplierIds);
        return ItemID + "," + ItemName + "," + String.format("%.2f", price) + "," + stock + "," + supplierJoined;
    }
    
    public static ArrayList<Item> loadItemFromFile(String filename, ArrayList<Supplier> supplierList) {
        ArrayList<Item> itemList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("item.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String itemId = parts[0].trim();
                    String itemName = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    int stock = Integer.parseInt(parts[3].trim());
                    
                    Item item = new Item (itemId,itemName, price, stock);
                    
                    if(!parts[4].isEmpty()){
                        String[] supplierIds = parts[4].split(";");
                        for (String id:supplierIds){
                            String trimmedId = id.trim();
                            item.addSupplierId(trimmedId);
                            for (Supplier s: supplierList){
                                if(s.getSupplierId().equalsIgnoreCase(trimmedId)){
                                    break;
                                }
                            }
                        }
                        itemList.add(item);
                    }
                }    
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return itemList;
    }
    
    public static void saveItemToFile(ArrayList<Item> itemList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("item.txt"))) {
            for (Item item : itemList) {
                String supplierJoined = String.join(";", item.getSupplierIds());
                String line = item.getItemID() + "," +item.getItemName() + "," +String.format("%.2f", item.getPrice()) + "," +item.getStock() + "," + supplierJoined;
            writer.write(line);
            writer.newLine();
        }
            System.out.println("Item stock updated and saved to item.txt");
        } catch (IOException e) {
            System.out.println("Error saving item file: " + e.getMessage());
        }
    }
}