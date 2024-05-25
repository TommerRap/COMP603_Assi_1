/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Qijia Yuan 22176238
 */
public class HybridVehicle extends Vehicle{
    private boolean fuelOnlyEndurance;//does this hybridcar support fuelonly endurance
    private boolean plugIn;//does this hybrid car support both fuel and elecrtric endurance
    
     public HybridVehicle(boolean fuelOnlyEndurance, boolean plugIn, int id, String make, String model, int year, String licence, double price, boolean isSold )
    {
        super(id, make, model, year, licence, price, isSold);
        this.fuelOnlyEndurance=fuelOnlyEndurance;
        this.plugIn=plugIn;
    }
    
     
     
     
     public boolean isPlugIn()
     {
         return plugIn;
     }
    
     public boolean isFuelOnlyEndurance()
     {
         return fuelOnlyEndurance;
     }
     
     public void setPlugIn(boolean plugIn)
     {
         this.plugIn=plugIn;
     }
     public void setFuelOnlyEndurance()
     {
         this.fuelOnlyEndurance=fuelOnlyEndurance;
     }
}


