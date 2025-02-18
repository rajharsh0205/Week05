package com.intermediateproblems.filterrecordsfromcsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FilterRecords {
    public static void main(String[] args) {

        // Try-with-resources to automatically close the CSVReader when done
        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day01\\src\\main\\java\\com\\intermediateproblems\\filterrecordsfromcsv\\student_record.csv"))) {
            // Array to store each row from the CSV file
            String[] row;

            // Read and print the first line (header) of the CSV
            // This will print the column names or headers as an array
            System.out.println(Arrays.toString(reader.readNext()));

            // Loop through each row in the CSV file
            while((row = reader.readNext()) != null) {
                // Extract the values from the row: ID, Name, Age, and Marks
                String id = row[0];
                String name = row[1];
                String age = row[2];
                // Parse the marks as a double value
                double marks = Double.parseDouble(row[3]);

                // If the marks are greater than 80, print the record
                if(marks > 80) {
                    // Print out the student's details with ID, Name, Age, and Marks
                    System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Mark: " + marks);
                }
            }

            // Catching exceptions related to CSV validation or I/O errors
        } catch (CsvValidationException | IOException e) {
            // If an error occurs, throw a runtime exception with the original exception
            throw new RuntimeException(e);
        }
    }
}
