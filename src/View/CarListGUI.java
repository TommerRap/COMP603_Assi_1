/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import DAL.VehicleDAL;
import Models.ElectricVehicle;
import Models.Vehicle;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author tomme
 */
public class CarListGUI {
    
    JButton car1Page;
    ArrayList<Vehicle> cars = new ArrayList();
    ArrayList<Vehicle> totalCars = new ArrayList();
    JLabel[] CarIDs = new JLabel[6];
    JLabel[] CarInfos = new JLabel[6];
    JLabel[] CarTypes = new JLabel[6];
    JLabel[] CarPrices = new JLabel[6];
    JLabel[] ImageDisplayFields = new JLabel[6];
    ImageIcon[] Images = new ImageIcon[6];
    JButton[] Buttons = new JButton[6];
    JButton[] editButtons = new JButton[6];
    int currentPage;
    int totalPage;
    
    
    public CarListGUI(ArrayList<Vehicle> array, int page){
        this.totalCars = array;
        if(totalCars.size()%6!=0){
            totalPage = totalCars.size()/6 +1;
        }
        try{
        if(page==1){
            for(int i = 0;i<6;i++){
                cars.add(totalCars.get(i));
            }
        }else{
            for(int i = 0;i<6;i++){
                cars.add(totalCars.get(i+6*(page-1)));
            }
        }}catch(IndexOutOfBoundsException e){}
        
        //Setup JFrame
        JFrame frame = new JFrame();
        frame.setSize(1200,950);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        //Setup JPanel
         JPanel panel = new JPanel();
         frame.add(panel);
         panel.setLayout(null);
         
         //Setup Page Section
         JButton previousBtn = new JButton("Previous");
         JButton nextBtn = new JButton("Next");
         JLabel pageDisplay = new JLabel("Page "+page+" of "+totalPage);
         pageDisplay.setBounds(530,850,100,50);
         pageDisplay.setFont(new Font("Serif",Font.PLAIN,22));

         panel.add(pageDisplay);
         previousBtn.setBounds(410,860,90,30);
         previousBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               new CarListGUI(totalCars,page-1);
               frame.dispose();
            }
        });
         
         nextBtn.setBounds(690,860,90,30);
         
         nextBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new CarListGUI(totalCars,page+1);
                frame.dispose();
            }
        });
         
        if(page !=1){
        panel.add(previousBtn);
       }
        if(page!=totalPage){
         panel.add(nextBtn);
        }
        
         //Place Holders
         
        for(int i = 0; i<6; i++){
            try{Vehicle car = cars.get(i);}catch(IndexOutOfBoundsException e){break;}
            if(cars.get(i)!=null){
                Vehicle car = cars.get(i);
                Images[i] = new ImageIcon();
                
                try{
                    Images[i] = new ImageIcon(ImageIO.read(new File("./"+car.getType()+".jpg")).getScaledInstance(300,300,10));
                }catch(Exception e){e.printStackTrace();}
                ImageDisplayFields[i] = new JLabel(Images[i]);
                CarIDs[i] = new JLabel("ID: "+car.getId());
                CarInfos[i] = new JLabel (car.getYear()+" "+car.getMake()+" "+car.getModel());
                CarTypes[i] = new JLabel (car.getType());
                CarPrices[i] = new JLabel("$"+car.getPrice());
                Buttons[i] = new JButton("View More");
                Buttons[i].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    new DetailPageGUI(car);
                    
                }
            });
                editButtons[i] = new JButton("Edit");
                editButtons[i].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new EditCarGUI(car);
                        
                    }
                
                });
                
                
                //Configuration Position
                if(i<3){
                    editButtons[i].setBounds(250+(380*i),375,100,40);
                    ImageDisplayFields[i].setBounds(50+(380*i),20,300,300);
                    CarIDs[i].setBounds(50+380*i,320,50,30);
                    CarInfos[i].setBounds(50+380*i,340,150,30);
                    CarTypes[i].setBounds(50+380*i,360,50,30);
                    CarPrices[i].setBounds(50+380*i,380,100,30);
                    Buttons[i].setBounds(250+380*i,325,100,40);
                    panel.add(editButtons[i]);
                    panel.add(ImageDisplayFields[i]);
                    panel.add(CarIDs[i]);
                    panel.add(CarInfos[i]);
                    panel.add(CarTypes[i]);
                    panel.add(CarPrices[i]);
                    panel.add(Buttons[i]);
                }else{
                    editButtons[i].setBounds(250+(380*(i-3)),800,100,40);
                    ImageDisplayFields[i].setBounds(50+(380*(i-3)),450,300,300);
                    CarIDs[i].setBounds(50+380*(i-3),750,50,30);
                    CarInfos[i].setBounds(50+380*(i-3),770,150,30);
                    CarTypes[i].setBounds(50+380*(i-3),790,50,30);
                    CarPrices[i].setBounds(50+380*(i-3),810,100,30);
                    Buttons[i].setBounds(250+380*(i-3),755,100,40);
                    panel.add(editButtons[i]);
                    panel.add(ImageDisplayFields[i]);
                    panel.add(CarIDs[i]);
                    panel.add(CarInfos[i]);
                    panel.add(CarTypes[i]);
                    panel.add(CarPrices[i]);
                    panel.add(Buttons[i]);
                }
            }
        }
         
//         //PlaceHolder 1
//         ImageIcon image1 = new ImageIcon();
//         try{
//         image1 = new ImageIcon(ImageIO.read(new File("./EV.jpg")).getScaledInstance(300,300,10));
//         }catch(Exception e){e.printStackTrace();}
//         
//         JLabel image1DisplayField = new JLabel(image1);
//         JLabel car1ID = new JLabel("ID:10001");
//         JLabel car1Info = new JLabel("2011 Audi A4");
//         //JLabel car1Info = new JLabel(car1.getYear()+" "+ car1.getMake()+" "+car1.getModel());
//         JLabel car1Type = new JLabel("EV");
//         //JLabel car1Type = new JLabel(car1.getType());
//         JLabel car1Price = new JLabel("$19999");
//         //JLabel car1Price = new JLabel("$"+car1.getPrice());
//
//         car1Page = new JButton("View More");
//         //car1Page.addActionListener(this);
//         
//         car1ID.setBounds(50,320,50,30);
//         image1DisplayField.setBounds(50,20,300,300);
//         car1Info.setBounds(50,340,150,30);
//         car1Type.setBounds(50,360,50,30);
//         car1Price.setBounds(50,380,100,30);
//         car1Page.setBounds(250,340,100,50);
//         car1Page.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                car1Page = null;
//            }
//        });
//         panel.add(car1ID);
//         panel.add(image1DisplayField);
//         panel.add(car1Info);
//         panel.add(car1Type);
//         panel.add(car1Price);
//         panel.add(car1Page);
//         
        frame.setVisible(true);
    }
}
