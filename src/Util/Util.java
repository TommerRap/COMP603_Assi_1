package Util;

import java.io.File;
import java.io.IOException;


public class Util {
    /**
     *  Academic Integrity Statement: Util.clearScreen() is an method generated by ChatGPT, in order to enable the function of flushing the current console and dispose all older outputs. For a better CUI interface only and do not affect the core function of this program.
     */
    public static void clearScreen(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                System.out.print("\033[H\033[2J");
        } catch (IOException | InterruptedException ex) {}
    }

    /**
     * An Util method to check weather the data folder for the current instance exists.
     * If not exist, create it.
     */
    public static void resolveDataFolder(){
        File dir = new File("./data");
        if(!dir.exists()){
            dir.mkdir();
        }
    }

    /**
     * Pause the program and wait for the next input to continue.
     */
    public static void pressToContinue(){
        try{
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Print Spaces
     * @param amount the amount of spaces needs to print
     */
    public static void spacePrinter(int amount){
        for (int i = 0; i <= amount; i++) {
            System.out.print(" ");
        }
    }

    /**
     * Print out System.error.println, attached with a default message "invalid input", plus a customisable message. Shows the reloading animation and continue loops for the original program.
     * @param msg Message after "Invalid Input: "
     */
    public static void invalidInput(String msg){
        System.err.println("Invalid Input : " + msg);
        try{
            Thread.sleep(1000);
            System.err.println("Redirecting you to the previous menu.");
            Thread.sleep(1000);
            for (int i = 0; i <= 6; i++) {
                if(i==6){
                    System.out.println(".\n");
                }else {
                    System.out.print(".");
                    Thread.sleep(400);
                }
            }
            Thread.sleep(1000);
        }catch (Exception er){
            er.printStackTrace();
        }
    }

    /**
     * Block the thread and wait.
     * @param mills mills needs to wait.
     */
    public static void wait(int mills){
        try{Thread.sleep(mills);}catch (InterruptedException e){e.printStackTrace();}

    }



}