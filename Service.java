/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cpit251_aargroup4_careonequeuesystem;

// Service class represents one car wash service type
public class Service {
    private int serviceID;
    private String serviceName;
    private double price;

    public Service(int serviceID, String serviceName, double price) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.price = price;
    }

    //Getters
    public int getServiceID() { return serviceID; }
    public String getServiceName() { return serviceName; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return serviceName + " (ID:" + serviceID + ", " + price + " SR)";
    }
}
