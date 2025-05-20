/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesManager;

import main.FileReaderUtil;
import java.util.*;

/**
 *
 * @author User
 */
public class Item{
    private String ItemID;
    private String ItemName;
    private double price;
    private double salesPrice;
    private int stock;
    private List<Supplier> supplier;

    public Item(String ItemID, String ItemName, List<Supplier> supplier ,double price, double salesPrice, int stock) {
        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.supplier = supplier;
        this.price = price;
        this.salesPrice = salesPrice;
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

    public double getSalesPrice() { return salesPrice;}
    public void setSalesPrice(double salesPrice) { this.salesPrice = salesPrice;}

    public List<Supplier> getSupplier() {return supplier;}
    public void setSupplier(List<Supplier> supplier) {this.supplier = supplier;}
    
    public List<String> getSupplierids(){
        List<String> ids = new ArrayList<>();
        for (Supplier s : supplier){
            ids.add(s.getSupplierId());
        }
        return ids;
    }

    public String toFileString() {
        String supplierJoined = String.join(";", getSupplierids());
        return ItemID + "," + ItemName + "," + supplierJoined + "," + String.format("%.2f", price) + "," + stock;
    }
    
    public static List<Item> loadItemFromFile(String filename, List<Supplier> supplierList) {
        List<Item> itemList = new ArrayList<>();
        List<String[]> itemData = FileReaderUtil.readFile(filename);
        for (String[] parts : itemData) {
            if (parts.length == 6) {
                String itemId = parts[0].trim();
                String itemName = parts[1].trim();
                String[] supplierIds = parts[2].split(";");
                List<Supplier> matchedSuppliers = new ArrayList<>();
                for (String sid : supplierIds) {
                        for (Supplier s : supplierList) {
                        if (s.getSupplierId().equalsIgnoreCase(sid.trim())) {
                            matchedSuppliers.add(s);
                            break;
                        }
                    }
                }
                double price = Double.parseDouble(parts[3].trim());
                double salesPrice = Double.parseDouble(parts[4].trim());
                int stock = Integer.parseInt(parts[5].trim());
                Item item = new Item(itemId, itemName, matchedSuppliers,price, salesPrice,stock);
                itemList.add(item);
            }
        }
        return itemList;
    }
    
    public static List<String[]> convertToStringArrayList(List<Item> itemList) {
        List<String[]> data = new ArrayList<>();
        for (Item item : itemList) {
            String[] parts = {
                item.getItemID(),
                item.getItemName(),
                String.join(";", item.getSupplierids()),
                String.format("%.2f", item.getPrice()),
                String.format("%.2f", item.getSalesPrice()),
                String.valueOf(item.getStock())
            };
            data.add(parts);
        }
        return data;
    }
    
}