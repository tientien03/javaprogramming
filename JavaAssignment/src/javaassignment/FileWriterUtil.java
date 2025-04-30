/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import java.io.*;
import java.util.List;

public class FileWriterUtil {
    //add new line only
    public static void appendToFile(String fileName, String line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("❌ Error appending to file: " + e.getMessage());
        }
    }
    
    //replace whole file with updated content
    public static void writeFile(String fileName, List<String[]> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String[] parts : data) {
                bw.write(String.join(",", parts));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ Error writing file: " + e.getMessage());
        }
    }
}
