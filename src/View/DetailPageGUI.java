package View;

import DAL.VehicleDAL;
import Models.ElectricVehicle;
import Models.FuelCar;
import Models.HybridVehicle;
import Models.Vehicle;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
    public DetailPageGUI(Vehicle car){
        
        //Setup JFrame
        JFrame frame = new JFrame();
        frame.setSize(1200,800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        //Setup JPanel
         JPanel panel = new JPanel();
         frame.add(panel);
         panel.setLayout(null);

         //Declare General Information
         JLabel carInfo = new JLabel(car.getYear() + " " + car.getMake()+" "+car.getModel());
         JLabel carPrice = new JLabel("$" + car.getPrice()+"");
         JLabel carType = new JLabel(car.getType());
         ImageIcon image =  new ImageIcon();
         try{
             image = new ImageIcon(ImageIO.read(new File("./"+car.getType()+".jpg")).getScaledInstance(500,500,10));
         }catch(Exception e){
             e.printStackTrace();
         }
         JLabel imagePlaceHolder = new JLabel(image);
         JButton carOperation = new JButton();
         if(car.isAvailable()){
             carOperation.setText("Purchase");
         }else{
              carOperation.setText("Sold");
              carOperation.setEnabled(false);
         } 
         
         //Allocate General Information
         imagePlaceHolder.setBounds(50,50,500,500);
         panel.add(imagePlaceHolder);
         
         carInfo.setBounds(700,50,500,50);
         carInfo.setFont(new Font("Serif",Font.PLAIN,36));
         panel.add(carInfo);
         
         carPrice.setForeground(Color.RED);
         carPrice.setFont(new Font("Serif",Font.PLAIN,36));
         carPrice.setBounds(700,350,500,50);
         panel.add(carPrice);
         
         carOperation.setBounds(700,450,150,50);
         panel.add(carOperation);
         
         
         
        if(car.getType().equals("EV")){
            ElectricVehicle ev = VehicleDAL.getEV(car); 
            carType.setOpaque(true);
            carType.setBounds(700,100,50,50);
            carType.setFont(new Font("Serif",Font.PLAIN,36));
            carType.setBackground(new Color(2,108,69));
            carType.setForeground(Color.WHITE);
            panel.add(carType);
            
            //Declare EV specific fields
            JLabel evEndurance = new JLabel("Endurance: "+ ev.getEndurance()+"km");
            evEndurance.setFont(new Font("Serif",Font.PLAIN,22));
            JLabel evIsSupportSuperCharge = new JLabel("Super Charge Support: " + ev.isSuperCharge());
            evIsSupportSuperCharge.setFont(new Font("Serif",Font.PLAIN,22));
            JLabel evSuperChargeRate = new JLabel("Super Charge Rate: " + ev.getSuperChargeRate()+"kW");
            evSuperChargeRate.setFont(new Font("Serif",Font.PLAIN,22));

            evEndurance.setBounds(700,150,400,50);
            evIsSupportSuperCharge.setBounds(700,200,400,50);
            evSuperChargeRate.setBounds(700,250,400,50);
            panel.add(evEndurance);
            panel.add(evIsSupportSuperCharge);
            if(ev.isSuperCharge()){
                panel.add(evSuperChargeRate);
            }     
            
        }else if(car.getType().equals("Hybrid")){
            HybridVehicle hv = VehicleDAL.getHybrid(car);
            carType.setOpaque(true);
            carType.setBounds(700,100,100,50);
            carType.setFont(new Font("Serif",Font.PLAIN,36));
            carType.setBackground(new Color(48,86,121));
            carType.setForeground(Color.WHITE);
            panel.add(carType);
            
            JLabel hvEndurance = new JLabel("Fuel-only Endurance: "+ hv.getFuelOnlyEndurance()+"km");
            hvEndurance.setFont(new Font("Serif",Font.PLAIN,22));
            hvEndurance.setBounds(700,150,400,50);
            JLabel hvIsPlugInEV = new JLabel("PHEV: " + hv.isPlugIn());
            hvIsPlugInEV.setFont(new Font("Serif",Font.PLAIN,22));
            hvIsPlugInEV.setBounds(700,200,400,50);
            
            panel.add(hvEndurance);
            panel.add(hvIsPlugInEV);
         
    }else{
            FuelCar fuelCar = VehicleDAL.getFuel(car);
            carType.setOpaque(true);
            carType.setBounds(700,100,75,50);
            carType.setFont(new Font("Serif",Font.PLAIN,36));
            carType.setBackground(new Color(255,51,51));
            carType.setForeground(Color.WHITE);
            panel.add(carType);
            
            JLabel avgFuel = new JLabel("Average Fuel Cunsumption: " + fuelCar.getAverageFuelConsumption()+" L/100km");
            avgFuel.setFont(new Font("Serif",Font.PLAIN,22));
            avgFuel.setBounds(700,150,450,50);
            panel.add(avgFuel);
        }
         
         
         
         frame.setVisible(true);
    }
}
