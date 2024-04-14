package Application;


import java.util.InputMismatchException;
import java.util.Scanner;
import Util.Util;
import Models.Car;
import javax.swing.text.View;



public class Main {
    public static void main(String[] args) {
        int selection = 0;
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("| Dear Instructor:                                                      |");
        System.out.println("|      Thanks for reviewing our project.As there are indeed limitations |");
        System.out.println("|      with CUI developing, we would highly recommend our users and     | ");
        System.out.println("|      request the TAs to kindly run this project with Terminals rather |");
        System.out.println("|      than IDE build-in outputs for the best CUI interface. Functions  |");
        System.out.println("|      of the program will not be interfered with IDE build-in outputs. |");
        System.out.println("|                                                                       |");
        System.out.println("| Authors:                                                              |");
        System.out.println("| Tommer Hu 22160969 hyf8256                                            |");
        System.out.println("| Qijia Yuan 22176238 yft9451                                           |");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\n-----------------------------------");
        System.out.println("|    Input Any Key to Continue    |");
        System.out.println("-----------------------------------");
        Util.pressToContinue();



        while(true){
            Util.clearScreen();
            Scanner sc = new Scanner(System.in);

            System.out.println("---------------------------");
            System.out.println("|  WELCOME TO CarTraders! |");
            System.out.println("|        Haere Mai!       |");
            System.out.println("|        ----------       |");
            System.out.println("|                         |");
            System.out.println("|Please select:           |");
            System.out.println("|      1. View Cars       |");
            System.out.println("|      2. Add Cars        |");
            System.out.println("|      3. Exit Program    | ");
            System.out.println("---------------------------");
            System.out.print("\nPlease select the page:");
            try {
                selection = sc.nextInt();
            }catch (InputMismatchException e){
                Util.clearScreen();
                Util.invalidInput("Your input is not a number!");
                continue;
            }
                switch (selection){
                    case 1:
                        while(true) {
                            System.out.println("How many cars would you like to display in one page (maximum 10)?");
                            try {
                                System.out.print("Your Input:");
                                int temp = sc.nextInt();
                                if(temp>0 && temp <= 10) {
                                    ViewCar.viewCars(temp);
                                    break;
                                }else{
                                    Util.invalidInput("Please input a number between 1-10!");
                                }
                            } catch (InputMismatchException e) {
                                Util.clearScreen();
                                sc.next();
                                Util.invalidInput("Your input is not a number!");
                            }
                        }
                        break;
                    case 2:
                        AddCar.addPage();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        try {
                            Util.invalidInput("Your input does not match with the options!");
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                }
            }
        }
    }

