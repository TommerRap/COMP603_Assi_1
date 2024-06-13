/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.ElectricVehicle;
import Models.FuelCar;
import Models.HybridVehicle;
import Models.Vehicle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tommer & Jason
 */
public class VehicleDAL {
    //public ResultSet
    
    public void setUnavailable(Vehicle car){
        try{
             DatabaseHelper db = new DatabaseHelper();
            Statement statement = db.getConnection().createStatement();
            String query = "UPDATE VEHICLES SET AVAILABILITY = false WHERE VEHICLE_ID = " + car.getId(); //Fuel specific Updates
            statement.executeUpdate(query);
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ResultSet searchForCar(String input){
        try{
                DatabaseHelper db = new DatabaseHelper();
                Statement statement = db.getConnection().createStatement();
                String query = "SELECT * FROM VEHICLES WHERE RTRIM(CHAR(VEHICLE_ID)) LIKE '%"+input+"%' OR VEHICLE_MAKE LIKE '%"+input+"%' OR VEHICLE_MODEL LIKE '%"+input+"%' OR RTRIM(CHAR(VEHICLE_YEAR)) LIKE '%"+input+"%'";
                return statement.executeQuery(query);}catch(SQLException e){e.printStackTrace();}
                return null;
    }
    
    public ResultSet getAllCars(){
        try{
         DatabaseHelper db = new DatabaseHelper();
        Statement statement = db.getConnection().createStatement();
        String query = "select * from VEHICLES";
        ResultSet rs = statement.executeQuery(query);
        return rs;
        
        }catch(SQLException e){e.printStackTrace();}
        return null;
    }
    
     public boolean isExist(int id){
        try{
        DatabaseHelper db = new DatabaseHelper();
        Statement statement = db.getConnection().createStatement();
        String query = "select * from VEHICLES where VEHICLE_ID = "+id;
        ResultSet rs = statement.executeQuery(query);
        if(rs.next()){
            statement.close();
            return true;
        }
        return false;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public ResultSet getAllEVs(){
         try{
         DatabaseHelper db = new DatabaseHelper();
        Statement statement = db.getConnection().createStatement();
        String query = "SELECT * FROM VEHICLES WHERE VEHICLE_ID IN (SELECT EV_ID FROM EV)";
        return statement.executeQuery(query);}catch(SQLException e){e.printStackTrace();}
        return null;
    }
    
    public ResultSet getAllHybrid(){
         try{
         DatabaseHelper db = new DatabaseHelper();
        Statement statement = db.getConnection().createStatement();
        String query = "SELECT * FROM VEHICLES WHERE VEHICLE_ID IN (SELECT HYBRID_VEHICLE_ID FROM HYBRIDVEHICLE)";
        return statement.executeQuery(query);}catch(SQLException e){e.printStackTrace();}
        return null;
    }
    public ResultSet getAllFuel(){
         try{
         DatabaseHelper db = new DatabaseHelper();
        Statement statement = db.getConnection().createStatement();
        String query = "SELECT * FROM VEHICLES WHERE VEHICLE_ID IN (SELECT FUEL_ID FROM FUELVEHICLE)";
        return statement.executeQuery(query);}catch(SQLException e){e.printStackTrace();}
        return null;
    }
    
    public static Vehicle getCar (int id){
        try{
        DatabaseHelper db = new DatabaseHelper();
        Statement statement = db.getConnection().createStatement();
        String query = "select * from VEHICLES where VEHICLE_ID = "+id;
        ResultSet rs = statement.executeQuery(query);
        rs.next();
        Vehicle vehicle = new Vehicle(rs.getInt(1),rs.getString("VEHICLE_MAKE"),rs.getString("VEHICLE_MODEL"),rs.getString("VEHICLE_TYPE"),rs.getInt(4),rs.getFloat("PRICE"),rs.getBoolean("AVAILABILITY"));
       
        statement.close();
        return vehicle;
        
        }catch(SQLException e){
        e.printStackTrace();}
        
        return null;
    }
    
    public static String getType(int id){
        try{
        DatabaseHelper db = new DatabaseHelper();
        Statement statement = db.getConnection().createStatement();
        String query = "select VEHICLE_TYPE from VEHICLES where VEHICLE_ID = "+id;
        ResultSet rs = statement.executeQuery(query);
        rs.next();
        String result = rs.getString("VEHICLE_TYPE");
        statement.close();
        return result;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static ElectricVehicle getEV(Vehicle car){
        try{
        DatabaseHelper db = new DatabaseHelper();
        Statement statement = db.getConnection().createStatement();
        String query = "select * from EV where EV_ID = "+car.getId();
        ResultSet rs = statement.executeQuery(query);
        rs.next();
        ElectricVehicle ev = new ElectricVehicle(rs.getInt(2),rs.getBoolean(3),rs.getInt(4),car.getId(),car.getMake(),car.getModel(),car.getYear(),car.getPrice(),car.isAvailable());
        statement.close();
        return ev;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static HybridVehicle getHybrid(Vehicle car){
        try{
            DatabaseHelper db = new DatabaseHelper();
            Statement statement = db.getConnection().createStatement();
            String query = "select * from HYBRIDVEHICLE where HYBRID_VEHICLE_ID = "+car.getId();
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            HybridVehicle hv = new HybridVehicle(rs.getInt(2),rs.getBoolean(3),car.getId(),car.getMake(),car.getModel(),car.getYear(),car.getPrice(),car.isAvailable());
            statement.close();
            return hv;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static FuelCar getFuel(Vehicle car){
            try{
            DatabaseHelper db = new DatabaseHelper();
            Statement statement = db.getConnection().createStatement();
            String query = "select * from FUELVEHICLE where FUEL_ID = "+car.getId();
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            FuelCar result = new FuelCar(rs.getFloat(2),car.getId(),car.getMake(),car.getModel(),car.getYear(),car.getPrice(),car.isAvailable());
            statement.close();
            return result;
            
            }catch(SQLException e){
                e.printStackTrace();
            }
            return null;
    }
    
    public void updateFuelCar(FuelCar car){
        try{
             DatabaseHelper db = new DatabaseHelper();
            Statement statement = db.getConnection().createStatement();
            String query = "UPDATE FUELVEHICLE SET AVERAGEFUEL = " +car.getAverageFuelConsumption() +" WHERE FUEL_ID = " + car.getId(); //Fuel specific Updates
            statement.executeUpdate(query);
            UpdateVehicle(car,statement); //General Updates
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        }
public void createFuelCar(FuelCar car){
        try{
             DatabaseHelper db = new DatabaseHelper();
            Statement statement = db.getConnection().createStatement();
            String query = "INSERT INTO FUELVEHICLE (FUEL_ID,AVERAGEFUEL) VALUES("+car.getId()+","+car.getAverageFuelConsumption()+")";
            //String query = "UPDATE FUELVEHICLE SET AVERAGEFUEL = " +car.getAverageFuelConsumption() +" WHERE FUEL_ID = " + car.getId(); //Fuel specific Updates
            statement.executeUpdate(query);
            createVehicle(car,statement); //General Updates
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void updateEV(ElectricVehicle car){
        try{
             DatabaseHelper db = new DatabaseHelper();
            Statement statement = db.getConnection().createStatement();
            String query = "UPDATE EV SET ENDURANCE = " +car.getEndurance() +", ISSUPERCHARGESUPPORTED = "+car.isSuperCharge()+",SUPERCHARGERATE = "+car.getSuperChargeRate()+" WHERE EV_ID = " + car.getId(); //EV specific Updates
            statement.executeUpdate(query);
            UpdateVehicle(car,statement); //General Updates
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        }

    public void createEV(ElectricVehicle car){
        try{
             DatabaseHelper db = new DatabaseHelper();
            Statement statement = db.getConnection().createStatement();
            String query = "INSERT INTO EV (EV_ID,ENDURANCE,ISSUPERCHARGESUPPORTED,SUPERCHARGERATE) VALUES("+car.getId()+","+car.getEndurance()+","+car.isSuperCharge()+","+car.getSuperChargeRate()+")";
            //String query = "UPDATE FUELVEHICLE SET AVERAGEFUEL = " +car.getAverageFuelConsumption() +" WHERE FUEL_ID = " + car.getId(); //Fuel specific Updates
            statement.executeUpdate(query);
            createVehicle(car,statement); //General Updates
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void updateHybrid(HybridVehicle car){
        try{
             DatabaseHelper db = new DatabaseHelper();
            Statement statement = db.getConnection().createStatement();
            String query = "UPDATE HYBRIDVEHICLE SET FUELONLYENDURANCE = " +car.getFuelOnlyEndurance() +", ISPHEV = "+car.isPlugIn()+" WHERE HYBRID_VEHICLE_ID = " + car.getId(); //EV specific Updates
            statement.executeUpdate(query);
            UpdateVehicle(car,statement); //General Updates
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void createHybrid(HybridVehicle car){
         try{
             DatabaseHelper db = new DatabaseHelper();
            Statement statement = db.getConnection().createStatement();
            String query = "INSERT INTO HYBRIDVEHICLE (HYBRID_VEHICLE_ID,FUELONLYENDURANCE,ISPHEV) VALUES("+car.getId()+","+car.getFuelOnlyEndurance()+","+car.isPlugIn()+")";
            //String query = "UPDATE FUELVEHICLE SET AVERAGEFUEL = " +car.getAverageFuelConsumption() +" WHERE FUEL_ID = " + car.getId(); //Fuel specific Updates
            statement.executeUpdate(query);
            createVehicle(car,statement); //General Updates
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    private void UpdateVehicle(Vehicle car, Statement statement){
        try{
            String query = "UPDATE VEHICLES SET VEHICLE_MAKE = '"+car.getMake()+"',VEHICLE_MODEL = '"+car.getModel()+"',VEHICLE_YEAR = "+car.getYear()+",AVAILABILITY = "+car.isAvailable()+",PRICE = "+car.getPrice()+" WHERE VEHICLE_ID = "+car.getId();
            statement.executeUpdate(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    private void createVehicle(Vehicle car, Statement statement){
        try{
            String query = "INSERT INTO VEHICLES (VEHICLE_ID,VEHICLE_MAKE,VEHICLE_MODEL,VEHICLE_YEAR,AVAILABILITY,PRICE,VEHICLE_TYPE) VALUES ("+car.getId()+",'"+car.getMake()+"','"+car.getModel()+"',"+car.getYear()+","+car.isAvailable()+","+car.getPrice()+",'"+car.getType()+"')";
            statement.executeUpdate(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    
}
