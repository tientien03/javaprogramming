/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import java.io.*;
import java.util.*;

/**
 *
 * @author HP
 */
public class PurchaseOrder {
    private String poID;
    private String prID;
    private String itemCode;
    private int quantity;
    private String supplierID;
    private String pmID;
    private String date;
    private String status;

    public PurchaseOrder(String poID, String prID, String itemCode, int quantity, String supplierID, String pmID, String date, String status) {
        this.poID = poID;
        this.prID = prID;
        this.itemCode = itemCode;
        this.quantity = quantity;
        this.supplierID = supplierID;
        this.pmID = pmID;
        this.date = date;
        this.status = status;
    }

    public String getPoID() {
        return poID;
    }

    public void setPoID(String poID) {
        this.poID = poID;
    }

    public String getPrID() {
        return prID;
    }

    public void setPrID(String prID) {
        this.prID = prID;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getPmID() {
        return pmID;
    }

    public void setPmID(String pmID) {
        this.pmID = pmID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return poID + "," + prID + "," + itemCode + "," + quantity + "," + supplierID + "," + pmID + "," + date + "," +status;
    }
    public static ArrayList<PurchaseOrder> loadPurchaseOrders() {
        ArrayList<PurchaseOrder> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("purchase_orders.txt"))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 8) {
                    list.add(new PurchaseOrder(
                        parts[0],
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        parts[4],
                        parts[5],
                        parts[6],
                        parts[7]
                    ));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading POs: " + e.getMessage());
        }
        return list;
    }

    // Save POs back to purchase_orders.txt
    public static void savePurchaseOrders(List<PurchaseOrder> list) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("purchase_orders.txt"))) {
            for (PurchaseOrder po : list) {
                writer.println(po.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving POs: " + e.getMessage());
        }
    }
}
