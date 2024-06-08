package View;

import DAL.VehicleDAL;
import Models.ElectricVehicle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tomme
 */
public class DetailPageGUI {
    int vehicleID;
    public DetailPageGUI(int id){
        String vehicleType = VehicleDAL.getType(id);
        
        //Declare Basic Info
        
        //Setup JFrame
        JFrame frame = new JFrame();
        frame.setSize(1200,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Setup JPanel
         JPanel panel = new JPanel();
         frame.add(panel);
         panel.setLayout(null);

         //Declare General Information
         JLabel carInfo = new JLabel();
         JLabel carPrice = new JLabel();
         JLabel carType = new JLabel();
         JButton carOperation = new JButton();
         //BasicInfo
         
        if(vehicleType.equals("EV")){
            
            //ElectricVehicle ev = VehicleDAL.getCar(this.vehicleID);
        }
         
         
         
         frame.setVisible(true);
    }
}
