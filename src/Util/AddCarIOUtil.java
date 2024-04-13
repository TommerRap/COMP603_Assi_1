package Util;

import Models.Car;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class AddCarIOUtil extends Thread{
    Set<Car> cars;
    public boolean IOready = false;

    public AddCarIOUtil(Set<Car> cars){
        this.cars=cars;
    }

    @Override
    public void run(){
        for(Car car : cars){
            try{
                car.setID(this.generateId());
                Util.resolveDataFolder();
                BufferedWriter write = new BufferedWriter(new FileWriter("./data/"+car.getID()+".txt"));
                write.write("ID:"+car.getID());
                write.write("\nMake:"+car.getMake());
                write.write("\nModel:"+car.getModel());
                write.write("\nYear:"+car.getYear());
                write.write("\nLicence Plate:"+car.getLicence());
                write.write("\nFuel Type:"+car.getFuel());
                write.write("\nPrice:"+car.getPrice());
                write.write("\nAvailable:true");
                write.close();
                this.IOready=true;
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private String generateId() throws IOException {
        int id = 10001;
        while (true) {
            try {
                BufferedReader read = new BufferedReader(new FileReader("./data/"+id + ".txt"));
                read.close();
                id++;
                continue; //if current file already exists, continue loop
            } catch (FileNotFoundException e) {
                return String.valueOf(id);
            }
        }
    }

}
