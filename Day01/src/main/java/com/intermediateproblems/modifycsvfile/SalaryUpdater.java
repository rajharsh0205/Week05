package com.intermediateproblems.modifycsvfile;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SalaryUpdater {
    public static void main(String[] args) throws CsvValidationException, IOException {
        //Creating csv file reader
        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day01\\src\\main\\java\\com\\intermediateproblems\\modifycsvfile\\EmployeeRecords.csv"));

        //Creating csv file writer
        CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day01\\src\\main\\java\\com\\intermediateproblems\\modifycsvfile\\updatedEmployeeRecords.csv"));
        //Creating array to store record
        String[] record;

        //Storing the header record
        String[] header = reader.readNext();

        //Writing the header to new file
        writer.writeNext(header);

        //Reading records from csv file
        //Checking if the employee belongs to IT deparment
        while((record = reader.readNext()) != null) if (record[2].equalsIgnoreCase("IT")) {

            //Increasing the salary (by 10%) of employee belongs to IT department
            record[3] = String.valueOf(((Double.parseDouble(record[3])) * 110) / 100);

            writer.writeNext(record);
        }
        //Closing the csv writer
        writer.close();

        System.out.println("Successfully updated salary.....");
    }
}
