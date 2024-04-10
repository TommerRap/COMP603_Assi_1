package Models;

import java.util.HashMap;
import java.util.Map;

public class Car {
    /**
     * A Map Collection that hold all variables with their keys & values of the vehicle
     */
    private HashMap<String,String> var = new HashMap<>();

    public Car(){
        var.put("ID","Undefined");
        var.put("Make","Undefined");
        var.put("Model","Undefined");
        var.put("Year","Undefined");
        var.put("Licence","Undefined");
        var.put("Fuel","Undefined");
        var.put("Price","Undefined");
    }


    public void setID(String Id){var.put("ID",Id);}
    public String getID(){return var.get("ID");}

    public void setMake(String make){
        var.put("Make",make);
    }
    public String getMake(){return var.get("Make");}

    public void setModel(String model){
        var.put("Model",model);
    }
    public String getModel(){return var.get("Model");}

    public void setYear(String year){
        var.put("Year",year);
    }
    public String getYear(){return var.get("Year");}

    public void setLicence(String licence){
        var.put("Licence",licence);
    }
    public String getLicence(){return var.get("Licence");}

    public void setFuel(String fuel){
        var.put("Fuel",fuel);
    }
    public String getFuel(){return var.get("Fuel");}

    public void setPrice(String price){
        var.put("Price",price);
    }
    public String getPrice(){return var.get("Price");}

    public String toString(){
        return var.toString();
    }




}
