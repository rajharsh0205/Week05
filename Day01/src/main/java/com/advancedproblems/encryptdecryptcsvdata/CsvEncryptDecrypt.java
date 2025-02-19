package com.advancedproblems.encryptdecryptcsvdata;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.*;

public class CsvEncryptDecrypt {

    // encryption by reversing the string
    public static String encrypt(String data) {
        return new StringBuilder(data).reverse().toString();
    }

    // decryption by reversing back
    public static String decrypt(String data) {
        return new StringBuilder(data).reverse().toString();
    }

    // Method to write encrypted data to CSV
    public static void writeToCSV(String filePath) {
        String[] header = {"Employee ID", "Name", "Department", "Salary", "Email"};
        String[][] employees = {
                {"101", "Deep", "IT", encrypt("50000"), encrypt("deep@gmail.com")},
                {"102", "Yogesh", "HR", encrypt("60000"), encrypt("yogesh@gmail.com")},
                {"103", "Pradeep", "Finance", encrypt("70000"), encrypt("pradeep@gmail.com")}
        };

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(header);
            for (String[] emp : employees) {
                writer.writeNext(emp);
            }
            System.out.println("Encrypted data written to CSV.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read and decrypt data from CSV
    public static void readFromCSV(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            for (int i = 0; i < records.size(); i++) {
                String[] row = records.get(i);
                if (i > 0) { // Skip header
                    row[3] = decrypt(row[3]); // Decrypt Salary
                    row[4] = decrypt(row[4]); // Decrypt Email
                }
                System.out.println(Arrays.toString(row));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day01\\src\\main\\java\\com\\advancedproblems\\encryptdecryptcsvdata\\employees.csv";
        writeToCSV(filePath);
        System.out.println("\nReading decrypted data from CSV:");
        readFromCSV(filePath);
    }
}