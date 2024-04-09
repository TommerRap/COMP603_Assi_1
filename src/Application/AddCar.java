package Application;

import Models.Car;
import Util.Util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddCar {
    public static void addPage(){
        while(true) {
            System.out.println("Please fill in details as instructed:");
            addCar();
        }
    }
    public static void addCar(){
        Scanner sc = new Scanner(System.in);
        Util.clearScreen();
        String temp = "";
        Car car = new Car();

        System.out.println("----------------------------------------");
        System.out.print("| Make:");

        car.setMake(sc.nextLine());

        System.out.print("| Model:");
        car.setModel(sc.nextLine());

        System.out.print("| Year:");
        car.setYear(sc.nextLine());


        System.out.print("| Licence Plate:");
        car.setLicence(sc.nextLine());


        System.out.print("| Fuel Type:");
        car.setFuel(sc.nextLine());


        while(true){
            System.out.print("| Price:");
            try{
                car.setPrice(String.valueOf(sc.nextDouble()));

            break;
            }catch (InputMismatchException e){
                System.err.println("| Invalid Price! Try again.");
                sc.next(); // Clear sc buffer
            }
        }
        System.out.println("----------------------------------------");

        System.out.println(car);
        sc.next();
    }
}
