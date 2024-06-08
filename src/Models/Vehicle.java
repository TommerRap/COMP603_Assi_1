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
    private boolean isSold; 
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

    public boolean isSold() {
        return isSold;
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

    public void setIsSold(boolean isSold) {
        this.isSold = isSold;
    }
    
    public void setType(String type){
        this.carType = type;
    }
    
    public String getType(){
        return this.carType;
    }
    
    
    public Vehicle(int id, String make, String model, String type, int year, float price, boolean isSold) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isSold = isSold;
        this.carType = type;
    }

}
