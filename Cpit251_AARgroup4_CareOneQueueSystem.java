/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cpit251_aargroup4_careonequeuesystem;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
public class Cpit251_AARgroup4_CareOneQueueSystem {

    // Main UI class
    // Reads commands from data.txt and generates output in CareOneProject.txt
    public static void main(String[] args) throws Exception {
        File input = new File("data.txt");
        File output = new File("CareOneProject.txt");

        if (!input.exists()) {
            System.out.println("The file named " + input.getName() + " does not exist in " + input.getAbsolutePath());
            System.exit(1);
        }

        Scanner scanInput = new Scanner(input);
        PrintWriter outputFile = new PrintWriter(output);
        CareOne co = new CareOne();

        while (scanInput.hasNext()) {
            String command = scanInput.next();
            switch (command) {
                case "add_customer": {
                    String fullName = scanInput.next();
                    String cusPhone = scanInput.next();
                    Customer customer = new Customer(fullName, cusPhone);
                    outputFile.println(co.addCustomer(customer));
                    break;
                }
                case "add_car": {
                    String carBrand = scanInput.next();
                    String carModel = scanInput.next();
                    String carSize = scanInput.next();
                    String carType = scanInput.next();
                    String ownerPhone = scanInput.next();
                    Car car = new Car(carBrand, carModel, carSize, carType, ownerPhone);
                    outputFile.println(co.addCar(car));
                    break;
                }
                case "book_appointment": {
                    String cusPhone = scanInput.next();
                    String carBrand = scanInput.next();
                    String carModel = scanInput.next();
                    String carSize = scanInput.next();
                    String carType = scanInput.next();
                    int serviceID = scanInput.nextInt();
                    String date = scanInput.next();
                    String time = scanInput.next();
                    outputFile.println(co.bookAppointment(cusPhone, carBrand, carModel, carSize, carType, serviceID, date, time));
                    break;
                }
                case "display_confirmation": {
                    int bookingID = scanInput.nextInt();
                    outputFile.println(co.displayConfirmation(bookingID));
                    break;
                }
                case "status_report": {
                    String cusPhone = scanInput.next();
                    int bookingID = scanInput.nextInt();
                    outputFile.println(co.statusReport(cusPhone, bookingID));
                    break;
                }
                case "update_status": {
                    int bookingID = scanInput.nextInt();
                    String stateStr = scanInput.next();
                    Status.State s;
                    try {
                        s = Status.State.valueOf(stateStr);
                    } catch (Exception e) {
                        outputFile.println("Invalid status value: " + stateStr);
                        break;
                    }
                    outputFile.println(co.updateStatus(bookingID, s));
                    break;
                }
                default:
                    outputFile.println("Unknown command: " + command);
            }
        }

        scanInput.close();
        outputFile.flush();
        outputFile.close();
        System.out.println("Processing finished. Output -> " + output.getAbsolutePath());
    }
}
