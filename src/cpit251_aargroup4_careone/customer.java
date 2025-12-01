package cpit251_AARgroup4_CareOne;
import java.util.ArrayList;
import java.util.List;
public class customer {
    private String fullName;
    private String cusPhone;
    private List<car> cars;

    public customer (String fullName, String cusPhone){
    this.fullName=fullName;
    this.cusPhone=cusPhone;
    this.cars=new ArrayList<>();}
    
    public String getName(){return fullName;}
    public String getCusPhone(){return cusPhone;}
    public List<car> getCar(){return cars;} 
    public void addCarToCustomer(car car){
    if(car.getOwnerPhone().equals(this.cusPhone))
        this.cars.add(car);}
    public void deleteCustomerCar(car car){
    if(car.getOwnerPhone().equals(this.cusPhone))
        this.cars.remove(car);}
}

