/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesManager;

import java.util.*;
import main.*;

/**
 *
 * @author User
 */
public class PurchaseRequisition {
    private String prId;
    private Item item;
    private List<Supplier> supplier;
    private int quantity;
    private String requiredDate;
    private String raisedBy;
    private String status;

    public PurchaseRequisition(String prId, Item item, List<Supplier> supplier, int quantity, String requiredDate, String raisedBy, String status) {
        this.prId = prId;
        this.item = item;
        this.supplier = supplier;
        this.quantity = quantity;
        this.requiredDate = requiredDate;
        this.raisedBy = raisedBy;
        this.status = status;
    }

    public String getPrId() {return prId;}
    public void setPrId(String prId) {this.prId = prId;}

    public Item getItem() {return item;}
    public void setItem(Item item) {this.item = item;}

    public List<Supplier> getSupplier() {return supplier;}
    public void setSupplier(List<Supplier> supplier) { this.supplier = supplier;}
    
    public List<String> getSupplierIds(){
        List<String> ids = new ArrayList<>();
        for (Supplier s : supplier){
            ids.add(s.getSupplierId());
        }
        return ids;
    }
    
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public String getRequiredDate() {return requiredDate;}

    public void setRequiredDate(String requiredDate) {this.requiredDate = requiredDate;}

    public String getRaisedBy() {
        return raisedBy;
    }

    public void setRaisedBy(String raisedBy) {
        this.raisedBy = raisedBy;
    }

    public String toString() {
        String supplierJoined = String.join(";", getSupplierIds());
        return  prId + "," + item.getItemID() + "," + supplierJoined + "," + quantity + "," + requiredDate + "," + raisedBy + "," + status;
    }
    
    public static List<PurchaseRequisition> loadPRFromFile(String filename, List<Item> itemList, List<Supplier> supplierList) {
        List<PurchaseRequisition> prList = new ArrayList<>();
        List<String[]> prData = FileReaderUtil.readFile(filename);
        for (String[] parts : prData) {
            if (parts.length == 7) {
                String prId = parts[0].trim();
                String itemId = parts[1].trim();
                String[] supplierIds = parts[2].split(";");
                int quantity = Integer.parseInt(parts[3].trim());
                String requiredDate = parts[4].trim();
                String raisedBy = parts[5].trim();
                String status = parts[6].trim();
                
                // Match item
                Item matchedItem = null;
                for (Item item : itemList) {
                    if (item.getItemID().equalsIgnoreCase(itemId)) {
                        matchedItem = item;
                        break;
                    }
                }

                // Match supplier
                List<Supplier>  matchedSuppliers = new ArrayList<>();
                for (String sid : supplierIds) {
                    for(Supplier s: supplierList){
                        if (s.getSupplierId().equalsIgnoreCase(sid.trim())) {
                            matchedSuppliers.add(s);
                            break;
                        }
                    }
                }
                
                if (matchedItem != null && !matchedSuppliers.isEmpty()) {
                    PurchaseRequisition pr = new PurchaseRequisition(
                        prId, matchedItem, matchedSuppliers, quantity, requiredDate, raisedBy, status
                    );
                    prList.add(pr);
                }
                
            }
        }            
        return prList;
    }
    
    public static List<String[]> convertToStringArrayList(List<PurchaseRequisition> PRList) {
        List<String[]> data = new ArrayList<>();
        for (PurchaseRequisition pr : PRList) {
            String[] parts = {
                pr.getPrId(),
                pr.getItem().getItemID(),            
                String.join(";", pr.getSupplierIds()),
                String.valueOf(pr.getQuantity()),
                pr.getRequiredDate(),
                pr.getRaisedBy(),
                pr.getStatus()
            };
            data.add(parts);
        }
        return data;
    }
}
