package com.handsonproblem.jsontoxml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.IOException;

public class JsonToXml {
    public static void main(String[] args) {

    try{
        File jsonFile = new File("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day02\\src\\main\\java\\com\\handsonproblem\\jsontoxml\\student.json");
        // Create ObjectMapper to read JSON
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonFile);

        // Create XmlMapper to convert JSON to XML
        XmlMapper xmlMapper = new XmlMapper();

        String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        // Print XML output
        System.out.println(xml);
    }catch(IOException e){
        e.printStackTrace();
    }
    }
}
