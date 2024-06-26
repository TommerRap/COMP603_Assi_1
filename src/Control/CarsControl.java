/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import DAL.DatabaseHelper;
import DAL.VehicleDAL;
import Models.ElectricVehicle;
import Models.FuelCar;
import Models.HybridVehicle;
import Models.Vehicle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tomme
 */
public class CarsControl {
    VehicleDAL dal = new VehicleDAL();
    
    public void setUnavailable(Vehicle car){
        dal.setUnavailable(car);
    }
    
    public void passinHybrid(HybridVehicle hv){
        if(dal.isExist(hv.getId())){
            dal.updateHybrid(hv);

        }else{
            dal.createHybrid(hv);
        }
    

}
    
    public void passInFuelCar(FuelCar car){
        if(dal.isExist(car.getId())){
            dal.updateFuelCar(car);
        }else{
            dal.createFuelCar(car);
        }
    }
    
    public void passInEV(ElectricVehicle ev){
        if(dal.isExist(ev.getId())){
            dal.updateEV(ev);
        }else{
            dal.createEV(ev);
        }
    }
    
    public ArrayList<Vehicle> getAllCars() throws SQLException{
        ArrayList<Vehicle> list = new ArrayList();
        ResultSet rs = dal.getAllCars();
        while(rs.next()){
            Vehicle car = new Vehicle(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getInt(4),rs.getFloat(7),rs.getBoolean(6));
            list.add(car);
        }
        rs.getStatement().close();
        return list;
    }
    
    public ArrayList<Vehicle> getAllEV() throws SQLException{
        ArrayList<Vehicle> list = new ArrayList();
        ResultSet rs = dal.getAllEVs();
        while(rs.next()){
            Vehicle car = new Vehicle(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getInt(4),rs.getFloat(7),rs.getBoolean(6));
            list.add(car);
        }
                rs.getStatement().close();

        return list;
    }
    
    public ArrayList<Vehicle> getAllHybrid() throws SQLException{
        ArrayList<Vehicle> list = new ArrayList();
        ResultSet rs = dal.getAllHybrid();
        while(rs.next()){
            Vehicle car = new Vehicle(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getInt(4),rs.getFloat(7),rs.getBoolean(6));
            list.add(car);
        }
                rs.getStatement().close();

        return list;
    }
    
    public ArrayList<Vehicle> getAllFuel() throws SQLException{
        ArrayList<Vehicle> list = new ArrayList();
        ResultSet rs = dal.getAllFuel();
        while(rs.next()){
            Vehicle car = new Vehicle(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getInt(4),rs.getFloat(7),rs.getBoolean(6));
            list.add(car);
        }
                rs.getStatement().close();

        return list;
    }
    
    public ArrayList<Vehicle> searchForCar(String keyWord) throws SQLException{
        ArrayList<Vehicle> list = new ArrayList();
        ResultSet rs = dal.searchForCar(keyWord);
        if(rs!=null){
            while(rs.next()){
            Vehicle car = new Vehicle(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getInt(4),rs.getFloat(7),rs.getBoolean(6));
            list.add(car);
            }
            return list;
        }
                rs.getStatement().close();

        return null;
    }
    
    public  boolean isExist(int id){
        return dal.isExist(id);
    }
    
    public int generateID(){
        return 10000+DatabaseHelper.getDataCount("VEHICLES")+1;
    }
    
}
