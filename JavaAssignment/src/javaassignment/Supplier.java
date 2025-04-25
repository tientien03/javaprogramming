/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Supplier {
    private String SupplierId;
    private String SupplierName;
    private String SupplierPhoneNo;
    private String SupplierEmail;
    private ArrayList<String> suppliedItems = new ArrayList<>();

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
        String base =  SupplierId + "," + SupplierName + "," + SupplierPhoneNo + "," + SupplierEmail;
        if(!suppliedItems.isEmpty()){
            base += "," + String.join(";", suppliedItems);
        }
        return base;
    }
    
    public void addItemId(String itemId){
        if (!suppliedItems.contains(itemId)) {
            suppliedItems.add(itemId);
        }
    }
    
    public ArrayList<String> getSuppliedItems() {
        return suppliedItems;
    }
    
    public static ArrayList<Supplier> loadSupplierFromFile(String filename){
        ArrayList<Supplier> supplierList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = reader.readLine())!=null){
                String[] parts = line.split(",",5);
                if(parts.length >= 4){
                    String supplierId = parts[0].trim();
                    String supplierName = parts[1].trim();
                    String supplierPhoneNo = parts[2].trim();
                    String supplierEmail = parts[3].trim();
                    Supplier supplier = new Supplier(supplierId,supplierName,supplierPhoneNo,supplierEmail);
                    if(parts.length == 5){
                        String[] ids = parts[4].split(";");
                        for (String id : ids){
                            supplier.addItemId(id.trim());
                        }
                    }
                    supplierList.add(supplier);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return supplierList;
    }
    
    public static void saveSupplierToFile(ArrayList<Supplier> supplierList){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("suppliers.txt"))) {
            for (Supplier supplier : supplierList) {
                writer.write(supplier.toString());
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving suppliers: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
 