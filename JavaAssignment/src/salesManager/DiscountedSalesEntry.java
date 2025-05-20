/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesManager;

/**
 *
 * @author User
 */
public class DiscountedSalesEntry extends SalesEntry {
    private double discountRate;

    public DiscountedSalesEntry(String SalesID, String Salesdate, Item item, int quantity,double discountRate) {
        super(SalesID, Salesdate, item, quantity);
        this.discountRate = discountRate;
    }
    
    @Override
    public double getTotal(){
        return getItem().getSalesPrice()* getQuantity() * (1-discountRate/100);
    }

    public double getDiscountRate() {
        return discountRate;
    }
}