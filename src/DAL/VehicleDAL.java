/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Car;
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
}
