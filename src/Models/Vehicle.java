/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Tommer Hu 22160969
 */
public class Vehicle {
    
    private int id;
    private String make;
    private String model;
    private int year;
    private float price;
    private boolean isAvailable; 
    private String carType;

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    public void setType(String type){
        this.carType = type;
    }
    
    public String getType(){
        return this.carType;
    }
    
    
    public Vehicle(int id, String make, String model, String type, int year, float price, boolean isAvailable) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isAvailable = isAvailable;
        this.carType = type;
    }
    
    public Vehicle(int id,String type){
        this.id = id;
        this.make = "";
        this.model = "";
        this.carType = type;
        this.year = 0000;
        this.price = 0;
        this.isAvailable=true;
    }
    
    
//    public ElectricVehicle castElectric(){
//        ElectricVehicle ev = new ElectricVehicle(0,false,0,this.id,this.make,this.model,this.year,this.price,this.isAvailable);
//        return ev;
//    }
}
