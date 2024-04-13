package Util;

import Models.Car;

import java.io.*;
import java.util.ArrayList;

public class CarIOUtil {
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
                if(read.readLine().split(":")[1].equals("true")){
                    cars.add(car);
                }
                id++;
            }catch (FileNotFoundException e){
                break;
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return cars;
    }

    public void deleteCar(Car car){
        try {

            BufferedWriter write = new BufferedWriter(new FileWriter("./data/"+car.getID()+".txt"));
            write.write("ID:"+car.getID());
            write.write("\nMake:"+car.getMake());
            write.write("\nModel:"+car.getModel());
            write.write("\nYear:"+car.getYear());
            write.write("\nLicence Plate:"+car.getLicence());
            write.write("\nFuel Type:"+car.getFuel());
            write.write("\nPrice:"+car.getPrice());
            write.write("\nAvailable:false");
            write.close();
        }catch (IOException e){

        }
    }
}
