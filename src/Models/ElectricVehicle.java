/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Qijia Yuan 22176238
 */
public class ElectricVehicle extends Vehicle {
    
    private int endurance;   
    private boolean superCharge;
    private int superChargeRate;
   
    
    public ElectricVehicle(int endurance, boolean superCharge, int superChargeRate, int id, String make, String model, int year, String licence, double price, boolean isSold )
    {
        super(id, make, model, year, licence, price, isSold);
         this.endurance=endurance;
         this.superCharge=superCharge;
         this.superChargeRate=superChargeRate;         
    }
 
    public int getEndurance()
    {
        return endurance;
    }
    
    public boolean isSuperCharge()
    {
        return superCharge;
    }
    
    public int getSuperChargeRate()
    {
        return superChargeRate;
    }
    
    public void setEndurance(int endurance)
    {
        this.endurance=endurance;
        
    }
    
    public void setSuperCharge(boolean superCharge)
    {
        this.superCharge=superCharge;
    }
    public void setSuperChargeRate(int superChargeRate)
    {
        this.superChargeRate=superChargeRate;
    }
    
}
