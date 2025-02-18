package com.basicproblem.readandcountrows;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class ReadAndCount {
    public static void main(String[] args) {

        // Initialize the row count variable to 0
        int rowCount = 0;

        // Use try-with-resources to automatically close the CSVReader after the operation
        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day01\\src\\main\\java\\com\\basicproblem\\readandcountrows\\CSVfile.csv"))) {

            // Array to store each row from the CSV file
            String[] row;

            // Read each row of the CSV file
            while((row = reader.readNext()) != null) {
                rowCount++;
            }

            // Output the row count, subtracting 1 to exclude the header row
            System.out.println(rowCount - 1);

            // Catching any exceptions related to CSV validation or I/O issues
        } catch (CsvValidationException | IOException e) {
            // If an error occurs, throw a runtime exception with the original exception
            throw new RuntimeException(e);
        }
    }
}
