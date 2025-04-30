/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class SalesEntry {
    private String SalesID;
    private String Salesdate;
    private Item item;
    private int quantity;
    private double total;

    public SalesEntry(String SalesID, String Salesdate, Item item, int quantity, double total) {
        this.SalesID = SalesID;
        this.Salesdate = Salesdate;
        this.item = item;
        this.quantity = quantity;
        this.total = total;
    }

    public String getSalesID() {
        return SalesID;
    }

    public void setSalesID(String SalesID) {
        this.SalesID = SalesID;
    }

    public String getSalesdate() {
        return Salesdate;
    }

    public void setSalesdate(String Salesdate) {
        this.Salesdate = Salesdate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
 
    public static ArrayList<SalesEntry> loadSalesEntryFromFile(String filename) throws FileNotFoundException{
        ArrayList<SalesEntry> salesList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = reader.readLine())!=null){
                String[] parts = line.split(",");
                if(parts.length == 7){
                    String salesId = parts[0].trim();
                    String date = parts[1].trim();
                    String itemId = parts[2].trim();
                    String itemName = parts[3].trim();
                    double price = Double.parseDouble(parts[4].trim());
                    int quantity = Integer.parseInt(parts[5].trim());
                    double total = Double.parseDouble(parts[6].trim());
                    
                    Item item = new Item (itemId, itemName,price,0);
                    
                    SalesEntry entry = new SalesEntry(salesId,date,item,quantity,total);
                    salesList.add(entry);
                }
            }
            
        }catch (IOException e){
            System.out.println("Error reading file:"+e.getMessage());
        }
        return salesList;
    }
    
}
