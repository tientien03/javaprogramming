/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package financeManager;
import java.io.*;

public class Payment {
    public String poID;
    public String supplierID;
    public String itemID;
    public int quantity;
    public double unitPrice;
    public double totalPrice;
    public String paymentDate;
    public String method;


    public Payment(String poID, String supplierID, String itemID, int quantity,
                   double unitPrice, double totalPrice, String paymentDate, String method) {
        this.poID = poID;
        this.supplierID = supplierID;
        this.itemID = itemID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.paymentDate = paymentDate;
        this.method = method;
    }


    public static boolean isAlreadyPaid(String poID, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].equals(poID)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void savePayment(Payment payment) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("payments.txt", true))) {
            writer.write(payment.poID + "," +
                         payment.supplierID + "," +
                         payment.itemID + "," +
                         payment.quantity + "," +
                         payment.unitPrice + "," +
                         payment.totalPrice + "," +
                         payment.paymentDate + "," +
                         payment.method);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void updatePOStatus(String poID, String filePath) {
        File inputFile = new File(filePath);
        File tempFile = new File("temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 8 && parts[0].equals(poID)) {
                    parts[7] = "Paid"; // update status at index 7
                    line = String.join(",", parts);
                }
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);
    }


    public static double lookupSupplierPrice(String itemCode, String supplierID, String itemFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(itemFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[0].equalsIgnoreCase(itemCode)) {
                    String[] suppliers = parts[2].split(";");
                    for (String s : suppliers) {
                        if (s.trim().equalsIgnoreCase(supplierID)) {
                            return Double.parseDouble(parts[3]); // supplier price
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }


    public static double calculateTotalFromSupplier(String itemCode, String supplierID, int quantity, String itemFilePath) {
        double price = lookupSupplierPrice(itemCode, supplierID, itemFilePath);
        return (price > 0) ? price * quantity : -1;
    }
}


