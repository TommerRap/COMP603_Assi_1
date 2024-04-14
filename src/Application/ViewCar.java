package Application;
import Models.Car;
import Util.Util;
import Util.CarIOUtil;

import java.util.*;

public class ViewCar {
    public static void viewCars(int carsPerPage) {
        Scanner sc = new Scanner(System.in);
        CarIOUtil IO = new CarIOUtil(); //init IO Util
        ArrayList<Car> cars = IO.getAllCars(); //store all Cars in ArrayList<> cars
        ArrayList<Car> currentPageCars = new ArrayList<>(); //register a new arrayList for current page cats.
        int totalCars = cars.size();
        int currentPage = 1;
        char stat = ' ';//init input status
        int totalPage = getTotalPage(carsPerPage, totalCars); //get total page
        while(true) {
            currentPageCars.clear(); //reassign currentPage cars
            Util.clearScreen();
            System.out.println("-------------------------------------------------------------------------");
            if(!cars.isEmpty()) {//output if there are cars
                System.out.println(" |    Total Cars:" + totalCars);
                System.out.println(" |    Page " + currentPage + " of " + totalPage);
            }else{//output if there is no car.
                System.out.println(" |    THERE IS NO CAR IN THE DATABASE!");
            }
            System.out.println("-------------------------------------------------------------------------");
            for(int j = 0;j<carsPerPage;j++){
                //j is the index for the current page.

                //i is the index for the overall car ArrayList.
                int i = (currentPage-1)*carsPerPage+j;//calculate the corresponding index for the overall cars ArrayList accroding to j value.

                if(i<cars.size()){//iterate all cars
                    currentPageCars.add(cars.get(i));
                    System.out.println(" | No." + (j+1)+ "  |  ID:" + cars.get(i).getID() + "  |" + cars.get(i).getYear() + " " + cars.get(i).getMake() + " " + cars.get(i).getModel() + "|" + cars.get(i).getFuel() + "|");
                    System.out.println("-------------------------------------------------------------------------");
                }
            }

                System.out.println("Please choose your next action:");
            if(cars.size()!=0) {
                System.out.print("\nNumber 1");
                if (currentPageCars.size() > 1) {
                    System.out.print("-" + currentPageCars.size() + " : View Car Detail\n");
                } else {
                    System.out.print(" : View Car Detail\n");
                }
            }
                System.out.println("a: Add new cars");
                System.out.println("r: Return to Main Menu");
                if (currentPage < totalPage) {
                    System.out.println("n: Next Page");
                }
                if (currentPage != 1)
                    System.out.println("p: Previous Page");
                System.out.print("\nYour Input:");
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
                        totalPage = getTotalPage(carsPerPage, totalCars);
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
                            int index = Integer.parseInt(input+"")-1; //try to access currentPageCars.get(input)
                            CarDetailPage.carDetail(currentPageCars.get(index));
                            cars=IO.getAllCars();
                            totalCars = cars.size();
                            currentPage = 1;
                            totalPage = getTotalPage(carsPerPage, totalCars);
                            continue;
                        }catch (NumberFormatException e){ //catch numberformat means not a number
                            stat=' ';
                            Util.invalidInput("There is no such option!");
                            continue;
                        }catch (IndexOutOfBoundsException e){ //OutofBound means number more than available cars.
                            stat=' ';
                            Util.invalidInput("There is no such car!");
                            continue;
                        }
//
                }
            if (stat == 'n'||stat=='p'||stat=='a') {
                continue;
            } else if (stat == 'r') {
                break;
            }
            }


    }


    private static int getTotalPage(int carsPerPage, int totalCars) {
        int totalPage;
        if(totalCars%carsPerPage!=0){
            //comes with potential that int cancels the decimal value for thr result of totalCars/carsPerPage
            if(totalCars/carsPerPage==0){

                //if total car value is lesser than the single page car value
                if(totalCars<carsPerPage){
                    totalPage=totalCars/carsPerPage+1;
                }else {
                    totalPage = totalCars / carsPerPage + 2;
                }
            }else{
                totalPage=totalCars/carsPerPage+1;}
        }else{
            //if totalCars%carsPerPage==0, then result equals to totalPage.
            totalPage= totalCars/carsPerPage;
        }
        return totalPage;
    }
}
