package com.handsonproblem.mergetwojsonfile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class MergeJsonfFile {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON files
            JsonNode json1 = objectMapper.readTree(new File("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day02\\src\\main\\java\\com\\handsonproblem\\mergetwojsonfile\\file1.json"));
            JsonNode json2 = objectMapper.readTree(new File("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day02\\src\\main\\java\\com\\handsonproblem\\mergetwojsonfile\\file2.json"));

            // Merge JSON objects
            JsonNode mergedJson = mergeJson(json1, json2);

            // Print merged JSON
            System.out.println("Merged JSON:\n" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JsonNode mergeJson(JsonNode mainNode, JsonNode updateNode) {
        if (!mainNode.isObject() || !updateNode.isObject()) {
            return mainNode; // If not objects, return as is
        }
        Iterator<Map.Entry<String, JsonNode>> it;
        // Merge two JSON objects
        for ( it = updateNode.fields(); it.hasNext(); ) {
            Map.Entry<String, JsonNode> entry = it.next();
            ((ObjectNode) mainNode).set(entry.getKey(), entry.getValue());
        }

        return mainNode;
    }
}