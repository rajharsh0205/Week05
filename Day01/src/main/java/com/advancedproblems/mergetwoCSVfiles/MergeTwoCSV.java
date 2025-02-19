package com.advancedproblems.mergetwoCSVfiles;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MergeTwoCSV {
    public static void main(String[] args) {
        String file1 = "C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day01\\src\\main\\java\\com\\advancedproblems\\mergetwoCSVfiles\\student1.csv";
        String file2 = "C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day01\\src\\main\\java\\com\\advancedproblems\\mergetwoCSVfiles\\student2.csv";
        String outputFile = "C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day01\\src\\main\\java\\com\\advancedproblems\\mergetwoCSVfiles\\merged_student.csv";

        // Maps to store data based on ID
        Map<String, String[]> students1 = new HashMap<>(); // Contains ID, Name, Age
        Map<String, String[]> students2 = new HashMap<>(); // Contains ID, Marks, Grade

        try {
            // Read students1.csv (ID, Name, Age)
            try {
                CSVReader reader = new CSVReader(new FileReader(file1));
                String[] header = reader.readNext(); // Skip header
                String[] nextLine;
                while ((nextLine = reader.readNext()) != null) {
                    students1.put(nextLine[0], nextLine); // Key by ID
                }
            }catch (IOException e){
                e.printStackTrace();
            }

            // Read students2.csv (ID, Marks, Grade)
            try (CSVReader reader = new CSVReader(new FileReader(file2))) {
                String[] header = reader.readNext(); // Skip header
                String[] nextLine;
                while ((nextLine = reader.readNext()) != null) {
                    students2.put(nextLine[0], nextLine); // Key by ID
                }
            }catch (IOException e){
                e.printStackTrace();
            }

            // Create the merged output file (merged_students.csv)
            try {
                CSVWriter writer = new CSVWriter(new FileWriter(outputFile));
                // Write the header for the merged file
                writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});

                // Merge the data from both files
                for (String id : students1.keySet()) {
                    if (students2.containsKey(id)) {
                        String[] student1 = students1.get(id);
                        String[] student2 = students2.get(id);

                        // Create a merged row: ID, Name, Age, Marks, Grade
                        String[] mergedRow = new String[]{
                                id,
                                student1[1], // Name
                                student1[2], // Age
                                student2[1], // Marks
                                student2[2]  // Grade
                        };

                        // Write the merged row to the output file
                        writer.writeNext(mergedRow);
                    }
                }
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }

            System.out.println("Merged file created: " + outputFile);


        } catch (CsvValidationException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

