/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class PurchaseRequisition {
    private String prId;
    private Item item;
    private Supplier supplier;
    private int quantity;
    private String requiredDate;
    private String raisedBy;
    private String status;

    public PurchaseRequisition(String prId, Item item, Supplier supplier, int quantity, String requiredDate, String raisedBy, String status) {
        this.prId = prId;
        this.item = item;
        this.supplier = supplier;
        this.quantity = quantity;
        this.requiredDate = requiredDate;
        this.raisedBy = raisedBy;
        this.status = status;
    }

    public String getPrId() {
        return prId;
    }

    public void setPrId(String prId) {
        this.prId = prId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(String requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getRaisedBy() {
        return raisedBy;
    }

    public void setRaisedBy(String raisedBy) {
        this.raisedBy = raisedBy;
    }

    public String toString() {
        return  prId + "," + item.getItemID() + "," + supplier.getSupplierId() + "," + quantity + "," + requiredDate + "," + raisedBy + "," + status;
    }
    
    public static ArrayList<PurchaseRequisition> loadPRFromFile(String filename, ArrayList<Item> itemList, ArrayList<Supplier> supplierList) {
        ArrayList<PurchaseRequisition> prList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    String prId = parts[0].trim();
                    String itemId = parts[1].trim();
                    String supplierId = parts[2].trim();
                    int quantity = Integer.parseInt(parts[3].trim());
                    String requiredDate = parts[4].trim();
                    String raisedBy = parts[5].trim();
                    String status = parts[6].trim();

                    // Find matching Item
                    Item matchedItem = null;
                    for (Item item : itemList) {
                        if (item.getItemID().equalsIgnoreCase(itemId)) {
                            matchedItem = item;
                            break;
                        }
                    }

                    // Find matching Supplier
                    Supplier matchedSupplier = null;
                    for (Supplier s : supplierList) {
                        if (s.getSupplierId().equalsIgnoreCase(supplierId)) {
                            matchedSupplier = s;
                            break;
                        }
                    }

                    if (matchedItem != null && matchedSupplier != null) {
                        prList.add(new PurchaseRequisition(prId, matchedItem, matchedSupplier, quantity, requiredDate, raisedBy, status));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prList;
    }
}
