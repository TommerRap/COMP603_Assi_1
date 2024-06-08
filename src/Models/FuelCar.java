/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author tomme
 */
public class FuelCar extends Vehicle{
    private float averageFuelConsumption;
    
    
    public FuelCar(float averageFuelConsumption, int id, String make, String model, int year, float price, boolean isAvailable )
    {
        super(id, make, model,"Fuel",year, price, isAvailable);
         this.averageFuelConsumption=averageFuelConsumption;
    }
    
    
    public void setAverageFuelConsumption(int averageFuelConsumption)
    {
        this.averageFuelConsumption=averageFuelConsumption;
    }
    public float getAverageFuelConsumption()
    {
        return averageFuelConsumption;
    }
    
    
}
