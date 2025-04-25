/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Item{
    private String ItemID;
    private String ItemName;
    private Supplier supplier;
    private double price;
    private int stock;

    public Item(String ItemID, String ItemName, Supplier supplier, double price, int stock) {
        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.supplier = supplier;
        this.price = price;
        this.stock = stock;
    }

    public String getItemID() {return ItemID;}
    public void setItemID(String ItemID) {this.ItemID = ItemID;}

    public String getItemName() {return ItemName;}
    public void setItemName(String ItemName) {this.ItemName = ItemName;}

    public Supplier getSupplier() {return supplier;}
    public void setSupplier(Supplier supplier) {this.supplier = supplier;}
        
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}

    public String toFileString() {
        return ItemID + "," + ItemName + "," + supplier.getSupplierId() + "," + String.format("%.2f", price) + "," + stock;
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
                    String supplierId = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    int stock = Integer.parseInt(parts[4].trim());
                    
                    Supplier matchedSupplier = null;
                    for (Supplier s : supplierList) {
                        if (s.getSupplierId().equalsIgnoreCase(supplierId)) {
                            matchedSupplier = s;
                            break;
                        }
                    }
                    if (matchedSupplier == null) {
                        matchedSupplier = new Supplier("Unknown", "Unknown", "-", "-");
                    }
                    itemList.add(new Item(itemId, itemName, matchedSupplier, price, stock));
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
                String line = item.getItemID() + "," +item.getItemName() + "," +item.getSupplier().getSupplierId() + "," +String.format("%.2f", item.getPrice()) + "," +item.getStock();
            writer.write(line);
            writer.newLine();
        }
            System.out.println("Item stock updated and saved to item.txt");
        } catch (IOException e) {
            System.out.println("Error saving item file: " + e.getMessage());
        }
    }
}