/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Control.CarsControl;
import DAL.VehicleDAL;

/**
 *
 * @author tomme
 */
public class FuelCar extends Vehicle{
    private float averageFuelConsumption;
    
    public FuelCar(){
        super(0,"","","Fuel",0000,0,true);
    }
    
    public FuelCar(float averageFuelConsumption, int id, String make, String model, int year, float price, boolean isAvailable )
    {
        super(id, make, model,"Fuel",year, price, isAvailable);
         this.averageFuelConsumption=averageFuelConsumption;
    }
    
    public FuelCar(Vehicle car){
           super(car.getId(),car.getMake(),car.getModel(),"Fuel",car.getYear(),car.getPrice(),car.isAvailable()); 
           this.averageFuelConsumption = 0;
    }
    
    public void setAverageFuelConsumption(float averageFuelConsumption)
    {
        this.averageFuelConsumption=averageFuelConsumption;
    }
    public float getAverageFuelConsumption()
    {
        return averageFuelConsumption;
    }
    
    
}
