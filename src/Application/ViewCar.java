package Application;
import Models.Car;
import Util.Util;
import Util.ViewCarIOUtil;

import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ViewCar {
    public static void viewCars(int carsPerPage) {
        Scanner sc = new Scanner(System.in);
        ViewCarIOUtil IO = new ViewCarIOUtil();
        ArrayList<Car> cars = IO.getAllCars();
        int totalCars = cars.size();
        int currentPage = 1;
        int totalPage = 0;
        char stat = ' ';
        if(totalCars%carsPerPage!=0){
            if(totalCars/carsPerPage==0){
                totalPage=totalCars/carsPerPage+2;
            }else{
            totalPage=totalCars/carsPerPage+1;}
        }else{
            totalPage= totalCars/carsPerPage;
        }
        while(true) {
            Util.clearScreen();
            System.out.println("-------------------------------------------------------------------------");
            System.out.println(" |    Total Cars:" + totalCars);
            System.out.println(" |    Page " + currentPage + " of " + totalPage);
            System.out.println("-------------------------------------------------------------------------");
            for(int j = 0;j<carsPerPage;j++){
                int i = (currentPage-1)*carsPerPage+j;
                if(i<cars.size()){
                    System.out.println(" | " + (j+1)+ "  |  ID:" + cars.get(i).getID() + "  |" + cars.get(i).getYear() + " " + cars.get(i).getMake() + " " + cars.get(i).getModel() + "|" + cars.get(i).getFuel() + "|");
                    System.out.println("-------------------------------------------------------------------------");
                }
            }
            while (true) {
                System.out.println("Please choose your next action:");
                System.out.println("r: Return to Main Menu");
                if (currentPage < totalPage) {
                    System.out.println("n: Next Page");
                }
                if (currentPage != 1)
                    System.out.println("p: Previous Page");
                System.out.print("Your Input:");
                char input = ' ';
                try {
                    input = sc.next().charAt(0);
                } catch (IndexOutOfBoundsException e) {
                    Util.invalidInput("Your input is more than 1 character!");
                    continue;
                }
                switch (input) {
                    case 'r':
                        System.out.println("r");
                        break;
                    case 'n':
                        if (currentPage < totalPage) {
                            currentPage++;
                            stat='n';
                            break;
                        } else {
                            Util.invalidInput("There is no next page!");
                            continue;
                        }
                    case 'p':
                        System.out.println("p");
                        break;
                }
                break;
            }
            if (stat == 'n') {
                continue;
            } else if (stat == 'r') {
                break;

            }
        }
        Util.pressToContinue();
    }


}
