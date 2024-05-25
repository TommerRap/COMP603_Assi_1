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
    private int averageFuelConsumption;
    
    
    public FuelCar(int averageFuelConsumption, int id, String make, String model, int year, String licence, double price, boolean isSold )
    {
        super(id, make, model, year, licence, price, isSold);
         this.averageFuelConsumption=averageFuelConsumption;
    }
    
    
    public void setAverageFuelConsumption(int averageFuelConsumption)
    {
        this.averageFuelConsumption=averageFuelConsumption;
    }
    public int getAverageFuelConsumption()
    {
        return averageFuelConsumption;
    }
    
    
}
