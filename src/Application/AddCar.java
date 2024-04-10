package Application;

import Models.Car;
import Util.Util;
import Util.AddCarIOUtil;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class AddCar {
    public static void addPage(){
        Set<Car> cars = new HashSet();

        //Loop for the add car page
        while(true) {
            Scanner sc = new Scanner(System.in);
            Util.clearScreen();
            System.out.println("Please fill in details as instructed:");
            cars.add(addCar()); //Car added to the Set.
            int sel = 0;

            //Loop for the next action page
            while(true){
                Util.clearScreen();
                System.out.println("----------------------------------------");
                System.out.println("| There are "+cars.size()+" car(s) in the list.       |");
                System.out.println("|                                       |");
                System.out.println("| Please Select yout next action:       |");
                System.out.println("| 1. Add Another Car                    |");
                System.out.println("| 2. Finish and return to Main Menu     |");
                System.out.println("----------------------------------------");
                System.out.println("Please Select:");
                try {
                    sel = sc.nextInt();
                    if(sel!= 1 && sel != 2){
                        Util.invalidInput("Your selection does not match with the options!");
                        continue;
                    }
                }catch (InputMismatchException e){
                        sc.next();
                        Util.invalidInput("Your input is not a number!");
                        continue;
                    }
                break;
            }
            if(sel == 1) {
                continue;
            }else{
                AddCarIOUtil IO = new AddCarIOUtil(cars);
                IO.start();
                System.out.print("Processing");
                while (!IO.IOready){
                    Util.wait(300);
                    System.out.print(".");
                }
                System.out.println("\nSuccessful! " +cars.size() + " cars has been added.");
                Util.wait(1000);
                System.out.println("Redirecting you to the main menu.");
                Util.wait(3000);
                break ;
            }
        }
    }

    /**
     * This is the procedure with CUI, to set up a new Car Object with its variables(except ID pending generated)
     * @return Car Object with variables form user input
     */
    public static Car addCar(){
        Scanner sc = new Scanner(System.in);

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
            try{
                System.out.print("| Price:");
                car.setPrice(String.valueOf(sc.nextDouble()));

            break;
            }catch (InputMismatchException e){
                sc.next(); // Clear sc buffer
                Util.wait(500);
                System.out.println("| Invalid Price! Try again.");
                Util.wait(700);
            }
        }
        System.out.println("----------------------------------------");
        return car;
    }


}
