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
    
    private int endurance;   //the electric car's endurance
    private boolean superCharge;//does electric car able to supercharge
    private int superChargeRate;//electric car's superchargerate
   
    
    public ElectricVehicle(int endurance, boolean superCharge, int superChargeRate, int id, String make, String model, int year, float price, boolean isSold )
    {
        super(id, make, model, "EV",year,price, isSold);
         this.endurance=endurance;
         this.superCharge=superCharge;
         this.superChargeRate=superChargeRate;         
    }
    
    public ElectricVehicle(Vehicle car){
        super(car.getId(),car.getMake(),car.getModel(),"EV",car.getYear(),car.getPrice(),car.isAvailable()); 
        this.endurance = 0;
        this.superCharge=false;
        this.superChargeRate = 0;
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
