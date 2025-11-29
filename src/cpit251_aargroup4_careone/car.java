package cpit251_AARgroup4_CareOne;

public class car {
    private String brand;
    private String model;
    private String size;
    private String type;
    private String ownerPhone;

    public car(String brand, String model, String size, String type, String ownerPhone){
    this.brand=brand;
    this.model=model;
    this.size=size;
    this.type=type;
    this.ownerPhone=ownerPhone;}
    
    //public String getCarInfo(){return brand +" "+model+" "+size+" "+type;}
    @Override
    public String toString(){return "Car Brand=" + brand + ", Model=" + model + ", Size=" + size + ", Type=" + type ;}
    public String getOwnerPhone(){return ownerPhone;}
    
}
