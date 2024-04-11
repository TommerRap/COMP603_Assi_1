package Util;

import Models.Car;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ViewCarIOUtil{
    public  ArrayList<Car> getAllCars(){
        ArrayList<Car> cars = new ArrayList<>();
        int id = 10001;
        while (true) {
            try {
                BufferedReader read = new BufferedReader(new FileReader("./data/"+id + ".txt"));
                Car car = new Car();
                car.setID(read.readLine().split(":")[1]);
                car.setMake(read.readLine().split(":")[1]);
                car.setModel(read.readLine().split(":")[1]);
                car.setYear(read.readLine().split(":")[1]);
                car.setLicence(read.readLine().split(":")[1]);
                car.setFuel(read.readLine().split(":")[1]);
                car.setPrice(read.readLine().split(":")[1]);
                cars.add(car);
                id++;
            }catch (FileNotFoundException e){
                break;
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return cars;
    }
}
