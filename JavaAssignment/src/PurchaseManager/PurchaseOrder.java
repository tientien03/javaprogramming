/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PurchaseManager;

import java.util.*;
import salesManager.*;


public class PurchaseOrder {
    private String poID;
    private PurchaseRequisition purchaseRequisition;
    private Item item;
    private int quantity;
    private Supplier supplier;
    private String purchaseManagerID;
    private String date;
    private String status;
    private List<Supplier> suppliers = new ArrayList<>();

    public PurchaseOrder(String poID, PurchaseRequisition purchaseRequisition, Item item, int quantity, List<Supplier> suppliers, String purchaseManagerID, String date, String status) {
        this.poID = poID;
        this.purchaseRequisition = purchaseRequisition;
        this.item = item;
        this.quantity = quantity;
        this.suppliers = (suppliers != null) ? suppliers : new ArrayList<>();
        this.purchaseManagerID = purchaseManagerID;
        this.date = date;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.join(",", 
                poID, 
                purchaseRequisition.getPrId(),
                item.getItemID(),
                String.valueOf(quantity), 
                String.join(";", getSupplierIds()),               
                purchaseManagerID, 
                date, 
                status
        );
    }

    public static PurchaseOrder fromString(String line, List<PurchaseRequisition> requisitions, List<Supplier> supplierList) {
        String[] parts = line.split(",");
        if (parts.length != 8) return null;
        
        String poID = parts[0];
        String prID = parts[1];
        String itemCode = parts[2];
        int quantity = Integer.parseInt(parts[3]);
        String supplierIDs = parts[4];
        String purchaseManagerID = parts[5];
        String date = parts[6];
        String status = parts[7];
        PurchaseRequisition pr = requisitions.stream()
            .filter(p -> p.getPrId().equalsIgnoreCase(prID))
            .findFirst()
            .orElse(null);

        if (pr == null) {
            return null; // PR not found
        }
    
        // Find the suppliers (can be multiple, separated by ;)
        List<Supplier> suppliers = new ArrayList<>();
        for (String id : supplierIDs.split(";")) {
            Supplier supplier = supplierList.stream()
                .filter(s -> s.getSupplierId().equalsIgnoreCase(id.trim()))
                .findFirst()
                .orElse(null);
        
            if (supplier != null) {
                suppliers.add(supplier);
            }
        }

        // Create the PurchaseOrder
        PurchaseOrder po = new PurchaseOrder(poID, pr, pr.getItem(), quantity, suppliers, purchaseManagerID, date, status);
        po.setSuppliers(suppliers);  // Set the list of suppliers

        return po;
    }   
    
    // Getters
    public String getPoID() { return poID; }
    public PurchaseRequisition getPurchaseRequisition() { return purchaseRequisition; }
    public Item getItem() { return item; }
    public Supplier getSupplier() { return supplier; }
    public int getQuantity() { return quantity; }
    public String getPurchaseManagerID() { return purchaseManagerID; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
    public List<String> getSupplierIds(){
        List<String> ids = new ArrayList<>();
        for (Supplier s : suppliers){
            ids.add(s.getSupplierId());
        }
        return ids;
    }


    // Setters
    public void setPoID(String poID) { this.poID = poID; }
    public void setPurchaseRequisition(PurchaseRequisition purchaseRequisition) {
        this.purchaseRequisition = purchaseRequisition;
        this.item = purchaseRequisition.getItem();
        this.quantity = purchaseRequisition.getQuantity();
    }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPurchaseManagerID(String purchaseManagerID) { this.purchaseManagerID = purchaseManagerID; }
    public void setDate(String date) { this.date = date; }
    public void setStatus(String status) { this.status = status; }
    public void setSuppliers(List<Supplier> suppliers) { this.suppliers = suppliers; }
}

