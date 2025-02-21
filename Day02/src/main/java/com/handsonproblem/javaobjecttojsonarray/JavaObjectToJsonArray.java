package com.handsonproblem.javaobjecttojsonarray;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int rollNo;
    private int age;
    private int phone;

    public Student(String name, int rollNo, int age, int phone) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
        this.phone = phone;
    }

    // Getter and Setter methods

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getRollNo() { return rollNo; }
    public void setRollNo(int rollNo) { this.rollNo = rollNo; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getPhone() { return phone; }
    public void setPhone(int phone) { this.phone = phone; }
}

public class JavaObjectToJsonArray {
    public static void main(String[] args){
        try{

            List<Student> stuArr = new ArrayList<>();

            // Adding student objects to the list
            stuArr.add(new Student("Pradeep", 2, 43, 03463));
            stuArr.add(new Student("Rahul", 3, 73, 4745));
            stuArr.add(new Student("Aman", 5, 34, 6874));
            stuArr.add(new Student("Deep", 26, 23, 046763));

            // Creating ObjectMapper instance to convert Java objects to JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Convert the list of students to a formatted JSON array string
            String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stuArr);

            // Print the JSON array
            System.out.println(jsonArray);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
