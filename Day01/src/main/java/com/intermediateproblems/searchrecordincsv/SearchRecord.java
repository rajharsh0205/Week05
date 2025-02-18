package com.intermediateproblems.searchrecordincsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            CSVReader reader = new CSVReader(new FileReader("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day01\\src\\main\\java\\com\\intermediateproblems\\searchrecordincsv\\employees.csv"));

            //Creating variable EmployeeToFind to store employee name to be searched
            String employeeToFind = "Harsh";
            //Creating array to store record
            String[] record;

            //Skipping the header record
            reader.readNext();

            //Reading records from csv file
            while((record = reader.readNext()) != null) {

                //Printing department and salary if employee name is deepanshu
                if (record[1].equalsIgnoreCase(employeeToFind)) {
                    System.out.println("Employee found......");
                    System.out.println("Name: " + record[1]);
                    System.out.println("Department: " + record[2]);
                    System.out.println("Salary: " + record[3]);
                    System.out.println("------------------------------");
                }

            }
            System.out.println("File readed successfully......");

        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
