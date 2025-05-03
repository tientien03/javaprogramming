/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesManager;

import main.FileReaderUtil;
import java.util.*;

/**
 *
 * @author User
 */
public class Supplier {
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
    
    public static List<Supplier> loadSupplierFromFile(String filename){
        List<Supplier> supplierList = new ArrayList<>();
        List<String[]> supplierData = FileReaderUtil.readFile(filename);
        for (String[] parts : supplierData) {
            if (parts.length == 4) {
                String supplierId = parts[0].trim();
                String supplierName = parts[1].trim();
                String supplierPhoneNo = parts[2].trim();
                String supplierEmail = parts[3].trim();
                Supplier supplier = new Supplier(supplierId,supplierName,supplierPhoneNo,supplierEmail);
                supplierList.add(supplier);
            }
        }            
        return supplierList;
    }
    public static List<String[]> convertToStringArrayList(List<Supplier> supplierList) {
        List<String[]> data = new ArrayList<>();
        for (Supplier s : supplierList) {
            String[] parts = {
                s.getSupplierId(),
                s.getSupplierName(),
                s.getSupplierPhoneNo(),
                s.getSupplierEmail()
            };
            data.add(parts);
        }
        return data;
    }
}