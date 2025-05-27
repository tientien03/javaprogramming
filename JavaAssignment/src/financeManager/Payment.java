/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financeManager;
import PurchaseManager.PurchaseOrder;
import salesManager.Item;
import salesManager.Supplier;
/**
 *
 * @author HP
 */


public class Payment {
    private PurchaseOrder purchaseOrder;
    private Supplier supplier;
    private Item item;
    private double totalPrice;
    private String paymentDate;

    public Payment(PurchaseOrder purchaseOrder, Supplier supplier, Item item, double totalPrice, String paymentDate) {
        this.purchaseOrder = purchaseOrder;
        this.supplier = supplier;
        this.item = item;
        this.totalPrice = totalPrice;
        this.paymentDate = paymentDate;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }


}


