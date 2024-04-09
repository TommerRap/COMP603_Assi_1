package Application;

import java.util.InputMismatchException;
import java.util.Scanner;
import Util.Util;

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
            System.out.println("|      2. Add Cars.       |");
            System.out.println("|      3. Delete Cars     | ");
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
                    System.out.println("View Cars PUC");
                    break;
                case 2:
                    AddCar.addPage();
                    break;
                case 3:
                    System.out.println("Delete Cars");
                    break;
                default:
                    try {
                        System.out.println("1111");
                        //System.out.print("\033[H\033[2J");
                        Util.pressToContinue();
                        Util.clearScreen();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
            }
        }
    }

}
