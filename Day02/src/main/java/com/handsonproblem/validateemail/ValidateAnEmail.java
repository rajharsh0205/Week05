package com.handsonproblem.validateemail;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import java.io.File;
import java.io.IOException;
public class ValidateAnEmail {
    public static void main(String[] args) {
     try{
         ObjectMapper objectMapper = new ObjectMapper();
         // Load JSON Schema
         JsonNode schemaNode = objectMapper.readTree(new File("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day02\\src\\main\\java\\com\\handsonproblem\\validateemail\\user-schema.json"));
         JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
         JsonSchema schema = factory.getJsonSchema(schemaNode);
         // Load JSON Data
         JsonNode jsonData = objectMapper.readTree(new File("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day02\\src\\main\\java\\com\\handsonproblem\\validateemail\\user.json"));
         // Validate JSON
         for(JsonNode node: jsonData){
             System.out.println(node);
             if (schema.validate(node).isSuccess()) {
                 System.out.println("JSON is valid!");
             } else {
                 System.out.println("Invalid JSON!");
             }
         }
     }catch (IOException | ProcessingException e){
         e.printStackTrace();
     }

    }
}

