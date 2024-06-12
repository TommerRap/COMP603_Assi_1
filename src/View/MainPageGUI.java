/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Control.CarsControl;
import DAL.DatabaseHelper;
import DAL.VehicleDAL;
import Models.Vehicle;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Tommer & Jason
 */
public class MainPageGUI implements ActionListener {
    JButton car1Page;
    JButton car2Page;
    JButton car3Page;
    Vehicle car1;
    Vehicle car2;
    Vehicle car3;
    int dataCount = DatabaseHelper.getDataCount("VEHICLES");
    public MainPageGUI(){
        //Setup JFrame
        JFrame frame = new JFrame();
        frame.setSize(1200,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Setup JPanel
         JPanel panel = new JPanel();
         frame.add(panel);
         panel.setLayout(null);
         
         //Main Greetings Label
         JLabel greetingsLabel = new JLabel("Kia Ora! Welcome to Car Trader!");
         greetingsLabel.setFont(new Font("Serif",Font.PLAIN,36));
         greetingsLabel.setBounds(360,50,480,30);
         panel.add(greetingsLabel);
         
         //Search Bar
         JTextField searchBar = new JTextField(20);
         searchBar.setText("Input your keyword here... (Case sensitive)");
         searchBar.setBounds(360,120,400,30);
         searchBar.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                searchBar.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(searchBar.getText().equals("")){
                             searchBar.setText("Input your keyword here... (Case sensitive)");
                }
            }
             
         });
         panel.add(searchBar);
         
         
         //Search Button
         JButton searchButton = new JButton("Search");
         searchButton.setBounds(760, 120, 80, 30);
         
         
         searchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CarsControl control = new CarsControl();
                try {
                    ArrayList<Vehicle> result = control.searchForCar(searchBar.getText());
                    if(result!=null && result.size()!=0){
                        new CarListGUI(result);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MainPageGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
   });
         panel.add(searchButton);
                 
         System.out.println(searchBar.getText());
      
         
         
         /**
          * Category Button Set Start
          */
        
         //Fuel Button
         JButton fuelButton = new JButton("Fuel");
         fuelButton.setBounds(400,160,80,30);
         fuelButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CarsControl control = new CarsControl();
                try{new CarListGUI(control.getAllFuel());}catch(SQLException ex){ex.printStackTrace();}
            }
        });
         panel.add(fuelButton);
         
         //Hybrid Button
         JButton hybridButton = new JButton("Hybrid");
         hybridButton.setBounds(500,160,80,30);
         hybridButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CarsControl control = new CarsControl();
                try{new CarListGUI(control.getAllHybrid());}catch(SQLException ex){ex.printStackTrace();}
            }
        });
         panel.add(hybridButton);
         
         
         //EV Button
         JButton EVButton = new JButton("EV");
         EVButton.setBounds(600,160,80,30);
         EVButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CarsControl control = new CarsControl();
                try{new CarListGUI(control.getAllEV());}catch(SQLException ex){ex.printStackTrace();}
            }
        });
         panel.add(EVButton);
         
         
         //All Button
         JButton AllButton = new JButton("See All");
         AllButton.setBounds(700,160,80,30);
         AllButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CarsControl control = new CarsControl();
                try{new CarListGUI(control.getAllCars());}catch(SQLException ex){ex.printStackTrace();}
            }
        });
         panel.add(AllButton);
         
         
         /**
         * Category Button Set Ends
         */
        
         
         /**
          * FEATURED SECTION BEGINS
          */
         
         //Featured Label
         JLabel featuredLabel = new JLabel("Featured");
         featuredLabel.setFont(new Font("Serif",Font.PLAIN,36));
         featuredLabel.setBounds(50,300,150,30);
         //featuredLabel.setText(DatabaseHelper.getDataCount("VEHICLES")+"");
         panel.add(featuredLabel);
          
         Random r = new Random();
         
         //Car PlaceHolder 1
         int id1 =10000 + r.nextInt(this.dataCount)+1;
         car1 = VehicleDAL.getCar(id1);
         
         ImageIcon image1 = new ImageIcon();
         try{
         image1 = new ImageIcon(ImageIO.read(new File("./"+car1.getType()+".jpg")).getScaledInstance(300,300,10));
         }catch(Exception e){e.printStackTrace();}
         
         JLabel image1DisplayField = new JLabel(image1);
         JLabel car1Info = new JLabel(car1.getYear()+" "+ car1.getMake()+" "+car1.getModel());
         JLabel car1Type = new JLabel(car1.getType());
         JLabel car1Price = new JLabel("$"+car1.getPrice());
         car1Page = new JButton("View More");
         car1Page.addActionListener(this);
         
         image1DisplayField.setBounds(50,350,300,300);
         car1Info.setBounds(50,650,300,30);
         car1Type.setBounds(50,670,100,30);
         car1Price.setBounds(50,690,100,30);
         car1Page.setBounds(250,660,100,50);
         panel.add(image1DisplayField);
         panel.add(car1Info);
         panel.add(car1Type);
         panel.add(car1Price);
         panel.add(car1Page);
         
         
       

         //Car PlaceHolder 2
        
         
         int id2 =10000 + r.nextInt(dataCount)+1;
         while(true){
             if(id2==id1){
                 id2 = 10000+r.nextInt(dataCount)+1; //if got the same ID number, generate a new one
             }else{
                 break;
             }
         }
         
          car2 = VehicleDAL.getCar(id2);
         ImageIcon image2 = new ImageIcon();
         try{
         image2 = new ImageIcon(ImageIO.read(new File("./"+car2.getType()+".jpg")).getScaledInstance(300,300,10));
         }catch(Exception e){e.printStackTrace();}
         
         JLabel image2DisplayField = new JLabel(image2);
         JLabel car2Info = new JLabel(car2.getYear()+" "+ car2.getMake()+" "+car2.getModel());
         JLabel car2Type = new JLabel(car2.getType());
         JLabel car2Price = new JLabel("$"+car2.getPrice());
         car2Page = new JButton("View More");
         car2Page.addActionListener(this);
         
         image2DisplayField.setBounds(450,350,300,300);
         car2Info.setBounds(450,650,300,30);
         car2Type.setBounds(450,670,100,30);
         car2Price.setBounds(450,690,100,30);
         car2Page.setBounds(650,660,100,50);
         panel.add(image2DisplayField);
         panel.add(car2Info);
         panel.add(car2Type);
         panel.add(car2Price);
         panel.add(car2Page);
         
        
         //Car PlaceHolder 3
         int id3 =10000 + r.nextInt(dataCount)+1;
         while(true){
             if(id3==id2||id3==id1){
                 id3 = 10000+r.nextInt(dataCount)+1; //if got the same ID number, generate a new one
             }else{
                 break;
             }
         }
          car3 = VehicleDAL.getCar(id3);
         
         ImageIcon image3 = new ImageIcon();
         try{
         image3 = new ImageIcon(ImageIO.read(new File("./"+car3.getType()+".jpg")).getScaledInstance(300,300,10));
         }catch(Exception e){e.printStackTrace();}
         
         JLabel image3DisplayField = new JLabel(image3);
         JLabel car3Info = new JLabel(car3.getYear()+" "+ car3.getMake()+" "+car3.getModel());
         JLabel car3Type = new JLabel(car3.getType());
         JLabel car3Price = new JLabel("$"+car3.getPrice());
         car3Page = new JButton("View More");
         car3Page.addActionListener(this);
         
         image3DisplayField.setBounds(850,350,300,300);
         car3Info.setBounds(850,650,300,30);
         car3Type.setBounds(850,670,100,30);
         car3Price.setBounds(850,690,100,30);
         car3Page.setBounds(1050,660,100,50);
         panel.add(image3DisplayField);
         panel.add(car3Info);
         panel.add(car3Type);
         panel.add(car3Price);
         panel.add(car3Page);
         
         
         frame.addWindowListener(new WindowListener(){
            
            @Override
            public void windowOpened(WindowEvent e) {
                searchButton.grabFocus();
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }
         });
         frame.setVisible(true);
        // new DetailPageGUI(car1);
        //new DetailPageGUI(VehicleDAL.getCar(10001));
        new EditCarGUI(VehicleDAL.getCar(10001));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==car1Page){
            new DetailPageGUI(car1);
        }else if(e.getSource()==car2Page){
            new DetailPageGUI(car2);
        }else if(e.getSource() == car3Page){
            new DetailPageGUI(car3);
        }
    }
   
}
