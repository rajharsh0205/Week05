package com.handsonproblem.convertcsvtojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvToJson {
    public static void main(String[] args) {
        // Path to CSV file
        String csvFilePath = "C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day02\\src\\main\\java\\com\\handsonproblem\\convertcsvtojson\\student.csv";

        // Path to save JSON file
        String jsonFilePath = "C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day02\\src\\main\\java\\com\\handsonproblem\\convertcsvtojson\\student.json";

        try  {
            CSVReader csvReader = new CSVReader(new FileReader(csvFilePath));
            List<String[]> allRows = csvReader.readAll();

            // Extract header row
            String[] headers = allRows.get(0);
            List<String[]> dataRows = allRows.subList(1, allRows.size());

            // Convert CSV data to JSON format
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode jsonArray = objectMapper.createArrayNode();

            for (String[] row : dataRows) {
                ObjectNode jsonObject = objectMapper.createObjectNode();
                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i], row[i]);
                }
                jsonArray.add(jsonObject);
            }

            // Write JSON to file
            objectMapper.writeValue(new File(jsonFilePath), jsonArray);

            System.out.println("CSV converted to JSON successfully!");
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
