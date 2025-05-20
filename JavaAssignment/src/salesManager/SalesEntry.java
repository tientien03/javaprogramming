/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesManager;

import java.util.*;
import main.FileReaderUtil;

/**
 *
 * @author User
 */
public class SalesEntry {
    private String SalesID;
    private String Salesdate;
    private Item item;
    private int quantity;

    public SalesEntry(String SalesID, String Salesdate, Item item, int quantity) {
        this.SalesID = SalesID;
        this.Salesdate = Salesdate;
        this.item = item;
        this.quantity = quantity;
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

    public double getTotal(){
        return item.getSalesPrice()*quantity;
    }
 
    public static List<SalesEntry> loadSalesEntryFromFile(String filename, List<Item> itemList){
        List<SalesEntry> salesList = new ArrayList<>();
        List<String[]> SalesEntryData = FileReaderUtil.readFile(filename);
        for (String[] parts : SalesEntryData) {
            if (parts.length >= 7) {
                String salesId = parts[0].trim();
                String salesDate = parts[1].trim();
                String itemId = parts[2].trim();
                String itemName = parts[3].trim();
                Double salesprice = Double.parseDouble(parts[4].trim());
                int quantity = Integer.parseInt(parts[5].trim());
                // Match item
                Item matchedItem = null;
                for (Item item : itemList) {
                    if (item.getItemID().equalsIgnoreCase(itemId)) {
                        matchedItem = item;
                        break;
                    }
                }             
                Item item = matchedItem != null ? matchedItem : new Item (itemId, itemName,null,0.0,0.0,0);  
                SalesEntry entry;
                if(parts.length == 8){
                    double discountRate = Double.parseDouble(parts[7].trim());
                    entry = new DiscountedSalesEntry(salesId, salesDate, item, quantity, discountRate);
                }else{
                    entry = new SalesEntry(salesId, salesDate, item, quantity);
                }
                
                salesList.add(entry);
            }
        }            
        return salesList;
    } 
    
    public static List<String[]> convertToStringArrayList(List<SalesEntry> salesEntryList) {
        List<String[]> data = new ArrayList<>();
        for (SalesEntry se : salesEntryList) {
            if (se instanceof DiscountedSalesEntry){
                DiscountedSalesEntry dse = (DiscountedSalesEntry) se;
                data.add(new String[]{
                    dse.getSalesID(),
                    dse.getSalesdate(),
                    dse.getItem().getItemID(),
                    dse.getItem().getItemName(),
                    String.format("%.2f",dse.getItem().getSalesPrice()),
                    String.valueOf(dse.getQuantity()),
                    String.format("%.2f",dse.getTotal()),
                    String.format("%.0f",dse.getDiscountRate())
                });
            }else{
                data.add(new String[]{
                    se.getSalesID(),
                    se.getSalesdate(),
                    se.getItem().getItemID(),
                    se.getItem().getItemName(),
                    String.valueOf(se.getItem().getSalesPrice()),
                    String.valueOf(se.getQuantity()),
                    String.valueOf(se.getTotal())
                });
            }
            
        }
        return data;
    }
}
