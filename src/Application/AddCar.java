package Application;

import Models.Car;
import Util.Util;
import Util.AddCarIOUtil;

import java.util.*;

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
                System.out.print("| There ");
                if(cars.size()==1){
                    System.out.print("is 1 car in the list.           |\n");
                }else{
                    System.out.println("are "+cars.size()+" cars in the list          |");
                }
                System.out.println("|                                       |");
                System.out.println("| Please Select your next action:       |");
                System.out.println("| 1. Add Another Car                    |");
                System.out.println("| 2. Finish and return to Previous      |");
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
                System.out.println("Redirecting you to the previous section.");
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
        temp=sc.nextLine();
        if(temp.equals("")){
            car.setMake("Undefined");
        }else {
            car.setMake(temp);
        }
        temp="";

        System.out.print("| Model:");
        temp=sc.nextLine();
        if(temp.equals("")){
            car.setModel("Undefined");
        }else {
            car.setModel(temp);
        }
        temp="";



        System.out.print("| Year:");
        temp = sc.nextLine();
        if(temp.equals("")){
            car.setYear("Undefined");
        }else {
            car.setYear(temp);
        }
        temp="";


        System.out.print("| Licence Plate:");
        temp=sc.nextLine();
        if(temp.equals("")){
            car.setLicence("Undefined");
        }else {
            car.setLicence(temp);
        }
        temp="";


        System.out.print("| Fuel Type:");
        temp=sc.nextLine();
        if(temp.equals("")){
            car.setFuel("Undefined");
        }else {
            car.setFuel(temp);
        }
        temp="";


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
