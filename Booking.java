/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cpit251_aargroup4_careonequeuesystem;

import java.time.LocalDate;
import java.time.LocalTime;

// Booking class stores booking details: customer, car, service, date/time, amount, and status
public class Booking {
    private final int bookingID;
    private final Customer customer;
    private final Car car;
    private final Service service;
    private final LocalDate date;
    private final LocalTime time;
    private final double amount;
    private Status status;

    public Booking(int bookingID, Customer customer, Car car, Service service,
                   LocalDate date, LocalTime time) {
        this.bookingID = bookingID;
        this.customer = customer;
        this.car = car;
        this.service = service;
        this.date = date;
        this.time = time;
        this.amount = calculateAmount();
        this.status = new Status(Status.State.IN_QUEUE);
    }

    // Price calculation based on service
    private double calculateAmount() {
        return service.getPrice();
    }

    //Getters
    public int getBookingID() { return bookingID; }
    public Customer getCustomer() { return customer; }
    public Car getCar() { return car; }
    public Service getService() { return service; }
    public LocalDate getDate() { return date; }
    public LocalTime getTime() { return time; }
    public double getAmount() { return amount; }
    public Status getStatus() { return status; }
    //setter
    public void setStatus(Status.State s) { this.status.setState(s); }

    // String that generate confirmation summary
    public String getSummary() {
        return "BookingID: " + bookingID +
               "\nCustomer: " + customer.getFullName() + " (" + customer.getCustomerPhone() + ")" +
               "\nCar: " + car.toString() +
               "\nService: " + service.getServiceName() + " (" + service.getPrice() + " SR)" +
               "\nDate: " + date + " Time: " + time +
               "\nAmount: " + amount + " SR" +
               "\nStatus: " + status.toString();
    }
}