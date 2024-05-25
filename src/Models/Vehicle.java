/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Tommer Hu 22160969
 */
abstract class Vehicle {
    
    private int id;
    private String make;
    private String model;
    private int year;
    private String licence;
    private double price;
    private boolean isSold;
    
    
    public Vehicle(int id, String make, String model, int year, String licence, double price, boolean isSold) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.licence = licence;
        this.price = price;
        this.isSold = isSold;
    }
    
    public static Vehicle getVehicleObject(String carType){
        return null;
    }
    
}
