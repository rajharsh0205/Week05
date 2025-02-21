package com.practiceproblem.convertjavaobject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


class Car{
    String model;
    String brand;
    double average;

    public Car(String model, String brand, double average) {
        this.model = model;
        this.brand = brand;
        this.average = average;
    }

    //getter and setter
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
public class ConvertJavaObject {

    public static void main(String[] args) {
        try{
            //object mapper object
            ObjectMapper objectMapper = new ObjectMapper();
            //creating car class object
            Car car = new Car("XUV700","Mahindra",12.5);
            String jsonString = objectMapper.writeValueAsString(car);
            System.out.println(jsonString);
        }catch ( JsonProcessingException e){
            e.printStackTrace();
        }
    }
}
