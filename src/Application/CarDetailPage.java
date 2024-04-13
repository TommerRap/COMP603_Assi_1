package Application;

import Models.Car;
import Util.CarIOUtil;
import Util.Util;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarDetailPage {
    public static void carDetail(Car car){
            Util.clearScreen();
            System.out.println("---------------------------");
            System.out.println(" | Database ID:" + car.getID());
            System.out.println(" | Make:" + car.getMake());
            System.out.println(" | Model:" + car.getModel());
            System.out.println(" | Year:" + car.getYear());
            System.out.println(" | Licence:" + car.getLicence());
            System.out.println(" | Fuel Type:" + car.getFuel());
            System.out.println(" | Price:" + car.getPrice());
            System.out.println("---------------------------");

            System.out.println("Please select your next action:");
            System.out.println("d: Delete this car");
            System.out.println("Any other keys: exit to previous Page");
            System.out.print("Your input:");
            Scanner sc = new Scanner(System.in);
            char sel = ' ';
            try{ sel = sc.nextLine().charAt(0);}catch (Exception e){}
            switch (sel){
                case 'd':
                    CarIOUtil IO = new CarIOUtil();
                    IO.deleteCar(car);
                    break;
                default:
                    break;
            }
    }
}
