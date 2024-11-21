package com.hotel.hotelmngsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Services.driverService;
import model.Driver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.HashSet;
import java.util.List;

public class driverInfo extends JFrame {
	driverService ds =  new driverService();
	DefaultTableModel model;
    driverInfo(){

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(5,5,788,588);
        panel.setLayout(null);
        add(panel);

        JLabel pus = new JLabel("Driver Details");
        pus.setBounds(90,11,160,25);
        pus.setForeground(Color.WHITE);
        pus.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(pus);

        JLabel TOC = new JLabel("Type of Car");
        TOC.setBounds(32,97,89,14);
        TOC.setForeground(Color.WHITE);
        TOC.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(TOC);

        Choice c = new Choice();
        c.setBounds(123,94,150,25);
        panel.add(c);

        try{
        	List<Driver> resultSet = ds.getAllDriver();
        	HashSet<String> s = new HashSet<String>();
            for(Driver driver:resultSet){
            	s.add(driver.getCarcompany());
            }
            for(String item:s) {	
            	c.add(item);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        model  = new DefaultTableModel(new String[]{"Name","Age","Gender","Phone","Car Name","Location"},0);
        JTable table = new JTable();
        table.setBounds(10,233,800,250);
        table.setBackground(Color.DARK_GRAY);
        table.setForeground(Color.WHITE);
        panel.add(table);
        
        
        try{
	          List<Driver> resultSet = ds.getAllDriver();
	          for(Driver d:resultSet) {
	          model.addRow(new Object[]{d.getName(),d.getAge(),d.getGender(),d.getPhone(),d.getCarcompany(),d.getLocation()});
          }
	          table.setModel(model);
	      }catch (Exception e ){
	          e.printStackTrace();
	      }

        JLabel name = new JLabel("Name");
        name.setBounds(24,208,46,14);
        name.setForeground(Color.WHITE);
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(165,208,46,14);
        age.setForeground(Color.WHITE);
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(300,208,46,14);
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        JLabel company = new JLabel("Phone NO.");
        company.setBounds(420,208,100,14);
        company.setForeground(Color.WHITE);
        panel.add(company);

        JLabel Carname = new JLabel("Car Name");
        Carname.setBounds(560,208,100,14);
        Carname.setForeground(Color.WHITE);
        panel.add(Carname);


        JLabel loacation = new JLabel("Loacation");
        loacation.setBounds(700,208,100,14);
        loacation.setForeground(Color.WHITE);
        panel.add(loacation);

        JButton display = new JButton("Display");
        display.setBounds(200,500,120,30);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                	model.setRowCount(0);
	  	          	List<Driver> resultSet = ds.getAllDriver();
	  	          	for(Driver d:resultSet) {
	  	          		String car = c.getSelectedItem();
	  	          		if(car.equalsIgnoreCase(d.getCarcompany()))
	  	          		model.addRow(new Object[]{d.getName(),d.getAge(),d.getGender(),d.getPhone(),d.getCarcompany(),d.getLocation()});
	  	          	}
	  	         table.setModel(model);
	  	      	}catch (Exception ex){
	  	          ex.printStackTrace();
	  	      		}
            }
        });



        JButton Back = new JButton("Back");
        Back.setBounds(350,500,120,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);dispose();
            }
        });
        
        JButton print = new JButton("Print");
        print.setBounds(500,500,120,30);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        panel.add(print);
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
    				table.print();
    			} catch (PrinterException ex) {
    				ex.printStackTrace();
    			}
            }
        });
        
        

        setUndecorated(true);
        setLayout(null);
        setSize(800,600);
        setLocation(500,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new driverInfo();
    }
}
