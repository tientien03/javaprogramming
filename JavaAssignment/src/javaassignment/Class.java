/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

class Item{
    private String ItemID;
    private String ItemName;
    private Supplier supplier;
    private double price;
    private int quantity;

    public Item(String ItemID, String ItemName, Supplier supplier, double price, int quantity) {
        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.supplier = supplier;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemID() {return ItemID;}
    public void setItemID(String ItemID) {this.ItemID = ItemID;}

    public String getItemName() {return ItemName;}
    public void setItemName(String ItemName) {this.ItemName = ItemName;}

    public Supplier getSupplierID() {return supplier;}

    public void setSupplierID(Supplier supplier) {this.supplier = supplier;}
    
    
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    public String toFileString() {
        return ItemID + "," + ItemName + "," + supplier.getSupplierId() + "," + String.format("%.2f", price) + "," + quantity;
    }
    
}

class Supplier {
    private String SupplierId;
    private String SupplierName;
    private String SupplierPhoneNo;
    private String SupplierEmail;

    public Supplier(String SupplierId, String SupplierName, String SupplierPhoneNo, String SupplierEmail) {
        this.SupplierId = SupplierId;
        this.SupplierName = SupplierName;
        this.SupplierPhoneNo = SupplierPhoneNo;
        this.SupplierEmail = SupplierEmail;
    }

    public String getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(String SupplierId) {
        this.SupplierId = SupplierId;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String SupplierName) {
        this.SupplierName = SupplierName;
    }

    public String getSupplierPhoneNo() {
        return SupplierPhoneNo;
    }

    public void setSupplierPhoneNo(String SupplierPhoneNo) {
        this.SupplierPhoneNo = SupplierPhoneNo;
    }

    public String getSupplierEmail() {
        return SupplierEmail;
    }

    public void setSupplierEmail(String SupplierEmail) {
        this.SupplierEmail = SupplierEmail;
    }

    public String toString() {
        return SupplierId + "," + SupplierName + "," + SupplierPhoneNo + "," + SupplierEmail;
    }
    
}

class salesEntry{
    
}


