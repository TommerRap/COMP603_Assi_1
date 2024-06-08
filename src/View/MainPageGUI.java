/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author tomme
 */
public class MainPageGUI {
    
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
         searchBar.setText("Input your keyword here...");
         searchBar.setBounds(360,120,400,30);
         panel.add(searchBar);
         
         //Search Button
         JButton searchButton = new JButton("Search");
         searchButton.setBounds(760, 120, 80, 30);
         panel.add(searchButton);
      
         
         
         /**
          * Category Button Set Start
          */
        
         //Fuel Button
         JButton fuelButton = new JButton("Fuel");
         fuelButton.setBounds(400,160,80,30);
         panel.add(fuelButton);
         
         //Hybrid Button
         JButton hybridButton = new JButton("Hybrid");
         hybridButton.setBounds(500,160,80,30);
         panel.add(hybridButton);
         
         //EV Button
         JButton EVButton = new JButton("EV");
         EVButton.setBounds(600,160,80,30);
         panel.add(EVButton);
         
         
         //All Button
         JButton AllButton = new JButton("See All");
         AllButton.setBounds(700,160,80,30);
         panel.add(AllButton);
         
         /**
         * Category Button Set Ends
         */
        
         
         frame.setVisible(true);

    }
    
}
