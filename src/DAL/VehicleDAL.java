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
 * @author tomme
 */
public class VehicleDAL {
    //public ResultSet
    
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
        return statement.executeQuery(query);}catch(SQLException e){e.printStackTrace();}
        return null;
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
        return rs.getString("VEHICLE_TYPE");
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
        return new ElectricVehicle(rs.getInt(2),rs.getBoolean(3),rs.getInt(4),car.getId(),car.getMake(),car.getModel(),car.getYear(),car.getPrice(),car.isAvailable());

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
            return new HybridVehicle(rs.getInt(2),rs.getBoolean(3),car.getId(),car.getMake(),car.getModel(),car.getYear(),car.getPrice(),car.isAvailable());
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
            return new FuelCar(rs.getFloat(2),car.getId(),car.getMake(),car.getModel(),car.getYear(),car.getPrice(),car.isAvailable());
            
            }catch(SQLException e){
                e.printStackTrace();
            }
            return null;
    }
}
