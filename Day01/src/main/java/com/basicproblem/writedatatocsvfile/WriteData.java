package com.basicproblem.writedatatocsvfile;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class WriteData {
    public static void main(String[] args) {
        try(CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day01\\src\\main\\java\\com\\basicproblem\\writedatatocsvfile\\employee_details.csv"))) {
            String[] header = {"ID","Name","Department","Salary"};
            String[] emp1 = {"56","Harsh Raj","IT","100000"};
            String[] emp2 = {"86","Nikhil Saha","BDE","50000"};
            String[] emp3 = {"94","Nishant Kumar Bharti","Sales","30000"};
            String[] emp4 = {"129","Purvansh Sharma", "IT","100000"};
            String[] emp5 = {"130","Pushkar Gupta","Sales","30000"};

            writer.writeNext(header);
            writer.writeNext(emp1);
            writer.writeNext(emp2);
            writer.writeNext(emp3);
            writer.writeNext(emp4);
            writer.writeNext(emp5);

            System.out.println("CSV file written successfully using OpenCSV!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
