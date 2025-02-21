package com.practiceproblem.validateJSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

class Person {
    private String name;
    private int age;

    // Default constructor (required by Jackson for JSON deserialization)
    public Person() {}

    // Getter and Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}

public class ValidateJSON {
    public static void main(String[] args) {

        File jsonFile = new File("C:\\Users\\rajha\\OneDrive\\Desktop\\CG_Java\\Week05\\Day02\\src\\main\\java\\com\\practiceproblem\\validateJSON\\person.json");

        // Validate the JSON structure and print the result
        System.out.println(isValidJsonStructure(jsonFile, Person.class));
    }

    public static boolean isValidJsonStructure(File file, Class<?> clz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Attempt to deserialize the JSON file into the provided Java class
            objectMapper.readValue(file, clz);
            return true; // JSON is valid
        } catch (IOException e) {
            return false; // JSON is invalid
        }
    }
}
