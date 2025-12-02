/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cpit251_aargroup4_careonequeuesystem;

import java.util.ArrayList;
import java.util.List;

// Customer class stores customer information and the list of the cars they have
public class Customer {
    private String fullName;
    private String customerPhone;
    private List<Car> cars;

    public Customer(String fullName, String customerPhone){
        this.fullName = fullName;
        this.customerPhone = customerPhone;
        this.cars = new ArrayList<>();
    }

    //Getters
    public String getFullName() { return fullName; }
    public String getCustomerPhone() { return customerPhone; }
    public List<Car> getCars() { return cars; }

    // Add car to customer and checks customer phoneNo if matching
    public boolean addCar(Car car){
        if (car.getOwnerPhone().equals(this.customerPhone)) {
            if (!cars.contains(car)) {
                cars.add(car);
                return true;
            }
        }
        return false;
    }

    // Remove a car from customer's list
    public boolean deleteCar(Car car){
        return cars.remove(car);
    }

    @Override
    public String toString(){
        return fullName + " (" + customerPhone + ")";
    }
}
