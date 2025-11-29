package cpit251_AARgroup4_CareOne;
import java.util.ArrayList;
import java.util.List;

public class CareOne {
    private ArrayList<customer> list = new ArrayList();
    public String addCustomers(customer customer){
        list.add(customer);
        return "Customer "+customer.getName()+" added.";}
    
    private customer findCustomerByPhone(String phone){
        for(customer customer:list){
            if(customer.getCusPhone().equals(phone))
                return customer;} 
        return null;}
    
    public String addCar(car car){
    customer customer = findCustomerByPhone(car.getOwnerPhone());
    customer.addCarToCustomer(car);
    return "car added to "+ customer.getName()+" profile successfully.";}
    
    public static void bookAppointment(){}
    public static void displayConfimation(){}
    public static void statusReport(){}
    
    public String testing(){ //can be removed
        StringBuilder report = new StringBuilder();
        for (customer customer:list){
            report.append(customer.getName()+"\n");
            report.append(customer.getCar()+"\n");}
        return "testing\n"+report.toString();}

    
}
