package com.mycompany.cpit251_aargroup4_careonequeuesystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

// CareOne class is the system controller
public class CareOne {
    private final List<Customer> customers;
    private final List<Booking> bookings;
    private final List<Service> services;
    private int nextBookingId = 1;

    public CareOne() {
        this.customers = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.services = new ArrayList<>();
        loadDefaultServices();
    }

    // loads service list
    private void loadDefaultServices() {
        // Services
        services.add(new Service(1, "Basic Wash", 20.0));
        services.add(new Service(2, "Interior Cleaning", 35.0));
        services.add(new Service(3, "Full Wash & Wax", 60.0));
    }

    // method that adds a customer
    public String addCustomer(Customer c) {
        // if customer already exists print a message that they already exist
        if (findCustomerByPhone(c.getCustomerPhone()) != null) {
            return "Customer already exists: " + c.getCustomerPhone();
        }
        // else add customer to the list and print "customer added"
        else{
        customers.add(c);
        return "Customer added: " + c.getFullName() + " (" + c.getCustomerPhone() + ")";
        }
    }

    // method that adds a car
    public String addCar(Car car) {
        // find the customer by car's owner phone
        Customer owner = findCustomerByPhone(car.getOwnerPhone());
        
        // if customer doesn't exist, car can't be added
        if (owner == null) {
            return "No customer found with phone " + car.getOwnerPhone() + ". Add customer first.";
        }
        
        // adding car attempt. Boolean if added is True or false, and based on it the message will be sent
        boolean added = owner.addCar(car);
        return added ? "Car added to customer " + owner.getCustomerPhone() + ": " + car.toString()
                     : "Car already exists or doesn't match owner phone.";
    }

    // books an appointment for a customer
    public String bookAppointment(String customerPhone,
                                  String carBrand, String carModel, String carSize, String carType,
                                  int serviceID,
                                  String dateStr, String timeStr) {
        
        // check if customer exists
        Customer c = findCustomerByPhone(customerPhone);
        if (c == null) return "Customer not found with phone: " + customerPhone;

        // find the car among the customer's cars
        Car chosenCar = null;
        for (Car car : c.getCars()) {
            // matching attributes
            if (car.getBrand().equalsIgnoreCase(carBrand) &&
                car.getModel().equalsIgnoreCase(carModel) &&
                car.getSize().equalsIgnoreCase(carSize) &&
                car.getType().equalsIgnoreCase(carType)) {
                chosenCar = car;
                break; // break if it matches
            }
        }
        // if car was not found
        if (chosenCar == null) return "Car not found for customer. Make sure car was added.";

        // find the service by serviceID
        Service svc = findServiceById(serviceID);
        if (svc == null) return "Service not found with ID: " + serviceID;

        LocalDate date;
        LocalTime time;
        try {
            date = LocalDate.parse(dateStr);   // expects YYYY-MM-DD
            time = LocalTime.parse(timeStr);   // expects HH:MM
        } catch (Exception e) {
            return "Invalid date/time format. Use YYYY-MM-DD and HH:MM (24h).";
        }

        // new booking id is generated
        int id = nextBookingId++;
        Booking booking = new Booking(id, c, chosenCar, svc, date, time);
        //adds booking to the list
        bookings.add(booking);
        return "Booking created. BookingID=" + id;
    }

    // returns a detailed summary of the booking
    public String displayConfirmation(int bookingID) {
        // find booking by id
        Booking b = findBookingById(bookingID);
        // if booking not found
        if (b == null) return "No booking found with ID " + bookingID;
        // else return summary
        return b.getSummary();
    }

    // returns current status of a booking
    public String statusReport(String customerPhone, int bookingID) {
        // find booking by id
        Booking b = findBookingById(bookingID);
        if (b == null) return "No booking found with ID " + bookingID;
        // to make sure booking belongs to the customer requesting the status
        if (!b.getCustomer().getCustomerPhone().equals(customerPhone)) {
            return "Booking does not belong to customer " + customerPhone;
        }
        return "Status for booking " + bookingID + ": " + b.getStatus().toString();
    }

    // Admin method to update the status
    public String updateStatus(int bookingID, Status.State newState) {
        // find booking by id
        Booking b = findBookingById(bookingID);
        if (b == null) return "No booking found with ID " + bookingID;
        // update status
        b.setStatus(newState);
        return "Booking " + bookingID + " updated to " + b.getStatus().toString();
    }

    //.................. Helper methods ..............
    
    
    private Customer findCustomerByPhone(String phone) {
        for (Customer c : customers) if (c.getCustomerPhone().equals(phone)) return c;
        return null;
    }

    private Booking findBookingById(int id) {
        for (Booking b : bookings) if (b.getBookingID() == id) return b;
        return null;
    }

    private Service findServiceById(int id) {
        for (Service s : services) if (s.getServiceID() == id) return s;
        return null;
    }
}