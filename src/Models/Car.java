package Models;

import java.util.HashMap;
import java.util.Map;

public class Car {
    /**
     * A Map Collection that hold all variables with their keys & values of the vehicle
     */
    private HashMap<String,String> var = new HashMap<>();

    public Car(){
        var.put("Make","");
        var.put("Model","");
        var.put("Year","");
        var.put("Licence","");
        var.put("Fuel","");
        var.put("Price","");
    }

    public void setMake(String make){
        var.put("Make",make);
    }

    public void setModel(String model){
        var.put("Model",model);
    }

    public void setYear(String year){
        var.put("Year",year);
    }

    public void setLicence(String licence){
        var.put("Licence",licence);
    }

    public void setFuel(String fuel){
        var.put("Fuel",fuel);
    }

    public void setPrice(String price){
        var.put("Price",price);
    }

    public String toString(){
        return var.toString();
    }




}
