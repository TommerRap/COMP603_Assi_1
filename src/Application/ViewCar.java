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
        ArrayList<Car> currentPageCars = new ArrayList<>();
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
            currentPageCars.clear();
            Util.clearScreen();
            System.out.println("-------------------------------------------------------------------------");
            if(!cars.isEmpty()) {
                System.out.println(" |    Total Cars:" + totalCars);
                System.out.println(" |    Page " + currentPage + " of " + totalPage);
            }else{
                System.out.println(" |    THERE IS NO CAR IN THE DATABASE!");
            }
            System.out.println("-------------------------------------------------------------------------");
            for(int j = 0;j<carsPerPage;j++){
                int i = (currentPage-1)*carsPerPage+j;
                if(i<cars.size()){
                    currentPageCars.add(cars.get(i));
                    System.out.println(" | " + (j+1)+ "  |  ID:" + cars.get(i).getID() + "  |" + cars.get(i).getYear() + " " + cars.get(i).getMake() + " " + cars.get(i).getModel() + "|" + cars.get(i).getFuel() + "|");
                    System.out.println("-------------------------------------------------------------------------");
                }
            }
            while (true) {

                System.out.println("Please choose your next action:");
                System.out.println("a: Add new cars");
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
                    case 'a':
                        AddCar.addPage();
                        stat='a';
                        cars=IO.getAllCars();
                        totalCars = cars.size();
                        currentPage = 1;
                        if(totalCars%carsPerPage!=0){
                            if(totalCars/carsPerPage==0){
                                totalPage=totalCars/carsPerPage+2;
                            }else{
                                totalPage=totalCars/carsPerPage+1;}
                        }else{
                            totalPage= totalCars/carsPerPage;
                        }
                        break;
                    case 'r':
                        System.out.println("r");
                        stat='r';
                        break;
                    case 'n':
                        if (currentPage < totalPage) {
                            currentPage++;
                            stat='n';
                            break;
                        } else {
                            stat=' ';
                            Util.invalidInput("There is no next page!");
                            continue;
                        }
                    case 'p':
                        if (currentPage!=1) {
                            currentPage--;
                            stat='p';
                            break;
                        } else {
                            stat=' ';
                            Util.invalidInput("There is no previous page!");
                            continue;
                        }
                    default:
                        try{
                            int index = Integer.parseInt(input+"")-1;
                            CarDetailPage.carDetail(currentPageCars.get(index));
                            continue;
                        }catch (NumberFormatException e){
                            stat=' ';
                            Util.invalidInput("There is no such option!");
                            continue;
                        }catch (IndexOutOfBoundsException e){
                            stat=' ';
                            Util.invalidInput("There is no such car!");
                            continue;
                        }
//                        stat=' ';
//                        Util.invalidInput("There is no such option!");
//                        continue;
                }
                break;
            }
            if (stat == 'n'||stat=='p'||stat=='a') {
                continue;
            } else if (stat == 'r') {
                break;
            }
            break;
        }
    }


}
