package cpit251_AARgroup4_CareOne;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
public class Cpit251_AARgroup4_CareOne {

    
    public static void main(String[] args) throws Exception{
        //input and output files
        File input=new File("data.txt");
        File output=new File("CareOneProject.txt");
        //check is input file exists
        if(!input.exists()){
        System.out.println("The file named "+input.getName()+" does not exist in "+input.getAbsolutePath());
        System.exit(1);}
        //Scanner
        Scanner scanInput = new Scanner (input); 
        //printWriter 
        PrintWriter outputFile = new PrintWriter (output);
        CareOne co = new CareOne();
        
        //Variables
        String command;
        String fullName;
        String cusPhone;
        customer customer;
        String carBrand;
        String carModel;
        String carSize;
        String carType;
        String ownerPhone;
        car car;
        
        //scan input files and store information
        while(scanInput.hasNext()){
        command=scanInput.next();
        switch(command){
        case"add_customer":
            fullName=scanInput.next();
            cusPhone=scanInput.next();
            customer=new customer(fullName,cusPhone);
            outputFile.println(co.addCustomers(customer));
            break;
        case"add_car":
            carBrand=scanInput.next();
            carModel=scanInput.next();
            carSize=scanInput.next();
            carType=scanInput.next();
            ownerPhone=scanInput.next();
            car = new car(carBrand,carModel,carSize,carType,ownerPhone);
            outputFile.println(co.addCar(car));
            break;
        }}
        outputFile.println(co.testing());
        scanInput.close();
        outputFile.flush();
        outputFile.close();
    }
    
}
