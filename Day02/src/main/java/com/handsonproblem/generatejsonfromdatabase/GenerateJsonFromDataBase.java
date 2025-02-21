package com.handsonproblem.generatejsonfromdatabase;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.sql.*;

public class GenerateJsonFromDataBase {
    public static void main(String[] args) {
        // Database connection details
        String url = "";
        String user = "harsh";
        String password = "password";

        // Query to fetch records
        String query = "SELECT id, name, department, salary FROM employees";

        // Path to save JSON file
        String jsonFilePath = "";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Create Jackson JSON Mapper
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode jsonArray = objectMapper.createArrayNode();

            // Get column names dynamically
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Process result set and convert to JSON
            while (rs.next()) {
                ObjectNode jsonObject = objectMapper.createObjectNode();
                for (int i = 1; i <= columnCount; i++) {
                    jsonObject.put(metaData.getColumnName(i), rs.getString(i));
                }
                jsonArray.add(jsonObject);
            }

            // Write JSON to file
            objectMapper.writeValue(new File(jsonFilePath), jsonArray);

            System.out.println("JSON report generated successfully: " + jsonFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
