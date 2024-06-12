/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Control.CarsControl;
import DAL.VehicleDAL;
import Models.ElectricVehicle;
import Models.FuelCar;
import Models.HybridVehicle;
import Models.Vehicle;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
public class EditCarGUI implements FocusListener{
    JLabel errorMsg;
    String[] bol = new String[]{"true","false"};
    Vehicle car;
    JPanel panel;
    JFrame frame;
    
    JButton saveButton;
    JLabel idInput;
    JTextField makeInput;
    JTextField modelInput;
    JTextField yearInput;
    JComboBox avaiInput;
    JTextField priceInput;

    JTextField consInput;
    
    JTextField enduranceInput;
    JComboBox superInput;
    JTextField rateInput;
    
    JTextField fuelEndInput;
    JComboBox PHEVInput;
    
    CarsControl control = new CarsControl();
    public EditCarGUI(Vehicle car){
        this.car=car;
//Setup JFrame
        frame = new JFrame();
        frame.setSize(1200,800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
 
        //Setup JPanel
         panel = new JPanel();
         frame.add(panel);
         panel.setLayout(null);
            
        
         //Declare General Information
         
         //Error Message
        errorMsg = new JLabel();
        errorMsg.setBounds(650,650,500,30);
        errorMsg.setVisible(false);
        errorMsg.setForeground(Color.red);
        errorMsg.setFont(new Font("Serif",Font.PLAIN,22));
        panel.add(errorMsg);
        
        
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
         idInput = new JLabel(car.getId()+"");
         idInput.addFocusListener(this);
         //Make
         JLabel makeLabel = new JLabel("Make:");
          makeInput = new JTextField(car.getMake());
          makeInput.addFocusListener(this);
         //Model
         JLabel modelLabel = new JLabel("Model:");
          modelInput = new JTextField(car.getModel());
          modelInput.addFocusListener(this);
         //Year
         JLabel yearLabel = new JLabel("Year:");
          yearInput = new JTextField(car.getYear()+"");
          yearInput.addFocusListener(this);
         
        //Availability
         JLabel avaiLabel = new JLabel("Availability:");
         avaiInput = new JComboBox(bol);
         avaiInput.addFocusListener(this);
         //Price
         JLabel priceLabel = new JLabel("Price:");
         priceInput = new JTextField(car.getPrice()+"");
         priceInput.addFocusListener(this);
         //Validate Button
         JButton validateButton = new JButton("Validate");
         
         //SaveButton
         
         saveButton = new JButton("Save");
         saveButton.setEnabled(false);
         
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
         
         //Allocate Price
         priceLabel.setBounds(650,350,300,45);
         priceLabel.setFont(new Font("Serif",Font.PLAIN,36));
         priceInput.setBounds(950,350,150,45);
         priceInput.setFont(new Font("Serif",Font.PLAIN,36));
         panel.add(priceLabel);
         panel.add(priceInput);
         
         //Allocate Buttons
         validateButton.setBounds(650,700,150,45);
         panel.add(validateButton);
         saveButton.setBounds(850,700,150,45);
         panel.add(saveButton);
         saveButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                             saveCar(car);            }
         });
         validateButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 if(!Validate()){
                    errorMsg.setVisible(true);
                 }else{
                    saveButton.setEnabled(true);
                 }
            }
         });
         
         if(car.getType().equals("Fuel")){
            FuelCar fuelCar;
             if(control.isExist(car.getId())){
                 fuelCar=VehicleDAL.getFuel(car);
             }else{
                 fuelCar = new FuelCar(car);
             }
             //Allocate Type
            carType.setOpaque(true);
            carType.setBounds(650,50,75,50);
            carType.setFont(new Font("Serif",Font.PLAIN,36));
            carType.setBackground(new Color(255,51,51));
            carType.setForeground(Color.WHITE);
            panel.add(carType);
            
            //Declare and Allocate FuelCons
            JLabel consLabel = new JLabel("Average Fuel Consumption:");
             consInput = new JTextField(fuelCar.getAverageFuelConsumption()+"");
             consInput.addFocusListener(this);
            consLabel.setBounds(650,400,300,45);
            consLabel.setFont(new Font("Serif",Font.PLAIN,22));
            consInput.setBounds(950,400,150,45);
            consInput.setFont(new Font("Serif",Font.PLAIN,26));
            panel.add(consLabel);
            panel.add(consInput);
         }else if(car.getType().equals("EV")){
             ElectricVehicle evCar;
             if(control.isExist(car.getId())){
                 evCar=VehicleDAL.getEV(car);
             }else{
                 evCar = new ElectricVehicle(car);
             }
              //Allocate Type
            carType.setOpaque(true);
            carType.setBounds(650,50,75,50);
            carType.setFont(new Font("Serif",Font.PLAIN,36));
            carType.setBackground(new Color(2,108,69));
            carType.setForeground(Color.WHITE);
            panel.add(carType);
            
            //Declare and Allocate Endurance
            JLabel enduranceLabel = new JLabel("Endurance:");
            enduranceInput = new JTextField(evCar.getEndurance()+"");
            enduranceInput.addFocusListener(this);
            enduranceLabel.setBounds(650,400,300,45);
            enduranceLabel.setFont(new Font("Serif",Font.PLAIN,36));
            enduranceInput.setBounds(950,400,150,45);
            enduranceInput.setFont(new Font("Serif",Font.PLAIN,36));
            panel.add(enduranceLabel);
            panel.add(enduranceInput);
            
            //Declare and allocate superCharge
            JLabel superLabel = new JLabel("SuperCharge Support:");
            superInput = new JComboBox(bol);
            if(evCar.isSuperCharge()){superInput.setSelectedIndex(0);}else{superInput.setSelectedIndex(1);}
            superLabel.setBounds(650,450,300,45);
            superLabel.setFont(new Font("Serif",Font.PLAIN,26));
            superInput.setBounds(950,450,150,45);
            superInput.addFocusListener(this);
            superInput.setFont(new Font("Serif",Font.PLAIN,36));
            JLabel rateLabel = new JLabel("SuperCharge Rate:");
            rateInput = new JTextField(evCar.getSuperChargeRate()+"");
            rateInput.addFocusListener(this);
            rateLabel.setFont(new Font("Serif",Font.PLAIN,26));
            rateLabel.setBounds(650,500,300,45);
            rateInput.setBounds(950,500,150,45);
            rateInput.setFont(new Font("Serif",Font.PLAIN,36));
            panel.add(rateLabel);
            panel.add(rateInput);
            panel.add(superLabel);
            panel.add(superInput);
             if(!evCar.isSuperCharge()){
                 rateLabel.setVisible(false);
                 rateInput.setVisible(false);
                 rateInput.setText("0");
             }
            superInput.addItemListener(new ItemListener(){
                 @Override
                 public void itemStateChanged(ItemEvent e) {
                     if(superInput.getSelectedIndex()==0){
                        rateLabel.setVisible(true);
                        rateInput.setVisible(true);
                     }else{
                        rateLabel.setVisible(false);
                        rateInput.setVisible(false);
                     }
                 }
             });
         }else{
             //Hybrid Obj
             HybridVehicle hv;
             if(control.isExist(car.getId())){
                 hv=VehicleDAL.getHybrid(car);
             }else{
                 hv = new HybridVehicle(car);
             }
             
            //Allocate Type Display
            carType.setOpaque(true);
            carType.setBounds(650,50,100,50);
            carType.setFont(new Font("Serif",Font.PLAIN,36));
            carType.setBackground(new Color(48,86,121));
            carType.setForeground(Color.WHITE);
            panel.add(carType);
            
            //Allocate Fuel Only Endurance
            JLabel fuelEndLabel = new JLabel("Fuel-Only Endurance:");
            fuelEndLabel.setFont(new Font("Serif",Font.PLAIN,22));
            fuelEndLabel.setBounds(650,400,300,45);
            fuelEndInput = new JTextField(hv.getFuelOnlyEndurance()+"");
            fuelEndInput.setBounds(950,400,150,45);
            fuelEndInput.setFont(new Font("Serif",Font.PLAIN,36));
            fuelEndInput.addFocusListener(this);
            panel.add(fuelEndLabel);
            panel.add(fuelEndInput);
            
            JLabel PHEVLabel = new JLabel("PHEV");
            PHEVLabel.setFont(new Font("Serif",Font.PLAIN,36));
            PHEVLabel.setBounds(650,450,300,45);
            PHEVInput = new JComboBox(bol);
            if(!hv.isPlugIn()){
                PHEVInput.setSelectedIndex(1);
         }
            PHEVInput.setBounds(950,450,150,45);
            PHEVInput.setFont(new Font("Serif",Font.PLAIN,36));
            PHEVInput.addFocusListener(this);
            panel.add(PHEVLabel);
            panel.add(PHEVInput);
            

         
         }
         frame.setVisible(true);
    }
    
    public void saveCar(Vehicle car){
        if(car.getType().equals("Fuel")){
            FuelCar fuelCar = new FuelCar();
            fuelCar.setId(Integer.parseInt(idInput.getText()));
            fuelCar.setMake(makeInput.getText());
            fuelCar.setModel(modelInput.getText());
            fuelCar.setPrice(Float.parseFloat(priceInput.getText()));
            fuelCar.setType("Fuel");
            fuelCar.setYear(Integer.parseInt(yearInput.getText()));
            fuelCar.setAvailability(Boolean.parseBoolean(bol[avaiInput.getSelectedIndex()]));
            fuelCar.setAverageFuelConsumption(Float.parseFloat(consInput.getText()));
            control.passInFuelCar(fuelCar);
            frame.dispose();
        }else if(car.getType().equals("EV")){
            ElectricVehicle ev = new ElectricVehicle();
            ev.setId(Integer.parseInt(idInput.getText()));
            ev.setMake(makeInput.getText());
            ev.setModel(modelInput.getText());
            ev.setPrice(Float.parseFloat(priceInput.getText()));
            ev.setType("EV");
            ev.setYear(Integer.parseInt(yearInput.getText()));
            ev.setAvailability(Boolean.parseBoolean(bol[avaiInput.getSelectedIndex()]));
            ev.setEndurance(Integer.parseInt(enduranceInput.getText()));
            ev.setSuperCharge(Boolean.parseBoolean(bol[superInput.getSelectedIndex()]));
            ev.setSuperChargeRate(Integer.parseInt(rateInput.getText()));
            control.passInEV(ev);
            frame.dispose();
        }else{
            HybridVehicle hv = new HybridVehicle();
            hv.setId(Integer.parseInt(idInput.getText()));
            hv.setMake(makeInput.getText());
            hv.setModel(modelInput.getText());
            hv.setPrice(Float.parseFloat(priceInput.getText()));
            hv.setYear(Integer.parseInt(yearInput.getText()));
            hv.setType("Hybrid");
            hv.setAvailability(Boolean.parseBoolean(bol[avaiInput.getSelectedIndex()]));
            hv.setFuelOnlyEndurance(Integer.parseInt(fuelEndInput.getText()));
            hv.setPlugIn(Boolean.parseBoolean(bol[PHEVInput.getSelectedIndex()]));
            control.passinHybrid(hv);
            frame.dispose();
        }
    }
    
    public boolean Validate(){
        int stage = 0;
        try{
            switch(stage){
                case 0:
                    Integer.parseInt(yearInput.getText());
                    stage++;
                case 1:
                    Float.parseFloat(priceInput.getText());
                    stage++;
            }
            if(car.getType().equals("Fuel")){
                switch(stage){
                    case 2:
                        Float.parseFloat(consInput.getText());
                }
            }else if(car.getType().equals("EV")){
                switch(stage){
                    case 2:
                        Integer.parseInt(enduranceInput.getText());
                        stage++;
                    case 3:
                        Integer.parseInt(rateInput.getText());
                        stage++;
                }
            }else{
                switch(stage){
                    case 2:
                        Integer.parseInt(fuelEndInput.getText());
                }
            }
            
            return true;
        }catch(NumberFormatException e){
                    switch (stage){
                        case 0:
                            errorMsg.setText("Please Input a Valid Year Number!");
                            break;
                        case 1:
                            errorMsg.setText("Please Input a Valid Price Amount!");
                            break;
                        case 2:
                            switch(car.getType()){
                                case "EV":
                                    errorMsg.setText("Please Input a Valid Endurance Amount!");
                                    break;
                                case "Fuel":
                                    errorMsg.setText("Please Input a Valid AFC Amount!");
                                    break;
                                case "Hybrid":
                                    errorMsg.setText("Please Input a Valid Fuel-only Endurance Number!");
                                    
                            }
                            break;
                        case 3:
                            switch(car.getType()){
                                case "EV":
                                    errorMsg.setText("Please Input a Valid SuperCharge Rate!");        
                            }
                    }
        }
//        if(this.car.getType().equals("Fuel")){
//            int stage = 0;
//            try{
//                switch(stage){
//                    case 0:
//                        Integer.parseInt(yearInput.getText());
//                        stage++;
//                        
//                    case 1:
//                        Float.parseFloat(priceInput.getText());
//                        stage++;
//                        
//                    case 2:
//                        Float.parseFloat(consInput.getText());
//                        stage++;
//                        break;
//                }
//               return true;
//            }catch(NumberFormatException e){
//                switch(stage){
//                    case 0:
//                        errorMsg.setText("Please Input a Valid Year Number!");
//                        break;
//                    case 1:
//                        errorMsg.setText("Please Input a Valid Price Amount!");
//                        break;
//                    case 2:
//                        errorMsg.setText("Please Input a Valid AFC Amount!");
//                        break;
//                }
//                return false;
//            }
//        }else if(this.car.getType().equals("EV")){
//            int stage = 0;
//            try{
//                switch(stage){
//                    case 0:
//                        Integer.parseInt(yeat)
//                }
//            }
//        }
        return false;
    }

    @Override
    public void focusGained(FocusEvent e) {
        saveButton.setEnabled(false);
        errorMsg.setVisible(false);
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
}
