/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.cpit251_aargroup4_careonequeuesystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Test cases for: addCar(), bookAppointment(), displayConfirmation(), statusReport()
public class CareOneTest {

    private CareOne controller;

    @BeforeEach
    void setUp() {
        controller = new CareOne();

        // Add a customer
        Customer c = new Customer("Danyah", "0501234567");
        controller.addCustomer(c);

        // Add a car
        Car car = new Car("Toyota", "Corolla", "Small", "Sedan", "0501234567");
        controller.addCar(car);
    }

    @Test
    void testAddCar() {

        Car newCar = new Car("Honda", "Civic", "Small", "Sedan", "0501234567");
        String result = controller.addCar(newCar);

        assertEquals(
            "Car added to customer 0501234567: Honda Civic (Small, Sedan)",
            result
        );
    }

    @Test
    void testBookAppointment() {

        String result = controller.bookAppointment(
            "0501234567",
            "Toyota", "Corolla", "Small", "Sedan",
            1,
            "2025-12-05",
            "10:30"
        );

        assertEquals("Booking created. BookingID=1", result);
    }

    @Test
    void testDisplayConfirmation() {

        // Create a booking first
        controller.bookAppointment(
            "0501234567",
            "Toyota", "Corolla", "Small", "Sedan",
            1,
            "2025-12-05",
            "10:30"
        );

        String result = controller.displayConfirmation(1);

        assertTrue(result.contains("BookingID: 1"));
        assertTrue(result.contains("Toyota Corolla (Small, Sedan)"));
        assertTrue(result.contains("Basic Wash"));
        assertTrue(result.contains("In Queue"));
    }

    @Test
    void testStatusReport() {

        // Create a booking first
        controller.bookAppointment(
            "0501234567",
            "Toyota", "Corolla", "Small", "Sedan",
            1,
            "2025-12-05",
            "10:30"
        );

        String result = controller.statusReport("0501234567", 1);

        assertEquals("Status for booking 1: In Queue", result);
    }
}