package Application;

import Models.Car;
import Util.Util;

public class CarDetailPage {
    public static void carDetail(Car car){
        Util.clearScreen();
        System.out.println("---------------------------");
        System.out.println(" | Database ID:"+car.getID());
        System.out.println(" | Make:"+car.getMake());
        System.out.println(" | Model:" +car.getModel());
        System.out.println(" | Year:" +car.getYear());
        System.out.println(" | Licence:" +car.getLicence());
        System.out.println(" | Fuel Type:" +car.getFuel());
        System.out.println(" | Price:"+car.getPrice());
        System.out.println("---------------------------");

        System.out.println("\n-----------------------------------");
        System.out.println("|     Input Any Key to return     |");
        System.out.println("-----------------------------------");
        Util.pressToContinue();
    }
}
