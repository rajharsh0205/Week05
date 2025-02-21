package com.practiceproblem.readJSONfile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ReadJSONFile {
    public static void main(String[] args) throws IOException {

        File fr = new File("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day02\\src\\main\\java\\com\\practiceproblem\\readJSONfile\\user.json");

        // Create an instance of ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Read the JSON file and parse it into a JsonNode object
        JsonNode jsonArray = objectMapper.readTree(fr);

        // Iterate through each JSON node
        for (JsonNode jsonNode : jsonArray) {

            String name = jsonNode.has("name") ? jsonNode.get("name").asText() : "N/A";


            String email = jsonNode.has("email") ? jsonNode.get("email").asText() : "N/A";

            // Print extracted values
            System.out.println(name);
            System.out.println(email);
            System.out.println("----------------");
        }
    }
}
