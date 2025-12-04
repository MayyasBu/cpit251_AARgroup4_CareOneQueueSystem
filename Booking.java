/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.careonecarui_group4;

/**
 *
 * @author Acer
 */
import java.time.LocalTime;
import java.time.LocalDate;

public class Booking {
    private final int bookingID;
    private final customer customer;
    private final car car;
    private final service service;
    private final LocalDate date;
    private final LocalTime time;
    private final double amount;
    private status statu;
    
    
   public Booking(int bookingID, customer customer, car car, service service,
                   LocalDate date, LocalTime time) {
        this.bookingID = bookingID;
        this.customer = customer;
        this.car = car;
        this.service = service;
        this.date = date;
        this.time = time;
        this.amount = calculateAmount();
        this.statu = new status(status.State.IN_QUEUE); }


    private double calculateAmount() {
        return service.getPrice(); }

    public int getBookingID() { return bookingID; }
    public customer getCustomer() { return customer; }
    public car getCar() { return car; }
    public service getService() { return service; }
    public LocalDate getDate() { return date; }
    public LocalTime getTime() { return time; }
    public double getAmount() { return amount; }
    public status getStatus() { return statu; }
    public void setStatus(status.State s) { this.statu.setState(s); }

    public String getSummary() {
        return "BookingID: " + bookingID +
               "\nCustomer: " + customer.getFullName() + " (" + customer.getCustomerPhone() + ")" +
               "\nCar: " + car.toString() +
               "\nService: " + service.getServiceName() + " (" + service.getPrice() + " SR)" +
               "\nDate: " + date + " Time: " + time +
               "\nAmount: " + amount + " SR" +
               "\nStatus: " + statu.toString(); }
                                                                                          }