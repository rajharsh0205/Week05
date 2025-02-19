package com.advancedproblems.detectduplicatecsvfile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day01\\src\\main\\java\\com\\advancedproblems\\detectduplicatecsvfile\\student.csv";
        Set<String> uniqueIds = new HashSet<>(); // Set to track unique IDs
        List<String[]> duplicateEntries = new ArrayList<>(); // List to store duplicate rows

        try {
            FileReader fr = new FileReader(filePath);
            CSVReader reader = new CSVReader(fr);
            String[] header = reader.readNext(); // Skip the header row

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String id = nextLine[0];

                // Check if the ID is already in the set (duplicate)
                if (!uniqueIds.add(id)) {
                    duplicateEntries.add(nextLine); // Add duplicate row to the list
                }

            }

            // Print all duplicates
            if (!duplicateEntries.isEmpty()) {
                System.out.println("Duplicate Records Based on ID:");
                for (String[] row : duplicateEntries) {
                    System.out.println(Arrays.toString(row));
                }
            } else {
                System.out.println("No duplicate records found.");
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}