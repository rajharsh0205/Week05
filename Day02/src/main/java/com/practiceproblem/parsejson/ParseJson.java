package com.practiceproblem.parsejson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ParseJson {
    public static void main(String[] args) {
        try {

            File file = new File("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day02\\src\\main\\java\\com\\practiceproblem\\parsejson\\student.json");

            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file as an array node
            JsonNode jsonArray = objectMapper.readTree(file);

            // Iterate over the JSON array and filter students with age > 25
            System.out.println("Students with age > 25:");
            for (JsonNode node : jsonArray) {
                int age = node.get("age").asInt();
                if (age > 25) {
                    String name = node.get("name").asText();
                    // Print the filtered students in JSON format
                    System.out.println(node.toPrettyString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
