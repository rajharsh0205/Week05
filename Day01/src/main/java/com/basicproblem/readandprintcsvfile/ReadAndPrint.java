package com.basicproblem.readandprintcsvfile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndPrint {
    public static void main(String[] args) {
        // Declare a CSVReader object to handle reading the CSV file
        CSVReader csvReader;

        try {
            // Initialize the CSVReader with the path to the CSV file
            // The file path here points to a student details CSV
            csvReader = new CSVReader(new FileReader("src/main/java/com/basicproblem/readandprintcsvfile/student_details.csv"));

            // Array to store a line from the CSV file
            String[] lines;

            // Read each line of the CSV file and process it
            while((lines = csvReader.readNext()) != null) {
                // Print out the values of each field in the line
                // Assuming each line contains ID, Name, Age, and Marks
                System.out.println("ID: " + lines[0] + ", Name: " + lines[1] + ", Age: " + lines[2] + ", Marks: " + lines[3]);
            }

            // Catching any exceptions during CSV reading or I/O operations
        } catch (CsvValidationException | IOException e) {
            // If an error occurs, print the stack trace for debugging
            e.printStackTrace();
        }
    }
}