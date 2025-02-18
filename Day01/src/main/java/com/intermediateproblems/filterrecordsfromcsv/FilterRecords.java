package com.intermediateproblems.filterrecordsfromcsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FilterRecords {
    public static void main(String[] args) {
        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day01\\src\\main\\java\\com\\intermediateproblems\\filterrecordsfromcsv\\student_record.csv"))) {
            String[] row;

            System.out.println(Arrays.toString(reader.readNext()));
            while((row = reader.readNext()) != null) {
                String id = row[0];
                String name = row[1];
                String age = row[2];
                double marks = Double.parseDouble(row[3]);
                if(marks > 80)
                    System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Mark: " + marks);
            }

        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
