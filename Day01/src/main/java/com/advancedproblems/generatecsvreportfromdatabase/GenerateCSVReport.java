package com.advancedproblems.generatecsvreportfromdatabase;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GenerateCSVReport {
    public static void main(String[] args) {
        String url = "";
        String user = "harsh";
        String password = "password";
        String csvFile = "C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day01\\src\\main\\java\\com\\advancedproblems\\generatecsvreportfromdatabase\\employees_report.csv";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             FileWriter writer = new FileWriter(csvFile)) {

            String query = "SELECT id, name, department, salary FROM employees";
            ResultSet rs = stmt.executeQuery(query);

            // Writing header
            writer.append("Employee ID,Name,Department,Salary\n");

            // Writing data
            while (rs.next()) {
                writer.append(rs.getInt("id") + ",");
                writer.append(rs.getString("name") + ",");
                writer.append(rs.getString("department") + ",");
                writer.append(rs.getDouble("salary") + "\n");
            }

            System.out.println("CSV report generated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}