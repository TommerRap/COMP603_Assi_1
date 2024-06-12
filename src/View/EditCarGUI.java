/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Models.FuelCar;
import Models.Vehicle;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author tomme
 */
public class EditCarGUI {
    String[] bol = new String[]{"true","false"};
    public EditCarGUI(Vehicle car){
 //Setup JFrame
        JFrame frame = new JFrame();
        frame.setSize(1200,800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        //Setup JPanel
         JPanel panel = new JPanel();
         frame.add(panel);
         panel.setLayout(null);

         //Declare General Information
         JLabel carType = new JLabel(car.getType());
         ImageIcon image =  new ImageIcon();
         try{
             image = new ImageIcon(ImageIO.read(new File("./"+car.getType()+".jpg")).getScaledInstance(500,500,10));
         }catch(Exception e){
             e.printStackTrace();
         }
         JLabel imagePlaceHolder = new JLabel(image);
         
         //ID
         JLabel idLabel = new JLabel("ID:");
         JLabel idInput = new JLabel(car.getId()+"");
         //Make
         JLabel makeLabel = new JLabel("Make:");
         JTextField makeInput = new JTextField(car.getMake());
         //Model
         JLabel modelLabel = new JLabel("Model:");
         JTextField modelInput = new JTextField(car.getModel());
         //Year
         JLabel yearLabel = new JLabel("Year:");
         JTextField yearInput = new JTextField(car.getYear()+"");
         
        //Availability
         JLabel avaiLabel = new JLabel("Availability:");
         JComboBox avaiInput = new JComboBox(bol);
         
         if(car.isAvailable()){
                 avaiInput.setSelectedIndex(0);
         }else{
                 avaiInput.setSelectedIndex(1);
                 }
         
         //Allocate General Information
         imagePlaceHolder.setBounds(50,50,500,500);
         panel.add(imagePlaceHolder);
         
         //Allocate ID
         idLabel.setBounds(650,100,300,45);
         idLabel.setFont(new Font("Serif",Font.PLAIN,36));
         idInput.setBounds(950,100,150,45);
         idInput.setFont(new Font("Serif",Font.PLAIN,36));
         panel.add(idLabel);
         panel.add(idInput);
         
         //Allocate Make
         makeLabel.setBounds(650,150,300,45);
         makeLabel.setFont(new Font("Serif",Font.PLAIN,36));
         makeInput.setBounds(950,150,150,45);
         makeInput.setFont(new Font("Serif",Font.PLAIN,28));
         panel.add(makeInput);
         panel.add(makeLabel);
         
         //Allocate Model
         modelLabel.setBounds(650,200,300,45);
         modelLabel.setFont(new Font("Serif",Font.PLAIN,36));
         modelInput.setBounds(950,200,150,45);
         modelInput.setFont(new Font("Serif",Font.PLAIN,28));
         panel.add(modelInput);
         panel.add(modelLabel);
         
         //Allocate Year
         yearLabel.setBounds(650,250,300,45);
         yearLabel.setFont(new Font("Serif",Font.PLAIN,36));
         yearInput.setBounds(950,250,150,45);
         yearInput.setFont(new Font("Serif",Font.PLAIN,28));
         panel.add(yearInput);
         panel.add(yearLabel);
         
         
         //Allocate Availability
         avaiLabel.setBounds(650,300,300,45);
         avaiLabel.setFont(new Font("Serif",Font.PLAIN,36));
         avaiInput.setBounds(950,300,150,45);
         avaiInput.setFont(new Font("Serif",Font.PLAIN,36));
         panel.add(avaiInput);
         panel.add(avaiLabel);
         
         if(car.getType().equals("Fuel")){
            FuelCar fuelCar = new FuelCar(car);
             //Allocate Type
            carType.setOpaque(true);
            carType.setBounds(650,50,75,50);
            carType.setFont(new Font("Serif",Font.PLAIN,36));
            carType.setBackground(new Color(255,51,51));
            carType.setForeground(Color.WHITE);
            panel.add(carType);
            
            //Declare and Allocate FuelCons
            JLabel consLabel = new JLabel("Average Fuel Consumption:");
            JTextField consInput = new JTextField(fuelCar.getAverageFuelConsumption()+"");
            consLabel.setBounds(650,350,300,45);
            consLabel.setFont(new Font("Serif",Font.PLAIN,22));
            consInput.setBounds(950,350,150,45);
            consInput.setFont(new Font("Serif",Font.PLAIN,26));
            panel.add(consLabel);
            panel.add(consInput);
         }
         
         
         frame.setVisible(true);
    }
}
