package com.advancedproblems.validatecsvdatabeforeprocessing;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class ValidateCSVData {
    // Regular expression pattern for a valid email
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

    public static void main(String[] args) {
        String filePath = "C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day01\\src\\main\\java\\com\\advancedproblems\\validatecsvdatabeforeprocessing\\contact.csv";

        List<String[]> employeeList = new ArrayList<>();
        List<String[]> invalidEntries = new ArrayList<>();

        try {
            FileReader fr = new FileReader(filePath);
            CSVReader csvr = new CSVReader(fr);

            // Read and ignore the first line (header row)
            String[] header = csvr.readNext();

            String[] nextLine;
            while ((nextLine = csvr.readNext()) != null) {
                if (nextLine.length < 5) {
                    invalidEntries.add(nextLine);
                    continue;
                }

                String email = nextLine[2].trim();
                String phone = nextLine[3].trim();

                if (!isValidEmail(email) || !isValidPhone(phone)) {
                    invalidEntries.add(nextLine);
                } else {
                    employeeList.add(nextLine); // Add only valid entries
                }
            }

            // Print invalid entries
            if (!invalidEntries.isEmpty()) {
                System.out.println("\nInvalid Entries:\n");
                for (String[] invalidEmp : invalidEntries) {
                    String email = invalidEmp.length > 2 ? invalidEmp[2] : "MISSING_EMAIL";
                    String phone = invalidEmp.length > 3 ? invalidEmp[3] : "MISSING_PHONE";
                    System.out.println("Invalid: "+ invalidEmp[0]+"    "+ invalidEmp[1]+  "     " + invalidEmp[2] +"    " + invalidEmp[3]+"   "+ invalidEmp[4]);

                    // Print Specific Issues
                    if (!isValidEmail(email)) {
                        System.out.println(" Invalid Email Format: " + email);
                    }
                    if (!isValidPhone(phone)) {
                        System.out.println(" Invalid Phone Number: " + phone);
                    }
                    System.out.println("----------------------------------");
                }

            }
            fr.close();
            csvr.close();

        } catch (IOException | CsvValidationException | NumberFormatException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

    // Method to validate email using regex
    private static boolean isValidEmail(String email) {
        return emailPattern.matcher(email).matches();
    }

    // Method to validate phone number
    private static boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }
}