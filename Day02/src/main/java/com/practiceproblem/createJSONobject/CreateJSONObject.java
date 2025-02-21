package com.practiceproblem.createJSONobject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

class Student{
    String name;
    int age;
    List<String> subject;

    Student(String name, int age, List<String> subject){
        this.name = name;
        this.age = age;
        this.subject = subject;
    }
    //getter and setter
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
    }
}
public class CreateJSONObject {
    public static void main(String[] args) {
        try {

            //objectMapper object
            ObjectMapper objectMapper = new ObjectMapper();
            //creating student class object
            Student student = new Student("Aman",21, List.of("Maths","Science"));
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
            System.out.println(jsonString);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
