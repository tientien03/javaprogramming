/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PurchaseManager;

public class PurchaseOrder {
    private String poID;
    private String prID;
    private String itemCode;
    private int quantity;
    private String supplierID;
    private String purchaseManagerID;
    private String date;
    private String status;

    public PurchaseOrder(String poID, String prID, String itemCode, int quantity, String supplierID, String purchaseManagerID, String date, String status) {
        this.poID = poID;
        this.prID = prID;
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.supplierID = supplierID;
        this.purchaseManagerID = purchaseManagerID;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.join(",", poID, prID, itemCode, String.valueOf(quantity), supplierID, purchaseManagerID, date, status);
    }

    public static PurchaseOrder fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length != 8) return null;
        int qty = Integer.parseInt(parts[3]);  
        return new PurchaseOrder(
                parts[0], // poID
                parts[1], // requisitionID
                parts[2], // itemCode
                qty,      // quantity
                parts[4], // supplierID
                parts[5], // purchaseManagerID
                parts[6], // Date
                parts[7]  // Status
        );
    }
    
    // Getters
    public String getPoID() { return poID; }
    public String getPrID() { return prID; }
    public String getItemCode() { return itemCode; }
    public int getQuantity() { return quantity; }
    public String getSupplierID() { return supplierID; }
    public String getPurchaseManagerID() { return purchaseManagerID; }
    public String getDate() { return date; }
    public String getStatus() { return status; }

    // Setters
    public void setPoID(String poID) { this.poID = poID; }
    public void setPrID(String prID) { this.prID = prID; }
    public void setItemCode(String itemCode) { this.itemCode = itemCode; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setSupplierID(String supplierID) { this.supplierID = supplierID; }
    public void setPurchaseManagerID(String purchaseManagerID) { this.purchaseManagerID = purchaseManagerID; }
    public void setDate(String date) { this.date = date; }
    public void setStatus(String status) { this.status = status; }
}

