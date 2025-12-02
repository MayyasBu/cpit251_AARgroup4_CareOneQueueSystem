/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cpit251_aargroup4_careonequeuesystem;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

// Car class is for customer's vehicles
public class Car {
    private String brand;
    private String model;
    private String size;
    private String type;
    private String ownerPhone;

    public Car(String brand, String model, String size, String type, String ownerPhone){
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.type = type;
        this.ownerPhone = ownerPhone;
    }

    // Getters
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getSize() { return size; }
    public String getType() { return type; }
    public String getOwnerPhone() { return ownerPhone; }

    @Override
    public String toString(){
        return brand + " " + model + " (" + size + ", " + type + ")";
    }
}